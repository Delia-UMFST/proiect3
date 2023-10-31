package proiect3.exceptii;

public class ProdusDuplicatException extends ComandaException {
    //exceptie care se va arunca daca produsul exista deja
    public ProdusDuplicatException(String msg){
        super(msg);
    }
}
