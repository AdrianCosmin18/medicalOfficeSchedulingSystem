package code.clase.programare;

import code.clase.data.Data;

public class Programare {

    private int id;
    private int idClient;
    private int idMedic;
    private int idClinica;
    private Data data;//dd mm yyyy hh mm

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public Programare(int id, int idClient, int idMedic, int idClinica, Data data) {
        
        this.id = id;
        this.idClient = idClient;
        this.idMedic = idMedic;
        this.idClinica = idClinica;
        this.data = data;
    }

    public Programare(String prp){

        id = Integer.parseInt(prp.split(",")[0]);
        idClient = Integer.parseInt(prp.split(",")[1]);
        idMedic = Integer.parseInt(prp.split(",")[2]);
        idClinica = Integer.parseInt(prp.split(",")[3]);

        String [] v = prp.split(",");
        String text1 = "";
        for(int i=4; i <= 8; i++){

            if(i != 8){

                text1 += v[i] + ",";
            }
            else{
                text1 += v[i];
            }
        }

        String text2 = "";
        for(int i = 9; i <= 13; i++){

            if(i != 13){

                text2 += v[i] += ",";
            }
            else{
                text2 += v[i];
            }
        }

        data = new Data(text1, text2);
    }

    @Override
    public String toString(){

        return id + "," + idClient + "," + idMedic + "," + idClinica;
    }

    @Override
    public boolean equals(Object o){//egalitate daca eu acelasi client

        return this.idClient == ((Programare) o).idClient;
    }

    public String describe(){

        String text = "";
        text += "ID Programare : "+ id;
        text += "\nID client : " + idClient;
        text += "\nID medic : " + idMedic;
        text += "\nID clinica : " + idClinica;
        text += "\n" + data;

        return text;
    }

    public Programare copy(Programare p){

        return new Programare(p.getId(), p.getIdClient(), p.getIdMedic(), p.getIdClinica(), p.getData());
    }
}
