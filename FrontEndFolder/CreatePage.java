package FrontEndFolder;
import javax.swing.*;

public class CreatePage extends JFrame {

    public CreatePage() {
        // Initialize the CardLayout and main panel
        JFrame frame = new JFrame("Labeled TextFields Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null); // Using null layout for manual positioning

        // Create labels and text fields
        JLabel label1 = new JLabel("Name:");
        label1.setBounds(50, 50, 100, 30); // x, y, width, height
        JTextField textField1 = new JTextField();
        textField1.setBounds(150, 50, 200, 30);

        JLabel label2 = new JLabel("Email:");
        label2.setBounds(50, 100, 100, 30);
        JTextField textField2 = new JTextField();
        textField2.setBounds(150, 100, 200, 30);

        JLabel label3 = new JLabel("Phone:");
        label3.setBounds(50, 150, 100, 30);
        JTextField textField3 = new JTextField();
        textField3.setBounds(150, 150, 200, 30);

        // Add labels and text fields to the JFrame
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(label3);
        frame.add(textField3);

        // Make the frame visible
        frame.setVisible(true);
    }
}