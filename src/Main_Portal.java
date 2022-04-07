import javax.swing.*;


public class Main_Portal {
    public static void main(String[] args) {
        Main_PortalFrame frame = new Main_PortalFrame();
        frame.setTitle("Rescue My Data");
        frame.setVisible(true);
        frame.setExtendedState (java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

