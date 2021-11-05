package upc.edu.pe.FortlomBackend.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.service.EventService;
import upc.edu.pe.FortlomBackend.backend.mapping.EventMapper;
import upc.edu.pe.FortlomBackend.backend.resource.Event.EventResource;
import upc.edu.pe.FortlomBackend.backend.resource.Event.UpdateEventResource;
import upc.edu.pe.FortlomBackend.backend.resource.Event.CreateEventResource;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventMapper mapper;

    @GetMapping
    public Page<EventResource> getAllEvents(Pageable pageable) {
        return mapper.modelListToPage(eventService.getAllEvents(), pageable);
    }
    @GetMapping("{eventId}")
    public EventResource getEventById(@PathVariable Long eventId) {
        return mapper.toResource(eventService.getEventById(eventId));
    }
    @GetMapping("{artistId}")
    public Page<EventResource> getAllEventsByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(eventService.getEventsByArtistId(artistId), pageable);
    }
    @PostMapping
    public EventResource createEvent(@RequestBody CreateEventResource request) {

        return mapper.toResource(eventService.createEvent(mapper.toModel(request)));
    }
    @PutMapping("{eventId}")
    public EventResource updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventResource request) {
        return mapper.toResource(eventService.updateEvent(eventId, mapper.toModel(request)));
    }
    @DeleteMapping("{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        return eventService.deleteEvent(eventId);
    }
}
