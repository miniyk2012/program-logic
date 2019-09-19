package headfirst.designpatterns.command.undo;

public class CeilingFanHighCommand extends CeilingUndo implements Command {

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

}
