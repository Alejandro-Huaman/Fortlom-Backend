package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication,Long>{

}