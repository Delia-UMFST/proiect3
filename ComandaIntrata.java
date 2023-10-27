import java.util.ArrayList;

public class ComandaIntrata extends Comanda{
    private String client;

    public ComandaIntrata(ArrayList<ItemComanda> produse, String client) {
        super(produse);
        this.client=client;
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


}
