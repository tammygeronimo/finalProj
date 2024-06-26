import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class systemClass extends JFrame {
    JLabel sysHead = new JLabel("About the System");
    public systemClass () {
        setTitle("System Information");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        sysHead.setBounds(10,20,100,25);
        add(sysHead);



        setResizable(false);
        setVisible(true);
    }
}
