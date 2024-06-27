import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

@SuppressWarnings("serial")
class deliveryForm extends JFrame {
    JLabel sCodeLabel = new JLabel("Supplier Code:");
    JLabel sNameLabel = new JLabel("Supplier Name:");
    JComboBox cmbSupplier = new JComboBox();
    JTextField sNameField = new JTextField();

    JLabel pCodeLabel = new JLabel("Product Code:");
    JLabel pNameLabel = new JLabel("Product Name:");
    JComboBox cmbProduct = new JComboBox();
    JTextField pNameField = new JTextField();

    JLabel prodLabel = new JLabel("Product");
    JLabel descLabel = new JLabel("Description:");
    JLabel quantityLabel = new JLabel("Quantity");
    JLabel delLabel = new JLabel("Delivered:");
    JTextArea prodDescField = new JTextArea();
    JTextField quantityField = new JTextField();

    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public deliveryForm() {
        setTitle("Delivery Information");
        setSize(565,330);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#EAE5DF"));

        sCodeLabel.setBounds(28, 30, 86, 14);cmbSupplier.setBounds(112, 26, 137, 22);
        sNameLabel.setBounds(272, 30, 97, 14);sNameField.setBounds(379, 27, 137, 20);sNameField.setEnabled(false);
        add(sCodeLabel);add(cmbSupplier);add(sNameLabel);add(sNameField);

        pCodeLabel.setBounds(28, 70, 86, 14);cmbProduct.setBounds(112, 66, 137, 22);
        pNameLabel.setBounds(272, 70, 97, 14);pNameField.setBounds(379, 67, 137, 20);pNameField.setEnabled(false);
        add(pCodeLabel);add(cmbProduct);add(pNameLabel);add(pNameField);

        prodLabel.setBounds(28, 110, 86, 14);prodDescField.setBounds(112, 110, 137, 49); descLabel.setBounds(28, 125, 87, 14);
        prodDescField.setEnabled(false); prodDescField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        quantityLabel.setBounds(272, 110, 97, 14);delLabel.setBounds(272,125,97,14); quantityField.setBounds(379, 110, 86, 20);
        add(prodLabel);add(descLabel);add(prodDescField); add(quantityLabel); add(delLabel); add(quantityField);

        textArea.setBounds(28, 186, 488, 33);
        textArea.setEnabled(false); textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); add(textArea);

        newButton.setBackground(Color.decode("#450202"));newButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.decode("#450202"));addButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#B19C8F"));
        newButton.setBounds(45, 244, 89, 23);addButton.setBounds(224, 244, 89, 23);backButton.setBounds(413, 244, 89, 23);
        add(newButton);add(addButton);add(backButton);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new deliveryForm());
    }

    /*
      TODO Create a Function that READ the 'Supplier.txt' and trim the indexes to add into SupplierBox AND set the text
       in product Supplier Name

     */
    /*
       TODO Create a Functions that READ the 'Package.txt' and trim the indexes to add into ProductBox AND set the text
        in Product Name

     */

    /*
       TODO Create A Function that READS the 'Package.txt' & 'Variant.txt' and trim the indexes to add the
        package details and variant details

         Description includes:
         1. Package Code
         2. Package Name
         3. Variant Code //not sure
         4. Variant Name

         Ex. Package Code: 1223
             Package Name: CellPhone
             Variant Code; 1562
             Variant Name: Xiaomi
     */

    /*
        TODO Create an ActionEventListener for AddBtn that appends the details

        Details Contains:
            1. Product Code
            2. Name
            3. Description
            4. Quantity

     */
}
