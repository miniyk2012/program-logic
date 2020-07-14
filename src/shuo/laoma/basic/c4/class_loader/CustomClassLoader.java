package shuo.laoma.basic.c4.class_loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class CustomClassLoader extends ClassLoader {
    private String basedir; // 需要该类加载器直接加载的类文件的基目录
    private HashSet<String> className; // 需要由该类加载器直接加载的类名

    public CustomClassLoader(String basedir, String[] clazns) throws Exception {
        super(null); // 指定父类加载器为 null
        this.basedir = basedir;
        className = new HashSet();
        loadClassByMe(clazns);
    }

    private void loadClassByMe(String[] clazns) throws Exception {
        for (int i = 0; i < clazns.length; i++) {
            loadDirectly(clazns[i]);
            className.add(clazns[i]);
        }
    }

    private Class loadDirectly(String name) throws Exception {
        Class cls = null;
        StringBuffer sb = new StringBuffer(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separatorChar + classname);
        File classF = new File(sb.toString());
        cls = instantiateClass(name, new FileInputStream(classF), classF.length());
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) throws Exception {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        return defineClass(name, raw, 0, raw.length);  // 会把得到的类放到该类加载器的命名空间中
    }

    protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class cls = null;
        cls = findLoadedClass(name);
        if (!this.className.contains(name) && cls == null)
            cls = getSystemClassLoader().loadClass(name);
        if (cls == null)
            throw new ClassNotFoundException(name);
        if (resolve)
            resolveClass(cls);
        return cls;
    }

    public static void main(String[] args) throws Exception {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    CustomClassLoader customClassLoader = new CustomClassLoader(
                            "/Users/admin/Documents/javaprojects/program-logic/out/production/program-logic", new String[]{"shuo.laoma.basic.c4.class_loader.Foo"});

                    // 每次都创建出一个新的类加载器
                    Class<?> cls = customClassLoader.loadClass("shuo.laoma.basic.c4.class_loader.Foo");
//                    Object foo = cls.newInstance();
                    FooInterface foo = (FooInterface )cls.newInstance();
                    foo.sayHi();
//                    Method m = foo.getClass().getMethod("sayHi", new Class[]{});
//                    m.invoke(foo, new Object[]{});
                    FooInterface foo2 = new Foo();
                    foo2.sayHi();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }, 0, 1000L);
    }
}
