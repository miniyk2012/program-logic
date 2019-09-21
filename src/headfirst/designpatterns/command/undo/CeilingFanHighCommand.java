package headfirst.designpatterns.command.undo;

public class CeilingFanHighCommand extends CeilingUndo implements Command {

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        // 用命令对象来存储接收者上次的状态, 这只是权宜之计,
        // 每个命令只能存储一个状态, 而且状态分散在不同命令中, 极不容易思考问题.
        // 可以给Command接口增加store和load方法, 将状态存到持久介质中, 就可以存储许多状态,
        // 而且状态可以集中管理
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

}
