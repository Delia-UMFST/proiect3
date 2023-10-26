public class Carti implements IProdus{
    private static final int TVA=5;
    private int stoc;
    public String nume;
    public String SKU;

    public String tip;

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
    public String getTip() {
        return tip;
    }

    @Override
    public void setTip(String tip) {
        this.tip=tip;

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
}
