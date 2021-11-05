package upc.edu.pe.FortlomBackend.backend.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface PublicationService {

    List<Publication> getAll();
    Page<Publication> getAll(Pageable pageable);
    Publication getById(Long publicationId);
    Publication create(Publication publication);
    Publication update(Long publicationId,Publication request);
    ResponseEntity<?> delete(Long publicationId);

}