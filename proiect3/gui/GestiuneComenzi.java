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
        //setLocationRelativeTo(null);


        setVisible(true);//se afiseaza gestiuneComenzi
        setTitle("gestiuneComenzi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);

        for(Comanda com: comenziDepozit){
            if(com instanceof ComandaIntrata){
                comIntrate.addElement((ComandaIntrata) com);
            }
            else if (com instanceof ComandaIesita) {
                comIesite.addElement((ComandaIesita) com);
            }
        }

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

        detaliiComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            comIntrList.getSelectedValue().infoComanda());
                } else if (null!=comIesList.getSelectedValue()) {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            comIesList.getSelectedValue().infoComanda());
                }else {
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
        stergereComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){
                    Logger.getInstance().log("Stergere comanda "+comIntrList.getSelectedValue().getIdComanda());
                    comenziDepozit.remove(comIntrList.getSelectedValue());
                    comIntrate.remove(comIntrList.getSelectedIndex());
                } else if (null!=comIesList.getSelectedValue()) {
                    Logger.getInstance().log("Stergere comanda "+comIesList.getSelectedValue().getIdComanda());
                    comenziDepozit.remove(comIesList.getSelectedValue());
                    comIesite.remove(comIesList.getSelectedIndex());
                }else {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });

        addProduseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){

                    JDialog modalAddProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Adaugare Produse Comanda "+comIntrList.getSelectedValue().getIdComanda(),true);
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(produseDepozit,comIntrList.getSelectedValue()));
                    modalAddProduseDialog.pack();
                    modalAddProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalAddProduseDialog.setVisible(true);

                    //modalAddProduseDialog.add(new AddProduseWindow(comIntrList.getSelectedValue()));
                    //new AddProduseWindow(comIntrList.getSelectedValue());
                } else if (null!=comIesList.getSelectedValue()) {
                    JDialog modalAddProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Adaugare Produse Comanda "+comIesList.getSelectedValue().getIdComanda(),true);
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(produseDepozit,comIesList.getSelectedValue()));
                    modalAddProduseDialog.pack();
                    modalAddProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalAddProduseDialog.setVisible(true);
                    //new AddProduseWindow(comIesList.getSelectedValue());
                }else {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });
        stergereProduseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=comIntrList.getSelectedValue()){
                    JDialog modalStergereProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Stergere Produse Comanda "+comIntrList.getSelectedValue().getIdComanda(),true);
                    modalStergereProduseDialog.setContentPane(new StergereProduseWindow(comIntrList.getSelectedValue()));
                    modalStergereProduseDialog.pack();
                    modalStergereProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalStergereProduseDialog.setVisible(true);
                    //new StergereProduseWindow(comIntrList.getSelectedValue());
                } else if (null!=comIesList.getSelectedValue()) {
                    JDialog modalStergereProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Stergere Produse Comanda "+comIesList.getSelectedValue().getIdComanda(),true);
                    modalStergereProduseDialog.setContentPane(new StergereProduseWindow(comIesList.getSelectedValue()));
                    modalStergereProduseDialog.pack();
                    modalStergereProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalStergereProduseDialog.setVisible(true);
                    //new StergereProduseWindow(comIesList.getSelectedValue());
                }else {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati o comanda");
                }
            }
        });
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
        creareComBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!comIntrRB.isSelected() && !comIesRB.isSelected()){
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Selectati tipul comenzii");
                }
                else if (clientFurnizorTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(GestiuneComenzi.this,
                            "Introduceti "+clientFurnizorLB.getText()+"ul");
                }
                else {
                    if (comIntrRB.isSelected()){
                        ComandaIntrata com = new ComandaIntrata(clientFurnizorTF.getText());
                        Logger.getInstance().log("Creare comanda "+com.getIdComanda());
                        comIntrate.addElement(com);
                        comenziDepozit.add(com);
                    }
                    else if (comIesRB.isSelected()) {
                        ComandaIesita com = new ComandaIesita(clientFurnizorTF.getText());
                        Logger.getInstance().log("Creare comanda "+com.getIdComanda());
                        comIesite.addElement(com);
                        comenziDepozit.add(com);
                    }
                }
            }
        });
    }
}