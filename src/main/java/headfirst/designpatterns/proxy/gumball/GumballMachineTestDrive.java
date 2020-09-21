package headfirst.designpatterns.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        String location = "gumballmachine";
        int count = 3;
        try {
            gumballMachine = new GumballMachine("santafe.mightygumball.com", count);
            Naming.rebind(location, gumballMachine);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
