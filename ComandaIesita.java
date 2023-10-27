import java.util.ArrayList;

public class ComandaIesita extends Comanda{
    private static int comenziOutCounter=0;
    private String furnizor;

    public ComandaIesita(ArrayList<ItemComanda> produse, String furnizor) {
        super(produse);
        this.furnizor = furnizor;
        idComanda='O'+String.format("%1$06d",comenziOutCounter);
        ++comenziOutCounter;
    }

    @Override
    public void calculPretItem(ItemComanda item) {
        item.setPretItem(item.getCantitate() * item.getProdus().getPretIntrare());
    }

    @Override
    public String infoComanda() {
        StringBuffer info=new StringBuffer("Furnizor: "+furnizor+System.lineSeparator()+"Produse:"+System.lineSeparator());
        for (ItemComanda item: produse){
            info.append(item);
            info.append(System.lineSeparator());
        }
        info.append("Total: ");
        info.append(pretComanda);
        return info.toString();
    }

    public String getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public static int getComenziOutCounter() {
        return comenziOutCounter;
    }
}
