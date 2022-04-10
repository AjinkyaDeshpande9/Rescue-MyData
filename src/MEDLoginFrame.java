import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MEDLoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel InfoLabel = new JLabel("Paramedic Portal ");
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Not a Paramedic ?");
    JCheckBox showPassword = new JCheckBox("Show Password");

    MEDLoginFrame()
    {
        setlayoutManager();
        setLocationAndSize();
        addComponentstoContainer();
        addActionEvent();
    }

    public void setlayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        InfoLabel.setBounds(525, 50, 1000, 55);
        InfoLabel.setFont(new Font("Times New Roman",Font.PLAIN,45));
        userLabel.setBounds(500+50, 150, 100, 30);
        passwordLabel.setBounds(500+50, 220, 100, 30);
        userTextField.setBounds(500+150, 150, 150, 30);
        passwordField.setBounds(500+150, 220, 150, 30);
        showPassword.setBounds(500+150, 250, 150, 30);
        loginButton.setBounds(500+50, 350, 100, 30);
        backButton.setBounds(500+200, 350, 140, 30);
    }

    public void addComponentstoContainer()
    {
        container.add(InfoLabel);
        container.add(userLabel);
        container.add(userTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(backButton);
    }

    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        backButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String passwordText;
            userText = userTextField.getText();
            passwordText = passwordField.getText();
            if (userText.equalsIgnoreCase("AJINKYA") && passwordText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Welcome Back Ajinkya","Logged in Successfully!",JOptionPane.INFORMATION_MESSAGE);
                SearchPageFrame searchPage = new SearchPageFrame();
                dispose();
                searchPage.setVisible(true);
                searchPage.setExtendedState (java.awt.Frame.MAXIMIZED_BOTH);
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password","Logged in Failed!",JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==backButton)
        {
            Main_PortalFrame goback = new Main_PortalFrame();
            dispose();
            goback.setVisible(true);
            goback.setExtendedState (java.awt.Frame.MAXIMIZED_BOTH);
        }

        if(e.getSource()==showPassword)
        {
            if(showPassword.isSelected())
            {
                passwordField.setEchoChar((char)0);
            }
            else
                passwordField.setEchoChar('*');
        }
    }
}
