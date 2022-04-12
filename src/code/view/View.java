package code.view;

import code.clase.persoane.Client;
import code.controllere.ControlClinici;
import code.controllere.ControlPersoane;
import code.controllere.ControlProgramari;

import java.util.Scanner;

public abstract class View {

    public Scanner read;
    public Client client;

    public ControlProgramari controlProgramari;
    public ControlPersoane controlPersoane;
    public ControlClinici controlClinici;

    public View(ControlPersoane cp, Client c){//trimitem ca parametru si controllerul pentru ca aplicatia sa nu lucreze pe 2 controlere diferite

        controlPersoane = cp;
        this.client = c;

        read = new Scanner(System.in);
        controlClinici = new ControlClinici();
        controlProgramari = new ControlProgramari();
    }

    public abstract void meniu();
    public abstract void play();
}
