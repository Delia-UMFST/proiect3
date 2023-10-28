package proiect3.entitati.inventar;

public interface IProdus {
    public int adaugareStoc(int nrcitit);
    public int eliminareStoc(int nrcitit);
    public int adaugareStoc();
    public int eliminareStoc();
    public int verificareStoc();
    public int getTVA();
    public String getNume();
    public void setNume(String nume);
    public String getSKU();
    public void setSKU(String SKU);
    public void aplicaDiscount(double discount);
    public void crestePret(double crestePretCuProcent);
    public double getPretRaft();
    public double getPretIntrare();
}