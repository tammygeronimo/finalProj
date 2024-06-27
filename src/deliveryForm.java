import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JTextField prodDescField = new JTextField();
    JTextField quantityField = new JTextField();

    JLabel disLabel = new JLabel("Display");
    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public deliveryForm() {
        setTitle("Delivery Information");
        setSize(565,360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        sCodeLabel.setBounds(28, 30, 100, 14); cmbSupplier.setBounds(130, 26, 137, 22);
        sCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sCodeLabel.setForeground(Color.decode("#31C198"));
        sNameLabel.setBounds(280, 30, 100, 14);
        sNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sNameLabel.setForeground(Color.decode("#31C198"));
        sNameField.setBounds(383, 27, 137, 22); sNameField.setEnabled(false);
        add(sCodeLabel); add(cmbSupplier); add(sNameLabel); add(sNameField);

        pCodeLabel.setBounds(28, 70, 100, 14); cmbProduct.setBounds(130, 66, 137, 22);
        pCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pCodeLabel.setForeground(Color.decode("#31C198"));
        pNameLabel.setBounds(280, 70, 97, 14);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        pNameField.setBounds(383, 67, 137, 22);
        pNameField.setEnabled(false);
        add(pCodeLabel);add(cmbProduct);add(pNameLabel);add(pNameField);

        prodLabel.setBounds(28, 110, 86, 14);
        prodLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        prodLabel.setForeground(Color.decode("#31C198"));
        descLabel.setBounds(28, 125, 87, 14);
        descLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        descLabel.setForeground(Color.decode("#31C198"));
        prodDescField.setBounds(130, 110, 137, 60);
        prodDescField.setEnabled(false); // prodDescField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        quantityLabel.setBounds(280, 110, 97, 14);
        quantityLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        quantityLabel.setForeground(Color.decode("#31C198"));
        delLabel.setBounds(280,125,97,14);
        delLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        delLabel.setForeground(Color.decode("#31C198"));
        quantityField.setBounds(383, 110, 86, 22);
        add(prodLabel);add(descLabel);add(prodDescField); add(quantityLabel); add(delLabel); add(quantityField);

        disLabel.setBounds(28,170,488,33);
        disLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        disLabel.setForeground(Color.decode("#31C198"));
        textArea.setBounds(28, 198, 488, 70);
        textArea.setEnabled(false); //textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(disLabel); add(textArea);

        newButton.setBounds(45, 285, 89, 23);
        newButton.setBackground(Color.decode("#31C198"));
        newButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setBounds(224, 285, 89, 23);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setBounds(413, 285, 89, 23);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        add(newButton);add(addButton);add(backButton);

        // ACTION LISTENERS
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setVisible(true);


    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
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
