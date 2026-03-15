package hw6.task1;

public class RealWeatherService implements WeatherService{

    public static int count;
    @Override
    public String getWeather(String city) {
        System.out.println("[API] Fetching weather for " + city + "...");
        count++;
        return "Sunny, 22°C";
    }

    @Override
    public String getTemperature(String city) {
        count++;
        System.out.println("[API] Fetching temperature for " + city + "...");
        return "22.0";
    }

    public static int getCount() {
        return count;
    }
}
