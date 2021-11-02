package upc.edu.pe.FortlomBackend.backend.domain.service;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtists();
    Page<Artist> getAllArtists(Pageable pageable);
    Artist getArtistById(Long artistId);
    Artist createArtist(Artist artist);
    Artist updateArtist(Long artistId, Artist request);
    ResponseEntity<?> deleteArtist(Long artistId);
}