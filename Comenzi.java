import javax.swing.*;

public class Comenzi extends JFrame{
    JFrame gestiuneComenzi =new JFrame();
    private JPanel PanelLeft;
    private JPanel PanelRight;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;


    public Comenzi() {
        setLocationRelativeTo(null);

        setVisible(true);//se afiseaza gestiuneComenzi
        setTitle("gestiuneComenzi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

    }

}
