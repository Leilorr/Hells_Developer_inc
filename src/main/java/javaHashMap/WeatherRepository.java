package javaHashMap;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherRepository {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    public static WeatherData getWeatherData(String city){
        return new WeatherData(city, random.nextInt(40), random.nextInt(90));
    }
}
