package proiect3.entitati;

import proiect3.DepozitUtils;

public class ItemComanda {
    private IProdus produs;
    private int cantitate;
    private double pretItem;

    public ItemComanda(IProdus produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }

    public ItemComanda(IProdus produs) {
        this.produs = produs;
        cantitate=1;
    }

    public IProdus getProdus() {
        return produs;
    }

    public void setProdus(IProdus produs) {
        this.produs = produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        if(cantitate>0) {
            this.cantitate = cantitate;
        }
    }

    public void incrCantitate(){
        ++cantitate;
    }

    public void decrCantitate(){
        --cantitate;
    }

    public double getPretItem() {
        return pretItem;
    }

    public void setPretItem(double pretItem) {
        this.pretItem = pretItem;
    }

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
