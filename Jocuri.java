public class Jocuri implements IProdus{
    private static final int TVA=19;
    private int stoc;
    private String nume;
    private String SKU;

    private String tip;

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
    public String getTip() {

        return tip;
    }

    @Override
    public void setTip(String tip) {this.tip=tip;
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
