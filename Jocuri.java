public class Jocuri implements IProdus{
    private static final int TVA=19;
    int stoc;


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

    @Override
    public int getTVA() {
        return TVA;
    }
}
