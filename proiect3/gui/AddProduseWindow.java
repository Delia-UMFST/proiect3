package proiect3.gui;

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
    //constructor care are ca si parametru lista produseDepozit si obiectul comanda de tip comanda
    public AddProduseWindow(ArrayList<IProdus> produseDepozit, Comanda comanda){

        add(addProdusePanel);

        produseList.setModel(produseListModel);
        produseList.setCellRenderer(new DefaultListCellRenderer());
        produseList.setVisible(true);
        //se trece prin lista de produse si se adauga la lista produseListModel
        for (IProdus produs : produseDepozit) {
            produseListModel.addElement(produs);
        }

        //adaugarea unui item de pe stoc la comanda
        adaugareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=produseList.getSelectedValue()) {
                    //daca TextField-ul este gol
                    if (cantitateTF.getText().isEmpty()) {
                        try {
                            //se incearca adaugarea unei singure bucati din produsul selectat cu acel SKU
                            comanda.addItem(new ItemComanda(produseList.getSelectedValue()));
                            Logger.getInstance().log("Adaugare produs SKU:"+produseList.getSelectedValue().getSKU()
                                    +"la comanda "+comanda.getIdComanda()+" (1BUC)");
                        }catch (ProdusDuplicatException ex){
                            // exceptie, afiseaza mesaj de eroare in caz de produs duplicat
                            Logger.getInstance().log("ProdusDuplicatException la adaugare produs: comanda "
                                    +comanda.getIdComanda()+", produs "+produseList.getSelectedValue().getSKU());
                            JOptionPane.showMessageDialog(AddProduseWindow.this,ex.getMessage());
                        }
                    } else {
                        int cantitate = 0;
                        boolean cantitateValida=false;
                        try {
                            //citeste cantitatea si daca cantitatea are formatul corespunzator e valid
                            cantitate = Integer.parseInt(cantitateTF.getText());
                            cantitateValida=true;
                        } catch (NumberFormatException ex) {
                            Logger.getInstance().log("NumberFormatException la introducere cantitate: "
                                    +cantitateTF.getText());
                            JOptionPane.showMessageDialog(AddProduseWindow.this,
                                    "Cantitate invalida: "+cantitateTF.getText());
                        }
                        if (cantitateValida){
                            //daca cantitatea introdusa este valida se adauga acel produs in cantitatea corespunzatoare
                            try {
                                comanda.addItem(new ItemComanda(produseList.getSelectedValue(), cantitate));
                                Logger.getInstance().log("Adaugare produs SKU:"+produseList.getSelectedValue().getSKU()
                                        +"la comanda "+comanda.getIdComanda()+" ("+cantitateTF.getText()+"BUC)");
                            }catch (ProdusDuplicatException ex){
                                //daca produsul deja exista atunci se va afisa exceptia pentru produs duplicat
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
