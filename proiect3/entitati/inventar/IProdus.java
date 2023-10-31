package proiect3.entitati.inventar;

public interface IProdus {
    //Interfata IProdus contine metode abstracte,neimplementate, care vor fi folosite la:
    public int adaugareStoc(int nrcitit);//adaugare un unei anumite unitati de produse pe stoc
    public int eliminareStoc(int nrcitit);//scaderea un unei anumite unitati de produse pe stoc
    public int adaugareStoc();//adaugare pe stoc
    public int eliminareStoc();//eliminare/vanzare stoc
    public int verificareStoc();//verificare stoc
    public int getTVA();//returnare TVA
    public String getNume();//returnare nume
    public void setNume(String nume);//setare nume
    public String getSKU();//returnare SKU
    public void setSKU(String SKU);//setare SKU
    public boolean aplicaDiscount(double discount);//calculare discount
    public void crestePret(double crestePretCuProcent);//crestere pretul unui produs
    public double getPretRaft();//returnare pret de raft al unui produs
    public double getPretIntrare();//returnare pret de intrare al unui produs
}
