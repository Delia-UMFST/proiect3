import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Inventar extends JFrame {
    private JPanel gestiuneInventar;
    private JList<IProdus> produse;
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
    private JLabel DiscountSiScumpire;
    private JTextField DiscountSiScumpireTF;
    private JButton PretCreste;
    private JButton PretDiscount;
    //IProdus=interfata
    //Produse = Jlist, partea vizuala a listei
    //ProdusListModel= partea functionala, care functioneaza ca un arraylist
    //private JList<IProdus> produse = new JList<>();
   private DefaultListModel<IProdus> ProdusListModel = new DefaultListModel<>();

    //

    JFrame Inventar=new JFrame();

    public Inventar() {
        setContentPane(gestiuneInventar);
        setLocationRelativeTo(null);
        setTitle("Inventar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//se afiseaza Inventar
        setSize(500,700);


        produse.setModel(ProdusListModel);
        produse.setCellRenderer(new DefaultListCellRenderer());
        produse.setVisible(true);


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
                boolean produsExistent=false;

                for(Object produs: Arrays.asList(ProdusListModel.toArray())){
                    if(ProdusSKUTF.getText().equals(((IProdus)produs).getSKU())){
                        JOptionPane.showMessageDialog(Inventar.this, "Produs existent. nu se poate crea unul nou.");
                        produsExistent=true;
                    }
                }
                if(!ProdusStocTF.getText().isEmpty()) {
                    try {
                        stocP = Integer.parseInt(ProdusStocTF.getText());
                        validStocP = true;
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(Inventar.this, "Introdu un numar intreg");

                    }

                }
                else
                {
                    stocP=1;
                }
                try {
                    PretIntrP=Integer.parseInt(ProdusPretIntrareTF.getText());
                    validPretintrP=true;
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(Inventar.this,"Introdu un numar cu doua zecimale");

                }

                if(!numeP.isEmpty() && !SKUP.isEmpty() && validStocP &&validPretintrP&&!produsExistent) {
                    if (TipCarte.isSelected()) {
                        ProdusListModel.addElement(new Carte(numeP, stocP, SKUP, PretIntrP));

                    }
                    else if (TipJoc.isSelected()) {
                        ProdusListModel.addElement(new Joc(numeP, stocP, SKUP, PretIntrP));

                    }
                }
                else{
                    JOptionPane.showMessageDialog(Inventar.this,"Informatia introdusa nu este corecta.");
                }
                ProdusNumeTF.setText("");
                ProdusSKUTF.setText("");
                ProdusStocTF.setText("");
                ProdusPretIntrareTF.setText("");
                TipCarte.setSelected(false);
                TipJoc.setSelected(false);

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

        PretCreste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        PretDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        StocEliminaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        StocAdaugaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

