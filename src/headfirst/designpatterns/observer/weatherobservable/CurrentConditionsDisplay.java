package headfirst.designpatterns.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
    private float temperature;
    private float humidity;
    private Observable weatherData;


    public CurrentConditionsDisplay(Observable weatherData) {
        weatherData.addObserver(this);
        this.weatherData = weatherData;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.temperature = ((WeatherData) o).getPressure();
            this.humidity = ((WeatherData) o).getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
