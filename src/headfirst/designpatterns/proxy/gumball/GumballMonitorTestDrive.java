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
            monitor.report();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
