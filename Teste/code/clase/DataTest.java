package code.clase;

import code.clase.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataTest {

    Data data1;
    Data data2;

    @BeforeEach
    public void testConstructor(){

        data1 = new Data("18,12,2018,15,30", "18,12,2018,16,30");
        data2 = new Data("5,4,2024,6,30","5,4,2024,7,0");
    }

    @Test
    public void testToString(){

        System.out.println(data1);
        System.out.println(data2);
    }

    @Test
    public void testDuration(){

        System.out.println(data2.getDurata().toMinutes());
    }

    @Test
    public void testGetteri(){

        System.out.println(data1.getDataInceput());
    }
}