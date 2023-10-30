package proiect3.exceptii;

public class DepozitException extends RuntimeException{
    //Clasa DepozitException extinde clasa RuntimeException care este o clasa de exceptii verificate in Java
    public DepozitException(String msg) {
        super(msg);
    }
}
