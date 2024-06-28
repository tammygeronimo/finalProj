import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

//Changes Update 8:29


public class productFrame extends JFrame{

    JLabel categoryLabel = new JLabel("Category Code: ");
    JLabel packageLabel = new JLabel("Package Code: ");
    JLabel variantLabel = new JLabel("Variant Code: ");
    JLabel productCodeLabel = new JLabel("Product Code: ");
    JLabel priceLabel = new JLabel("Price: ");
    JLabel categoryNameLabel = new JLabel("Category Name: ");
    JLabel packageNameLabel = new JLabel("Package Name: ");
    JLabel variantNameLabel = new JLabel("Variant Name: ");
    JLabel productNameLabel = new JLabel("Product Name: ");

    private static String[] categList;
    static JComboBox<String> categoryComboBox;
    static JComboBox<String> packageBox;
    static JComboBox<String> variantBox;

    private static ArrayList<String> categoryCodes = new ArrayList<>();
    private static ArrayList<String> categoryNames = new ArrayList<>();
    private static ArrayList<String> packageCodes = new ArrayList<>();
    private static ArrayList<String> packageNames = new ArrayList<>();
    private static ArrayList<String> variantCodes = new ArrayList<>();
    private static ArrayList<String> variantNames = new ArrayList<>();

    JTextField productCodeField = new JTextField(11);
    JTextField CategoryNameField = new JTextField(20);
    JTextField packageField = new JTextField(20);
    JTextField variantField = new JTextField(20);
    JTextField productNameField = new JTextField(20);
    JTextField priceField = new JTextField(17);

    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back");

    static File categoryFile = new File("File Handling/Category.txt");
    static File packageFile = new File("File Handling/Package.txt");
    static File variantFile = new File("File Handling/Variant.txt");

    static String infoWrite;
    static String categoryInfo, packageInfo, variantInfo, productCode, productName;
    static String productPrice;

    productFrame() {

        setTitle("Product Form");
        setSize(700, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        categoryComboBox = new JComboBox<>();
        packageBox = new JComboBox<>();
        variantBox = new JComboBox<>();

        infoLoads();

        JPanel head = new JPanel();
        head.setPreferredSize(new Dimension(700, 35));

        JLabel titleHead = new JLabel("Product Form");
        titleHead.setFont(new Font("Verdana", Font.BOLD, 25));
        head.add(titleHead);
        add(head);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 33));
        panel1.setPreferredSize(new Dimension(120, 240));

