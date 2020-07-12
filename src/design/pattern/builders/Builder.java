package design.pattern.builders;

import design.pattern.builders.cars.Type;
import design.pattern.builders.components.Engine;
import design.pattern.builders.components.GPSNavigator;
import design.pattern.builders.components.Transmission;
import design.pattern.builders.components.TripComputer;

public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
