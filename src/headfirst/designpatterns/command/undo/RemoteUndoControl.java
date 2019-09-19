package headfirst.designpatterns.command.undo;


//
// This is the invoker
//
public class RemoteUndoControl {
	Command[] onCommands;
	Command[] offCommands;
    Command prevCommand = new NoCommand();

	public RemoteUndoControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		for (int i = 0; i < 7; i++) {
			onCommands[i] = new NoCommand();
			offCommands[i] = new NoCommand();
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
        prevCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
        prevCommand = offCommands[slot];
	}

    public void undoButtonWasPushed() {
        prevCommand.undo();
    }


    public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + prevCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}
}
