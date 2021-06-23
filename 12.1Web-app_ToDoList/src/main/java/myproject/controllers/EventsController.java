package myproject.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import response.Event;

import java.io.IOException;
import java.util.List;

@RestController
public class EventsController {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    @GetMapping("/events/")
    public List<Event> eventList(){
        return Storage.getEventsList();
    }

    @PostMapping("/events/")
    public int addNewEvent(@RequestBody Event event) {
        System.out.println(event.getTheme());
        return Storage.addEvent(event);
    }
}
