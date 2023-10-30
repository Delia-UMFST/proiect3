package proiect3.entitati.gestiune;

import java.util.ArrayList;

public class ComandaIesita extends Comanda {
    private static int comenziOutCounter=0;
    private String furnizor;
    //constructor cu lista de produse, furnizori care genereaza un identificator unic pentru comenzi
    public ComandaIesita(ArrayList<ItemComanda> produse, String furnizor) {
        super(produse);
        this.furnizor = furnizor;
        idComanda='O'+String.format("%1$06d",comenziOutCounter);
        ++comenziOutCounter;
    }
    //constructor cu furnizor care creeaza identificatori unici pentru fiecare comanda
    public ComandaIesita(String furnizor){
        super();
        this.furnizor=furnizor;
        idComanda='O'+String.format("%1$06d",comenziOutCounter);
        ++comenziOutCounter;
    }

    //calculeaza pretul fiecarui item din comanda
    @Override
    public void calculPretItem(ItemComanda item) {
        item.setPretItem(item.getCantitate() * item.getProdus().getPretIntrare());
    }
    //returneaza informatii despre comanda cu ajutorul Stringbufferului
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
    //returneaza furnizor
    public String getFurnizor() {
        return furnizor;
    }
    //setare furnizor
    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }
    //returneaza ComenziOutCounter, numarul de comenzi iesite
    public static int getComenziOutCounter() {
        return comenziOutCounter;
    }

    //returneaza un String creat cu StringBuilder
    // informatiile pe care le contine Stringul sun:idComanda,furnizor,pretComanda
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html><pre>");
        sb.append(String.format("%s \t  %s \t %.2f",idComanda,furnizor,pretComanda));
        sb.append("Lei");
        sb.append("</pre></html>");
        return  sb.toString();
    }
}