        panel1.add(categoryLabel);
        panel1.add(packageLabel);
        panel1.add(variantLabel);
        panel1.add(productCodeLabel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 21));
        panel2.setPreferredSize(new Dimension(135, 240));

        comboActions infoBox = new comboActions();
        categoryComboBox.addActionListener(infoBox);
        packageBox.addActionListener(infoBox);
        variantBox.addActionListener(infoBox);

        categoryComboBox.setPreferredSize(new Dimension(125, 30));
        packageBox.setPreferredSize(new Dimension(125, 30));
        variantBox.setPreferredSize(new Dimension(125, 30));
        productCodeField.setPreferredSize(new Dimension(125, 30));

        panel2.add(categoryComboBox);
        panel2.add(packageBox);
        panel2.add(variantBox);
        panel2.add(productCodeField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 33));
        panel3.setPreferredSize(new Dimension(105, 240));

        panel3.add(categoryNameLabel);
        panel3.add(packageNameLabel);
        panel3.add(variantNameLabel);
        panel3.add(productNameLabel);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 21));
        panel4.setPreferredSize(new Dimension(250, 240));

        CategoryNameField.setPreferredSize(new Dimension(245, 30));
        CategoryNameField.setEditable(false); CategoryNameField.setEnabled(false);

        packageField.setPreferredSize(new Dimension(245, 30));
        packageField.setEditable(false); packageField.setEnabled(false);

        variantField.setPreferredSize(new Dimension(245, 30));
        variantField.setEditable(false); variantField.setEnabled(false);

        productNameField.setPreferredSize(new Dimension(245, 30));

        panel4.add(CategoryNameField);
        panel4.add(packageField);
        panel4.add(variantField);
        panel4.add(productNameField);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        add(priceLabel); // TODO wag natin pantay sa buttons
        add(priceField); // TODO wag natin pantay sa buttons

        buttonActions btnFunction = new buttonActions();
        addBtn.addActionListener(btnFunction);
        backBtn.addActionListener(btnFunction);

        add(addBtn);
        add(backBtn);

        setResizable(false);
        setVisible(true);

    }

    public class buttonActions extends Component implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == addBtn){

                String catCode = (String) categoryComboBox.getSelectedItem();
                String pBox = (String) packageBox.getSelectedItem();
                String vBox = (String) variantBox.getSelectedItem();

                productName = productNameField.getText();
                productCode = productCodeField.getText();
                productPrice = priceField.getText();

                if (productName.isEmpty() || productCode.isEmpty() || productPrice.isEmpty() || catCode.isEmpty()
                        || pBox.isEmpty() || vBox.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }



                infoWrite = categoryInfo + "\t" + packageInfo + "\t" + variantInfo + "\t" + productCode + "\t" + productName + "\t" + productPrice;
                //infoWrite = "\t" + productCode + "\t" + productName + "\t" + productPrice;

                System.out.println(infoWrite);


                JOptionPane.showMessageDialog(null,  "Product successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("File Handling/Product.txt", true))) {
                    writer.write(infoWrite);
                    writer.newLine();

                } catch (IOException ae) {
                    ae.printStackTrace();
                }

                categoryComboBox.setSelectedIndex(0);
                CategoryNameField.setText("");
                packageBox.setSelectedIndex(0);
                packageField.setText("");
                variantBox.setSelectedIndex(0);
                variantField.setText("");
                productCodeField.setText("");
                productNameField.setText("");
                priceField.setText("");



            } else {
                dispose();

            }

        }
    }

    public class comboActions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == categoryComboBox){
                int categoryIndex = categoryComboBox.getSelectedIndex();

                if(categoryIndex != -1){

                    String catCode = (String) categoryComboBox.getSelectedItem();
                    String catName = categoryNames.get(categoryIndex);
                    CategoryNameField.setText(catName);

                    categoryInfo = catCode + "\t" + catName;

                }

            } else if (e.getSource() == packageBox) {
                int packageIndex = packageBox.getSelectedIndex();

                if (packageIndex != -1) {

                    String packCode = (String) packageBox.getSelectedItem();
                    String packName = packageNames.get(packageIndex);
                    packageField.setText(packName);

                    packageInfo = packCode + "\t" + packName;
                }

            } else if (e.getSource() == variantBox) {
                int variantIndex = variantBox.getSelectedIndex();

                if(variantIndex != -1){

                    String varCode = (String) variantBox.getSelectedItem();
                    String varName = variantNames.get(variantIndex);
                    variantField.setText(varName);

                    variantInfo = varCode + "\t" + varName;
                }
            }

        }
    }

    public static void infoLoads() {
        try(BufferedReader br = new BufferedReader(new FileReader(categoryFile))){
            String line;
            while((line = br.readLine()) != null) {
                String[] categoryBox = line.split("\t");

                if (categoryBox.length >= 2) {
                    String CategoryCode = categoryBox[0];
                    String CategoryName = categoryBox[1];

                    categoryCodes.add(CategoryCode);
                    categoryNames.add(CategoryName);
                    categoryComboBox.addItem(CategoryCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader((new FileReader(packageFile)))){
            String line;
            while ((line = br.readLine()) != null){
                String[] packBox = line.split("\t");

                if (packBox.length >= 2){
                    String packCode = packBox[0];
                    String packName = packBox[1];

                    packageCodes.add(packCode);
                    packageNames.add(packName);
                    packageBox.addItem(packCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }


        try(BufferedReader br = new BufferedReader(new FileReader(variantFile))){
            String line;
            while ((line = br.readLine()) != null){
                String[] varBox = line.split("\t");

                if (varBox.length >= 2){

                    String varCode = varBox[0];
                    String varName = varBox[1];

                    variantCodes.add(varCode);
                    variantNames.add(varName);
                    variantBox.addItem(varCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //TODO Create A Function that Read the 'Package.txt' for and setText the Package Name
    //TODO Create A Function that Read the 'Package.txt' and added and trim the items to JComboBox [Product Code]

    //TODO Create A Function that Read the 'Category.txt' for and setText the Category Name
    //TODO Create A Function that Read the 'Category.txt' and added and trim the items to JComboBox [Category Code]

    //TODO Create A Function that Read the 'Variant.txt' for and setText the Variant Name
    //TODO Create A Function that Read the 'Variant.txt' and added and trim the items to JComboBox [Variant Code]

    //TODO Create A Function that Write Information in 'Product.txt' for and setText the Product Code & Name
    // when clicked


}




