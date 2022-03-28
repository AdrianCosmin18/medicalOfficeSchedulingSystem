package code.clase;

import code.clase.persoane.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client cosmin;
    Client andrei;
    Client anonim;
    Client cosmin2;

    @BeforeEach
    public void create(){

        cosmin = new Client("0,Nedelcu Cosmin,1234,22,Client,Timisul de Jos 3,0773941106");
        andrei = new Client(1, "Nedelcu Andrei", "acasa", 17, "Client", "Timisul de Jos 3", "051651651");
        anonim = new Client();
        cosmin2 = new Client();
        //cosmin2.setId(3);
        //cosmin2.setNume("Nedelcu Cosmin");
        //cosmin2.setParola("234523");
        //cosmin2.setVarsta(22);
    }

    @Test
    public void testEquals(){

        //assertEquals(false, cosmin.equals(andrei));
        assertEquals(true, anonim.equals(cosmin2));
    }

    @Test
    public void testDescribe(){


        System.out.println(cosmin.compareTo(cosmin2));
    }

    @Test
    public void testCopy(){

        System.out.println(new Client().copy(cosmin).describe());
    }


}