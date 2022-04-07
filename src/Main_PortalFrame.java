import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_PortalFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel Heading = new JLabel("Welcome to Rescue : My Data");
    JLabel InfoLabel = new JLabel("You are a ... ");
    JButton DoctorButton = new JButton("Paramedic");
    JButton PatientButton = new JButton("Patient");

    Main_PortalFrame()
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
        Heading.setBounds(375,100,2000,60);
        Heading.setFont(new Font("Times New Roman",Font.PLAIN,55));
        InfoLabel.setBounds(600, 200+50, 1000, 55);
        InfoLabel.setFont(new Font("Times New Roman",Font.PLAIN,45));
        DoctorButton.setBounds(400, 350+50, 200, 50);
        DoctorButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
        PatientButton.setBounds(800, 350+50, 200, 50);
        PatientButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
    }

    public void addComponentstoContainer()
    {
        container.add(Heading);
        container.add(InfoLabel);
        container.add(DoctorButton);
        container.add(PatientButton);
            }

    public void addActionEvent()
    {
        DoctorButton.addActionListener(this);
        PatientButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == DoctorButton) {
            MEDLoginFrame doc = new MEDLoginFrame();
            dispose();
            doc.setVisible(true);
            doc.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        }
        else if (e.getSource() == PatientButton) {
            PatLoginFrame pat = new PatLoginFrame();
            dispose();
            pat.setVisible(true);
            pat.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Patient ID");
            }
        }
    }
