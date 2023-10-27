public class Carte implements IProdus{
    private static final int TVA=5;
    private int stoc;
    public String nume;
    public String SKU;
    private PretProdus pret;


    public Carte(String nume, int stoc, String SKU, double pretIntrare) {
        this.nume=nume;
        this.stoc=stoc;
        this.SKU=SKU;
        pret=new PretProdus(pretIntrare,TVA);
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }


    @Override
    public void aplicaDiscount(double discount) {

    }

    @Override
    public double getPretRaft() {
        return pret.getPretRaft();
    }

    @Override
    public double getPretIntrare() {
        return pret.getPretIntrare();
    }

    public String getSKU() {
        return SKU;
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


    public int getTVA(){
        return TVA;
    }
    @Override

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html><pre>");
        sb.append(String.format("%s \t  %s \t %s \t %s",nume,SKU,stoc,pret.getPretRaft()));
        sb.append("</pre></html>");
        return  sb.toString();
    }
}
