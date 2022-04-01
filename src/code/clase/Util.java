package code.clase;

import java.time.LocalDateTime;

public class Util {

    public static LocalDateTime stringToLocalDateTime (String data){

        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);

        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }
}
