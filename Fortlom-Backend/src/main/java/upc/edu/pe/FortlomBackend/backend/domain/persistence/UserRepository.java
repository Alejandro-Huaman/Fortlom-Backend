package upc.edu.pe.FortlomBackend.backend.domain.persistence;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}