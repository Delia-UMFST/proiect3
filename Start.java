import java.awt.*;
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


     accesComenzi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             new Comenzi();
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