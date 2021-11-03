package upc.edu.pe.FortlomBackend.backend.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;
import upc.edu.pe.FortlomBackend.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Artist")

public class Artist {

    @Id
    private Long Id;

    @NotNull
    @Column(unique = true)
    private Long tags;

    @NotNull
    @Column(unique = true)
    private Long followers;

}
