package code.main;

import code.clase.persoane.Client;
import code.controllere.ControlPersoane;
import code.view.ViewClient;

public class main {

    public static void main(String[] args) {

        Client cosmin = new Client("11,Nedelcu Cosmin,12345,22,Client,Timisul de Jos 3,0773941106");
        ControlPersoane controlPersoane = new ControlPersoane();

        ViewClient viewClient = new ViewClient(controlPersoane, cosmin);
        viewClient.play();
    }
}
