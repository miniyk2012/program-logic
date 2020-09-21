package headfirst.designpatterns.singleton.doublecheckedlocking;

// This implementation of Singleton not
// guaranteed to work prior to Java 5, 这是因为volatile在java 1.4及之前有缺陷
public class Singleton {
    private static volatile Singleton uniqueInstance;  // 多个线程同时访问时, 能保证访问到最新的赋值
    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {  // 初始化成功后, 以后再也不用同步判断, 直接返回
            synchronized (Singleton.class) {  // 还未初始化时, 多个线程同时进入时, 加锁只允许同时只有一个线程进入
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public String getDescription() {
        return "I'm double checked locking Singleton";
    }
}
