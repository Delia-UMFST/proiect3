package proiect3.entitati.gestiune;

import java.util.ArrayList;

public class ComandaIntrata extends Comanda {
    private static int comenziInCounter=0;
    private String client;

    //constructor cu lista de produse, clienti care genereaza un identificator unic pentru comenzi

    public ComandaIntrata(ArrayList<ItemComanda> produse, String client) {
        super(produse);
        this.client=client;
        idComanda='I'+String.format("%1$06d", comenziInCounter);
        ++comenziInCounter;
    }
    //constructor cu client care creeaza identificatori unici pentru fiecare comanda

    public ComandaIntrata(String client){
        super();
        this.client=client;
        idComanda='I'+String.format("%1$06d", comenziInCounter);
        ++comenziInCounter;
    }

    //calculeaza pretul fiecarui item din comanda
    @Override
    public void calculPretItem(ItemComanda item) {
        item.setPretItem(item.getCantitate() * item.getProdus().getPretRaft());
    }

    //returneaza informatii despre comanda cu ajutorul Stringbufferului

    @Override
    public String infoComanda() {
        StringBuffer info=new StringBuffer("Client: "+client+System.lineSeparator()+"Produse:"+System.lineSeparator());
        for (ItemComanda item: produse){
            info.append(item);
            info.append(System.lineSeparator());
        }
        info.append("Total: ");
        info.append(pretComanda);
        info.append("Lei");
        return info.toString();
    }

    //returneaza client
    public String getClient() {
        return client;
    }

    //seteaza client
    public void setClient(String client) {
        this.client = client;
    }

    //returneaza ComenziOutCounter, numarul de comenzi iesite
    public static int getComenziInCounter() {
        return comenziInCounter;
    }

    //returneaza un String creat cu StringBuilder pentru a fi folosit in JList
    // informatiile pe care le contine Stringul sun:idComanda,client,pretComanda
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html><pre>");
        sb.append(String.format("%s \t  %s \t %.2f",idComanda,client,pretComanda));
        sb.append("Lei");
        sb.append("</pre></html>");
        return  sb.toString();
    }
}
