package code.controllere;

import code.clase.persoane.Client;
import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlPersoaneTest {

    private ControlPersoane cp;
    //private ArrayList<Persoana> persoane;

    @BeforeEach
    public void create(){

        cp = new ControlPersoane();
    }

    @Test
    public void testTraverse(){

        cp.traverse();
    }

    @Test
    public void testExistID(){

        assertEquals(true, cp.existsID(1));
    }

    @Test
    public void testAdd(){

        cp.add(new Client("20,Miha,12334,23,Client,Macinului 1,09536342345"));
        cp.traverse();
    }

    @Test
    public void testIndexOf(){

        System.out.println(cp.indexOf(new Medic("6,Leu,parola,22,Medic,nutritie,3000,1")));
    }

    @Test
    public void testRemove(){
        //cp.remove(11);

        cp.remove(new Client("10,Nedelcu Cosmin,12345,22,Client,Timisul de Jos 3,0773941106"));
        cp.traverse();

    }

    @Test
    public void testgetNextAvailableID(){

        assertEquals(13,cp.getNextAvailableID());
    }

    @Test
    public void testContains(){

        Client cosmin = new Client("10,Nedelcu Cosmin,12345,22,Client,Timisul de Jos 3,0773941106");
        Medic laur = new Medic("3,Laurentiu,1234,26,Medic,stomatologie,2750,3");


        Persoana p1=cosmin;
        Persoana p2=laur;


        assertEquals(false, p1.equals(p2));
    }

    @Test
    public void testSize(){

        assertEquals(12, cp.size());
    }

    @Test
    public void testModify(){

        cp.modify(new Client(10,"Nedelcu Adrian", "decembrie18", 21,"Client","Callatis 12", "87566645674567"));
        cp.modify(new Medic(2, "Popa Claudia Gabriela", "parola", 48, "Medic","ortopedie", 4500, 21));
        cp.traverse();
    }

    @Test
    public void testGetPersoanaByID(){

        System.out.println(cp.getPersoanaByID(1).describe());
    }

    @Test
    public void testgetIdByName(){

        assertEquals(10, cp.getIdByName("Nedelcu Cosmin"));
    }

    @Test
    public void testGetPersonByNameAndPassword(){

        assertEquals(true, new Medic("1,Nedelcu Andrei,1234,18,Medic,cardiologie,2500,2").equals(cp.getPersonByNameAndPassword("Nedelcu Andrei", "1234")));
    }
}