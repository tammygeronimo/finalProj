import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class systemClass extends JFrame {
    JLabel sysHead = new JLabel("About the System.");
    JLabel sysSubHead = new JLabel("Why use iTMS?");
    JPanel divider = new JPanel();

    public systemClass() {
        setTitle("System Information");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.decode("#EAE5DF"));
        sysHead.setHorizontalAlignment(SwingConstants.RIGHT);

        sysHead.setBounds(467, 10, 489, 93);
        sysHead.setFont(new Font("Segoe UI", Font.BOLD, 55));
        sysHead.setForeground(Color.decode("#1C1F20"));
        getContentPane().add(sysHead);

        sysSubHead.setBounds(30, 113, 215, 35);
        sysSubHead.setFont(new Font("Segoe UI", Font.BOLD, 30));
        sysSubHead.setForeground(Color.decode("#450202"));
        getContentPane().add(sysSubHead);

        divider.setBounds(467, 101, 489, 2);
        divider.setBackground(Color.LIGHT_GRAY);
        add(divider);

        JLabel lblNewLabel = new JLabel("<html>The Java-based Inventory and Transaction Management System (iTMS), designed to streamline business operations, is a comprehensive solution that seamlessly integrates product management, supplier coordination, and transaction processing, ensuring unparalleled efficiency and accuracy all in one application. With the iTMS, one can effortlessly manage product categories, packages, and variants, all stored securely in dedicated text files. Streamline supplier interactions by maintaining detailed supplier information and tracking deliveries with ease. The intuitive interface allows for smooth order management, automatically calculating total order amounts and facilitating cash transactions. <br></br><br>Generate insightful reports on product details and sales to make informed business decisions. The system also includes an [About] section, offering transparency with information about the system and its developers. Elevate your business with the iTMS – where innovation meets simplicity.</br></html>");
        lblNewLabel.setLabelFor(this);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        lblNewLabel.setBounds(30, 148, 529, 393);
        getContentPane().add(lblNewLabel);

        setResizable(false);
        setVisible(true);
    }
}
