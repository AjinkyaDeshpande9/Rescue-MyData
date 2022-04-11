import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatLoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("Patient Id:");
    JLabel passwordLabel = new JLabel("Password");
    JLabel InfoLabel = new JLabel("Patient Portal ");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton goBackButton = new JButton("Not a Patient ?");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton registrationButton = new JButton("Register");


    PatLoginFrame() {
        setlayoutManager();
        setLocationAndSize();
        addComponentstoContainer();
        addActionEvent();
    }

    public void setlayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(500 + 50, 150, 100, 30);
        passwordLabel.setBounds(500 + 50, 220, 100, 30);
        userTextField.setBounds(500 + 150, 150, 150, 30);
        passwordField.setBounds(500 + 150, 220, 150, 30);
        showPassword.setBounds(500 + 150, 250, 150, 30);
        loginButton.setBounds(500 + 50, 350, 100, 30);
        goBackButton.setBounds(500 + 250, 350, 120, 30);
        registrationButton.setBounds(500 + 150, 300, 100, 30);
        InfoLabel.setBounds(525, 50, 1000, 55);
        InfoLabel.setFont(new Font("Times New Roman",Font.PLAIN,45));
    }

    public void addComponentstoContainer() {
        container.add(userLabel);
        container.add(userTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(goBackButton);
        container.add(registrationButton);
        container.add(InfoLabel);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        goBackButton.addActionListener(this);
        showPassword.addActionListener(this);
        registrationButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rescuedata?useSSL=false", "root", "#MYSQL@007");
                String patient_id = userTextField.getText();
                String password = passwordField.getText();
                Statement stm = connection.createStatement();
                String sql = "select * from account where patient_id = '" + patient_id + "' and  password = '" + password + "'";
                ResultSet rs = stm.executeQuery(sql);


                if (rs.next()) {
                    String name = rs.getString("name");
                    String blood_grp = rs.getString("blood_grp");
                    String email_id = rs.getString("email_id");
                    String mobile_number = rs.getString("mobile_number");
                    String gender = rs.getString("gender");
                    String dob = rs.getString("dob");
                    String fam_doc = rs.getString("fam_doc");
                    String allergies = rs.getString("allergies");
                    String organ = rs.getString("organ");



                    JOptionPane.showMessageDialog(this, "Welcome Back " + name + "!" + "\n|Your Data|" + "\n Name              : " + name + "\n Blood group  : " + blood_grp + "\n Email               : " + email_id + "\n Mobile No.     : " + mobile_number + "\n Gender           : "
                            + gender + "\n Date Of Birth : " + dob + "\n Family Doctor: " + fam_doc + "\n Allergies         : " + allergies + "\n Registered as an organ donor : " + organ,"Logged in",JOptionPane.INFORMATION_MESSAGE);


                } else {
                    JOptionPane.showMessageDialog(this, "Patient id or Password is wrong...","Logged in Failed!",
                            JOptionPane.ERROR_MESSAGE);


                    userTextField.setText("");
                    passwordField.setText("");

                }



                connection.close();
            } catch (Exception x) {
                System.out.println(x.getMessage());

            }
        } else if (e.getSource() == registrationButton) {
            UserRegistrationFrame user = new UserRegistrationFrame();
            dispose();
            user.setVisible(true);
            user.setExtendedState(Frame.MAXIMIZED_BOTH);
        } else if (e.getSource() == goBackButton) {
            Main_PortalFrame goback = new Main_PortalFrame();
            dispose();
            goback.setVisible(true);
            goback.setExtendedState(Frame.MAXIMIZED_BOTH);
        } else if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else
                passwordField.setEchoChar('*');
        }
    }
}



