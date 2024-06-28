import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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

    JComboBox categoryBox = new JComboBox();
    JComboBox packageBox = new JComboBox();
    JComboBox variantBox = new JComboBox();

    static String[] categList;

    JTextField productCodeField = new JTextField(11);
    JTextField CategoryNameField = new JTextField(20);
    JTextField packageField = new JTextField(20);
    JTextField variantField = new JTextField(20);
    JTextField productNameField = new JTextField(20);
    JTextField priceField = new JTextField(17);

    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back");

    static String[] categoryList;
    static String addCategory = "";

    static File categoryFile = new File("Category.txt");

    productFrame() {

        setTitle("Product Form");
        setSize(700, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        categoryInfo();

        comboItems comboActions = new comboItems();
        categoryBox.addActionListener(comboActions);

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

        categoryBox.setPreferredSize(new Dimension(125, 30));
        packageBox.setPreferredSize(new Dimension(125, 30));
        variantBox.setPreferredSize(new Dimension(125, 30));
        productCodeField.setPreferredSize(new Dimension(125, 30));

        panel2.add(categoryBox);
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
        CategoryNameField.setEditable(false);

        packageField.setPreferredSize(new Dimension(245, 30));
        packageField.setEditable(false);

        variantField.setPreferredSize(new Dimension(245, 30));
        variantField.setEditable(false);

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

        add(addBtn);
        add(backBtn);


        setResizable(false);
        setVisible(true);



    }

    private static void categoryInfo() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(categoryFile));
            String addCategory2 = "";

            while((addCategory = br.readLine()) != null)
            {
                String[] categoryBox = addCategory.split("\t");
                addCategory2 += categoryBox[0] + " ";

            }

            categList = addCategory2.split(" ");
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public class comboAcations implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == categoryBox){

            }
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




