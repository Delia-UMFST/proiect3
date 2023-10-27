import javax.swing.*;

public class GestiuneComenzi extends JFrame{


    private JPanel GestiuneComenziPanel;
    private JPanel ComenziIntratePanel;
    private JLabel ComenziIntrat;
    private JPanel ComenziIesirePanel;
    private JLabel ComenziIesire;

    public GestiuneComenzi() {
        setLocationRelativeTo(null);

        setVisible(true);//se afiseaza gestiuneComenzi
        setTitle("gestiuneComenzi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

    }

}