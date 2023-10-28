package proiect3.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    JFrame Start=new JFrame();
    private JButton accesInventar;
    private JButton accesComenzi;
    private JPanel AccesGestiune;


 public Start (){
     setContentPane(AccesGestiune);
     setLocationRelativeTo(null);
     setVisible(true);
     setSize(300,200);
     setDefaultCloseOperation(EXIT_ON_CLOSE);


     accesComenzi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             new GestiuneComenzi();
             dispose();

         }
     });

     accesInventar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new Inventar();
            dispose();
         }
     });
 }
}