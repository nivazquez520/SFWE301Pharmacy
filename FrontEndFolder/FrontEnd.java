package FrontEndFolder;
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
//import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {
    private final DefaultListModel<String> taskModel;
    private final JList<String> taskList;
    public FrontEnd() {
        JFrame frame = new JFrame("Pharmacy App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel with Buttons
        JPanel inputPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton createButton = new JButton("Create");

        inputPanel.add(loginButton);
        inputPanel.add(createButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        // Task List in Center
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Action Listener for Create Button
        createButton.addActionListener(e -> {
            // Switch to the Create Page
            dispose(); // Close current window
            new CreatePage(); // Open CreatePage window
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FrontEnd::new);
    }
}