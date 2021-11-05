package upc.edu.pe.FortlomBackend.backend.resource.Artist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArtistResource {

    private Long Id;

    @NotNull
    private Long followers;

    @NotNull
    private Long tags;

}
