package proiect3;

import proiect3.entitati.gestiune.ComandaIesita;
import proiect3.entitati.gestiune.ComandaIntrata;
import proiect3.entitati.gestiune.ItemComanda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class DepozitUtils {

    public static final int STRING_LENGTH=15;


        //lista cu comenzile intrate
        public static void initComIntrate(DefaultListModel<ComandaIntrata> comIntrate){
        Random rand = new Random();//randomizare
        for(int i=0;i<3;++i){//se adauga 3 produse in lista care sunt randomizate
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+1),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+2),1+rand.nextInt(10)));
            ComandaIntrata com=new ComandaIntrata(prod,"Client"+i+" SRL");//se adauga la lista comandaintrata
            //produsele randomizate de mai sus, al carui client este Client nr SRL
            comIntrate.addElement(com);//adaugare in lista
        }
    }
    //lista cu comenzile iesite

    public static void initComIesite(DefaultListModel<ComandaIesita> comIesite){
        Random rand = new Random();//randomizare
        for(int i=0;i<3;++i){//se adauga 3 produse in lista care sunt randomizate
            ArrayList<ItemComanda> prod = new ArrayList<>();
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+1),1+rand.nextInt(10)));
            prod.add(new ItemComanda(DepozitMagazin.getProduse().get(i+2),1+rand.nextInt(10)));
            ComandaIesita com=new ComandaIesita(prod,"Furnizor"+i+" SRL");
            //se adauga la lista comandaieste
            //produsele randomizate de mai sus, al carui furnizor este Furnizor nr SRL
            comIesite.addElement(com);//adaugare in lista
        }
    }
}
