package headfirst.designpatterns.command.undo;


public class RemoteUndoLoader {
    public static void main(String[] args) {
        RemoteUndoControl remoteUndoControl = new RemoteUndoControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");


        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);

        remoteUndoControl.setCommand(0, ceilingFanLowCommand, ceilingFanOffCommand);
        remoteUndoControl.setCommand(5, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteUndoControl.setCommand(6, ceilingFanMediumCommand, ceilingFanOffCommand);

        for (int i = 0; i < 7; i++) {
            remoteUndoControl.onButtonWasPushed(i);
            remoteUndoControl.offButtonWasPushed(i);
            remoteUndoControl.undoButtonWasPushed();
        }
        remoteUndoControl.undoButtonWasPushed();
        System.out.println(remoteUndoControl);
    }
}
