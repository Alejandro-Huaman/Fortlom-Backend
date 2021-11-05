import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CommentService {

    List<Comment> getAll();
    Page<Comment> getAll(Pageable pageable);
    Comment getById(Long commentId);
    Comment create(Comment comment);
    Comment update(Long commentId, Comment request);
    ResponseEntity<?> delete(Long commentId);
}
