
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatLightLaf;

class orderForm extends JFrame{
    JLabel nameLabel = new JLabel("Customer Name:");
    JTextField nameField = new JTextField(10);

    JLabel pNameLabel = new JLabel("Product Name:");
    JLabel qtyLabel = new JLabel("Available Quantity:");
    JComboBox cmbProduct = new JComboBox();
    JTextField qtyField = new JTextField(10);

    JLabel qtyOrderLabel = new JLabel("Quantity Order:");
    JLabel priceLabel = new JLabel("Price:");
    JTextField qtyOrderField = new JTextField(10);
    JTextField priceField = new JTextField(10);

    JLabel totalLabel = new JLabel("Total Amount:");
    JLabel cashLabel = new JLabel("Cash Tender:");
    JLabel changeLabel = new JLabel("Change:");
    JTextField totalField = new JTextField(10);
    JTextField cashField = new JTextField(10);
    JTextField changeField = new JTextField(10);

    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton computeButton = new JButton("compute");
    JButton backButton = new JButton("Back");

    public orderForm() {
        setTitle("Delivery Information");
        setSize(600, 427);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        nameLabel.setBounds(35, 25, 100, 14);nameField.setBounds(145, 22, 362, 20);
        add(nameLabel);add(nameField);

        pNameLabel.setBounds(35, 57, 100, 14);cmbProduct.setBounds(145, 53, 149, 22);
        qtyLabel.setBounds(307, 57, 100, 14);qtyField.setBounds(414, 54, 93, 20);qtyField.setEnabled(false);
        add(pNameLabel);add(cmbProduct);add(qtyLabel);add(qtyField);

        qtyOrderLabel.setBounds(35, 90, 100, 14);qtyOrderField.setBounds(145, 87, 149, 20);
        priceLabel.setBounds(307, 90, 100, 14);priceField.setBounds(346, 87, 160, 20);priceField.setEnabled(false);
        add(qtyOrderLabel);add(qtyOrderField);add(priceLabel);add(priceField);

        totalLabel.setBounds(35, 123, 75, 14);totalField.setBounds(145, 120, 75, 20);totalField.setEditable(false);
        cashLabel.setBounds(225, 123, 68, 14);cashField.setBounds(297, 120, 75, 20);
        changeLabel.setBounds(378, 123, 46, 14);changeField.setBounds(430, 120, 75, 20);changeField.setEditable(false);
        add(totalLabel);add(totalField);add(cashLabel);add(cashField);add(changeLabel);add(changeField);

        textArea.setBounds(35, 162, 470, 118);
        add(textArea);

        newButton.setBounds(107, 302, 89, 23);addButton.setBounds(330, 302, 89, 23);computeButton.setBounds(107, 340, 89, 23);;backButton.setBounds(330, 340, 89, 23);
        add(newButton);add(addButton);add(computeButton);add(backButton);

        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new orderForm());
    }

}
