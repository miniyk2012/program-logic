package headfirst.designpatterns.proxy.gumball;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense() throws RemoteException;
}
