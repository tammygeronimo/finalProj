import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class mainForm extends JFrame {

    public mainForm() {
        setTitle("Home");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        // Menu Bar
        JMenuBar bar = new JMenuBar();
        bar.setOpaque(true);
        bar.setBackground(Color.decode("#31C198"));
        bar.setFont(new Font("Poppins", Font.PLAIN, 13));

        // Menu/SubMenu
        JMenu fileMenu = createColoredMenu("File", Color.decode("#1E1E1F"));
        JMenu prodSubMenu = new JMenu("Product Information");
        JMenu transMenu = createColoredMenu("Transaction", Color.decode("#1E1E1F"));
        JMenu repMenu = createColoredMenu("Report", Color.decode("#1E1E1F"));
        JMenu aboutMenu = createColoredMenu("About", Color.decode("#1E1E1F"));

        // Menu Items
        JMenuItem catItem = new JMenuItem("Category");
        JMenuItem packItem = new JMenuItem("Packaging");
        JMenuItem varItem = new JMenuItem("Variant");
        JMenuItem prodItem = new JMenuItem("Product");
        JMenuItem suppItem = new JMenuItem("Supplier Information");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem delItem = new JMenuItem("Delivery");
        JMenuItem orderItem = new JMenuItem("Order");
        JMenuItem repProdItem = new JMenuItem("Product");
        JMenuItem repSalesItem = new JMenuItem("Sales");
        JMenuItem sysItem = new JMenuItem("System");
        JMenuItem authorsItem = new JMenuItem("Authors");

        prodSubMenu.add(catItem);
        prodSubMenu.add(packItem);
        prodSubMenu.add(varItem);
        prodSubMenu.add(prodItem);

        fileMenu.add(prodSubMenu);
        fileMenu.add(suppItem);
        fileMenu.add(exitItem);

        transMenu.add(delItem);
        transMenu.add(orderItem);

        repMenu.add(repProdItem);
        repMenu.add(repSalesItem);

        aboutMenu.add(sysItem);
        aboutMenu.add(authorsItem);

        bar.add(fileMenu);
        bar.add(transMenu);
        bar.add(repMenu);
        bar.add(aboutMenu);
        setJMenuBar(bar);

        // JTextArea & JScrollPane
        JTextArea textArea = new JTextArea(28, 75);
        JLabel def_label = new JLabel("[ Display reports here via the Report Menu ]");
        def_label.setBounds(255, 220, 300, 15);
        def_label.setFont(new Font("Poppins", Font.ITALIC, 11));
        def_label.setForeground(Color.GRAY);
        textArea.add(def_label);
        textArea.setBackground(Color.decode("#323232"));
        // textArea.setBorder(BorderFactory.createLineBorder(Color.decode("#050505"), 5));
        textArea.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Customize the scrollbar appearance
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new CustomScrollBarUI());

        // Create a panel with BorderLayout to center the scroll pane
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel with FlowLayout to add spacing around the centered panel
        JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));
        outerPanel.add(centerPanel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(outerPanel, BorderLayout.CENTER);

        // ACTION LISTENERS
        catItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new categoryForm();
            }
        });

        packItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new packagingForm();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the confirmation dialog
                int result = JOptionPane.showConfirmDialog(
                        mainForm.this, "Are you sure you want to exit the iTMS?", "Exit?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        prodItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new productFrame();
            }
        });

        delItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deliveryForm();
            }
        });

        varItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new variantForm();
            }
        });

        orderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new orderForm();
            }
        });

        suppItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new supplierForm();
            }
        });

        sysItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new systemClass();
            }
        });

        authorsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new authorClass();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();

        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
        // Simulate some startup work
        try {
            Thread.sleep(3000); // Simulate loading time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.dispose();

        // Start the main application
        SwingUtilities.invokeLater(() -> new mainForm());
    }

    // Custom BasicScrollBarUI to customize scrollbar appearance
    private static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            // Change scrollbar colors here
            thumbColor = new Color(200, 200, 200);
            thumbHighlightColor = new Color(220, 220, 220);
            thumbDarkShadowColor = new Color(150, 150, 150);
            thumbLightShadowColor = new Color(180, 180, 180);
            trackColor = new Color(240, 240, 240);
        }
    }

    private JMenu createColoredMenu(String title, Color bgColor) {
        JMenu menu = new JMenu(title);
        menu.setOpaque(true);
        menu.setBackground(bgColor);
        return menu;
    }
}

@SuppressWarnings("serial")
class SplashScreen extends JWindow {
    public SplashScreen() {
        // Set the size of the splash screen
        setSize(600, 600);

        // Center the splash screen on the screen
        setLocationRelativeTo(null);

        // Create a panel to hold the splash screen contents
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.BLACK);

        // Load the image
        String imagePath = "C:\\Users\\Tamara\\Downloads\\yoga.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        // Add an image or text to the splash screen
        JLabel label = new JLabel("Loading, please wait...", SwingConstants.CENTER);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        content.add(imageLabel, BorderLayout.CENTER);
        content.add(label, BorderLayout.SOUTH);

        // Add the content to the splash screen
        add(content);
    }
}

