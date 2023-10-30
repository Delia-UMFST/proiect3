package proiect3.entitati.inventar;
public class PretProdus {

    private static final double MARJA=1.6;
    private double pretIntrare;
    private int TVA;
    public double pretRaft;

    //constructor care are ca si parametrii pretIntrare si TVA
    public PretProdus(double pretIntrare, int TVA){
        pretRaft=(pretIntrare+((pretIntrare*TVA)/100))*MARJA;
        this.pretIntrare=pretIntrare;
        this.TVA=TVA;
    }
    //returneaza pretIntrare
    public double getPretIntrare() {
        return pretIntrare;
    }

    //seteaza pretIntrare
    public void setPretIntrare(double pretIntrare) {
        this.pretIntrare = pretIntrare;
    }

    //returneaza pretRaft
    public double getPretRaft() {
        return pretRaft;
    }
    //seteaza pretRaft
    public void setPretRaft(double pretRaft)
    {
        this.pretRaft = pretRaft;
    }
    //calculeaza valoarea TVA a unui produs bazat pe rpetul de intrare si a TVA-ului
    public double getValoareTVA() {
        return (pretIntrare/100)*TVA;
    }

}
