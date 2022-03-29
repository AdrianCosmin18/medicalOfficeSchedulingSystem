package code.view;

import code.clase.clinica.Clinica;
import code.clase.persoane.Client;
import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;
import code.controllere.ControlClinici;
import code.controllere.ControlPersoane;
import code.controllere.ControlProgramari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ViewClient implements View{

    private Scanner read;
    private Client client;

    private ControlProgramari controlProgramari;
    private ControlPersoane controlPersoane;
    private ControlClinici controlClinici;



    public ViewClient(ControlPersoane cp, Client c){//trimitem ca parametru si controllerul pentru ca aplicatia sa nu lucreze pe 2 controlere diferite

        controlPersoane = cp;
        this.client = c;

        read = new Scanner(System.in);
        controlClinici = new ControlClinici();
        controlProgramari = new ControlProgramari();
    }

    @Override
    public void meniu() {

        System.out.println("\n\nContul meu : " + client.getNume());
        System.out.println("======================================");
        System.out.println("1. Lista tuturor clinicilor MedLife cu informatii");
        System.out.println("2. Informatii suplimentare despre o anumita clinica");//afiseaza describe-ul clincii dar si informatii depsre medici in acelasi timp
        System.out.println("3. Afla adresa unei anumite clinici");
        System.out.println("4. Lista tuturor medicilor");
        System.out.println("5. Inregistreaza o programare");
        System.out.println("6. Istoricul programarilor mele");
        System.out.println("7. Modifica data unei programari");
        System.out.println("8. Iesire");
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

                case 3 : adresaClinica();
                break;

                case 4 : listaMedici();
                break;

                case 8: run = false;
                break;
            }
        }
    }

    //Eroare: face sortare dar mai trebuie verificat !!!!!!!!!!!!!!!!!!!
    public void listaClinici(){

        System.out.print("Doriti afisate clinicile in ordine descrescatoare dupa numarul de specializari (da/nu) : ");
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

    public void listaMedici(){

        System.out.print("Doriti afisati medici in ordine crescatoare dupa numarul de ani de experienta ai acestora (da/nu) : ");
        String alegere;
        alegere = read.nextLine();


        ArrayList<Persoana> persoane = controlPersoane.getPersoane();
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
}
