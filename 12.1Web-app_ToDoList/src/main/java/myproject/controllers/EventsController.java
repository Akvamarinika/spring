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
        //System.out.println(Storage.getAllEvents());
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
}
