package headfirst.designpatterns.command.remote;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);
        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);

        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);

        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);

        remoteControl.setCommand(0, hottubOnCommand, hottubOffCommand);
        remoteControl.setCommand(5, stereoOnCommand, stereoOffCommand);
        remoteControl.setCommand(6, ceilingFanOnCommand, ceilingFanOffCommand);

        for (int i = 0; i < 7; i++) {
            remoteControl.onButtonWasPushed(i);
            remoteControl.offButtonWasPushed(i);
        }

        System.out.println(remoteControl);
    }
}
