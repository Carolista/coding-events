package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // Need a place to put events
    // final - able to add and remove events, but not replace entire collection
    private static final Map<Integer, Event> events = new HashMap<>();

    // Get all events
    // Note: built-in Collection is an interface that extends the built-in Iterable interface
    public static Collection<Event> getAll() {
        return events.values();
    }

    // Get a single event
    public static Event getById(int id) {
        return events.get(id);
    }

    // Add an event
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    // Remove an event
    public static void remove(int id) {
        events.remove(id);
    }

}
