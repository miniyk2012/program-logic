package headfirst.designpatterns.singleton.statically;

public class Singleton {
    // 急切实例化, JVM加载该类是就创建实例
    private static Singleton uniqueInstance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return uniqueInstance;
    }

    // other useful methods here
    public String getDescription() {
        return "I'm a statically initialized Singleton!";
    }
}
