package code.clase.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {

    private LocalDateTime dataInceput;
    private LocalDateTime dataSfarsit;

    public Data(String dataDeInceput, String dataDeSfarsit) {

        int ddi = Integer.parseInt(dataDeInceput.split(",")[0]);
        int mmi = Integer.parseInt(dataDeInceput.split(",")[1]);
        int yyi = Integer.parseInt(dataDeInceput.split(",")[2]);
        int hhi = Integer.parseInt(dataDeInceput.split(",")[3]);
        int mini = Integer.parseInt(dataDeInceput.split(",")[4]);
        int dds = Integer.parseInt(dataDeSfarsit.split(",")[0]);
        int mms = Integer.parseInt(dataDeSfarsit.split(",")[1]);
        int yys = Integer.parseInt(dataDeSfarsit.split(",")[2]);
        int hhs = Integer.parseInt(dataDeSfarsit.split(",")[3]);
        int mins = Integer.parseInt(dataDeSfarsit.split(",")[4]);

        this.dataInceput = LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
        this.dataSfarsit = LocalDateTime.of(yys, mms, dds, hhs, mins);
    }

    public Data(LocalDateTime dataInceput, LocalDateTime dataSfarsit) {

        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
    }

    public Duration getDurata() {
        return Duration.between(dataInceput, dataSfarsit);
    }


    public LocalDateTime getDataInceput() {
        return dataInceput;
    }

    public LocalDateTime getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataInceput(LocalDateTime di) {
        dataInceput = di;
    }

    public void setDataSfarsit(LocalDateTime ds) {
        dataSfarsit = ds;
    }


    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");

        String text = "";
        text += "Programrea este " + dataInceput.format(formatter) + "\n";
        text += "Se sfarseste la " + dataSfarsit.format(formatter) + "\n";
        text += "Dureaza " + this.getDurata().toMinutes() + " minutes";

        return text;
    }

    public String dateForSaveToFile(){

        //eroare la getDayOfMonth() - nu mi da ziua corecta => da un numar mare like ziua anului
        String text = "";
        text += dataInceput.getDayOfMonth() + "," + dataInceput.getMonthValue() + "," + dataInceput.getYear() + "," + dataInceput.getHour() + "," + dataInceput.getMinute();
        text += "," + dataSfarsit.getDayOfMonth() + "," + dataSfarsit.getMonthValue() + "," + dataSfarsit.getYear() + "," + dataSfarsit.getHour() + "," + dataSfarsit.getMinute();

        return text;
    }

    public static LocalDateTime stringToLocalDateTime (String data){

        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);

        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }
}
