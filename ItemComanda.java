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

    public double getPretItem() {
        return pretItem;
    }

    public void setPretItem(double pretItem) {
        this.pretItem = pretItem;
    }

    @Override
    public String toString() {
        return produs.getSKU() + ""+ cantitate + " BUC | " + pretItem+" Lei";
    }
}
