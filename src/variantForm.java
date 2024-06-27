import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class variantForm extends JFrame {

    JLabel vCodeLabel = new JLabel("Variant Code:");
    JLabel vNameLabel = new JLabel("Variant Name:");
    JTextField vCodeField = new JTextField();
    JTextField vNameField = new JTextField();
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public variantForm() {
        setTitle("Product Information : Variant");
        setSize(295, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        vCodeLabel.setBounds(10, 20, 100, 25);
        vCodeField.setBounds(120, 20, 150, 25);
        vCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        vCodeLabel.setForeground(Color.decode("#31C198"));
        add(vCodeLabel); add(vCodeField);

        vNameLabel.setBounds(10, 60, 100, 25);
        vNameField.setBounds(120, 60, 150, 25);
        vNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        vNameLabel.setForeground(Color.decode("#31C198"));
        add(vNameLabel); add(vNameField);

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
                String variantCode = vCodeField.getText();
                String variantName = vNameField.getText();
                addVariantToFile(variantCode, variantName);
                JOptionPane.showMessageDialog(null,  "Variant successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                vCodeField.setText("");
                vNameField.setText("");
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
    private void addVariantToFile(String variantCode, String variantName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Variant.txt", true))) {
            writer.write(variantCode + "," + variantName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}