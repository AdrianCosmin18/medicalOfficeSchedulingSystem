package code.controllere;

import code.clase.data.Data;
import code.clase.programare.Programare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlProgramariTest {

    private ControlProgramari controlProgramari;

    @BeforeEach
    public void create(){

        controlProgramari = new ControlProgramari();
    }

    @Test
    public void testTraverse(){

        controlProgramari.traverse();
    }

    @Test
    public void testExistsID(){

        assertEquals(false, controlProgramari.existsID(6));
    }

    @Test
    public void testAdd(){

        controlProgramari.add(new Programare("5,2,3,2,15,12,2000,12,00,15,12,2000,13,00"));
        controlProgramari.traverse();
    }

    @Test
    public void testIndexOf(){

        assertEquals(3,controlProgramari.indexOf(new Programare(3,10,3,2,new Data("30,03,2022,10,00","30,03,2022,11,00"))));
    }

    @Test
    public void testRemove(){

        //controlProgramari.remove(4);
        controlProgramari.remove(new Programare(3,10,3,2,new Data("30,03,2022,10,00","30,03,2022,11,00")));

        controlProgramari.traverse();
    }

    @Test
    public void testNexID(){

        assertEquals(6,controlProgramari.getNextAvailableID());
    }

    @Test
    public void testContains(){

        controlProgramari.remove(3);
        assertEquals(false, controlProgramari.contains(new Programare(3,10,3,2,new Data("30,03,2022,10,00","30,03,2022,11,00"))));
    }

    @Test
    public void testSize(){

        assertEquals(6, controlProgramari.size());
    }

    @Test
    public void testIsEmpty(){

        assertEquals(false, controlProgramari.isEmpty());
    }

    @Test
    public void testGetProgramareById(){

        System.out.println(controlProgramari.getProgramareByID(0).describe());
    }

    @Test
    public void testModify(){

        controlProgramari.modify(new Programare(3,3,3,3,new Data("30,03,2022,10,00","30,03,2022,11,00")));
        controlProgramari.traverse();
    }

    @Test
    public void testGetListaByClientID(){

        ArrayList<Programare> list = controlProgramari.getListaByClientID(12);
        for(Programare p : list){

            System.out.println(p.describe());
            System.out.println();
        }
    }

    @Test
    public void testSaveToFile(){

        controlProgramari.saveToFile();
    }

}