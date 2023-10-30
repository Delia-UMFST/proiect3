package proiect3.entitati.inventar;

public class Carte implements IProdus {
    //aceasta clasa implementeaza interfata IProdus
    private static final int TVA=5;
    private int stoc;
    public String nume;
    public String SKU;
    private PretProdus pret;

    //constructor care are ca si lista de parametriiL nume,stoc, SKU,pretintrare
    public Carte(String nume, int stoc, String SKU, double pretIntrare) {
        this.nume=nume;
        this.stoc=stoc;
        this.SKU=SKU;
        pret=new PretProdus(pretIntrare,TVA);
    }

    //setare nume
    public void setNume(String nume) {
        this.nume = nume;
    }
    //returnare nume
    public String getNume() {
        return nume;
    }
    //setare SKU
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    //calculare discount al unui produs, utilizatorul introduce discount-ul,
    //iar din pretul de raft se va scade acel procent
    @Override
    public void aplicaDiscount(double discount) {
        double pretCuDiscount;
        pretCuDiscount=pret.getPretRaft();
        pretCuDiscount=pretCuDiscount-(pretCuDiscount/100)*discount;
        pret.setPretRaft(pretCuDiscount);

    }

    //calculare pret nou al unui produs, utilizatorul introduce
    // cu cat procent ar dori sa creasca,
    //iar pretului de raft se va adauga acel procent
    @Override
    public void crestePret(double crestePretCuProcent) {
        double pretCuAdaos;
        pretCuAdaos=pret.getPretRaft();
        pretCuAdaos=pretCuAdaos+(pretCuAdaos/100)*crestePretCuProcent;
        pret.setPretRaft(pretCuAdaos);
    }
    //returnare pretRaft
    @Override
    public double getPretRaft() {
        return pret.getPretRaft();
    }
    //returnare pretIntrare
    @Override
    public double getPretIntrare() {
        return pret.getPretIntrare();
    }
    //returnare SKU
    public String getSKU() {
        return SKU;
    }

    //se adauga la stocul existent numarul de produse cu care doreste utilizatorul sa creasca stocul
    @Override
    public int adaugareStoc(int nrcitit) {
        return stoc+=nrcitit;
    }

    //se scade din stocul existent numarul de produse pe care doreste utilizatorul sa il vanda/elimine
    @Override
    public int eliminareStoc(int nrcitit) {
        return stoc-=nrcitit;
    }

    //se adauga pe stoc o unitate de produs
    @Override
    public int adaugareStoc() {
        return stoc+1;
    }

    //se scade de pe stoc o unitate de produs
    @Override
    public int eliminareStoc() {
        return stoc-1;
    }

    //returnare stoc
    @Override
    public int verificareStoc() {
        return stoc;
    }

    //returnare tVA
    public int getTVA(){
        return TVA;
    }
    @Override
    //metoda toString construita cu StringBuilder pentru a afisa produsul si informatiile acesteia
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html><pre>");
        sb.append(String.format("%s \t  %s \t %s \t %.2f",nume,SKU,stoc,pret.getPretRaft()));
        sb.append("Lei");
        sb.append("</pre></html>");
        return  sb.toString();
    }
}
