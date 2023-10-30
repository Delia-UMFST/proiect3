package proiect3;

import proiect3.entitati.gestiune.ComandaIesita;
import proiect3.entitati.gestiune.ComandaIntrata;
import proiect3.entitati.gestiune.ItemComanda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class DepozitUtils {

    public static final int STRING_LENGTH=15;



        public static void initComIntrate(DefaultListModel<ComandaIntrata> comIntrate){
        Random rand = new Random();
        for(int i=0;i<3;++i){
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+1),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+2),1+rand.nextInt(10)));
            ComandaIntrata com=new ComandaIntrata(prod,"Client"+i+" SRL");
            comIntrate.addElement(com);
        }
    }

    public static void initComIesite(DefaultListModel<ComandaIesita> comIesite){
        Random rand = new Random();
        for(int i=0;i<3;++i){
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+1),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+2),1+rand.nextInt(10)));
            ComandaIesita com=new ComandaIesita(prod,"Furnizor"+i+" SRL");
            comIesite.addElement(com);
        }
    }
}
