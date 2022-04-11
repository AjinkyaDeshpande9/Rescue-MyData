import javax.swing.*;

public class Pat_Login {
    public static void main(String[] args) {
        PatLoginFrame frame = new PatLoginFrame();
        frame.setTitle("PATIENT PORTAL");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
