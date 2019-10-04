package headfirst.designpatterns.decorator;

public abstract class Beverage {
    public enum Size {TALL, GRANDE, VENTI}

    protected String description = "Unknown Beverage";
    private Size size = Size.TALL;

    public String getDescription() {
        return description;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public abstract double cost();
}
