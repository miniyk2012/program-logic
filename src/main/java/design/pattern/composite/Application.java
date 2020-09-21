package design.pattern.composite;

import design.pattern.composite.editor.ImageEditor;
import design.pattern.composite.shapes.Circle;
import design.pattern.composite.shapes.CompoundShape;
import design.pattern.composite.shapes.Dot;
import design.pattern.composite.shapes.Rectangle;

import java.awt.Color;

public class Application {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        editor.loadShapes(new Circle(10, 10, 10, Color.BLUE),
                new CompoundShape(new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),
                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN),
                        new CompoundShape(new Circle(200, 160, 70, Color.BLACK),
                                new Dot(10, 160, Color.BLACK)
                        )
                )
        );
    }
}
