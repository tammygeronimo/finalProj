
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class variantForm extends JFrame {

    JLabel pCodeLabel = new JLabel("Variant Code:");
    JLabel pNameLabel = new JLabel("Variant Name:");
    JTextField pCodeField = new JTextField();
    JTextField pNameField = new JTextField();
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public variantForm() {
        setTitle("Product Information : Variant");
        setSize(300, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        pCodeLabel.setBounds(10, 20, 100, 25);
        pCodeField.setBounds(120, 20, 150, 25);
        add(pCodeLabel); add(pCodeField);

        pNameLabel.setBounds(10, 60, 100, 25);
        pNameField.setBounds(120, 60, 150, 25);
        add(pNameLabel); add(pNameField);

        addButton.setBounds(30, 110, 100, 25);
        backButton.setBounds(150, 110, 100, 25);
        add(addButton);add(backButton);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String packageCode = pCodeField.getText();
                String packageName = pNameField.getText();
                addVariantToFile(packageCode, packageName);
                JOptionPane.showMessageDialog(null,  "Variant successfully recorded.", "Variant",
                        JOptionPane.INFORMATION_MESSAGE);
                pCodeField.setText("");
                pNameField.setText("");
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

    // Writing to "Package.txt"
    private void addVariantToFile(String packageCode, String packageName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Variant.txt", true))) {
            writer.write(packageCode + "," + packageName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}