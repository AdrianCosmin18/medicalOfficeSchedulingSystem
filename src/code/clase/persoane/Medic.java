package code.clase.persoane;

public class Medic extends Persoana implements Comparable<Medic>{

    private String specializare;
    private double salariu;
    private int experienta;//nr de ani



    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public int getExperienta() {
        return experienta;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public Medic(){

        this.setId(-1);
        this.setNume("nume");
        this.setParola("parola");
        this.setVarsta(0);
        this.setTip("Medic");
        this.specializare = "Specializare";
        this.salariu = 0;
        this.experienta = 0;
    }

    public Medic(int id, String nume, String parola, int varsta, String tip, String specializare, double salariu, int xp) {

        super(id, nume, parola, varsta, tip);
        this.specializare = specializare;
        this.salariu = salariu;
        this.experienta = xp;
    }

    public Medic(String prp){

        String [] v = prp.split(",");
        this.setId(Integer.parseInt(v[0]));
        this.setNume(v[1]);
        this.setParola(v[2]);
        this.setVarsta((Integer.parseInt(v[3])));
        this.setTip(v[4]);
        this.specializare = v[5];
        this.salariu = Double.parseDouble(v[6]);
        this.experienta = Integer.parseInt(v[7]);
    }

    @Override
    public String toString(){

        return getId() + "," + getNume() + "," + getParola() + "," + getVarsta() + "," + getTip() + "," + getSpecializare()  + "," + getSalariu() + "," + getExperienta();
    }

    @Override
    public String describe() {

        String text = "";
        text += "\nID : " + this.getId();
        text += "\nNume : " + this.getNume();
        text += "\nVarsta : " + this.getVarsta();
        text += "\nTip : " + this.getTip();
        text += "\nSpecializare : " + this.specializare;
        text += "\nExperienta : " + this.experienta + " ani";

        return text;
    }

    @Override
    public boolean equals(Object o){//dupa specializare si ID

        Medic m = (Medic) o;
        return m.specializare.equals(this.specializare) && m.getId() == this.getId();
//        Persoana p = (Persoana) o;
//        return this.getId() == p.getId() && this.getNume().equals(p.getNume());
    }

    @Override
    public int compareTo(Medic m){//compare dupa anii de experienta

        if(this.experienta < m.experienta){

            return -1;
        }
        else if(this.experienta > m.experienta){

            return 1;
        }
        else{

            return 0;
        }
    }

    @Override
    public void copy(Persoana p) {

        try {
            Medic m = (Medic) p;
            this.setNume(m.getNume());
            this.setVarsta(m.getVarsta());
            this.setParola(m.getParola());
            this.setTip(m.getTip());
            this.specializare = m.specializare;
            this.salariu = m.salariu;
            this.experienta = m.experienta;
            //return new Medic(m.getId(), m.getNume(), m.getParola(), m.getVarsta(), m.getTip(), m.specializare, m.salariu, m.experienta);

        } catch (Exception e) {

            System.out.println("EROARE la copiere");
            //return null;
        }
    }
}
