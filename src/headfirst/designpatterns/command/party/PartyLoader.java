package headfirst.designpatterns.command.party;


public class PartyLoader {
    public static void main(String[] args) {
        RemoteUndoControl remoteUndoControl = new RemoteUndoControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);

        Hottub hottub = new Hottub();
        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);

        Command[] partyOn = new Command[]{ceilingFanHighCommand, hottubOnCommand};

        Command[] partyOff = new Command[]{ceilingFanOffCommand, hottubOffCommand,};

        MacroCommand macroOnCommand = new MacroCommand(partyOn);
        MacroCommand macroOffCommand = new MacroCommand(partyOff);

        remoteUndoControl.setCommand(0, macroOnCommand, macroOffCommand);

        System.out.println("------on------");
        remoteUndoControl.onButtonWasPushed(0);
        System.out.println("------off------");
        remoteUndoControl.offButtonWasPushed(0);
        System.out.println("------undo------");
        remoteUndoControl.undoButtonWasPushed();
        System.out.println(remoteUndoControl);
    }
}
