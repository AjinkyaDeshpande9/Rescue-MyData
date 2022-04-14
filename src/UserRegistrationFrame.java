import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UserRegistrationFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel Heading = new JLabel("Patient Registration Form");
    JLabel Name = new JLabel("Name");
    JLabel Blood = new JLabel("Blood Group ");
    JLabel EmailAddress = new JLabel("Email\r\n Address ");
    JLabel EmergencyContact = new JLabel("Emergency\r\n Contact ");
    JLabel Password = new JLabel("Password");
    JLabel Gender = new JLabel("Gender");
    JLabel DOB = new JLabel("Date of Birth");
    JLabel FamilyDoc = new JLabel("Family Doctor");
    JLabel Allergies = new JLabel("Allergies");
    JLabel OrganDonor = new JLabel("Donate Organs");

    JTextField nameTextField = new JTextField();
    JTextField bloodTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField emergencyTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField genderTextField = new JTextField();
    JTextField dobTextField = new JTextField();
    JTextField familydocTextField = new JTextField();
    JTextField allergiesTextField = new JTextField();
    JTextField organTextField = new JTextField();
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");

    UserRegistrationFrame() {
        setlayoutManager();
        setLocationAndSize();
        addComponentstoContainer();
        addActionEvent();
    }

    public void setlayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        Heading.setBounds(100,30,1000,50);
        Heading.setFont(new Font("Times New Roman",Font.PLAIN,45));
        Name.setBounds(100, 150, 100, 30);
        Name.setFont(new Font("Times New Roman",Font.PLAIN,20));
        Blood.setBounds(100, 250, 150, 30);
        Blood.setFont(new Font("Times New Roman",Font.PLAIN,20));
        EmailAddress.setBounds(100, 350, 150, 30);
        EmailAddress.setFont(new Font("Times New Roman",Font.PLAIN,20));
        EmergencyContact.setBounds(100, 450, 200, 30);
        EmergencyContact.setFont(new Font("Times New Roman",Font.PLAIN,20));
        Password.setBounds(100, 550, 150, 30);
        Password.setFont(new Font("Times New Roman",Font.PLAIN,20));
        Gender.setBounds(750, 150, 150, 30);
        Gender.setFont(new Font("Times New Roman",Font.PLAIN,20));
        DOB.setBounds(750, 250, 150, 30);
        DOB.setFont(new Font("Times New Roman",Font.PLAIN,20));
        FamilyDoc.setBounds(750, 350, 150, 30);
        FamilyDoc.setFont(new Font("Times New Roman",Font.PLAIN,20));
        Allergies.setBounds(750, 450, 150, 30);
        Allergies.setFont(new Font("Times New Roman",Font.PLAIN,20));
        OrganDonor.setBounds(750, 550, 150, 30);
        OrganDonor.setFont(new Font("Times New Roman",Font.PLAIN,20));


        nameTextField.setBounds(350, 150, 200, 30);
        bloodTextField.setBounds(350, 250, 200, 30);
        emailTextField.setBounds(350, 350, 200, 30);
        emergencyTextField.setBounds(350, 450, 200, 30);
        passwordField.setBounds(350, 550, 200, 30);
        genderTextField.setBounds(900, 150, 200, 30);
        dobTextField.setBounds(900, 250, 200, 30);
        familydocTextField.setBounds(900, 350, 200, 30);
        allergiesTextField.setBounds(900, 450, 200, 30);
        organTextField.setBounds(900, 550, 200, 30);
        registerButton.setBounds(400, 650, 200, 40);
        resetButton.setBounds(700, 650, 200, 40);
        backButton.setBounds(1000,50,100,30);
        backButton.setFont(new Font("Times New Roman",Font.PLAIN,12));
    }

    public void addComponentstoContainer() {
        container.add(Name);
        container.add(Blood);
        container.add(EmailAddress);
        container.add(EmergencyContact);
        container.add(Password);
        container.add(Gender);
        container.add(DOB);
        container.add(FamilyDoc);
        container.add(Allergies);
        container.add(OrganDonor);
        container.add(nameTextField);
        container.add(bloodTextField);
        container.add(emailTextField);
        container.add(emergencyTextField);
        container.add(passwordField);
        container.add(genderTextField);
        container.add(dobTextField);
        container.add(familydocTextField);
        container.add(allergiesTextField);
        container.add(organTextField);
        container.add(registerButton);
        container.add(resetButton);
        container.add(Heading);
        container.add(backButton);
    }

    public void addActionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        double randomDouble = Math.random();
        randomDouble = randomDouble * 99999 + 9999;
        int randomInt = (int) randomDouble;
        System.out.println(randomInt);

        String name = nameTextField.getText();
        String bloodgrp = bloodTextField.getText();
        String email = emailTextField.getText();
        String emergency = emergencyTextField.getText();
        String password = passwordField.getText();
        String gender = genderTextField.getText();
        String dob = dobTextField.getText();
        String familydoc = familydocTextField.getText();
        String allergies = allergiesTextField.getText();
        String organdonor = organTextField.getText();
        int len = emergency.length();


        String msg = "" + name;
        msg += " \n";
        if (e.getSource() == backButton) {
            PatLoginFrame back = new PatLoginFrame();
            dispose();
            back.setVisible(true);
            back.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        }
        else if (len != 10) {
            JOptionPane.showMessageDialog(registerButton, "Please enter a valid mobile number","Warning",JOptionPane.WARNING_MESSAGE);

        }
        else if (e.getSource() == registerButton){
            try {


                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rescuedata", "root", "#MYSQL@007");

                String query = "INSERT INTO account values('" + name + "','" + bloodgrp + "','" + email + "','" + emergency + "','" + password + "','" + gender + "','" + dob + "','" + familydoc + "','" + allergies + "','" + organdonor + "','" + randomInt + "')";

                Statement sta = connection.createStatement();
                sta.executeUpdate(query);
                JOptionPane.showMessageDialog(registerButton,
                        "Welcome, " + msg + " Your account is Successfully created and your unique Patient id is: " + randomInt + "  ","Registered Successfully!",JOptionPane.INFORMATION_MESSAGE);

                PatLoginFrame loginpat = new PatLoginFrame();
                dispose();
                loginpat.setVisible(true);
                loginpat.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
                connection.close();
            }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        else if(e.getSource()== resetButton)
                {
                    nameTextField.setText("");
                    bloodTextField.setText("");
                    emailTextField.setText("");
                    emergencyTextField.setText("");
                    passwordField.setText("");
                    genderTextField.setText("");
                    dobTextField.setText("");
                    familydocTextField.setText("");
                    allergiesTextField.setText("");
                    organTextField.setText("");
                }


            }


    }


