package headfirst.designpatterns.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;
import headfirst.designpatterns.observer.weather.DisplayElement;

public class ForecastDisplay implements DisplayElement, Observer {
    private float currentPressure;
    private float lastPressure;
    private Observable weatherData;

    public ForecastDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        lastPressure = currentPressure;
        if (o instanceof WeatherData) {
            this.currentPressure = ((WeatherData) o).getPressure();
            display();
        }
    }
}
