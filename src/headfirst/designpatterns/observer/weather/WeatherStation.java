package headfirst.designpatterns.observer.weather;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);


        weatherData.setMeasurements(10, 20, 100);
        System.out.println("------------------");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("------------------");
        heatIndexDisplay.unregister();
        weatherData.setMeasurements(82, 70, 29.2f);

    }
}
