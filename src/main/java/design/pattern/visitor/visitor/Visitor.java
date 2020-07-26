package design.pattern.visitor.visitor;

import design.pattern.visitor.shapes.Circle;
import design.pattern.visitor.shapes.CompoundShape;
import design.pattern.visitor.shapes.Dot;
import design.pattern.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
