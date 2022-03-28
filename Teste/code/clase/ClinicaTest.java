package code.clase;

import code.clase.clinica.Clinica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClinicaTest {

    Clinica clinica1;
    Clinica clinica2;
    Clinica clinica3;

    @BeforeEach
    public void testConstructors(){

        ArrayList<String>specializari = new ArrayList<>();
        specializari.add("nutritie");
        specializari.add("ortopedie");
        specializari.add("stomatologie");

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(0);
        ids.add(3);
        ids.add(5);
        ids.add(8);
        ids.add(12);
        ids.add(15);

        clinica1 = new Clinica();
        clinica2 = new Clinica(0, "MediLife BV","Brasov", "Valea Ursilor 3", specializari, ids);

        String prp = "1,MedLife Drumul Taberei,Bucuresti,Valea Argesului,psihiatru,dermatologie,cardiologie";
        String prpMedic = "2,5,9,6,10,11";
        clinica3 = new Clinica(prp,prpMedic);
    }

    @Test
    public void testDescribe(){

        System.out.println(clinica2.describe());
        System.out.println(clinica1.describe());
        System.out.println(clinica3.describe());
    }

    @Test
    public void testCompareTo(){

        assertEquals(0, clinica3.compareTo(clinica2));
        assertEquals(-1, clinica1.compareTo(clinica2));
        assertEquals(1, clinica3.compareTo(clinica1));
    }

    @Test
    public void testEquals(){

        //assertEquals(false, clinica3.equals(clinica2));
        assertEquals(true, clinica3.equals(clinica2));
    }

    @Test
    public void testToString(){

        System.out.println(clinica2.toString());
        System.out.println(clinica3);
        System.out.println(clinica1);
    }

    @Test
    public void testCopy(){

        Clinica clinica = new Clinica();
        clinica = clinica.copy(clinica2);
        System.out.println(clinica.describe());
    }

}