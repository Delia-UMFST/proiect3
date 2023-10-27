import java.util.ArrayList;

public abstract class Comanda {
    protected int instanceCounter=0;
    protected String idComanda;
    protected ArrayList<ItemComanda> produse;
    protected double pretComanda;

    public Comanda(ArrayList<ItemComanda> produse) {
        this.produse = produse;
        calculPreturiProduse();
        pretComanda=calculPretComanda();
        idComanda=String.format("%1$07d",instanceCounter);
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
}
