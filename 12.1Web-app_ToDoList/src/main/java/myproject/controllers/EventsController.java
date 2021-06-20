package myproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import response.Event;

import java.util.List;

@RestController
public class EventsController {

    @GetMapping("/events/")
    public List<Event> eventList(){
        return null;
    }

    @PostMapping("/events/add")
    public void addNewEvent(){

    }
}
