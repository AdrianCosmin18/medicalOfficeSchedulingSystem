package code.controller;

import code.clase.persoane.Client;
import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;

import java.util.ArrayList;

public class ControlPersoane implements Controler{

    private ArrayList<Persoana> persoane;

    @Override
    public void load() {

        Medic m1 = new Medic("1,Nedelcu Andrei,1234,18,Medic,cardiologie,2500,2");
        Medic m2 = new Medic("2,Nedelcu Clauida,1234,47,Medic,pediatrie,3800,20");
        Medic m3 = new Medic("3,Laurentiu,1234,26,Medic,stomatologie,2750,3");
        Medic m4 = new Medic("4,Gral Mihai,4567,33,Medic,ortopedie,3200,6");
        Medic m5 = new Medic("5,Muzulescu Andrei,parola,35,Medic,dermatologie,2500,3");//
        Medic m6 = new Medic("6,Leustean Alexandru,parola,22,Medic,nutritie,3000,1");//
        Medic m7 = new Medic("7,Dos Santos Aveiro,1234,37,Medic,cardiologie,2600,10");//
        Medic m8 = new Medic("8,Leo Alex,123456,40,Medic,ortopedie,5000,15");//
        Medic m9 = new Medic("9,Anne,12345,30,Medic,stomatologie,2000,6");//

        Client cosmin = new Client("10,Nedelcu Cosmin,12345,22,Client,Timisul de Jos 3,0773941106");
        Client ioan = new Client("11,Nedelcu Ioan,12345,53,Client,Callatis 12,0773941080");
        Client andrei = new Client("12,Mircea Andrei,12345,18,Client,Callatis 12,0789345123");

        persoane.add(m1);
        persoane.add(m2);
        persoane.add(m3);
        persoane.add(m4);
        persoane.add(m5);
        persoane.add(m6);
        persoane.add(m7);
        persoane.add(m8);
        persoane.add(m9);
        persoane.add(cosmin);
        persoane.add(ioan);
        persoane.add(andrei);
    }

    @Override
    public void traverse() {

        for(Persoana p : persoane){

            System.out.println(p.describe());
        }
    }

    public ControlPersoane(){

        persoane = new ArrayList<>();
        load();
    }

    @Override
    public boolean existsID(int id) {

        for(Persoana p : persoane){

            if(p.getId() == id){

                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object o) {

        Persoana p = (Persoana) o;
        if(!existsID(p.getId())){

            persoane.add(p);
        }
        else{
            System.out.println("Exista deja acest id");
        }
    }

    @Override
    public int indexOf(Object o) {

        Persoana persoana = (Persoana) o;
        int index = -1;
        for(Persoana p : persoane){

            index++;
            if(p.equals(persoana)){

                return index;
            }
        }
        return -1;
    }

    //@Override
    public void remove(int index) {

        persoane.remove(index);
    }

    //@Override
    public void remove(Object o){

        persoane.remove(indexOf(o));
    }

    @Override
    public void saveToFile() {

        //nothing for the moment => more to 2nd stage
    }

    @Override
    public int getNextAvailableID() {

        return persoane.get(persoane.size() - 1).getId() + 1;
    }

    @Override
    public boolean contains(Object o) {

        for(Persoana p : persoane){

            if(p.equals((Persoana) o)){

                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return persoane.size();
    }

    @Override
    public boolean isEmpty() {

        if(size() == 0){

            return true;
        }
        return false;
    }

    public int getIdByName(String name){

        for(Persoana p :persoane){

           if(p.getNume().equals(name)){

               return p.getId();
           }
        }
        return -1;
    }

    Persoana getPersoanaByID(int id){

        for(Persoana p : persoane){

            if(p.getId() == id){

                return p;
            }
        }
        return null;
    }

    //@Override
    public void modifyClient(int id, String nume, String parola, int varsta, String adresa, String telefon) {

        Persoana pers = getPersoanaByID(id);

        try{

            Client client = (Client) pers;
            client.setNume(nume);
            client.setParola(parola);
            client.setVarsta(varsta);
            client.setAdresa(adresa);
            client.setTelefon(telefon);
        }catch (Exception e){

            System.out.println("EROARE!");
        }
    }

    public void modifyMedic(int id, String nume, String parola, int varsta, String specializare, double salariu, int xp){

        Persoana pers = getPersoanaByID(id);

        try{

            Medic medic = (Medic) pers;
            medic.setParola(parola);
            medic.setNume(nume);
            medic.setVarsta(varsta);
            medic.setExperienta(xp);
            medic.setSalariu(salariu);
            medic.setSpecializare(specializare);

        }catch (Exception e){

            System.out.println("EROARE!");
        }
    }

    public Persoana getPersonByNameAndPassword(String name, String password){

        for(Persoana p : persoane){

            if(p.getNume().equals(name) && p.getParola().equals(password)){

                return p;
            }
        }
        return null;
    }
}
