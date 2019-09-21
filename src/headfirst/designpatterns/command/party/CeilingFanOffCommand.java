package headfirst.designpatterns.command.party;


public class CeilingFanOffCommand extends CeilingUndo implements Command {

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

}
