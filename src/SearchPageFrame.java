import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class SearchPageFrame extends JFrame implements ActionListener
{
    Container container = getContentPane();
    JLabel searchLabel = new JLabel("Patient ID");
    JTextField searchTextField = new JTextField();
    JButton searchButton = new JButton("Search");
    JButton LogoutButton = new JButton("Logout");
    JTextArea Info = new JTextArea();

    SearchPageFrame()
    {
        setlayoutManager();
        setLocationAndSize();
        addComponentstoContainer();
        addActionEvent();
    }

    public void setlayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize()
    {
        searchLabel.setBounds(20, 30, 100, 30);
        searchLabel.setFont(new Font("Times New Roman",Font.PLAIN,12));
        searchTextField.setBounds(120, 30, 150, 30);
        searchTextField.setFont(new Font("Times New Roman",Font.PLAIN,12));
        searchButton.setBounds(135, 80, 100, 30);
        searchButton.setFont(new Font("Times New Roman",Font.PLAIN,12));
        Info.setBounds(300,30,800,650);
        Info.setFont(new Font("Times New Roman",Font.PLAIN,36));
        LogoutButton.setBounds(1200,30,100,30);
        LogoutButton.setFont(new Font("Times New Roman",Font.PLAIN,12));
    }

    public void addComponentstoContainer()
    {
        container.add(searchLabel);
        container.add(searchTextField);
        container.add(searchButton);
        container.add(Info);
        container.add(LogoutButton);
    }

    public void addActionEvent()
    {
        searchButton.addActionListener(this);
        LogoutButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == LogoutButton) {
            MEDLoginFrame back = new MEDLoginFrame();
            dispose();
            back.setVisible(true);
            back.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        }
        if (e.getSource() == searchButton) {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rescuedata?useSSL=false", "root", "#MYSQL@007");
                String patient_id = searchTextField.getText();

                Statement stm = connection.createStatement();
                String sql = "select * from account where patient_id = '" + patient_id + "'";
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

                    Info.setText("Patient Name             : "+name+"\nPatient Blood group  : "+blood_grp+"\nPatient Email             : "+email_id+"\nPatient Mobile No.    : "+mobile_number+"\nPatient Gender           : "
                            +gender+"\nPatient Date Of Birth : "+dob+"\nPatient Family Doctor: "+fam_doc+"\nPatient Allergies         : "+allergies+"\nIs Patient an organ donor? : "+organ);



                } else {
                    JOptionPane.showMessageDialog(this, "Patient id is wrong!!");
                    searchTextField.setText("");


                }



                connection.close();
            } catch (Exception x) {
                System.out.println(x.getMessage());

            }

        }


        }
    }
