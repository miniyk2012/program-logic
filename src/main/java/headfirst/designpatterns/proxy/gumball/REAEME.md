export CLASSPATH=/Users/admin/Documents/javaprojects/program-logic/out/production/program-logic


# 服务端产生一个stub类, 静态存根已由动态生成的存根取代, 因此无需再生成
rmic headfirst.designpatterns.proxy.gumball.GumballMachine
# 服务端启动rmiregistry
rmiregistry &

# 服务端绑定GumballMachine到rmiregistry上
java headfirst/designpatterns/proxy/gumball/GumballMachineTestDrive
# 客户端通过代理与服务端通信
java headfirst/designpatterns/proxy/gumball/GumballMonitorTestDrive 