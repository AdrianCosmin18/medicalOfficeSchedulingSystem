package code.clase;

import code.clase.programare.Programare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramareTest {

    private Programare p1;
    private Programare p2;

    @BeforeEach
    public void testContructor(){

        p1 = new Programare("0,0,0,0,26,03,2022,10,30,26,03,2022,10,45");
        p2 = new Programare("1,0,1,2,27,03,2022,14,45,27,03,2022,15,30");
    }

    @Test
    public void testDescribe(){

        System.out.println(p2.describe());
    }

    @Test
    public void testEquals(){

        assertEquals(true, p1.equals(p2));
    }

    @Test
    public void testToString(){

        System.out.println(p1);
    }
}