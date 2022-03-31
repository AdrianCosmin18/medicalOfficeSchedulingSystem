package code.clase.persoane;

public class Client extends Persoana implements Comparable<Client> {

    private String adresa;
    public String telefon;


    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Client() {

        this.setId(-1);
        this.setNume("nume");
        this.setParola("parola");
        this.setVarsta(0);
        this.setTip("Client");
        this.adresa = "adresa";
        this.telefon = "00000000";
    }

    public Client(int id, String nume, String parola, int varsta, String tip, String adresa, String telefon) {

        super(id, nume, parola, varsta, "Client");
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Client(String prp){

        String v [] = prp.split(",");
        this.setId(Integer.parseInt(v[0]));
        this.setNume(v[1]);
        this.setParola(v[2]);
        this.setVarsta((Integer.parseInt(v[3])));
        this.setTip(v[4]);
        this.adresa = v[5];
        this.telefon = v[6];
    }


    @Override
    public boolean equals(Object o){//egalitate dupa nume

        Persoana p = (Persoana) o;
        return this.getId() == p.getId() && this.getNume().equals(p.getNume());
    }

    @Override
    public String toString(){

        return getId() + "," + getNume() + "," + getParola() + "," + getVarsta() + "," + getTip() + "," + adresa + "," + telefon;
    }

    @Override
    public String describe(){

        String text = "";
        text += "\nID : " + getId();
        text += "\nNume : " + getNume();
        text += "\nVarsta : " + getVarsta();
        text += "\nAdresa : " + adresa;
        text += "\nTelefon : " + telefon;
        text += "\nTip : " + getTip();

        return text;
    }

    @Override
    public int compareTo(Client c) {//compare dupa varsta

        if(this.getVarsta() < c.getVarsta()){

            return -1;
        }
        else if(this.getVarsta() > c.getVarsta()){

            return 1;
        }
        else{

            return 0;
        }
    }

    @Override
    public void copy(Persoana p){

        try{

            Client c = (Client) p;
            this.setNume(c.getNume());
            this.setVarsta(c.getVarsta());
            this.setParola(c.getParola());
            this.setTip(c.getTip());
            this.adresa = c.adresa;
            this.telefon = c.telefon;
            //return new Client(c.getId(), c.getNume(), c.getParola(), c.getVarsta(), c.getTip(), adresa, telefon);
        }catch (Exception e){

            System.out.println("EROARE la copy");
            //return null;
        }
    }
}
