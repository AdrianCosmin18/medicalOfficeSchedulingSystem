package code.controllere;

import code.clase.clinica.Clinica;
import code.clase.persoane.Client;
import code.clase.persoane.Persoana;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ControlClinici implements Controler<Clinica>{


    private ArrayList<Clinica> clinici;

    public ArrayList<Clinica> getClinici() {
        return clinici;
    }

    public ControlClinici(){

        clinici = new ArrayList<>();
        load();
    }

    @Override
    public void load() {

//        Clinica c1 = new Clinica("1,Hyperclinica MedLife PDR Turnului Brasov,Brasov,Strada Turnului 5,nutritie,dermatologie","6,5");
//        Clinica c2 = new Clinica("2,Hyperclinica MedLife Cluj,Cluj,Calea Moților 32,cardiologie,pediatrie,nutritie","1,2,10");
//        Clinica c3 = new Clinica("3,Hyperclinica MedLife Unirii,Bucuresti,Strada Hans Cristian Andersen 1,stomatologie,ortopedie","3,4");
//        Clinica c4 = new Clinica("4,Hyperclinica MedLife Favorit,Bucuresti,Drumul Taberei 24,stomatologie,ortopedie,cardiologie", "9,8,7");
//
//        clinici.add(c1);
//        clinici.add(c2);
//        clinici.add(c3);
//        clinici.add(c4);
        try{
            File f = new File("src/code/clase/fisiere/clinici.csv");
            Scanner read = new Scanner(f);
            while(read.hasNextLine()){

                String text1 = read.nextLine();
                String text2 = read.nextLine();
                clinici.add(new Clinica(text1, text2));
            }
        }catch(Exception e){}
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
    public void add(Clinica c) {

        if(!existsID(c.getId())){

            clinici.add(c);
        }
        else{
            System.out.println("Exista deja acest id");
        }
    }

    @Override
    public int indexOf(Clinica c) {

        int index = -1;
        for(Clinica clinica : clinici){

            index++;
            if(clinica.equals(c)){

                return index;
            }
        }
        return -1;
    }

    @Override
    public void remove(Clinica c){

        clinici.remove(indexOf(c));
    }

    public void remove(int index){

        clinici.remove(index);
    }

    @Override
    public void saveToFile() {
        //nothing for the moment => more to 2nd stage
        try{

            File f = new File("src/code/clase/fisiere/clinici.csv");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            String text = "";
            Iterator<Clinica> itr = clinici.iterator();
            while(itr.hasNext()){

                Clinica c = itr.next();
                text += c + "\n";
            }
            pw.print(text);
            pw.close();
        }catch (Exception e){}
    }

    @Override
    public int getNextAvailableID() {

        return clinici.get(clinici.size() - 1).getId() + 1;
    }

    @Override
    public boolean contains(Clinica c) {

        for(Clinica clinica : clinici){

            if(c.equals(clinica)){

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

    public void modify(Clinica clinicaModif){

        if(existsID(clinicaModif.getId())){

            Clinica clinicaLista = getClinicaByID(clinicaModif.getId());
            clinicaLista.copy(clinicaModif);
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
