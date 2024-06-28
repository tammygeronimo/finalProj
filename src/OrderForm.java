import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

// TODO add functionality to actionlisteners

class orderForm extends JFrame{
    // components
    JLabel orderHead = new JLabel("Order Form");
    JLabel nameLabel = new JLabel("Customer Name:");
    JLabel pNameLabel = new JLabel("Product Name:");
    JLabel qtyLabel = new JLabel("Available Quantity:");
    JLabel qtyOrderLabel = new JLabel("Quantity Order:");
    JLabel priceLabel = new JLabel("Price:");
    JLabel totalLabel = new JLabel("Total Amount:");
    JLabel cashLabel = new JLabel("Cash Tender:");
    JLabel changeLabel = new JLabel("Change:");
    JLabel disLabel = new JLabel("Display");

    JTextField nameField = new JTextField(10);
    JTextField qtyOrderField = new JTextField(10);
    JTextField priceField = new JTextField(10);
    JTextField totalField = new JTextField(10);
    JTextField cashField = new JTextField(10);
    JTextField changeField = new JTextField(10);

    private static String[] prodList;
    static JComboBox<String> cmbProduct;

    JTextField qtyField = new JTextField(10);
    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton computeButton = new JButton("Compute");
    JButton backButton = new JButton("Back");

    public orderForm() {
        setTitle("Order");
        setSize(550, 480);
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

        cmbProduct = new JComboBox<>();

        orderHead.setBounds(190, 20, 500, 25);
        orderHead.setFont(new Font("Poppins", Font.BOLD, 25));
        add(orderHead);

        nameLabel.setBounds(35, 60, 110, 25);
        nameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        nameLabel.setForeground(Color.decode("#31C198"));
        nameField.setBounds(150, 60, 345, 25);
        add(nameLabel); add(nameField);

        pNameLabel.setBounds(35, 92, 100, 25);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        cmbProduct.setBounds(150, 92, 149, 25);
        add(pNameLabel); add(cmbProduct);

        qtyLabel.setBounds(307, 92, 130, 25);
        qtyLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        qtyLabel.setForeground(Color.decode("#31C198"));
        qtyField.setBounds(435, 92, 60, 25);
        qtyField.setEnabled(false);
        add(qtyLabel); add(qtyField);

        qtyOrderLabel.setBounds(35, 125, 100, 25);
        qtyOrderLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        qtyOrderLabel.setForeground(Color.decode("#31C198"));
        qtyOrderField.setBounds(150, 125, 149, 25);
        add(qtyOrderLabel);add(qtyOrderField);

        priceLabel.setBounds(307, 125, 100, 25);
        priceLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        priceLabel.setForeground(Color.decode("#31C198"));
        priceField.setBounds(346, 125, 149, 25);
        priceField.setEnabled(false);
        add(priceLabel); add(priceField);

        totalLabel.setBounds(35, 158, 90, 25);
        totalLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        totalLabel.setForeground(Color.decode("#31C198"));
        totalField.setBounds(130, 158, 65, 25);
        totalField.setEditable(false);
        add(totalLabel); add(totalField);

        cashLabel.setBounds(205, 158, 85, 25);
        cashLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cashLabel.setForeground(Color.decode("#31C198"));
        cashField.setBounds(295, 158, 65, 25);
        add(cashLabel); add(cashField);

        changeLabel.setBounds(370, 158, 55, 25);
        changeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        changeLabel.setForeground(Color.decode("#31C198"));
        changeField.setBounds(430, 158, 65, 25);
        changeField.setEditable(false);
        add(changeLabel);add(changeField);

        disLabel.setBounds(35,195,488,33);
        disLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        disLabel.setForeground(Color.decode("#31C198"));
        textArea.setBounds(35, 227, 458, 118);
        textArea.setEnabled(false);
        add(disLabel); add(textArea);

        newButton.setBounds(107, 363, 95, 25);
        newButton.setBackground(Color.decode("#31C198"));
        newButton.setForeground(Color.decode("#1E1E1F"));
        newButton.setFont(new Font("Poppins", Font.BOLD,12));
        addButton.setBounds(330, 363, 95, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        computeButton.setBounds(107, 398, 95, 25);
        computeButton.setBackground(Color.decode("#31C198"));
        computeButton.setForeground(Color.decode("#1E1E1F"));
        computeButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(330, 398, 95, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(newButton); add(addButton); add(computeButton); add(backButton);

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

        computeButton.addActionListener(new ActionListener() {
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
        SwingUtilities.invokeLater(() -> new orderForm());
    }
}
