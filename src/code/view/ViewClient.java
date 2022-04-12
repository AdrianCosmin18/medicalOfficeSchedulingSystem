
package code.view;

import code.clase.clinica.Clinica;
import code.clase.data.Data;
import code.clase.persoane.Client;
import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;
import code.clase.programare.Programare;
import code.controllere.ControlClinici;
import code.controllere.ControlPersoane;
import code.controllere.ControlProgramari;
import static code.clase.Util.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;



public class ViewClient extends View{

//    private Scanner read;
//    private Client client;
//
//    private ControlProgramari controlProgramari;
//    private ControlPersoane controlPersoane;
//    private ControlClinici controlClinici;



    public ViewClient(ControlPersoane cp, Client client){//trimitem ca parametru si controllerul pentru ca aplicatia sa nu lucreze pe 2 controlere diferite

        super(cp, client);
//        controlPersoane = cp;
//        this.client = c;
//
//        read = new Scanner(System.in);
//        controlClinici = new ControlClinici();
//        controlProgramari = new ControlProgramari();
    }

    @Override
    public void meniu() {

        System.out.println("\n\nContul meu : " + client.getNume());
        System.out.println("======================================");
        System.out.println("1. Lista tuturor clinicilor MedLife cu informatii");
        System.out.println("2. Informatii suplimentare despre o anumita clinica");//afiseaza describe-ul clincii dar si informatii depsre medici in acelasi timp
        System.out.println("3. Afla lista specializarilor unei clinici");
        System.out.println("4. Afla adresa unei anumite clinici");
        System.out.println("5. Lista tuturor medicilor");
        System.out.println("6. Inregistreaza o programare");
        System.out.println("7. Toate programarilor mele");
        System.out.println("8. Modifica data unei programari");
        System.out.println("9. Stergeti o programare");
        System.out.println("10. Iesire");
    }

    @Override
    public void play() {

        boolean run = true;
        int alegere;

        while(run){

            meniu();
            System.out.println("\nTasta : ");
            alegere = Integer.parseInt(read.nextLine());

            switch (alegere){

                case 1: listaClinici();
                break;

                case 2: infoAnumitaClinica();
                break;

                case 3: listaSpecializari();
                break;

                case 4 : adresaClinica();
                break;

                case 5 : listaMedici();
                break;

                case 6: inregistreazaProgramare();
                break;

                case 7:istoricProgramari();
                break;

                case 8: modificaDataProgramare();
                break;

                case 9: stergeProgramare();
                break;

                case 10: run = false;
                break;
            }
        }
    }

    public void listaClinici(){

        System.out.print("Doriti afisate clinicile in ordine crescatoare dupa numarul de specializari (da/nu) : ");
        String alegere;
        alegere = read.nextLine();

        if(alegere.equals("da")){

            ArrayList<Clinica> clinici = controlClinici.getClinici();
            Collections.sort(clinici);

            for(Clinica c : clinici){

                System.out.println(c.describe());
                System.out.println();
            }
        }
        else if(alegere.equals("nu")){

            controlClinici.traverse();
        }
    }

    public void infoAnumitaClinica(){

        System.out.println("Introducei ID-ul clinicii depsre care doriti informatii amanuntite");
        int id = Integer.parseInt(read.nextLine());

        if(controlClinici.existsID(id)){

            Clinica clinica = controlClinici.getClinicaByID(id);
            ArrayList<Integer> listaMedici = clinica.getMedici();

            System.out.println(clinica.describe());

            for(Integer idMedic : listaMedici){

                Medic medic = (Medic) controlPersoane.getPersoanaByID(idMedic);
                System.out.println("\nMedic :");
                System.out.println(medic.describe());
            }
        }
        else{

            System.out.println("Nu exista o clinica cu aceast ID");
        }
    }

    public void adresaClinica(){

        System.out.print("Introduceti ID-ul clincii a carei adresa doriti sa o aflati : ");
        int id = Integer.parseInt(read.nextLine());

        if(controlClinici.existsID(id)){

            Clinica clinica = controlClinici.getClinicaByID(id);
            System.out.println("Adresa clinici " + clinica.getNume() + " este : " + clinica.getAdresa());
        }
        else{
            System.out.println("Nu exista clinica cu acest id");
        }
    }

    public void listaSpecializari(){

        System.out.print("Introdu ID-ul clinicii : ");
        int id = Integer.parseInt(read.nextLine());

        if(controlClinici.existsID(id)){

            ArrayList<String> specializari = controlClinici.getClinicaByID(id).getSpecializari();
            System.out.println("Clinica : " + controlClinici.getClinicaByID(id).getNume() + " are specializarile : ");
            for(String s:specializari){

                System.out.println(s);
            }
        }
    }

