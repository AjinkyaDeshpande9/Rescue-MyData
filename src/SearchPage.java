import javax.swing.*;

public class SearchPage {
    public static void main(String[] args) {
        SearchPageFrame frame1 = new SearchPageFrame();
        frame1.setTitle("Search Patient ID");
        frame1.setVisible(true);
        frame1.setBounds(10,10,370,600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
