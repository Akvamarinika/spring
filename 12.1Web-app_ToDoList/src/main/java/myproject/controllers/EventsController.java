package myproject.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import myproject.response.Event;
import java.util.List;
import java.util.Map;

@RestController
public class EventsController {

    @GetMapping("/events/")
    public List<Event> getAll(){
        return Storage.getAllEvents();
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
