package proiect3.entitati.gestiune;

import proiect3.DepozitUtils;
import proiect3.entitati.inventar.IProdus;

public class ItemComanda {
    private IProdus produs;
    private int cantitate;
    private double pretItem;
    //constructor care are ca parametrii produs si cantitate
    public ItemComanda(IProdus produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }
    //cosntructor care preia un produs din lista de produse si ii seteaza cantitatea la 1
    public ItemComanda(IProdus produs) {
        this.produs = produs;
        cantitate=1;
    }

    //returneaza produs
    public IProdus getProdus() {
        return produs;
    }
    //seteaza produs
    public void setProdus(IProdus produs) {
        this.produs = produs;
    }

    //returneaza cantitate
    public int getCantitate() {
        return cantitate;
    }

    //seteaza cantitate
    public void setCantitate(int cantitate) {
        if(cantitate>0) {
            this.cantitate = cantitate;
        }
    }
    //creste cantitatea produsului cu 1
    public void incrCantitate(){
        ++cantitate;
    }
    //scade cantitatea produsului cu 1
    public void decrCantitate(){
        --cantitate;
    }

    //returneaza pretItem
    public double getPretItem() {
        return pretItem;
    }

    //seteaza pretItem
    public void setPretItem(double pretItem) {
        this.pretItem = pretItem;
    }


    //returneaza un String creat cu StringBuilder pentru a fi folosit in JList
    //se returneaza informatiile unui produs: SKU, nume, cantitate, pretItem
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("<html><pre>");
        StringBuilder nume = new StringBuilder(produs.getNume());
        if (nume.length() > DepozitUtils.STRING_LENGTH)
        {
            nume.setLength(DepozitUtils.STRING_LENGTH-3);
            nume.append("...");
        }
        sb.append(String.format("%-6.6s  %-15.15s  %6s  %.2f",produs.getSKU(),nume.toString(),
                (cantitate+" BUC"),pretItem));
        sb.append("Lei");
        sb.append("</pre></html>");
        return  sb.toString();
    }
}
