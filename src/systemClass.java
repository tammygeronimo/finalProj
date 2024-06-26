import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class systemClass extends JFrame {
    JLabel sysHead = new JLabel("About the System.");
    JLabel sysSubHead = new JLabel("What is iTMS?");
    JLabel sysSubHead1 = new JLabel("<html><div style='text-align: right;'>What can iTMS do?</div></html>");
    JPanel divider = new JPanel();

    public systemClass() {
        setTitle("System Information");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#EAE5DF"));

        sysHead.setBounds(200, 0, 800, 95);
        sysHead.setFont(new Font("Segoe UI", Font.BOLD, 70));
        sysHead.setForeground(Color.decode("#1C1F20"));
        add(sysHead);

        divider.setBounds(30, 105, 940, 2);
        divider.setBackground(Color.LIGHT_GRAY);
        add(divider);

        sysSubHead.setBounds(100, 115, 500, 35);
        sysSubHead.setFont(new Font("Segoe UI", Font.BOLD, 30));
        sysSubHead.setForeground(Color.decode("#450202"));
        add(sysSubHead);

        sysSubHead1.setBounds(550, 115, 500, 35);
        sysSubHead1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        sysSubHead1.setForeground(Color.decode("#450202"));
        add(sysSubHead1);

        RoundedTextArea roundedTextArea1 = new RoundedTextArea();
        roundedTextArea1.setText("<html><div style='font-family: Microsoft Sans Serif; font-size: 16px; text-align: justify; color: white;'>" +
                "The Java-based Inventory and Transaction Management System (iTMS), designed to streamline business operations, is a comprehensive solution that seamlessly integrates product management, supplier coordination, and transaction processing, ensuring unparalleled efficiency and accuracy all in one application.<br><br>" +
                "Additional features include:<br>" +
                "- Secure storage of product information<br>" +
                "- Supplier management and coordination<br>" +
                "- Automated transaction processing</div></html>");
        roundedTextArea1.setBounds(30, 160, 400, 370);
        add(roundedTextArea1);

        RoundedTextArea roundedTextArea2 = new RoundedTextArea();
        roundedTextArea2.setText("<html><div style='font-family: Microsoft Sans Serif; font-size: 14.9px; text-align: justify; color: white;'>With the iTMS, one can effortlessly manage product categories, packages, and variants, all stored securely in dedicated text files. Streamline supplier interactions by maintaining detailed supplier information and tracking deliveries with ease. The intuitive interface allows for smooth order management, automatically calculating total order amounts and facilitating cash transactions. <br></br><br>Generate insightful reports on product details and sales to make informed business decisions. The system also includes an [About] section, offering transparency with information about the system and its developers. Elevate your business with the iTMS – where innovation meets simplicity.</br></div></html>");
        roundedTextArea2.setBounds(455, 160, 500, 370);
        add(roundedTextArea2);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new systemClass();
    }

    // Custom JTextPane with rounded corners
    class RoundedTextArea extends JEditorPane {
        private static final int ARC_WIDTH = 20;
        private static final int ARC_HEIGHT = 20;

        public RoundedTextArea() {
            setOpaque(false); // Make it transparent
            setEditable(false);
            setBackground(Color.decode("#450202"));
            setContentType("text/html"); // Set content type to HTML
            setMargin(new Insets(10, 10, 10, 10));
            //setFont(new Font("Segoe UI", Font.PLAIN, 18)); // Set Segoe UI font, size 18
            setEditorKit(new HTMLEditorKit()); // Use HTMLEditorKit for HTML rendering
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT));
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY); // Border color
            g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT));
            g2.dispose();
        }
    }
}
