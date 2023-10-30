package proiect3.exceptii;

public class ProdusDuplicatException extends ComandaException {
    //exceptie care se va afisa daca produsul exista deja
    public ProdusDuplicatException(String msg){
        super(msg);
    }
}
