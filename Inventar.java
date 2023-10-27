import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Inventar extends JFrame {
    private JPanel gestiuneInventar;
    private JList list1;
    private JLabel ProdusNou;
    private JLabel ProdusNume;
    private JLabel ProdusStoc;
    private JLabel ProdusTip;
    private JRadioButton TipJoc;
    private JRadioButton TipCarte;
    private JButton ProdusAdaugaNou;
    private JLabel ProdusSKU;
    private JTextField ProdusNumeTF;
    private JTextField ProdusStocTF;
    private JTextField ProdusSKUTF;
    private JLabel ProdusStocModifica;

    private JButton StocAdaugaButon;
    private JButton StocEliminaButon;
    private JLabel ProdusPretIntrare;
    private JTextField ProdusPretIntrareTF;
    private JTextField ProdusModificareStocTF;
    private JList<IProdus> Produse;
   private DefaultListModel<IProdus> ProdusListModel = new DefaultListModel<>();



    JFrame Inventar=new JFrame();

    public Inventar() {
        setContentPane(gestiuneInventar);
        setLocationRelativeTo(null);
        setTitle("Inventar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//se afiseaza Inventar
        setSize(500,700);

        Produse.setVisible(true);

        for (IProdus produs : Arrays.asList(new Joc("Catan", 3, "12346",
                100.0), new Joc("Ticket to Ride", 4, "9274",
                150.0), new Carte("Prima mea Enciclopedie", 2, "5555",
                30.0))) {
            ProdusListModel.addElement(produs);
        }

        ProdusAdaugaNou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeP=ProdusNumeTF.getText();
                String SKUP=ProdusSKUTF.getText();
                int stocP=0;
                boolean validStocP=false;
                double PretIntrP=0;
                boolean validPretintrP=false;
                //tip

                try{
                    stocP=Integer.parseInt(ProdusStocTF.getText());
                    validStocP=true;
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(Inventar.this,"Introdu un numar intreg");

                }

                try {
                    PretIntrP=Integer.parseInt(ProdusPretIntrareTF.getText());
                    validPretintrP=true;
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(Inventar.this,"Introdu un numar cu doua zecimale");

                }

                if(!numeP.isEmpty() && !SKUP.isEmpty() && validStocP &&validPretintrP) {
                    if (TipCarte.isSelected()) {
                        new Carte(numeP, stocP, SKUP, PretIntrP);
                    }
                    else if (TipJoc.isSelected()) {
                        new Joc(numeP, stocP, SKUP, PretIntrP);
                    }
                }
            }
        });
        TipCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     TipJoc.setSelected(false);
                 }
        });
        TipJoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     TipCarte.setSelected(false);
                 }
        });

    }
}

