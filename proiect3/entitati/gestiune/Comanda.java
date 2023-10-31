package proiect3.entitati.gestiune;

import proiect3.entitati.inventar.IProdus;
import proiect3.exceptii.ProdusDuplicatException;
import proiect3.exceptii.ProdusInexistentException;

import java.util.ArrayList;

public abstract class Comanda {
    protected String idComanda;
    protected ArrayList<ItemComanda> produse;
    protected double pretComanda;

    //constructor cu lista de obiecte ItemComanda, care calculeaza pretul comenzii
    public Comanda(ArrayList<ItemComanda> produse) {
        this.produse = produse;
        calculPreturiProduse();
        pretComanda=calculPretComanda();
    }
    //constructor care initializeaza o lista goala
    public Comanda(){
        this.produse=new ArrayList<>();
    }

    //metaoda abstracta calculPretItem
    public abstract void calculPretItem(ItemComanda item);
    //metoda abstracta infoComanda
    public abstract String infoComanda();
    //metoda care actualizeaza pretul pentru fiecare produs din comanda
    public void calculPreturiProduse(){
        for(ItemComanda item: produse){
            calculPretItem(item);
        }
    }
    //metoda care calculeaza pretul total al comenzii
    public double calculPretComanda(){
        double pret=0;
        for(ItemComanda item: produse){
            pret+=item.getPretItem();
        }
        return pret;
    }
    //returneaza lista de produse
    public ArrayList<ItemComanda> getProduse() {
        return produse;
    }
    //returneaza idComanda
    public String getIdComanda() {
        return idComanda;
    }
    //returneaza PretComanda
    public double getPretComanda() {
        return pretComanda;
    }
    //adauga un item nou la comanda
    public void addItem(ItemComanda item){
        if(existaProdus(item.getProdus())){//verificare daca acesta exista deja
            throw new ProdusDuplicatException("Produsul SKU:"+item.getProdus().getSKU()+
                    " exista deja in comanda "+idComanda);
            //afisare exceptie in cazul in care exista deja in sistem
        }
        produse.add(item);//se adauga la lista
        calculPretItem(item);//se calculeaza pretul produsului
        pretComanda=calculPretComanda();//se calculeaza pretul comenii
    }

    //stergere produs din comanda
    public void removeItem(ItemComanda item) {
        if(!existaProdus(item.getProdus())){//daca produsul nu exista
            throw new ProdusInexistentException("Produsul SKU:"+item.getProdus().getSKU()+
                    " exista deja in comanda "+idComanda);
        }
        //exceptie in cazul in care produsul nu exista
        produse.remove(item);//se sterge produsul din lista
        pretComanda=calculPretComanda();//se recalculeaza totalul comenzii
    }

    //verificare daca produsul exista deja sau nu
    public boolean existaProdus(IProdus produs){
        for(ItemComanda item: produse){
            if(item.getProdus()==produs){
                return true;
                //daca se gaseste in lista se seteaza true
            }
        }
        //daca nu se gaseste in lista atunci este false
        return false;
    }
}
