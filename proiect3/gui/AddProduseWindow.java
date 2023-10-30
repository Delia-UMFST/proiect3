package proiect3.gui;

import proiect3.DepozitUtils;
import proiect3.entitati.gestiune.Comanda;
import proiect3.entitati.inventar.IProdus;
import proiect3.entitati.gestiune.ItemComanda;
import proiect3.exceptii.ProdusDuplicatException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProduseWindow extends JPanel {
    private JPanel addProdusePanel;
    private JTextField cantitateTF;
    private JButton adaugareBtn;
    private JLabel cantitateLB;
    private JList<IProdus> produseList;
    private JLabel produseLB;
    private DefaultListModel<IProdus> produseListModel = new DefaultListModel<>();

    public AddProduseWindow(ArrayList<IProdus> produseDepozit, Comanda comanda){

        //setContentPane(addProdusePanel);
        add(addProdusePanel);
        //setLocationRelativeTo(null);
        //setTitle("Adaugare Produse Comanda "+comanda.getIdComanda());
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setVisible(true);//se afiseaza Inventar
        //setPreferredSize(new Dimension(500,500));

        produseList.setModel(produseListModel);
        produseList.setCellRenderer(new DefaultListCellRenderer());
        produseList.setVisible(true);

        for (IProdus produs : produseDepozit) {
            produseListModel.addElement(produs);
        }

        adaugareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=produseList.getSelectedValue()) {
                    if (cantitateTF.getText().isEmpty()) {
                        try {
                            comanda.addItem(new ItemComanda(produseList.getSelectedValue()));
                        }catch (ProdusDuplicatException ex){
                            JOptionPane.showMessageDialog(AddProduseWindow.this,ex.getMessage());
                        }
                    } else {
                        int cantitate = 0;
                        boolean cantitateValida=false;
                        try {
                            cantitate = Integer.parseInt(cantitateTF.getText());
                            cantitateValida=true;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(AddProduseWindow.this,
                                    "Cantitate invalida: "+cantitateTF.getText());
                        }
                        if (cantitateValida){
                            try {
                                comanda.addItem(new ItemComanda(produseList.getSelectedValue(), cantitate));
                            }catch (ProdusDuplicatException ex){
                                JOptionPane.showMessageDialog(AddProduseWindow.this,ex.getMessage());
                            }
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(AddProduseWindow.this,
                            "Selectati un produs");
                }
            }
        });
    }
}
