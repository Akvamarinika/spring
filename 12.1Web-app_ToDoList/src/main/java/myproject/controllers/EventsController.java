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
    @Autowired
    private EventRepository eventRepository;

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
    public ResponseEntity<Object> editEvent(@RequestBody Event event, @PathVariable("id") Long id){
        return Storage.editEvent(event, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PatchMapping("/events/{id}")
    public ResponseEntity<Object> patchEvent(@RequestBody Event event, @PathVariable("id") Long id){
        return Storage.patchEvent(event, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Object> removeEvent (@PathVariable("id") Long id){
        eventRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
