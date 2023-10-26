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
    private JList<IProdus> Produs;
   /private DefaultListModel<IProdus> ProdusListModel = new DefaultListModel<>();



    JFrame Inventar=new JFrame();

    public Inventar() {
        setContentPane(gestiuneInventar);
        setLocationRelativeTo(null);
        setTitle("Inventar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//se afiseaza Inventar
        setSize(500,700);

        Produs.setVisible(true);

        for (Produs produs : Arrays.asList(new Produs("Catan", 3, "12346",
                100, 19), new Produs("Ticket to Ride", 4, "9274",
                150, 19), new Produs("Prima mea Enciclopedie", 2, "5555",
                30, 5))) {
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
                     int TVA=0;
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
                     if (TipCarte.isSelected()) {
                         TVA=5;
                     }
                     if (TipJoc.isSelected()) {
                         TVA=19;
                     }

                     if(!numeP.isEmpty() && !SKUP.isEmpty() && validStocP &&validPretintrP) {
                         new Produs(numeP, validStocP, SKUP, PretIntrP, TVA);
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
}
