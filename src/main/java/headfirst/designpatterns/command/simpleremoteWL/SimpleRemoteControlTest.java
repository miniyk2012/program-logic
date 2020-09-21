package headfirst.designpatterns.command.simpleremoteWL;

public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();  // 请求者
        Light light = new Light();  // 接收者
        GarageDoor garageDoor = new GarageDoor();
        simpleRemoteControl.setSlot(light::on);
        simpleRemoteControl.buttonWasPressed();

        simpleRemoteControl.setSlot(garageDoor::lightOff);
        simpleRemoteControl.buttonWasPressed();
    }
}
