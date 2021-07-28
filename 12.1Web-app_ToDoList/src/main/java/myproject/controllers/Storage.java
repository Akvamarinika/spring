package myproject.controllers;

import response.Event;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Event> eventsList = new ArrayList<>();

    public static int addEvent(Event event){
        System.out.println(event.getDate());
        int id = eventsList.size() + 1;
        event.setId(id);
        eventsList.add(event);
        return id;
    }

    public static List<Event> getEventsList() {
        return eventsList;
    }
}
