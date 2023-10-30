package proiect3.entitati.gestiune;

import proiect3.entitati.inventar.IProdus;
import proiect3.exceptii.ProdusDuplicatException;
import proiect3.exceptii.ProdusInexistentException;

import java.util.ArrayList;

public abstract class Comanda {
    protected String idComanda;
    protected ArrayList<ItemComanda> produse;
    protected double pretComanda;

    public Comanda(ArrayList<ItemComanda> produse) {
        this.produse = produse;
        calculPreturiProduse();
        pretComanda=calculPretComanda();
    }
    public Comanda(){
        this.produse=new ArrayList<>();
    }

    public abstract void calculPretItem(ItemComanda item);
    public abstract String infoComanda();

    public void calculPreturiProduse(){
        for(ItemComanda item: produse){
            calculPretItem(item);
        }
    }

    public double calculPretComanda(){
        double pret=0;
        for(ItemComanda item: produse){
            pret+=item.getPretItem();
        }
        return pret;
    }

    public ArrayList<ItemComanda> getProduse() {
        return produse;
    }

    public String getIdComanda() {
        return idComanda;
    }

    public double getPretComanda() {
        return pretComanda;
    }

    public void addItem(ItemComanda item){
        if(existaProdus(item.getProdus())){
            throw new ProdusDuplicatException("Produsul SKU:"+item.getProdus().getSKU()+
                    " exista deja in comanda "+idComanda);
        }
        produse.add(item);
        calculPretItem(item);
        pretComanda=calculPretComanda();
    }

    public void removeItem(ItemComanda item) {
        if(!existaProdus(item.getProdus())){
            throw new ProdusInexistentException("Produsul SKU:"+item.getProdus().getSKU()+
                    " exista deja in comanda "+idComanda);
        }
        produse.remove(item);
        pretComanda=calculPretComanda();
    }

    public boolean existaProdus(IProdus produs){
        for(ItemComanda item: produse){
            if(item.getProdus()==produs){
                return true;
            }
        }
        return false;
    }
}
