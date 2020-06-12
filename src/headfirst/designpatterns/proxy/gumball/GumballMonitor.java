package headfirst.designpatterns.proxy.gumball;

import java.rmi.RemoteException;

public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine class: " + machine.getClass());
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
            System.out.println(machine.getState().getClass());
            machine.getState().turnCrank();
            machine.getState();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
