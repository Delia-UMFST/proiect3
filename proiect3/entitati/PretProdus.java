package proiect3.entitati;

public class PretProdus {
    private static final double MARJA=1.6;
    private double pretIntrare;
    private int TVA;
    public double pretRaft;



    public PretProdus(double pretIntrare, int TVA){
        pretRaft=(pretIntrare+((pretIntrare*TVA)/100))*MARJA;
        this.pretIntrare=pretIntrare;
        this.TVA=TVA;
    }

    public double getPretIntrare() {
        return pretIntrare;
    }

    public void setPretIntrare(double pretIntrare) {
        this.pretIntrare = pretIntrare;
    }

    public double getPretRaft() {
        return pretRaft;
    }

    public void setPretRaft(double pretRaft) {
        this.pretRaft = pretRaft;
    }

    public double getValoareTVA() {
        return (pretIntrare/100)*TVA;
    }

}
