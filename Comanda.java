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
        produse.add(item);
    }

    public void removeItem(ItemComanda item) {
        produse.remove(item);
    }
}
