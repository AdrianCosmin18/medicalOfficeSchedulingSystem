package code.view;

import code.clase.IOsingleton;
import code.clase.clinica.Clinica;
import code.clase.persoane.Client;
import code.clase.persoane.Medic;
import code.clase.persoane.Persoana;
import code.controllere.ControlClinici;
import code.controllere.ControlPersoane;
import code.controllere.ControlProgramari;

import java.util.Scanner;

public abstract class View {

    public Scanner read;
    public Client client;
    public Medic medic;

    public ControlProgramari controlProgramari;
    public ControlPersoane controlPersoane;
    public ControlClinici controlClinici;
    public IOsingleton iOsingleton;

    public View(ControlPersoane cp, Persoana p){//trimitem ca parametru si controllerul pentru ca aplicatia sa nu lucreze pe 2 controlere diferite

        controlPersoane = cp;
        if(p instanceof Client){

            this.client = (Client) p;
            this.medic = null;
        }
        else if(p instanceof Medic){

            this.client = null;
            this.medic = (Medic) p;
        }
        //this.client = c;

        read = new Scanner(System.in);
        controlClinici = new ControlClinici();
        controlProgramari = new ControlProgramari();
        iOsingleton = IOsingleton.getInstance();
    }

    public abstract void meniu();
    public abstract void play();
}
