package upc.edu.pe.FortlomBackend.backend.resource.Event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventResource {
    private Long id;
    private String EventName;
    private String EventDescription;
    private Long Likes;
    private Long artist_id;
}
