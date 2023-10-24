public class PretProduse {
    private static final double MARJA=1.6;
    private double pretIntrare;
    private int TVA;
    private double pretRaft;


    public PretProduse(double pretIntrare,int TVA){
        pretRaft=pretIntrare*(100/TVA)*MARJA;
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
