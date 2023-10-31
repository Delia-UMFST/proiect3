package proiect3.gui;

import proiect3.Logger;
import proiect3.entitati.gestiune.Comanda;
import proiect3.entitati.inventar.IProdus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start extends JFrame {
    JFrame Start=new JFrame();
    private JButton accesInventar;
    private JButton accesComenzi;
    private JPanel AccesGestiune;


 public Start (ArrayList<IProdus> produseDepozit, ArrayList<Comanda> comenziDepozit){
     setContentPane(AccesGestiune);

     setVisible(true);
     setSize(300,200);
     setLocationRelativeTo(null);

     setDefaultCloseOperation(EXIT_ON_CLOSE);

     //daca se apasa pe butonul de Gestiune, atunci se va afisa fereastra de Gestiune
     accesComenzi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             new GestiuneComenzi(produseDepozit, comenziDepozit);
             Logger.getInstance().log("Acces gestiune");
             dispose();

         }
     });
     //daca se apasa pe butonul de Inventar, atunci se va afisa fereastra de Inventar

     accesInventar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new Inventar(produseDepozit, comenziDepozit);
            Logger.getInstance().log("Acces inventar");
            dispose();
         }
     });
 }
}