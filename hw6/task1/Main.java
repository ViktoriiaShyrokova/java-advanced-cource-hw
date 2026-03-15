package hw6.task1;

public class Main {

    public static void main(String[] args) {

        WeatherService cachingWeatherService = new CachingWeatherService(new RealWeatherService());

        System.out.println(cachingWeatherService.getWeather("London"));
        System.out.println(cachingWeatherService.getWeather("London"));
        System.out.println(cachingWeatherService.getWeather("Paris"));
        System.out.println(RealWeatherService.getCount());
    }
}
