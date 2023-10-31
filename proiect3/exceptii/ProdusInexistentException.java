package proiect3.exceptii;

public class ProdusInexistentException extends ComandaException {
   //exceptie care se va arunca in cazul in care produsul nu exista
    public ProdusInexistentException(String msg) {
        super(msg);
    }
}
