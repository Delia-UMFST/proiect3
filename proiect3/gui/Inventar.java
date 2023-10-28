package proiect3.gui;

import proiect3.entitati.inventar.Carte;
import proiect3.entitati.inventar.IProdus;
import proiect3.entitati.inventar.Joc;

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
    private JLabel SKUPret;
    private JTextField SKUPretTF;
    private JTextField SKUStocTF;
    private JLabel SKUStoc;
    private JList list1;
    //IProdus=interfata
    //Produse = Jlist, partea vizuala a listei
    //ProdusListModel= partea functionala, care functioneaza ca un arraylist
    //private JList<IProdus> produse = new JList<>();
   private DefaultListModel<IProdus> ProdusListModel = new DefaultListModel<>();

    //

    JFrame Inventar=new JFrame();

    public Inventar() {
        setContentPane(gestiuneInventar);
        setTitle("Inventar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//se afiseaza Inventar
        setSize(700,700);
        setLocationRelativeTo(null);



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
                        JOptionPane.showMessageDialog(Inventar.this,
                                "Produs existent. nu se poate crea unul nou.");
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
                    PretIntrP=Double.parseDouble(ProdusPretIntrareTF.getText());
                    validPretintrP=true;
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Introdu un numar cu doua zecimale");

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
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Informatia introdusa nu este corecta.");
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
            boolean produsExistent=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUPretTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;
                        if (DiscountSiScumpireTF.getText() != null) {
                            ((IProdus) produs).crestePret(Double.parseDouble(DiscountSiScumpireTF.getText()));
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Pretul produsului a fost modificat.");
                        }
                        if (DiscountSiScumpireTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Setati procentul cu care doriti sa cresteti/scadeti pretul");
                        }

                    }
                }
                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                }

                SKUPretTF.setText("");
                DiscountSiScumpireTF.setText("");

            }

        });
        PretDiscount.addActionListener(new ActionListener() {
            boolean produsExistent=false;


            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUPretTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;
                        if (DiscountSiScumpireTF.getText() != null) {
                            ((IProdus) produs).aplicaDiscount(Double.parseDouble(DiscountSiScumpireTF.getText()));
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Pretul produsului a fost modificat.");
                        }
                        if (DiscountSiScumpireTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Setati procentul cu care doriti sa cresteti/scadeti pretul");
                        }

                    }
                }
                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                }
                DiscountSiScumpireTF.setText("");
                SKUPretTF.setText("");

            }
        });
        StocEliminaButon.addActionListener(new ActionListener() {
            boolean produsExistent=false;

            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUStocTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;
                        if (SKUStocTF.getText() != null) {
                            if(ProdusModificareStocTF.getText()!=null){
                            ((IProdus) produs).eliminareStoc(Integer.parseInt(ProdusModificareStocTF.getText()));
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Stocul produsului a fost modificat.");}
                            if(ProdusModificareStocTF.getText()==null){
                                ((IProdus) produs).eliminareStoc();
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                        }
                        if (SKUStocTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Introduceti un SKU pentru a identifica produsul");
                        }

                    }
                }
                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                }
                SKUStocTF.setText("");
                ProdusModificareStocTF.setText("");
            }
        });
        StocAdaugaButon.addActionListener(new ActionListener() {
            boolean produsExistent=false;

            @Override
            public void actionPerformed(ActionEvent e) {

                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUStocTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;
                        if (SKUStocTF.getText() != null) {
                            if(ProdusModificareStocTF.getText()!=null){
                                ((IProdus) produs).adaugareStoc(Integer.parseInt(ProdusModificareStocTF.getText()));
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                            if(ProdusModificareStocTF.getText()==null){
                                ((IProdus) produs).adaugareStoc();
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                        }
                        if (SKUStocTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Introduceti un SKU pentru a identifica produsul");
                        }

                    }
                }
                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                }


                SKUStocTF.setText("");
                ProdusModificareStocTF.setText("");
            }
        });
    }
}

