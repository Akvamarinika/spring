package myproject.controllers;
import myproject.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import myproject.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EventsController {
    private final EventRepository eventRepository;

    @Autowired
    public EventsController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events/")
    public List<Event> getAll(){
        Iterable<Event> eventsIterable = eventRepository.findAll();
        List<Event> eventsList = new ArrayList<>();
        for (Event event : eventsIterable){
            eventsList.add(event);
        }
        return eventsList;
    }

    @PostMapping("/events/")
    public Long addNewEvent(@RequestBody Event event) {
        Event newEvent = eventRepository.save(event);
        return newEvent.getId(); //id
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Object> getEvent(@PathVariable("id") Long id){
        Optional<Event> event = eventRepository.findById(id);

        if (event.isPresent()){
            return new ResponseEntity<>(event, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Object> updateEvent(@RequestBody Event eventUpdate, @PathVariable("id") Long id){
        if (eventRepository.existsById(id)){
            eventUpdate.setId(id);
            eventRepository.save(eventUpdate);
            return  ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }



    @DeleteMapping("/events/{id}")
    public ResponseEntity<Object> removeEvent (@PathVariable("id") Long id){
        eventRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
