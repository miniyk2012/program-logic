package headfirst.designpatterns.command.undo;

public class CeilingFanMediumCommand extends CeilingUndo implements Command {

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

}
