package javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
class Main{
    private static Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Type1", "Data1"));
        addEvent(new StreamEvent(2, "Type2", "Data2"));
        addEvent(new StreamEvent(3, "Type1", "Data3"));

        System.out.println("Search event by ID 1: " + getEventById(1));

        System.out.println("Search events by Type Type1: " + getEventsByType("Type1"));

        removeEvent(2);

        displayAllEvents();
    }

    public static void addEvent(StreamEvent event){
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(int id){
        return eventsById.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType){
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeEvent(int id){
        eventsById.remove(id);
        eventsByType.entrySet().removeIf(entry -> {
           entry.getValue().removeIf(event -> event.getId() == id);
           return entry.getValue().isEmpty();
        });
    }

    public static void displayAllEvents() {
        System.out.println("All Events:");
        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Type: " + entry.getValue().getEventType() + ", Data: " + entry.getValue().getData());
        }
    }



}