package javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

}

@Data
class Main {
    private static Map<String, WeatherData> weatherMap = new HashMap<>();

    public static void main(String[] args) {
        weatherMap.put("New York", new WeatherData("New York", 20, 65));
        weatherMap.put("London", new WeatherData("London", 18, 70));
        weatherMap.put("Tokyo", new WeatherData("Tokyo", 28, 80));

        System.out.println(getWeatherData("Paris"));
        updateWeatherData("London");
        deleteWeatherData("Tokyo");
        System.out.println(getAllCities());
    }

    public static WeatherData getWeatherData(String city) {
        WeatherData weatherDataCache = weatherMap.get(city);
        if (weatherDataCache == null) {
            WeatherData cityWeatherData = WeatherRepository.getWeatherData(city);
            weatherMap.put(city, cityWeatherData);
            return cityWeatherData;
        }
        return weatherDataCache;
    }

    public static WeatherData updateWeatherData(String city) {
        WeatherData cityWeatherData = weatherMap.get(city);
        if (cityWeatherData == null) {
            System.out.println("Data not found");
        } else {
            cityWeatherData = WeatherRepository.getWeatherData(city);
            weatherMap.put(city, cityWeatherData);
        }
        return cityWeatherData;
    }

    public static void deleteWeatherData(String city) {
        weatherMap.remove(city);
    }

    public static List<String> getAllCities() {
        return new ArrayList<>(weatherMap.keySet());
    }
}
