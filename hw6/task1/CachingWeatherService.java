package hw6.task1;

import java.util.HashMap;
import java.util.Map;

public class CachingWeatherService implements WeatherService {

    Map<String, String> cache = new HashMap<>();
    Map<String, Double> temperatureCache = new HashMap<>();
    WeatherService delegate;

    public CachingWeatherService(WeatherService realWeatherService) {
        this.delegate = realWeatherService;
    }

    @Override
    public String getWeather(String city) {
        if (cache.containsKey(city)) {
            System.out.println("[CACHE] Hit for " + city);
            return cache.get(city);
        } else {
            System.out.println("[CACHE] Miss for " + city);
            String result = delegate.getWeather(city);
            cache.put(city, result);
            return result;
        }

    }

    @Override
    public String getTemperature(String city) {
        if (cache.containsKey(city)) {
            System.out.println("[CACHE] Hit for " + city);
            return cache.get(city);
        } else {
            System.out.println("[CACHE] Miss for " + city);
            String result = delegate.getTemperature(city);
            cache.put(city, result);
            return result;
        }
    }
}
