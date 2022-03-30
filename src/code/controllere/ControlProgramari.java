package code.controllere;

import code.clase.data.Data;
import code.clase.programare.Programare;

import java.util.ArrayList;
import java.util.Iterator;

public class ControlProgramari implements Controler<Programare>{

    private ArrayList<Programare> programari;

    public ControlProgramari(){

        programari = new ArrayList<>();
        load();
    }

    @Override
    public void load() {

        Programare cosminLaDentist = new Programare(0,10,9,0, new Data("01,04,2022,12,30","01,04,2022,13,30"));
        Programare ioanLaOrtopeide = new Programare(1,11,4,3,new Data("07,04,2022,09,30","07,04,2022,10,00"));
        Programare andreiLaCardiologie = new Programare(2,12,1,2,new Data("03,04,2022,15,45","03,04,2022,16,30"));
        Programare cosminLaPediatrie = new Programare(3,10,2,2, new Data("29,03,2022,14,15","29,03,2022,15,00"));
        Programare ioanLaDermatologie = new Programare(4,11,5,1,new Data("30,03,2022,10,00","30,03,2022,11,00"));
        Programare andreiLaNutritie = new Programare(5,12,6,1, new Data("10,04,2022,08,30","10,04,2022,09,30"));

        programari.add(cosminLaDentist);
        programari.add(ioanLaOrtopeide);
        programari.add(andreiLaCardiologie);
        programari.add(cosminLaPediatrie);
        programari.add(ioanLaDermatologie);
        programari.add(andreiLaNutritie);
    }

    @Override
    public void traverse() {

        for(Programare p : programari){

            System.out.println(p.describe());
            System.out.println();
        }
    }

    @Override
    public boolean existsID(int id) {

        for(Programare p : programari){

            if(p.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Programare programare) {

        if(!existsID(programare.getId())){

            programari.add(programare);
        }
        else{

            System.out.println("Exista deja acest ID");
        }
    }

    @Override
    public int indexOf(Programare programare) {

        int index = -1;
        for(Programare p : programari){

            index++;
            if(p.equals(programare)){

                return index;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        programari.remove(index);
    }

    @Override
    public void remove(Programare programare) {

        programari.remove(indexOf(programare));
    }

    @Override
    public void saveToFile() {

        //more at 2nd stage of project
    }

    @Override
    public int getNextAvailableID() {
        return programari.get(programari.size() -1).getId() + 1;
    }

    @Override
    public boolean contains(Programare programare) {

        for(Programare p : programari){

            if(p.equals(programare)){

                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return programari.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public Programare getProgramareByID(int id){

        for(Programare p :programari){

            if(p.getId() == id){

                return p;
            }
        }
        return null;
    }

    @Override
    public void modify(Programare programare) {

        if(existsID(programare.getId())){

            Programare programareLista = getProgramareByID(programare.getId());
            programareLista.copy(programare);
        }
    }

    public ArrayList<Programare> getListaByClientID(int id){

        ArrayList<Programare> list = new ArrayList<>();

        for(Programare programare: programari){

            if(programare.getIdClient() == id){

                list.add(programare);
            }
        }
        return list;
    }

}
