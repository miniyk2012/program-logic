package headfirst.designpatterns.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String location = "rmi://localhost/gumballmachine";
        GumballMonitor monitor = null;
        try {
            GumballMachineRemote machine =
                    (GumballMachineRemote) Naming.lookup(location);
            monitor = new GumballMonitor(machine);
            // monitor实际上是Stub, Stub实现了GumballMachineRemote: headfirst.designpatterns.proxy.gumball.GumballMachine_Stub
            monitor.report();
            /**
             Gumball Machine class: class headfirst.designpatterns.proxy.gumball.GumballMachine_Stub
             Gumball Machine: santafe.mightygumball.com
             Current inventory: 3 gumballs
             Current state: waiting for quarter
             class headfirst.designpatterns.proxy.gumball.NoQuarterState
             You turned, but there's no quarter
             **/
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
