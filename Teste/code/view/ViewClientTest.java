package code.view;

import code.clase.persoane.Client;
import code.controllere.ControlPersoane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewClientTest {

    private ViewClient viewClient;

    @Test
    public void create(){

        viewClient = new ViewClient(new ControlPersoane(), new Client("10,Nedelcu Cosmin,12345,22,Client,Timisul de Jos 3,0773941106"));
        viewClient.play();
    }


}