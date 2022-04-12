package code.controllere;

import code.clase.clinica.Clinica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlCliniciTest {

    private ControlClinici controlClinici;

    @BeforeEach
    public void create(){

        controlClinici = new ControlClinici();
    }

    @Test
    public void testTraverse(){

        controlClinici.traverse();
    }

    @Test
    public void testExistsID(){

        assertEquals(true, controlClinici.existsID(0));
    }

    @Test
    public void testAdd(){

        controlClinici.add(new Clinica("4,Hyperclinica MedLife Giulesti,Bucuresti,Strada Giulesti 1,stomatologie,ortopedie","3,4"));
        controlClinici.traverse();
    }

    @Test
    public void testIndexOf(){

        assertEquals(0,controlClinici.indexOf(new Clinica("0,Hyperclinica MedLife Favorit,Cluj,Calea Moților 32,cardiologie,pediatrie","1,2")));
    }

    @Test
    public void testRemove(){

        controlClinici.remove(0);
        controlClinici.remove(new Clinica("3,Hyperclinica MedLife Unirii,Bucuresti,Strada Hans Cristian Andersen 1,stomatologie,ortopedie","3,4"));
        controlClinici.traverse();
    }

    @Test
    public void testGetNextAvailableID(){

        assertEquals(4,controlClinici.getNextAvailableID());
    }

    @Test
    public void testContains(){

        assertEquals(false, controlClinici.contains(new Clinica("4,Hyperclinica MedLife Unirii,Bucuresti,Strada Hans Cristian Andersen 1,stomatologie,ortopedie","3,4")));
    }

    @Test
    public void testSize(){

        assertEquals(4,controlClinici.size());
    }

    @Test
    public void testModify(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("stomatologie");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);

        controlClinici.modify(new Clinica(-1,"medLife Favorit", "Bucuresti", "Drumul Taberei 24", lista, list));
        controlClinici.traverse();
    }

    @Test
    public void testGetClinicaByID(){

        System.out.println(controlClinici.getClinicaByID(3).describe());
    }


    @Test
    public void testGetIdByName(){

        assertEquals(3, controlClinici.getIdByName("Hyperclinica MedLife Unirii"));
    }

    @Test
    public void testGetClinicaByNameAndPassword(){

        assertEquals(true, new Clinica("3,Hyperclinica MedLife Unirii,Bucuresti,Strada Hans Cristian Andersen 1,stomatologie,ortopedie","3,4").equals(controlClinici.getClinicaByNameAndOras("Hyperclinica MedLife Unirii" , "Bucuresti")));
    }

    @Test
    public void testSaveToFile(){

        controlClinici.saveToFile();
    }
}