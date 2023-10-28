package proiect3.gui;

import proiect3.DepozitUtils;
import proiect3.entitati.gestiune.ComandaIesita;
import proiect3.entitati.gestiune.ComandaIntrata;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private DefaultListModel<ComandaIesita> comIesite = new DefaultListModel<>();

    public GestiuneComenzi() {


        setContentPane(gestiuneComenziPanel);
        //setLocationRelativeTo(null);


        setVisible(true);//se afiseaza gestiuneComenzi
        setTitle("gestiuneComenzi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);


        DepozitUtils.initComIntrate(comIntrate);
        comIntrList.setModel(comIntrate);
        comIntrList.setCellRenderer(new DefaultListCellRenderer());
        comIntrList.setVisible(true);

        DepozitUtils.initComIesite(comIesite);
        comIesList.setModel(comIesite);
        comIesList.setCellRenderer(new DefaultListCellRenderer());
        comIesList.setVisible(true);

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
                    comIntrate.remove(comIntrList.getSelectedIndex());
                } else if (null!=comIesList.getSelectedValue()) {
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
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(comIntrList.getSelectedValue()));
                    modalAddProduseDialog.pack();
                    modalAddProduseDialog.setLocationRelativeTo(GestiuneComenzi.this);
                    modalAddProduseDialog.setVisible(true);

                    //modalAddProduseDialog.add(new AddProduseWindow(comIntrList.getSelectedValue()));
                    //new AddProduseWindow(comIntrList.getSelectedValue());
                } else if (null!=comIesList.getSelectedValue()) {
                    JDialog modalAddProduseDialog= new JDialog(GestiuneComenzi.this,
                            "Adaugare Produse Comanda "+comIesList.getSelectedValue().getIdComanda(),true);
                    modalAddProduseDialog.setContentPane(new AddProduseWindow(comIesList.getSelectedValue()));
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
    }


    private void createUIComponents() {
        System.out.println("GestiuneComenzi.createUIComponents was used");
    }
}