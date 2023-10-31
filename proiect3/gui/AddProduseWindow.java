package proiect3.gui;

import proiect3.DepozitUtils;
import proiect3.Logger;
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

        add(addProdusePanel);

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
                            Logger.getInstance().log("Adaugare produs SKU:"+produseList.getSelectedValue().getSKU()
                                    +"la comanda "+comanda.getIdComanda()+" (1BUC)");
                        }catch (ProdusDuplicatException ex){
                            Logger.getInstance().log("ProdusDuplicatException la adaugare produs: comanda "
                                    +comanda.getIdComanda()+", produs "+produseList.getSelectedValue().getSKU());
                            JOptionPane.showMessageDialog(AddProduseWindow.this,ex.getMessage());
                        }
                    } else {
                        int cantitate = 0;
                        boolean cantitateValida=false;
                        try {
                            cantitate = Integer.parseInt(cantitateTF.getText());
                            cantitateValida=true;
                        } catch (NumberFormatException ex) {
                            Logger.getInstance().log("NumberFormatException la introducere cantitate: "
                                    +cantitateTF.getText());
                            JOptionPane.showMessageDialog(AddProduseWindow.this,
                                    "Cantitate invalida: "+cantitateTF.getText());
                        }
                        if (cantitateValida){
                            try {
                                comanda.addItem(new ItemComanda(produseList.getSelectedValue(), cantitate));
                                Logger.getInstance().log("Adaugare produs SKU:"+produseList.getSelectedValue().getSKU()
                                        +"la comanda "+comanda.getIdComanda()+" ("+cantitateTF.getText()+"BUC)");
                            }catch (ProdusDuplicatException ex){
                                Logger.getInstance().log("ProdusDuplicatException la adaugare produs: comanda "
                                        +comanda.getIdComanda()+", produs "+produseList.getSelectedValue().getSKU());
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
