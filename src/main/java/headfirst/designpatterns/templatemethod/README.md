模板方法: 在一个方法中定义一个算法的骨架, 而将一些步骤延迟到子类中. 模板方法使得子类可以在不改变算法
结构的情况下, 重新定义算法中的某些步骤.



抽象类定义了一个算法的步骤, 并允许子类为一个或多个步骤提供实现. 客户端可以只依赖于抽象类.

好莱坞原则: 别调用我们, 我们会调用你.
模板方法中: 抽象类是高层组件, 子类是低层组件, 抽象类决定算法骨架, 调用各个步骤(子类来实现), 而子类也不会直接调用抽象类, 而只是实现抽象类的方法.

钩子:
钩子是一种方法, 它在抽象类中不做事, 或者只做默认的事情, 子类可以选择要不要去覆盖它.

