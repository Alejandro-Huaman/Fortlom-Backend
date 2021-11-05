package upc.edu.pe.FortlomBackend.backend.service;

import upc.edu.pe.FortlomBackend.backend.domain.model.entity.Event;
import upc.edu.pe.FortlomBackend.backend.domain.persistence.EventRepository;
import upc.edu.pe.FortlomBackend.backend.domain.service.EventService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.FortlomBackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {

    private static final String ENTITY = "Event";
    //private static final String ENTITY2 = "Artist";
    private final EventRepository eventRepository;

    private final Validator validator;

    public EventServiceImpl(EventRepository eventRepository, Validator validator){
        this.eventRepository=eventRepository;
        this.validator=validator;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }
    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }
    @Override
    public Event createEvent(Event request) {
        Set<ConstraintViolation<Event>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return eventRepository.save(request);
    }
    @Override
    public Event updateEvent(Long eventId, Event request) {

        Set<ConstraintViolation<Event>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return eventRepository.findById(eventId).map(event ->
                eventRepository.save(
                        event.withEventName(request.getEventName())
                                .withEventDescription(request.getEventDescription())
                                .withLikes(request.getLikes())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));

    }
    @Override
    public List<Event> getEventsByArtistId(Long artistId) {

        return eventRepository.findByArtistId(artistId);
    }
    @Override
    public ResponseEntity<?> deleteEvent(Long eventId) {
        return eventRepository.findById(eventId).map(event -> {
            eventRepository.delete(event);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }

}
