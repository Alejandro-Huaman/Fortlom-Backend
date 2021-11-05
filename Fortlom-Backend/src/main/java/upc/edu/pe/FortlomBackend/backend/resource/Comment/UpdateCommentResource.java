package upc.edu.pe.FortlomBackend.backend.resource.Artist;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Setter
@Getter
public class UpdateArtstResource {
    @NotNull
    private Long id;
    @NotNull
    private String CommentDescription;
    @NotNull
    private Long PublicationID;
    @NotNull
    private Long UserID;
    @NotNull
    private Date date;
}
