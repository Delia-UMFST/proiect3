public class Carti implements IProdus{
    private static final int TVA=5;
    private int stoc;


    @Override
    public int adaugareStoc(int nrcitit) {
        return 0;
    }

    @Override
    public int eliminareStoc(int nricitit) {
        return 0;
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
