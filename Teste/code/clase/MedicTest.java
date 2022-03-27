package code.clase;

import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicTest {

    Medic cosmin;
    Medic laur;
    Medic mihai;
    Medic copie;
    Persoana persoana;

    @BeforeEach
    public void create(){

        cosmin = new Medic(0, "Cosmin", "1234", 22, "Medic", "smecherie", 4000, 1);
        laur = new Medic("1,Laur,1234,26,NoMedic,ortoped,2500,5");
        mihai = new Medic();
        mihai.setExperienta(5);
        copie = new Medic("2,Cezar,1234,32,Medic Legist,ortoped,3000,7");
        persoana = new Medic();
    }

    @Test
    public void testDescribe(){

        //System.out.println(cosmin.describe());
        //System.out.println(laur.describe());
        //System.out.println(mihai.describe());
        //System.out.println(copie.describe());
        System.out.println(persoana.describe());
    }

    @Test
    public void testToString(){

        System.out.println(cosmin);
        System.out.println(laur);
        System.out.println(mihai);
        System.out.println(copie);
        System.out.println(persoana);
    }

    @Test
    public void testEquals(){

        assertEquals(true, laur.equals(copie));

    }

    @Test
    public void testCompareTo(){

        assertEquals(-1, cosmin.compareTo(laur));
        assertEquals(0, laur.compareTo(mihai));
    }

}