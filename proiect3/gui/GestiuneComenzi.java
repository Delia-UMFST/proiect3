package proiect3.gui;

import proiect3.DepozitUtils;
import proiect3.Logger;
import proiect3.entitati.gestiune.Comanda;
import proiect3.entitati.gestiune.ComandaIesita;
import proiect3.entitati.gestiune.ComandaIntrata;
import proiect3.entitati.inventar.IProdus;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GestiuneComenzi extends JFrame{


    private JPanel gestiuneComenziPanel;
    private JPanel comenziIntrateContainer;
    private JLabel comenziIntrateLB;
    private JPanel comenziIesiteContainer;
    private JLabel comenziIesiteLB;
    private JSplitPane comenziSplitPane;
    private JScrollPane comIntrScrollPane;
    private JScrollPane comIesScrollPane;
    private JPanel addComIntrPanel;
    private JLabel addComIntrLabel;
    private JLabel tipComLB;
    private JRadioButton comIntrRB;
    private JRadioButton comIesRB;
    private JLabel clientFurnizorLB;
    private JTextField clientFurnizorTF;
    private JPanel clientFurnizorPanel;
    private JPanel controlComPanel;
    private JButton detaliiComBtn;
    private JButton stergereComBtn;
    private JButton addProduseBtn;
    private JButton stergereProduseBtn;
    private JButton creareComBtn;
    private JList<ComandaIntrata> comIntrList;
    private DefaultListModel<ComandaIntrata> comIntrate = new DefaultListModel<>();
    private JList<ComandaIesita> comIesList;
    private JButton backButon;
    private JPanel backBtnPanel;
    private DefaultListModel<ComandaIesita> comIesite = new DefaultListModel<>();

    public GestiuneComenzi(ArrayList<IProdus> produseDepozit, ArrayList<Comanda> comenziDepozit) {

        setContentPane(gestiuneComenziPanel);

        setVisible(true);//se afiseaza gestiuneComenzi
        setTitle("gestiuneComenzi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        //se adauga comenzile din comenziDepozit in listele corespunzatoare comIntrate si comIesite
        for(Comanda com: comenziDepozit){
            if(com instanceof ComandaIntrata){
                comIntrate.addElement((ComandaIntrata) com);
            }
            else if (com instanceof ComandaIesita) {
                comIesite.addElement((ComandaIesita) com);
            }
        }
        //daca comenziDepozit este gol, se va initializa lista comIntrate si comIesite
        if(comenziDepozit.isEmpty()) {
            DepozitUtils.initComIntrate(comIntrate);
            for(Object comIn: Arrays.asList(comIntrate.toArray())){
                comenziDepozit.add((ComandaIntrata)comIn);
            }
            DepozitUtils.initComIesite(comIesite);
            for(Object comOut: Arrays.asList(comIesite.toArray())){
                comenziDepozit.add((ComandaIesita)comOut);
            }
        }

        comIntrList.setModel(comIntrate);
        comIntrList.setCellRenderer(new DefaultListCellRenderer());
        comIntrList.setVisible(true);

        comIesList.setModel(comIesite);
        comIesList.setCellRenderer(new DefaultListCellRenderer());
        comIesList.setVisible(true);


        clientFurnizorPanel.setVisible(false);
        //la apasarea butonului se vor afisa detalii despre comenzi
        detaliiComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){//daca un rand a fost selectat din comIntrList
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,//se afiseaza informatiile
                            comIntrList.getSelectedValue().infoComanda());
                } else if (null!=comIesList.getSelectedValue()) {//daca un rand nu a fost selectat din comIntrList
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,//atunci a fost selectat comIesList
                            comIesList.getSelectedValue().infoComanda());//se afiseaza informatiile din comIesList
                }else {//daca nu este selectat nimic, se afiseaza mesaj utilizatorului
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });

        comIntrList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                comIesList.clearSelection();
            }
        });
        comIesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                comIntrList.clearSelection();
            }
        });
        //buton pentru stergerea comenzii
        stergereComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){//daca este selectat
                    Logger.getInstance().log("Stergere comanda "+comIntrList.getSelectedValue().getIdComanda());
                    comenziDepozit.remove(comIntrList.getSelectedValue());//comanda se va sterge din lista comenziDepozit
                    comIntrate.remove(comIntrList.getSelectedIndex());//se va sterge si din lista comIntrate
                } else if (null!=comIesList.getSelectedValue()) {//daca este selectat
                    Logger.getInstance().log("Stergere comanda "+comIesList.getSelectedValue().getIdComanda());
                    comenziDepozit.remove(comIesList.getSelectedValue());//comanda se va sterge din lista
                    comIesite.remove(comIesList.getSelectedIndex());//se va sterge si din lista comIntrate
                }else {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");//daca nicio comanda nu este selectata, se va afisa mesajul
                }
            }
        });
        //la apasarea butonului pentru adaugarea produs la comanda
        addProduseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){//daca lista de comenzi intrate este selectata
                    //se deschide o fereastra modala de adaugare produse
                    JDialog modalAddProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Adaugare Produse Comanda "+comIntrList.getSelectedValue().getIdComanda(),true);
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(produseDepozit,comIntrList.getSelectedValue()));
                    modalAddProduseDialog.pack();
                    modalAddProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalAddProduseDialog.setVisible(true);
                } else if (null!=comIesList.getSelectedValue()) {//daca lista de comenzi iesite este selectata
                    //se deschide o fereastra modala de adaugare produse
                    JDialog modalAddProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Adaugare Produse Comanda "+comIesList.getSelectedValue().getIdComanda(),true);
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(produseDepozit,comIesList.getSelectedValue()));
                    modalAddProduseDialog.pack();
                    modalAddProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalAddProduseDialog.setVisible(true);
                }else {
                    //daca nici o comanda nu este selectata, se afiseaza mesaj utilizatorului
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });

        //daca se apasa pe butonul de stergere de produs din comenzi
        stergereProduseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){
                    //se afiseaza mesaj de stergere produs selectat din comenzile intrate
                    JDialog modalStergereProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Stergere Produse Comanda "+comIntrList.getSelectedValue().getIdComanda(),true);
                    modalStergereProduseDialog.setContentPane(new StergereProduseWindow(comIntrList.getSelectedValue()));
                    modalStergereProduseDialog.pack();
                    modalStergereProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalStergereProduseDialog.setVisible(true);
                    //new StergereProduseWindow(comIntrList.getSelectedValue());
                } else if (null!=comIesList.getSelectedValue()) {
                    //se afiseaza mesaj de stergere produs selectat din comenzile iesite
                    JDialog modalStergereProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Stergere Produse Comanda "+comIesList.getSelectedValue().getIdComanda(),true);
                    modalStergereProduseDialog.setContentPane(new StergereProduseWindow(comIesList.getSelectedValue()));
                    modalStergereProduseDialog.pack();
                    modalStergereProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalStergereProduseDialog.setVisible(true);
                    //new StergereProduseWindow(comIesList.getSelectedValue());
                }else {
                    //daca nici o comanda nu este selectata, se afiseaza mesaj utilizatorului
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });
        //la apasarea butonului de back se va afisa fereastra de start
        backButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Start(produseDepozit, comenziDepozit);
                Logger.getInstance().log("Intoarcere la Start");
                dispose();
            }
        });
        comIntrRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comIesRB.setSelected(false);
                clientFurnizorLB.setText("Client");
                clientFurnizorPanel.setVisible(true);
            }
        });
        comIesRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comIntrRB.setSelected(false);
                clientFurnizorLB.setText("Furnizor");
                clientFurnizorPanel.setVisible(true);
            }
        });
        //buton pentru crearea comenzii
        creareComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!comIntrRB.isSelected() && !comIesRB.isSelected()){//daca nu este selectat ce tip de comanda este
                    //se afiseaza mesaj pentru utilizator
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati tipul comenzii");
                }
                else if (clientFurnizorTF.getText().isEmpty()) {
                    //daca campul clientFurnizorTF este gol se afiseaza mesaj utilizatorului
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Introduceti "+clientFurnizorLB.getText()+"ul");
                }
                else {//daca este selectata comIntrRB
                    if (comIntrRB.isSelected()){//se creeaza acel tip de comanda
                        ComandaIntrata com = new ComandaIntrata(clientFurnizorTF.getText());
                        Logger.getInstance().log("Creare comanda "+com.getIdComanda());
                        comIntrate.addElement(com);
                        comenziDepozit.add(com);//se adauga comanda la lista
                    }//daca este selectata comIesRB
                    else if (comIesRB.isSelected()) {//se creeaza acel tip de comanda
                        ComandaIesita com = new ComandaIesita(clientFurnizorTF.getText());
                        Logger.getInstance().log("Creare comanda "+com.getIdComanda());
                        comIesite.addElement(com);
                        comenziDepozit.add(com);//se adauga comanda la lista
                    }
                }
            }
        });
    }
}