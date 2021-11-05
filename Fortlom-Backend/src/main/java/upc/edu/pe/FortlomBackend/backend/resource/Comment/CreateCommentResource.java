package upc.edu.pe.FortlomBackend.backend.resource.Comment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateCommentResource {
    @NotNull
    private String CommentDescription;
    @NotNull
    private Long PublicationID;
    @NotNull
    private Long UserID;
    @NotNull
    private Date date;
}
