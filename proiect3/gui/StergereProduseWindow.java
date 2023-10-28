package proiect3.gui;

import proiect3.entitati.Comanda;
import proiect3.entitati.ItemComanda;
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

        //setContentPane(stergeProdusePanel);
        add(stergeProdusePanel);
        //setLocationRelativeTo(null);
        //setTitle("Stergere Produse Comanda "+comanda.getIdComanda());
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setVisible(true);//se afiseaza Inventar
        //setSize(500,500);

        produseList.setModel(produseListModel);
        produseList.setCellRenderer(new DefaultListCellRenderer());
        produseList.setVisible(true);

        for (ItemComanda item : comanda.getProduse()) {
            produseListModel.addElement(item);
        }

        stergereBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(null!=produseList.getSelectedValue()) {
                    try{
                        comanda.removeItem(produseList.getSelectedValue());
                        produseListModel.remove(produseList.getSelectedIndex());
                    }
                    catch (ProdusInexistentException ex){
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
