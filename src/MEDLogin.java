import javax.swing.*;
import java.awt.*;

public class MEDLogin {

    public static void main(String[] args) {
        MEDLoginFrame frame = new MEDLoginFrame();
        frame.setTitle("MEDICAL PORTAL");
        frame.setVisible(true);
        frame.setExtendedState (java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
