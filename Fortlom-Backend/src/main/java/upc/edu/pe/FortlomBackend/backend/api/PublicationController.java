package upc.edu.pe.FortlomBackend.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.service.PublicationService;
import upc.edu.pe.FortlomBackend.backend.mapping.PublicationMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.PublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.UpdatePublicationResource;
import upc.edu.pe.FortlomBackend.backend.resource.Publication.CreatePublicationResource;

@RestController
@RequestMapping("/api/v1/publications")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper mapper;

    @GetMapping
    public Page<PublicationResource> getAllPublications(Publication pageable) {
        return mapper.modelListToPage(publicationService.getAll(), pageable);
    }

    @GetMapping("{publicationId}")
    public PublicationResource getPublicationById(@PathVariable("publicationId") Long publicationId) {
        return mapper.toResource(publicationService.getById(publicationId));
    }

    @PostMapping
    public PublicationResource createPublication(@RequestBody CreatePublicationResource request) {
        return mapper.toResource(publicationService.create(mapper.toModel(request)));
    }

    @PutMapping("{publicationId}")
    public PublicationResource updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource request) {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }

    @DeleteMapping("{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        return publicationService.delete(publicationId);
    }
}
