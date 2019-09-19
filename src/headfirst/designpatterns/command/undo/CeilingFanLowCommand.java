package headfirst.designpatterns.command.undo;

public class CeilingFanLowCommand extends CeilingUndo implements Command {

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

}
