import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class categoryForm extends JFrame {

    JLabel cCodeLabel = new JLabel("Category Code:");
    JLabel cNameLabel = new JLabel("Category Name:");
    JTextField cCodeField = new JTextField();
    JTextField cNameField = new JTextField();
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public categoryForm() {
        setTitle("Product Information : Category");
        setSize(295, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        cCodeLabel.setBounds(10, 20, 115, 25);
        cCodeField.setBounds(120, 20, 150, 25);
        cCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cCodeLabel.setForeground(Color.decode("#31C198"));
        add(cCodeLabel); add(cCodeField);

        cNameLabel.setBounds(10, 60, 115, 25);
        cNameField.setBounds(120, 60, 150, 25);
        cNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cNameLabel.setForeground(Color.decode("#31C198"));
        add(cNameLabel); add(cNameField);

        addButton.setBounds(30, 110, 100, 25);
        backButton.setBounds(150, 110, 100, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(addButton);add(backButton);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String categoryCode = cCodeField.getText();
                String categoryName = cNameField.getText();
                addCategoryToFile(categoryCode, categoryName);
                JOptionPane.showMessageDialog(null,  "Category successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                cCodeField.setText("");
                cNameField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    // Writing to "Category.txt"
    private void addCategoryToFile(String categoryCode, String categoryName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Category.txt", true))) {
            writer.write(categoryCode + ", " + categoryName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}