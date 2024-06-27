import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

// toDos are on end of class

@SuppressWarnings("serial")
class deliveryForm extends JFrame {

    // components
    JLabel delHead = new JLabel("Delivery Form");
    JLabel sCodeLabel = new JLabel("Supplier Code:");
    JLabel sNameLabel = new JLabel("Supplier Name:");
    JLabel pCodeLabel = new JLabel("Product Code:");
    JLabel pNameLabel = new JLabel("Product Name:");
    JLabel prodLabel = new JLabel("Product");
    JLabel descLabel = new JLabel("Description:");
    JLabel quantityLabel = new JLabel("Quantity");
    JLabel delLabel = new JLabel("Delivered:");
    JLabel disLabel = new JLabel("Display");

    JComboBox cmbSupplier = new JComboBox();
    JComboBox cmbProduct = new JComboBox();

    JTextField sNameField = new JTextField();
    JTextField pNameField = new JTextField();
    JTextField prodDescField = new JTextField();
    JTextField quantityField = new JTextField();
    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public deliveryForm() {
        setTitle("Delivery");
        setSize(565,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Window Icon
        String imagePath = "media/tempcon.jpg";
        try {
            ImageIcon logoIcon = new ImageIcon(imagePath);
            Image logoImage = logoIcon.getImage();
            setIconImage(logoImage);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        delHead.setBounds(185, 20, 500, 25);
        delHead.setFont(new Font("Poppins", Font.BOLD, 25));
        add(delHead);

        sCodeLabel.setBounds(28, 70, 100, 25);
        sCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sCodeLabel.setForeground(Color.decode("#31C198"));
        cmbSupplier.setBounds(130, 70, 137, 25);
        add(sCodeLabel); add(cmbSupplier);

        sNameLabel.setBounds(280, 70, 100, 25);
        sNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sNameLabel.setForeground(Color.decode("#31C198"));
        sNameField.setBounds(383, 70, 137, 25);
        sNameField.setEnabled(false);
        add(sNameLabel); add(sNameField);

        pCodeLabel.setBounds(28, 110, 100, 25);
        pCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pCodeLabel.setForeground(Color.decode("#31C198"));
        cmbProduct.setBounds(130, 110, 137, 25);
        add(pCodeLabel); add(cmbProduct);

        pNameLabel.setBounds(280, 110, 97, 25);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        pNameField.setBounds(383, 110, 137, 25);
        pNameField.setEnabled(false);
        add(pNameLabel); add(pNameField);

        prodLabel.setBounds(28, 150, 86, 25);
        prodLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        prodLabel.setForeground(Color.decode("#31C198"));
        descLabel.setBounds(28, 165, 87, 25);
        descLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        descLabel.setForeground(Color.decode("#31C198"));
        prodDescField.setBounds(130, 150, 137, 60);
        prodDescField.setEnabled(false);
        // prodDescField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(prodLabel); add(descLabel); add(prodDescField);

        quantityLabel.setBounds(280, 150, 97, 25);
        quantityLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        quantityLabel.setForeground(Color.decode("#31C198"));
        delLabel.setBounds(280,165,97,25);
        delLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        delLabel.setForeground(Color.decode("#31C198"));
        quantityField.setBounds(383, 150, 86, 25);
        add(quantityLabel); add(delLabel); add(quantityField);

        disLabel.setBounds(28,215,488,33);
        disLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        disLabel.setForeground(Color.decode("#31C198"));
        textArea.setBounds(28, 243, 488, 70);
        textArea.setEnabled(false);
        //textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(disLabel); add(textArea);

        newButton.setBounds(45, 335, 89, 25);
        newButton.setBackground(Color.decode("#31C198"));
        newButton.setForeground(Color.decode("#1E1E1F"));
        newButton.setFont(new Font("Poppins", Font.BOLD,12));
        addButton.setBounds(224, 335, 89, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(413, 335, 89, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(newButton); add(addButton); add(backButton);

        // ACTION LISTENERS
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO add functionality
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO add functionality
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
