package design.pattern.prototype.caching.cache;

import design.pattern.prototype.shapes.Circle;
import design.pattern.prototype.shapes.Rectangle;
import design.pattern.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        Circle circle = new Circle(45);
        circle.x = 5;
        circle.y = 7;
        circle.color = "Green";

        Rectangle rectangle = new Rectangle(6, 9);
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";
        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public void put(String key, Shape shape) {
        cache.put(key, shape);
    }
    public Shape get(String key) {
        return cache.get(key).clone();
    }

}
