package proiect3.gui;

import proiect3.Logger;
import proiect3.entitati.gestiune.Comanda;
import proiect3.entitati.inventar.Carte;
import proiect3.entitati.inventar.IProdus;
import proiect3.entitati.inventar.Joc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JButton backButon;
    private JList list1;
    //IProdus=interfata
    //Produse = Jlist, partea vizuala a listei
    //ProdusListModel= partea functionala, care functioneaza ca un arraylist
    //private JList<IProdus> produse = new JList<>();
   private DefaultListModel<IProdus> ProdusListModel = new DefaultListModel<>();

    //

    JFrame Inventar=new JFrame();

    public Inventar(ArrayList<IProdus> produseDepozit, ArrayList<Comanda> comenziDepozit) {
        setContentPane(gestiuneInventar);
        setTitle("Inventar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);//se afiseaza Inventar
        setSize(700,700);
        setLocationRelativeTo(null);

        produse.setModel(ProdusListModel);
        produse.setCellRenderer(new DefaultListCellRenderer());
        produse.setVisible(true);
        //se adauga la lista ProdusListModel produsele
        for (IProdus produs : produseDepozit) {
            ProdusListModel.addElement(produs);
        }
        //in cazul in care se apasa pe butonul de ProdusAdaugaNou
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
                //in cazul in care exista deja un produs cu acelasi SKU se afiseaza mesaj utilizatorului
                for(IProdus produs: produseDepozit){
                    if(ProdusSKUTF.getText().equals(produs.getSKU())){
                        JOptionPane.showMessageDialog(Inventar.this,
                                "Produs existent. nu se poate crea unul nou.");
                        Logger.getInstance().log("Incercare introducere produs existent "+produs.getSKU());
                        produsExistent=true;
                    }
                }//daca se introduce o valoare incorecta in ProdusStocTF
                if(!ProdusStocTF.getText().isEmpty()) {
                    try {
                        stocP = Integer.parseInt(ProdusStocTF.getText());
                        validStocP = true;
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(Inventar.this, "Introdu un numar intreg");
                        Logger.getInstance().log("NumberFormatException la introducere inventar: " + ProdusStocTF.getText());
                    }

                }
                else
                {//daca ProdusStocTF e gol se adauga 1 la cantitatea produsul cu SKU selectat
                stocP=1;
                }
                try {//se incearca citirea pretului de intrare
                    PretIntrP=Double.parseDouble(ProdusPretIntrareTF.getText());
                    validPretintrP=true;
                }
                catch(NumberFormatException nfe){
                    //in cazul in care pretul introdus nu corespunde, se afiseaza mesaj utilizatorului
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Introdu un numar cu doua zecimale");
                    Logger.getInstance().log("NumberFormatException la introducere pret: "+ProdusPretIntrareTF.getText());

                }
                //in caazul in care toate informatiile introduse sunt corecte, se creeaza un produs nou de tip carte
                if(!numeP.isEmpty() && !SKUP.isEmpty() && validStocP &&validPretintrP&&!produsExistent) {
                    if (TipCarte.isSelected()) {
                        Carte carte=new Carte(numeP, stocP, SKUP, PretIntrP);
                        ProdusListModel.addElement(carte);
                        produseDepozit.add(carte);
                        Logger.getInstance().log("Carte adaugata la inventar: "+carte);
                    }
                    //in caazul in care toate informatiile introduse sunt corecte, se creeaza un produs nou de tip joc
                    else if (TipJoc.isSelected()) {
                        Joc joc=new Joc(numeP, stocP, SKUP, PretIntrP);
                        ProdusListModel.addElement(joc);
                        produseDepozit.add(joc);
                        Logger.getInstance().log("Joc adaugat la inventar: "+joc);
                    }
                }
                else{//daca informatiile introduse nu sunt corecte, se afiseaza mesaj utilizatorului

                    JOptionPane.showMessageDialog(Inventar.this,
                            "Informatia introdusa nu este corecta.");
                    Logger.getInstance().log("Incercare nereusita introducere produs");
                }
                //dupa introducere, se seteaza TextFieldurile sa nu afiseze nimic, iar JRadioButton-urile pe false.
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
                     //deselectare celalalt tip de JRadioButton, in cazul in care acest tip este selectat
                 }
        });
        TipJoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     TipCarte.setSelected(false);
                //deselectare celalalt tip de JRadioButton, in cazul in care acest tip este selectat

            }
        });

        //la apasarea butonului PretCreste
        PretCreste.addActionListener(new ActionListener() {
            boolean produsExistent=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUPretTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;//se verifica daca produsul exista
                        if (DiscountSiScumpireTF.getText() != null) {//si daca textFieldul nu e gol
                            //se modifica pretul, si se logheaza in logger
                            Logger.getInstance().log("Crestere pret produs "+((IProdus) produs).getSKU()+" de la "
                                    +((IProdus) produs).getPretRaft()+" cu "+DiscountSiScumpireTF.getText()+"%");
                            ((IProdus) produs).crestePret(Double.parseDouble(DiscountSiScumpireTF.getText()));
                            //se afiseaza un mesaj utilzatorului
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Pretul produsului a fost modificat.");
                        }
                        //mesaj afisat utilizatorului in cazul in care campul DiscountSiScumpireTF este gol
                        if (DiscountSiScumpireTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Setati procentul cu care doriti sa cresteti/scadeti pretul");
                        }

                    }
                }
                //mesaj afisat utilizatorului in cazul in care produsul nu exista

                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                    Logger.getInstance().log("Incercare crestere pret produs inexistent");
                }
                //resetare campuri folosite
                SKUPretTF.setText("");
                DiscountSiScumpireTF.setText("");

            }

        });
        //la apasarea butonului PretDiscount
        PretDiscount.addActionListener(new ActionListener() {
            boolean produsExistent=false;
            boolean discountAcceptabil=false;

            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUPretTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;//se verifica daca exsita produsul
                        if (DiscountSiScumpireTF.getText() != null) {//daca campul DiscountSiScumpireTF nu este gol
                            //se aplica un discount produsului si se logheaza in logger
                            Logger.getInstance().log("Scadere pret produs "+((IProdus) produs).getSKU()+" de la "
                                    +((IProdus) produs).getPretRaft()+" cu "+DiscountSiScumpireTF.getText()+"%");
                            discountAcceptabil=((IProdus) produs).aplicaDiscount(Double.parseDouble(DiscountSiScumpireTF.getText()));
                            if(discountAcceptabil){//se verifica daca discountul este acceptabil.
                                //un discount acceptabil este mai mare decat pretul de intrare al produsului+ TVA
                                //adica firma sa nu iasa in pierdere
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Pretul produsului a fost modificat.");
                        }
                            else {//in cazul in care discountul este prea mare, nu se va modifica pretul produsului
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Discountul este prea mare, pretul produsului nu a fost modificat.");
                            }
                        }//in cazul in care DiscountSiScumpireTF este null, se va afisa mesaj utilizatorului
                        if (DiscountSiScumpireTF.getText() == null) {
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Setati procentul cu care doriti sa cresteti/scadeti pretul");
                        }

                    }
                }//daca produsul nu exista, se va afisa mesaj utilizatorului
                if(produsExistent==false) {
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                    Logger.getInstance().log("Incercare scadere pret produs inexistent");
                }
                //se reseteaza campurile folosite
                DiscountSiScumpireTF.setText("");
                SKUPretTF.setText("");

            }
        });

        //daca se apasa pe butonul de eliminare a stocului
        StocEliminaButon.addActionListener(new ActionListener() {
            boolean produsExistent=false;

            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUStocTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;//se verifica daca produsul exista pe baza de SKU
                        if (SKUStocTF.getText() != null) {// daca campul de SKU pentru stoc nu este gol
                            if(ProdusModificareStocTF.getText()!=null){
                                //daca in campul s-a introdus unitatea cu care dorim sa modificam stocul
                                //se elimina numarul de bucati/unitati de produse respectiv, se logheaza in logger
                                Logger.getInstance().log("Eliminare " + ProdusModificareStocTF.getText()+"BUC produs "
                                        +((IProdus) produs).getSKU());
                                ((IProdus) produs).eliminareStoc(Integer.parseInt(ProdusModificareStocTF.getText()));
                                //se afiseaza mesaj utilizatoruliui
                                JOptionPane.showMessageDialog(Inventar.this,
                                    "Stocul produsului a fost modificat.");
                            }//daca nu s-a introdus unitatea/bucatile care doresc sa fie eliminate
                            if(ProdusModificareStocTF.getText()==null){
                                //se va elimina doar un produs, se logheaza si se afiseaza mesaj utilizatorului
                                Logger.getInstance().log("Eliminare 1BUC produs "+((IProdus) produs).getSKU());
                                ((IProdus) produs).eliminareStoc();
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                        }//daca nu s-a introdus SKU-ul produsului careia dorim sa ii modificam stocul
                        if (SKUStocTF.getText() == null) {//se va afisa mesaj utilizatorului
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Introduceti un SKU pentru a identifica produsul");
                        }

                    }
                }
                if(produsExistent==false) {//daca produsul nu exista se va afisa mesaj utilizatorului
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                    //si se va loga in logger
                    Logger.getInstance().log("Incercare eliminare stoc produs inexistent");
                }
                //se reseteaza campurile folosite
                SKUStocTF.setText("");
                ProdusModificareStocTF.setText("");
            }
        });
        //daca se apasa pe butonul de adaugare pe stoc

        StocAdaugaButon.addActionListener(new ActionListener() {
            boolean produsExistent=false;

            @Override
            public void actionPerformed(ActionEvent e) {

                for(Object produs: Arrays.asList(ProdusListModel.toArray())) {
                    if (SKUStocTF.getText().equals(((IProdus) produs).getSKU())) {
                        produsExistent = true;//se verifica daca produsul exista pe baza de SKU
                        if (SKUStocTF.getText() != null) {// daca campul de SKU pentru stoc nu este gol
                            if(ProdusModificareStocTF.getText()!=null){
                                //daca in campul s-a introdus unitatea cu care dorim sa modificam stocul
                                //se elimina numarul de bucati/unitati de produse respectiv, se logheaza in logger
                                Logger.getInstance().log("Adaugare " + ProdusModificareStocTF.getText()+"BUC produs "
                                        +((IProdus) produs).getSKU());
                                //se afiseaza mesaj utilizatoruliui

                                ((IProdus) produs).adaugareStoc(Integer.parseInt(ProdusModificareStocTF.getText()));
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                            //daca nu s-a introdus unitatea/bucatile care doresc sa fie eliminate
                            if(ProdusModificareStocTF.getText()==null){
                                //se va elimina doar un produs, se logheaza si se afiseaza mesaj utilizatorului
                                Logger.getInstance().log("Eliminare 1BUC produs "+((IProdus) produs).getSKU());
                                ((IProdus) produs).adaugareStoc();
                                JOptionPane.showMessageDialog(Inventar.this,
                                        "Stocul produsului a fost modificat.");}
                        }//daca nu s-a introdus SKU-ul produsului careia dorim sa ii modificam stocul
                        if (SKUStocTF.getText() == null) {//se va afisa mesaj utilizatorului
                            JOptionPane.showMessageDialog(Inventar.this,
                                    "Introduceti un SKU pentru a identifica produsul");
                        }

                    }
                }
                if(produsExistent==false) {//daca produsul nu exista se va afisa mesaj utilizatorului
                    JOptionPane.showMessageDialog(Inventar.this,
                            "Produs inexistent. Creeaza produsul.");
                    Logger.getInstance().log("Incercare adaugare stoc produs inexistent");
                }

                //se reseteaza campurile folosite
                SKUStocTF.setText("");
                ProdusModificareStocTF.setText("");
            }
        });
        //buton pentru a merge inapoi la pagina de start
        backButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Start(produseDepozit, comenziDepozit);
                Logger.getInstance().log("Intoarcere la Start");
                dispose();
            }
        });
    }
}

