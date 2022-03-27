package code.controller;

import code.clase.clinica.Clinica;
import code.clase.persoane.Persoana;

import java.util.ArrayList;

public class ControlClinici implements Controler{


    private ArrayList<Clinica> clinici;

    public ControlClinici(){

        clinici = new ArrayList<>();
        load();
    }

    @Override
    public void load() {

        Clinica c1 = new Clinica("0,Hyperclinica MedLife Favorit,Bucuresti,Drumul Taberei 24,stomatologie,ortopedie,cardiologie", "9,8,7");
        Clinica c2 = new Clinica("1,Hyperclinica MedLife PDR Turnului Brasov,Brasov,Strada Turnului 5,nutritie,dermatologie","6,5");
        Clinica c3 = new Clinica("2,Hyperclinica MedLife Cluj,Cluj,Calea Moților 32,cardiologie,pediatrie","1,2");
        Clinica c4 = new Clinica("3,Hyperclinica MedLife Unirii,Bucuresti,Strada Hans Cristian Andersen 1,stomatologie,ortopedie","3,4");

        clinici.add(c1);
        clinici.add(c2);
        clinici.add(c3);
        clinici.add(c4);
    }

    @Override
    public void traverse() {

        for(Clinica clinica : clinici){

            System.out.println(clinica.describe());
        }
    }

    @Override
    public boolean existsID(int id) {

        for(Clinica c : clinici){

            if(c.getId() == id){

                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object o) {

        Clinica c = (Clinica) o;
        if(!existsID(c.getId())){

            clinici.add(c);
        }
        else{
            System.out.println("Exista deja acest id");
        }
    }

    @Override
    public int indexOf(Object o) {

        Clinica c = (Clinica) o;
        int index = -1;
        for(Clinica clinica : clinici){

            index++;
            if(clinica.equals(c)){

                return index;
            }
        }
        return -1;
    }

    //@Override
    public void remove(Object o){

        clinici.remove(indexOf((Clinica)o));
    }

    public void remove(int index){

        clinici.remove(index);
    }

    @Override
    public void saveToFile() {
        //nothing for the moment => more to 2nd stage

    }

    @Override
    public int getNextAvailableID() {

        return clinici.get(clinici.size() - 1).getId() + 1;
    }

    @Override
    public boolean contains(Object o) {

        for(Clinica c : clinici){

            if(c.equals((Clinica) o)){

                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return clinici.size();
    }

    @Override
    public boolean isEmpty() {

        if(size() == 0){

            return true;
        }
        return false;
    }

    public int getIdByName(String name){

        for(Clinica c :clinici){

            if(c.getNume().equals(name)){

                return c.getId();
            }
        }
        return -1;
    }

    public Clinica getClinicaByID(int id){

        for(Clinica c : clinici){

            if(c.getId() == id){

                return c;
            }
        }
        return null;
    }

    public void modify(int id, String nume, String oras, String adresa, ArrayList<String> specializari, ArrayList<Integer> mediciID){

        try{

            Clinica clinica = getClinicaByID(id);
            clinica.setNume(nume);
            clinica.setOras(oras);
            clinica.setAdresa(adresa);
            clinica.setSpecializari(specializari);
            clinica.setMediciID(mediciID);
        }catch (Exception e){

            System.out.println("EROARE la modificare clinica");
        }
    }

    public Clinica getClinicaByNameAndOras(String nume, String oras){

        for(Clinica clinica : clinici){

            if(clinica.getNume().equals(nume) && clinica.getOras().equals(oras)){

                return clinica;
            }
        }
        return null;
    }
}
