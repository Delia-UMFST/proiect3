package proiect3;

import proiect3.entitati.inventar.Carte;
import proiect3.entitati.inventar.IProdus;
import proiect3.entitati.inventar.Joc;
import proiect3.gui.Start;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


public class DepozitMagazin extends JFrame {
    private static final IProdus demoProd1 =new Joc("Catan", 3, "12346",100.0);
    private static final IProdus demoProd2 =new Joc("Ticket to Ride", 4, "9274",150.0);
    private static final IProdus demoProd3 =new Joc("Azul", 7, "2713",100.99);
    private static final IProdus demoProd4 =new Carte("Prima mea Enciclopedie", 2, "5555",30.0);
    private static final IProdus demoProd5 =new Carte("Un loc sub soare", 5, "3924",47.5);

    private static final ArrayList<IProdus> produse = new ArrayList<>(
            Arrays.asList(demoProd1, demoProd2, demoProd3, demoProd4, demoProd5)
    );

    public static ArrayList<IProdus> getProduse(){
        return produse;
    }

    public DepozitMagazin() {

        new Start(produse);


    }

}
