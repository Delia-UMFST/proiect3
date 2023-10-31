package proiect3.gui;

import proiect3.Logger;
import proiect3.entitati.gestiune.Comanda;
import proiect3.entitati.gestiune.ItemComanda;
import proiect3.exceptii.ProdusInexistentException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StergereProduseWindow extends JPanel {
    private JButton stergereBtn;
    private JLabel produseLB;
    private JList<ItemComanda> produseList;
    private JPanel stergeProdusePanel;
    private DefaultListModel<ItemComanda> produseListModel = new DefaultListModel<>();

    public StergereProduseWindow(Comanda comanda){

        add(stergeProdusePanel);

        produseList.setModel(produseListModel);
        produseList.setCellRenderer(new DefaultListCellRenderer());
        produseList.setVisible(true);

        for (ItemComanda item : comanda.getProduse()) {
            produseListModel.addElement(item);
        }

        //stergerea unui item din comanda
        stergereBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=produseList.getSelectedValue()) {
                    try{
                        Logger.getInstance().log("Stergere produs SKU:"+produseList.getSelectedValue().getProdus().getSKU()
                                +"din comanda "+comanda.getIdComanda());
                        comanda.removeItem(produseList.getSelectedValue());
                        produseListModel.remove(produseList.getSelectedIndex());
                    }
                    catch (ProdusInexistentException ex){
                        Logger.getInstance().log("ProdusInexistentException la stergere produs: comanda "
                                +comanda.getIdComanda()+", produs "+produseList.getSelectedValue().getProdus().getSKU());
                        JOptionPane.showMessageDialog(StergereProduseWindow.this,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(StergereProduseWindow.this,
                            "Selectati un produs");
                }
            }
        });
    }
}
