import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class supplierForm extends JFrame {

    JLabel cCodeLabel = new JLabel("Supplier Code:");
    JLabel cNameLabel = new JLabel("Supplier Name:");
    JTextField cCodeField = new JTextField();
    JTextField cNameField = new JTextField();
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public supplierForm() {
        setTitle("Supplier Information");
        setSize(300, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        cCodeLabel.setBounds(10, 20, 100, 25);
        cCodeField.setBounds(120, 20, 150, 25);
        add(cCodeLabel); add(cCodeField);

        cNameLabel.setBounds(10, 60, 100, 25);
        cNameField.setBounds(120, 60, 150, 25);
        add(cNameLabel); add(cNameField);

        addButton.setBounds(30, 110, 100, 25);
        backButton.setBounds(150, 110, 100, 25);
        add(addButton);add(backButton);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String categoryCode = cCodeField.getText();
                String categoryName = cNameField.getText();
                addCategoryToFile(categoryCode, categoryName);
                JOptionPane.showMessageDialog(null,  "Supplier successfully recorded.", "Processed!",
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Supplier.txt", true))) {
            writer.write(categoryCode + ",\t" + categoryName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //TODO Create A functions thats write the informations into 'Supplier.txt'
    //TODO Create ActionEventListener for add and Back buttons
}