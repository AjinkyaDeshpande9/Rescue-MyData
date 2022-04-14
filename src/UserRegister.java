import javax.swing.*;
import java.awt.*;

public class UserRegister {
    public static void main(String[] args) {
        UserRegistrationFrame frame = new UserRegistrationFrame();
        frame.setTitle("REGISTRATION PORTAL");
        frame.setVisible(true);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
