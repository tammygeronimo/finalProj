import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class supplierForm extends JFrame {

    JLabel sCodeLabel = new JLabel("Supplier Code:");
    JLabel sNameLabel = new JLabel("Supplier Name:");
    JTextField sCodeField = new JTextField();
    JTextField sNameField = new JTextField();
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public supplierForm() {
        setTitle("Supplier Information");
        setSize(300, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        sCodeLabel.setBounds(10, 20, 100, 25);
        sCodeField.setBounds(120, 20, 150, 25);
        sCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sCodeLabel.setForeground(Color.decode("#31C198"));
        add(sCodeLabel); add(sCodeField);

        sNameLabel.setBounds(10, 60, 100, 25);
        sNameField.setBounds(120, 60, 150, 25);
        sNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sNameLabel.setForeground(Color.decode("#31C198"));
        add(sNameLabel); add(sNameField);

        addButton.setBounds(30, 110, 100, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(150, 110, 100, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(addButton);add(backButton);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String supplierCode = sCodeField.getText();
                String supplierName = sNameField.getText();
                addSupplierToFile(supplierCode, supplierName);
                JOptionPane.showMessageDialog(null,  "Supplier successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                sCodeField.setText("");
                sNameField.setText("");
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

    // Writing to "Supplier.txt"
    private void addSupplierToFile(String supplierCode, String supplierName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Supplier.txt", true))) {
            writer.write(supplierCode + "," + supplierName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}