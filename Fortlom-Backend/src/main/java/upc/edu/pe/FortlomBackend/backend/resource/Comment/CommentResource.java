package upc.edu.pe.FortlomBackend.backend.resource.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResource {

    private Long id;
    private String CommentDescription;
    private Long PublicationID;
    private Long UserID;
    private Date date;
}
