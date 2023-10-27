import java.util.ArrayList;

public class ComandaIntrata extends Comanda{
    private static int instanceCounter=0;
    private String client;

    public ComandaIntrata(ArrayList<ItemComanda> produse, String client) {
        super(produse);
        this.client=client;
        idComanda='I'+String.format("%1$06d",instanceCounter);
        ++instanceCounter;
    }

    @Override
    public void calculPretItem(ItemComanda item) {
        item.setPretItem(item.getCantitate() * item.getProdus().getPretRaft());
    }

    @Override
    public String infoComanda() {
        StringBuffer info=new StringBuffer("Client: "+client+System.lineSeparator()+"Produse:"+System.lineSeparator());
        for (ItemComanda item: produse){
            info.append(item);
            info.append(System.lineSeparator());
        }
        info.append("Total: ");
        info.append(pretComanda);
        return info.toString();
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void addItem(ItemComanda item){
        produse.add(item);
    }

    public void removeItem(ItemComanda item) {
        produse.remove(item);
    }

}