    public void listaMedici(){

        System.out.print("Doriti afisati medici in ordine crescatoare dupa numarul de ani de experienta ai acestora (da/nu) : ");
        String alegere;
        alegere = read.nextLine();


        Vector<Persoana> persoane = controlPersoane.getPersoane();
        ArrayList<Medic> medici = new ArrayList<>();

        for(Persoana p : persoane){

            if(p instanceof Medic){

                medici.add((Medic) p);
            }
        }

        if(alegere.equals("da")){

            Collections.sort(medici);
        }

        for(Medic m : medici){

            System.out.println(m.describe());
            System.out.println();
        }
    }

    public void inregistreazaProgramare(){

        System.out.println("Introduce ID-ul clinicii in care doriti sa va programati :");
        int idClinica = Integer.parseInt(read.nextLine());

        if(controlClinici.existsID(idClinica)){//verif daca exista clinica

            Clinica clinica = controlClinici.getClinicaByID(idClinica);

            System.out.println("Clinica : " + clinica.getNume() + " are specializarile : ");//afis specializ clinicii
            for(String s: clinica.getSpecializari()){

                System.out.println(s);
            }

            System.out.print("Introdcueti specializarea la care doriti sa va programati : ");
            String specializare = read.nextLine();

            if(clinica.existaSpecializare(specializare)){//verif dc clinica are specializarea introdusa

                int medicID = -1;
                ArrayList<Integer> mediciID = clinica.getMediciID();//obt id-ul medicului pt a inregistra programarea
                for(Integer id: mediciID) {

                    Medic m = (Medic) controlPersoane.getPersoanaByID(id);
                    if(m.getSpecializare().equals(specializare)){

                        medicID = m.getId();
                    }
                }

                System.out.println("Introdu noua data la care vrei sa te programezi");
                System.out.println("Exemplu introducere data : '18,12,2022,16,30' ceea ce inseamna 18 dec 2022 la ora 16:30");
                System.out.print("Data : ");
                String startData = read.nextLine();

                LocalDateTime localDateTimeStart = stringToLocalDateTime(startData);
                LocalDateTime localDateTimeStop = localDateTimeStart.plusHours(1);


                controlProgramari.add(new Programare(controlProgramari.getNextAvailableID(), this.client.getId(), medicID, clinica.getId(), new Data(localDateTimeStart, localDateTimeStop)));
                controlProgramari.saveToFile();
                System.out.println("Inregistrare realizata cu succes !!!");

            }
            else{

                System.out.println("Nu exista aceasta specializare in aceasta clinica");
            }
        }
        else{

            System.out.println("Nu exista o clinica cu acest ID");
        }
    }

    public void istoricProgramari(){

        System.out.println("Istoricul meu :");
        ArrayList<Programare> programari = controlProgramari.getListaByClientID(client.getId());

        int count = 0;
        for(Programare p: programari){

            count++;
            System.out.println("Programarea : " + count);
            System.out.println("ID: " + p.getId());
            System.out.println("Clinica: " + controlClinici.getClinicaByID(p.getIdClinica()).getNume());
            System.out.println("Specializarea: " + ((Medic) controlPersoane.getPersoanaByID(p.getIdMedic())).getSpecializare());
            System.out.println(p.getData());
            System.out.println();
        }
    }

    public void modificaDataProgramare(){

        System.out.println("Introduce data la care esti programat");
        System.out.println("Exemplu introducere data : 18,12,2022,16,30 = 18 dec 2022 la ora 16:30");
        System.out.print("Data :");
        String dataInceput = read.nextLine();
        Data data = new Data(dataInceput, dataInceput);

        System.out.println("Introdu noua data la care vrei sa te programezi");
        System.out.println("Exemplu introducere data : 18,12,2022,16,30 = 18 dec 2022 la ora 16:30");
        System.out.print("Data :");
        String nouaDataInceput = read.nextLine();

        LocalDateTime localDateTimeStart = stringToLocalDateTime(nouaDataInceput);
        LocalDateTime localDateTimeStop = localDateTimeStart.plusHours(1);

        Data nouaData = new Data(localDateTimeStart, localDateTimeStop);

        ArrayList<Programare> programari = controlProgramari.getListaByClientID(client.getId());
        for(Programare p: programari){

            if(p.getData().getDataInceput().equals(data.getDataInceput())){

                p.setData(nouaData);
                controlProgramari.saveToFile();
                System.out.println("Data modificata cu succes !!!");
                break;
            }
        }
    }

    public void stergeProgramare(){

        System.out.print("Introduce ID-ul programarii pe care vrei sa o stergi : ");
        int id = Integer.parseInt(read.nextLine());

        if(controlProgramari.existsID(id)){

            controlProgramari.remove(controlProgramari.indexOf(controlProgramari.getProgramareByID(id)));
            controlProgramari.saveToFile();
            System.out.println("Stergerea programarii a fost realizata cu succes !!!");
        }
        else{
            System.out.println("Nu exista o programare cu acest ID !!!");
        }
    }
}
