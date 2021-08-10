package myproject.controllers;
import myproject.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import myproject.model.Event;

import java.util.ArrayList;
import java.util.List;

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
    public int addNewEvent(@RequestBody Event event) {
        return Storage.addEvent(event); //id
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Object> getEvent(@PathVariable("id") int id){
        System.out.println(Storage.getEvent(id));

        Event event = Storage.getEvent(id);
        if (event.isNull()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Object> editEvent(@RequestBody Event event, @PathVariable("id") int id){
        return Storage.editEvent(event, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PatchMapping("/events/{id}")
    public ResponseEntity<Object> patchEvent(@RequestBody Event event, @PathVariable("id") int id){
        return Storage.patchEvent(event, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Object> removeEvent (@PathVariable("id") int id){
        return Storage.removeEvent(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
