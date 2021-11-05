package upc.edu.pe.FortlomBackend.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.service.CommentService;
import upc.edu.pe.FortlomBackend.backend.mapping.CommentMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.UpdateCommentResource;
import upc.edu.pe.FortlomBackend.backend.resource.Comment.CreateCommentResource;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper mapper;

    @GetMapping
    public Page<CommentResource> getAllComments(Comment pageable) {
        return mapper.modelListToPage(commentService.getAll(), pageable);
    }

    @GetMapping("{commentId}")
    public CommentResource getCommentById(@PathVariable("commentId") Long commentId) {
        return mapper.toResource(commentService.getById(commentId));
    }

    @PostMapping
    public CommentResource createComment(@RequestBody CreateCommentResource request) {
        return mapper.toResource(commentService.create(mapper.toModel(request)));
    }

    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentResource request) {
        return mapper.toResource(commentService.update(commentId, mapper.toModel(request)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
