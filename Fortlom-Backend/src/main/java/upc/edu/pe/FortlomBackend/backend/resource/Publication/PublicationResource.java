package upc.edu.pe.FortlomBackend.backend.resource.Publication;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublicationResource {

    private Long id;
    private String PublicationName;
    private String PublicationDescription;
    private Long likes;
    private Date date;
    private Long UserId;

}