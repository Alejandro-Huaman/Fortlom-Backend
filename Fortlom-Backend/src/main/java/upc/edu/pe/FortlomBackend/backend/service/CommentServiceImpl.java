package upc.edu.pe.FortlomBackend.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Comment;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.CommentRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.CommentService;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private static final String ENTITY = "Comment";

    private final CommentRepository commentRepository;

    private final Validator validator;

    public CommentServiceImpl(CommentRepository CommentRepository, Validator validator){

        this.CommentRepository=CommentRepository;
        this.validator=validator;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment getById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Comment create(Comment request) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return commentRepository.save(request);
    }

    @Override
    public Comment update(Long commentId, Comment request) {

        Set<ConstraintViolation<Publication>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return publicationRepository.findById(commentId).map(comment ->
                commentRepository.save(
                        //por implementar.
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return commentRepository.findById(commentId).map(post -> {
            commentRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}