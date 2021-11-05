package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.PublicationRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.PublicationService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PublicationServiceImpl implements PublicationService {

    private static final String ENTITY = "Publication";

    private final PublicationRepository publicationRepository;

    private final Validator validator;

    public PublicationServiceImpl(PublicationRepository PublicationRepository, Validator validator){

        this.PublicationRepository=PublicationRepository;
        this.validator=validator;
    }

    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Page<Publication> getAll(Pageable pageable) {
        return publicationRepository.findAll(pageable);
    }

    @Override
    public Publication getById(Long publicationId) {
        return publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public Publication create(Publication request) {
        Set<ConstraintViolation<Publication>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return publicationRepository.save(request);
    }

    @Override
    public Publication update(Long publicationId, Publication request) {

        Set<ConstraintViolation<Publication>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return publicationRepository.findById(publicationId).map(publication ->
                publicationRepository.save(
                        //por implementar.
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(post -> {
            publicationRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }
}