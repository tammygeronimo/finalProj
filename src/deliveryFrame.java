
import javax.swing.*;
import java.awt.*;

public class deliveryFrame extends JFrame{

    JLabel supplierCodeLabel = new JLabel("Supplier Code: ");
    JLabel productCodeLabel = new JLabel("Product Code: ");
    JLabel productDescLabel = new JLabel("Product Descriptions: ");
    JLabel supplierNameLabel = new JLabel("Supplier Name: ");
    JLabel productNameLabel = new JLabel("Product Name: ");
    JLabel quantityDelLabel = new JLabel("Quantity Delivered");

    JComboBox supplierBox = new JComboBox();
    JComboBox productCodeBox = new JComboBox();

    JTextField descriptionField = new JTextField(10);
    JTextField supplierField = new JTextField(10);
    JTextField productField = new JTextField(10);
    JTextField quantityField = new JTextField(10);

    JTextArea detailsArea = new JTextArea(10, 10);

    deliveryFrame(){
        setTitle("Delivery Form");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setLayout(null);


        supplierCodeLabel.setBounds(20, 20, 100, 50);
        productCodeLabel.setBounds(20, 80, 100, 50);
        productDescLabel.setBounds(20, 140, 120, 50);

        supplierBox.setBounds(120, 27, 150, 35);
        productCodeBox.setBounds(120, 87, 150, 35 );

        descriptionField.setBounds(145, 147, 200, 75);


        supplierNameLabel.setBounds(275, 20, 100, 50);



        add(supplierCodeLabel);
        add(productCodeLabel);
        add(productDescLabel);

        add(supplierBox);
        add(productCodeBox);
        add(descriptionField);

        add(supplierNameLabel);

        setVisible(true);
        setResizable(false);
    }
}
