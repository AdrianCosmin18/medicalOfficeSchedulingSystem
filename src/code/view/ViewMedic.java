package code.view;

import code.clase.persoane.Medic;
import code.controllere.ControlPersoane;

//medicul va fi admin, el va avea si comeznile unui client + lucruri pe care le poate face un admin
//public class ViewMedic extends View{

//    public ViewMedic(ControlPersoane cp, Medic medic){
//        super(cp, medic);
//    }
//
//
//    @Override
//    public void meniu(){
//
//        System.out.println("\n\nCont meu de Medic Admin : " + medic.getNume());
//        System.out.println("\nInformtii generale: ");
//        System.out.print("Numarul total de clienti inregistrati : " + controlPersoane.size());
//        System.out.println("");
//
//        System.out.println("\n======================================");
//        System.out.println("Meniul de tip client:");
//        System.out.println("1. Lista tuturor clinicilor MedLife cu informatii");
//        System.out.println("2. Informatii suplimentare despre o anumita clinica");//afiseaza describe-ul clincii dar si informatii depsre medici in acelasi timp
//        System.out.println("3. Afla lista specializarilor unei clinici");
//        System.out.println("4. Afla adresa unei anumite clinici");
//        System.out.println("5. Lista tuturor medicilor");
//        System.out.println("6. Inregistreaza o programare");
//        System.out.println("7. Toate programarilor mele");
//        System.out.println("8. Modifica data unei programari");
//        System.out.println("9. Stergeti o programare");
//
//        System.out.println("\n======================================");
//        System.out.println("Meniu de admin:");
//        System.out.println("10. Adauga un nou client/medic");
//        System.out.println("11. Sterge un client/medic");
//        System.out.println("12. Verifica existenta unui client/medic");
//        System.out.println("13. Modifica un client/medic");
//
//        System.out.println("14. ");
//        System.out.println("10. Iesire");
//    }
//
//    @Override
//    public void play(){
//
//        System.out.println();
//    }
//}
