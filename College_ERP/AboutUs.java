package College_ERP;
import javax.swing.*;
import java.awt.*;

public class AboutUs extends JFrame {

    AboutUs() {
        setSize(700,450);
        setLocation(400, 150);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 15, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>College<br/>Management<br/>System</html>");
        heading.setBounds(70, 20, 300, 180);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma", Font.BOLD, 45));
        add(heading);
        
        JLabel name = new JLabel("Developed By: Arshu Hamid");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);
        
        JLabel rollno = new JLabel("Roll number: 2103420100030");
        rollno.setBounds(70, 280, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(rollno);
        
        JLabel contact = new JLabel("Contact: arshuhamid3127@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 27));
        add(contact);
        
        setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AboutUs();
    }
}