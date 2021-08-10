package myproject.controllers;
import myproject.model.Event;
import myproject.response.NullEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Map<Long, Event> events = new HashMap<>();
    private static long currentId = 1;

    public static long addEvent(Event event){
        long id = currentId++;
        event.setId(id);
        events.put(id, event);
        return id;
    }

    public static Event getEvent(long id){
        if (events.containsKey(id)){
            return events.get(id);
        }
        return new NullEvent();
        //throw new NotFoundEvent(id, "The requested event is not in the database!");
    }

    public static List<Event> getAllEvents() {
        return new ArrayList<>(events.values());
    }

    public static boolean editEvent(Event event, long id){
        if (events.containsKey(id)){
            events.replace(id, events.get(id), event);
            return true;
        }
        return  false;
    }

    public static boolean patchEvent(Event event, long id){
        if (events.containsKey(id)){
            events.replace(id, event);
            return true;
        }
        return  false;
    }

    public static boolean removeEvent(long id){
        if(events.containsKey(id)){
            events.remove(id);
            return true;
        }
        return false;
    }
}
