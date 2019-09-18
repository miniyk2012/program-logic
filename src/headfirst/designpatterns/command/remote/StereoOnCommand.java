package headfirst.designpatterns.command.remote;

public class StereoOnCommand implements Command {
	Stereo stereo;
 
	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		stereo.setCD();
		stereo.setVolume(10);
		stereo.on();
	}
}
