package code.clase.persoane;

public abstract class Persoana {

    private int id;
    private String nume;
    private String parola;
    private int varsta;
    private String tip;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }



    public Persoana(int id, String nume, String parola, int varsta, String tip) {

        this.id = id;
        this.nume = nume;
        this.parola = parola;
        this.varsta = varsta;
        this.tip = tip;
    }

    public Persoana(){

        this.id = -1;
        this.nume = "nume";
        this.parola = "parola";
        this.varsta = 0;
        this.tip = "Persoana";
    }

    @Override
    public boolean equals(Object o){

        Persoana p = (Persoana) o;
        return this.getId() == p.getId() && this.getNume().equals(p.getNume());
    }

    public abstract void copy(Persoana p);

    public abstract String describe();

}
