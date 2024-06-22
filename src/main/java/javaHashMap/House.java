package javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;
}

class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        map.put("Stark", new House("Stark", "Direwolf"));
        map.put("Lannister", new House("Lannister", "Lion rampant"));
        map.put("Barateon", new House("Barateon", "Blak deer"));
        map.put("Tarli", new House("Tarli", "Red hunter"));

        addNewHouse(map, "Tully", "Fish");
        System.out.println(map);
        deliteHouse(map, "Lannister");
        System.out.println(map);
        System.out.println(findHouseSigil(map, "Tully"));
        printAllHouses(map);
    }

    public static Map<String, House> addNewHouse(Map<String, House> map, String name, String sigil) {
        if (name != null && sigil != null) {
            map.put(name, new House(name, sigil));
        }
        return map;
    }

    public static Map<String, House> deliteHouse(Map<String, House> map, String name) {
        if (name != null) {
            map.remove(name);
        }
        return map;
    }

    public static String findHouseSigil(Map<String, House> map, String name) {
        if (map.containsKey(name)) {
            return map.get(name).getSigil();
        } else {
            return "House not found";
        }
    }

    public static void printAllHouses(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getSigil());
        }
    }
}
