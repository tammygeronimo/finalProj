
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    JButton changeButton = new JButton("Change:");
    JTextField totalField = new JTextField(10);
    JTextField cashField = new JTextField(10);
    JTextField changeField = new JTextField(10);

    JTextArea textArea = new JTextArea();

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton computeButton = new JButton("compute");
    JButton backButton = new JButton("Back");

    private List<String[]> deliveryData;
    private List<String[]> productData;
    private List<String> orderData = new ArrayList<>();

    private float change=0;
    private float total;

    public orderForm() {
        deliveryData = loadDataFromDelivery("File Handling/Delivery.txt");
        productData = loadDataFromProduct("File Handling/Product.txt");

        setTitle("Order Information");
        setSize(550, 427);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        nameLabel.setBounds(35, 25, 100, 14);nameField.setBounds(145, 22, 350, 20);nameField.setEditable(false);
        add(nameLabel);add(nameField);

        pNameLabel.setBounds(35, 57, 100, 14);cmbProduct.setBounds(145, 53, 149, 22);
        qtyLabel.setBounds(307, 57, 100, 14);qtyField.setBounds(409, 54, 86, 20);qtyField.setEnabled(false);
        add(pNameLabel);add(cmbProduct);add(qtyLabel);add(qtyField);

        qtyOrderLabel.setBounds(35, 90, 100, 14);qtyOrderField.setBounds(145, 87, 149, 20);qtyOrderField.setEditable(false);
        priceLabel.setBounds(307, 90, 100, 14);priceField.setBounds(346, 87, 149, 20);priceField.setEnabled(false);
        add(qtyOrderLabel);add(qtyOrderField);add(priceLabel);add(priceField);

        totalLabel.setBounds(35, 123, 80, 14);totalField.setBounds(113, 120, 65, 20);totalField.setEditable(false);
        cashLabel.setBounds(183, 123, 68, 14);cashField.setBounds(253, 120, 65, 20);cashField.setEditable(false);
        changeButton.setBounds(330, 120, 85, 20);changeField.setBounds(420, 120, 75, 20);changeField.setEditable(false);
        add(totalLabel);add(totalField);add(cashLabel);add(cashField);add(changeButton);add(changeField);

        textArea.setBounds(35, 162, 460, 118);textArea.setEditable(false);
        add(textArea);

        newButton.setBounds(107, 302, 89, 23);addButton.setBounds(330, 302, 89, 23);computeButton.setBounds(107, 340, 89, 23);;backButton.setBounds(330, 340, 89, 23);
        add(newButton);add(addButton);add(computeButton);add(backButton);

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getChange();
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enableNewSupplierSelection();
                populateProductComboBox();
                enableFieldOnNew();

            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addOrder();
                clearOnAdd();

            }
        });

        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeTotal();

            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cmbProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProductName();
            }
        });

        setResizable(false);
        setVisible(true);

    }

    private void enableNewSupplierSelection() {
        cmbProduct.setEnabled(true);
        cmbProduct.removeAllItems();
        if (deliveryData != null) {
            for (String[] entry : deliveryData) {
                cmbProduct.addItem(entry[0]);
            }
        }
        cmbProduct.removeAllItems();
    }

    private void updateProductName() {
        String selectedCode = (String) cmbProduct.getSelectedItem();
        for (String[] del : deliveryData) {
            if (del[3].equals(selectedCode)) {
                qtyField.setText(del[7]);
                for (String[] pro : productData) {
                    if (del[3].equals(pro[7])) {
                        priceField.setText(pro[8]);
                        break;
                    }
                }
                break;
            }
        }
    }

    private void getChange() {
        try {
            float cash = Float.parseFloat(cashField.getText());
            float total = Float.parseFloat(totalField.getText());
            if(total>cash) {
                JOptionPane.showMessageDialog(this, "Kulang bayad mo!!", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                change = cash - total;
                changeField.setText(String.valueOf(change));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You need to Compute the Total amount & put the Cash Tendered first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void computeTotal() {
        try {
            float qtyOrder = Float.parseFloat(qtyOrderField.getText());
            float availableQty = Float.parseFloat(qtyField.getText());
            float price = Float.parseFloat(priceField.getText());
            float cash = Float.parseFloat(cashField.getText());

            if (qtyOrder > availableQty) {
                JOptionPane.showMessageDialog(this, "Ordered quantity exceeds available quantity", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                float total = qtyOrder * price;

                if (cash > total) {
                    totalField.setText(String.valueOf(total));
                    addToSalesFile(total);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Kulang bayad mo!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You need to fill all the Fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateProductComboBox() {
        cmbProduct.removeAllItems();
        if (deliveryData != null) {
            for (String[] entry : deliveryData) {
                cmbProduct.addItem(entry[3]);
            }
        }
    }

    private void addToSalesFile(float total) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("File Handling/Sales.txt", true))) {
            writer.write(total + "");
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to Sales.txt", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private List<String[]> loadDataFromDelivery(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 2) {
                    data.add(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data from " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return data;
    }

    private void addOrder() {
        String productName = (String) cmbProduct.getSelectedItem();
        String price = priceField.getText();
        String quantityOrder = qtyOrderField.getText();

        if (productName != null && !price.isEmpty() && !quantityOrder.isEmpty()) {
            String orderInfo = "Product Name: " + productName + "\tPrice: " + price + "\tQuantity Order: " + quantityOrder;
            orderData.add(orderInfo);
            updateTextArea();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product and enter a valid quantity order", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTextArea() {
        textArea.setText("");
        for (String order : orderData) {
            textArea.append(order + "\n");
        }
    }

    private List<String[]> loadDataFromProduct(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 2) {
                    data.add(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data from " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return data;
    }

    private void clearOnAdd() {
        qtyOrderField.setText("");qtyOrderField.setEditable(false);
        totalField.setText("");
        cashField.setText("");cashField.setEditable(false);
        changeField.setText("");
        nameField.setText("");nameField.setEditable(false);
        cmbProduct.setSelectedItem(null);
        qtyField.setText("");
        priceField.setText("");
    }

    private void enableFieldOnNew() {
        qtyOrderField.setEditable(true);
        cashField.setEditable(true);
        nameField.setEditable(true);
    }


    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new orderForm());
    }

}