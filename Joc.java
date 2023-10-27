public class Joc implements IProdus{
    private static final int TVA=19;
    private int stoc;
    private String nume;
    private String SKU;
    private PretProdus pret;
    private String tip;

    public Joc(String nume, int stoc, String SKU, double pretIntrare) {
        this.nume=nume;
        this.stoc=stoc;
        this.SKU=SKU;
        pret=new PretProdus(pretIntrare,TVA);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }


    @Override
    public void aplicaDiscount(double discount) {

         //pret.pretRaft- (pret.getPretRaft() / 100 * discount);
    }

    @Override
    public double getPretRaft() {
        return pret.getPretRaft();
    }

    @Override
    public double getPretIntrare() {
        return pret.getPretIntrare();
    }

    @Override
    public int adaugareStoc(int nrcitit) {
        return stoc+=nrcitit;
    }

    @Override
    public int eliminareStoc(int nrcitit) {
        return stoc-=nrcitit;
    }

    @Override
    public int adaugareStoc() {
        return stoc+1;
    }

    @Override
    public int eliminareStoc() {
        return stoc-1;
    }

    @Override
    public int verificareStoc() {
        return stoc;
    }

    @Override
    public int getTVA() {
        return TVA;
    }
}
