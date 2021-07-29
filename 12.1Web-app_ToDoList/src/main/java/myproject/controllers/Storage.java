package myproject.controllers;
import myproject.my_exceptions.NotFoundEvent;
import myproject.response.Event;
import myproject.response.NullEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Map<Integer, Event> events = new HashMap<>();
    private static int currentId = 1;

    public static int addEvent(Event event){
        System.out.println(event.getDate());
        int id = currentId++;
        event.setId(id);
        events.put(id, event);
        return id;
    }

    public static Event getEvent(int id){
        if (events.containsKey(id)){
            return events.get(id);
        }
        return new NullEvent();
        //throw new NotFoundEvent(id, "The requested event is not in the database!");
    }

    public static List<Event> getAllEvents() {
        return new ArrayList<>(events.values());
    }
}
