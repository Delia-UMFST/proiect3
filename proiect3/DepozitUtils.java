package proiect3;

import proiect3.entitati.gestiune.ComandaIesita;
import proiect3.entitati.gestiune.ComandaIntrata;
import proiect3.entitati.gestiune.ItemComanda;
import proiect3.entitati.inventar.Carte;
import proiect3.entitati.inventar.IProdus;
import proiect3.entitati.inventar.Joc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DepozitUtils {

    public static final int STRING_LENGTH=15;

    private static final IProdus demoProd1 =new Joc("Catan", 3, "12346",100.0);
    private static final IProdus demoProd2 =new Joc("Ticket to Ride", 4, "9274",150.0);
    private static final IProdus demoProd3 =new Joc("Azul", 7, "2713",84.99);
    private static final IProdus demoProd4 =new Carte("Prima mea Enciclopedie", 2, "5555",30.0);
    private static final IProdus demoProd5 =new Carte("Un loc sub soare", 5, "3924",47.5);

    public static final ArrayList<IProdus> produse = new ArrayList<>(
            Arrays.asList(demoProd1, demoProd2, demoProd3, demoProd4, demoProd5)
    );

    public static void initComIntrate(DefaultListModel<ComandaIntrata> comIntrate){
        Random rand = new Random();
        for(int i=0;i<3;++i){
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(demoProd1,1+rand.nextInt(10)));
            prod.add(new ItemComanda(demoProd2,1+rand.nextInt(10)));
            prod.add(new ItemComanda(demoProd4,1+rand.nextInt(10)));
            ComandaIntrata com=new ComandaIntrata(prod,"Client"+i+" SRL");
            comIntrate.addElement(com);
        }
    }

    public static void initComIesite(DefaultListModel<ComandaIesita> comIesite){
        Random rand = new Random();
        for(int i=0;i<3;++i){
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(demoProd3,1+rand.nextInt(10)));
            prod.add(new ItemComanda(demoProd4,1+rand.nextInt(10)));
            prod.add(new ItemComanda(demoProd5,1+rand.nextInt(10)));
            ComandaIesita com=new ComandaIesita(prod,"Furnizor"+i+" SRL");
            comIesite.addElement(com);
        }
    }
}
