package proiect3.exceptii;

public class ComandaException extends DepozitException {
    //clasa ComandaException extinde o alta clasa de exceptii numita DepozitException
    // care gestioneaza operatiile sau erorile legate de comenzi.
    public ComandaException(String msg){
        super(msg);
    }
}
