package code.clase.clinica;

import java.util.ArrayList;

public class Clinica implements Comparable<Clinica>{

    private int id;
    private String nume;
    private String oras;
    private String adresa;
    private ArrayList<String> specializari;
    private ArrayList<Integer> mediciID;//lista de id-uri de medici care lucreaza la aceasta clinica


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<Integer> getMediciID() {
        return mediciID;
    }

    public void setMediciID(ArrayList<Integer> mediciID) {
        this.mediciID = mediciID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public ArrayList<String> getSpecializari() {
        return specializari;
    }

    public void setSpecializari(ArrayList<String> specializari) {
        this.specializari = specializari;
    }

    public ArrayList<Integer> getMedici() {
        return mediciID;
    }

    public void setMedici(ArrayList<Integer> medici) {
        this.mediciID = medici;
    }


    public Clinica(){

        id = -1;
        nume = "Nume";
        oras = "Oras";
        adresa = "Adresa";
        specializari = new ArrayList<>();
        mediciID = new ArrayList<>();

        specializari.add("psihiatrie");
    }

    public Clinica(int id, String nume, String oras, String adresa, ArrayList<String> specializari, ArrayList<Integer> medici) {
        this.id = id;
        this.nume = nume;
        this.oras = oras;
        this.adresa = adresa;
        this.specializari = specializari;
        this.mediciID = medici;
    }

    public Clinica(String prp, String prpMedici){//prpMedici va fi o lista de ID-uri de medici care lucreaza la aceasta clinica

        String [] v = prp.split(",");
        this.id = Integer.parseInt(v[0]);
        this.nume = v[1];
        this.oras = v[2];
        this.adresa = v[3];

        specializari = new ArrayList<>();
        for(int i = 4; i< v.length; i++){

            specializari.add(v[i]);
        }

        String [] v2 = prpMedici.split(",");
        mediciID = new ArrayList<>();
        for(int i = 0;i< v2.length; i++){

            mediciID.add(Integer.parseInt(v2[i]));
        }
    }

    public String describe(){

        String text = "";
        text += "\nID : " + id;
        text += "\nNume : " + nume;
        text += "\nOras : " + oras;
        text += "\nAdresa : " + adresa;
        text += "\nSpecializari : ";
        for(int i = 0;i < specializari.size(); i++){

            if(i == specializari.size() -1){

                text += specializari.get(i) + ".";
            }
            else{

                text += specializari.get(i) + ", ";
            }
        }
        text += "\nNumar medici : " + mediciID.size();

        return text;
    }

    @Override
    public int compareTo(Clinica c){//compare dupa nr de specializari

        if(this.specializari.size() < c.specializari.size()){

            return -1;
        }
        else if(this.specializari.size() > c.specializari.size()){

            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){//egale dupa nr de medici

        Clinica c = (Clinica) o;
        return this.getId() == c.getId() && this.nume.equals(c.getNume());
    }

    @Override
    public String toString(){

        String text = "";
        text += id + "," + nume + "," + oras + "," + adresa + ",";
        for(int i = 0;i <specializari.size(); i++){

            if(i != specializari.size() -1){

                text += specializari.get(i) + ",";
            }
            else{

                text += specializari.get(i);
            }
        }

        text += "\n";

        for(int i = 0;i <mediciID.size(); i++){

            if(i != mediciID.size() -1){

                text += mediciID.get(i) + ",";
            }
            else{

                text += mediciID.get(i);
            }
        }

        return text;
    }

    public void copy(Clinica c){

        //return new Clinica(c.getId(), c.getNume(), c.getOras(), c.getAdresa(), c.getSpecializari(), c.getMediciID());
        this.setNume(c.getNume());
        this.setOras(c.getOras());
        this.setMediciID(c.getMediciID());
        this.setSpecializari(c.getSpecializari());
        this.setAdresa(c.getAdresa());
    }

    public boolean existaSpecializare(String specializare){

        for(String s:specializari){

            if(s.equals(specializare)){

                return true;
            }
        }

        return false;
    }
}
