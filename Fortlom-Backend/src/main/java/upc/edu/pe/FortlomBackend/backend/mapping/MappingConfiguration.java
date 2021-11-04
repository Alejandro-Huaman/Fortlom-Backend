package upc.edu.pe.FortlomBackend.backend.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapper();
    }

    @Bean
    public ArtistMapper artistMapper() {
        return new ArtistMapper();
    }


}