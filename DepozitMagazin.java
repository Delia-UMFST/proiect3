import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class DepozitMagazin extends JFrame {
    private JPanel AccesGestiune;
    private JButton accesInventar;
    private JButton accesComenzi;
    JFrame Comenzi=new JFrame();
    JFrame Inventar=new JFrame();
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
    private JButton ProdusModificaButon;



    public List<Jocuri> jocuriList = new ArrayList<>();//se creeaza lista

    public  List<Carti> cartiList = new ArrayList<>();//se creeaza lista




    public DepozitMagazin() {
        JFrame Start=new JFrame();
        Start.setVisible(true);
        setContentPane(AccesGestiune);
        setTitle("Depozit Magazin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(800,600);
        setLocationRelativeTo(null);

        Jocuri joc= new Jocuri();
        Carti carte= new Carti();




        accesInventar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventar.setVisible(true);//se afiseaza Inventar
                dispose();//se inchide frame-ul de start


            }
        });
        accesComenzi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comenzi.setVisible(true);//se afiseaza Comenzi
                dispose();//se inchide frame-ul de start

            }
        });
        ProdusAdaugaNou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (TipCarte.isSelected()) {

                    if (!ProdusNumeTF.getText().isEmpty()) {
                        carte.setNume(ProdusNumeTF.getText());
                    }
                    if(!ProdusSKUTF.getText().isEmpty()){
                        carte.adaugareStoc(Integer.parseInt(ProdusStocTF.getText()));
                    }
                    if (!ProdusSKUTF.getText().isEmpty())
                        carte.setSKU(ProdusSKUTF.getText());
                    cartiList.add(carte);

                } else {
                    if (!ProdusNumeTF.getText().isEmpty()) {
                        joc.setNume(ProdusNumeTF.getText());

                    }
                    if(!ProdusSKUTF.getText().isEmpty()){
                        joc.adaugareStoc(Integer.parseInt(ProdusStocTF.getText()));
                    }
                    if (!ProdusSKUTF.getText().isEmpty())
                        joc.setSKU(ProdusSKUTF.getText());
                    jocuriList.add(joc);
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
