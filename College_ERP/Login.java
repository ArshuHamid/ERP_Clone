package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfusername,tfpassword;
    
    Login(){
    getContentPane().setBackground(Color.CYAN);
    setLayout(null);
    //Image
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/icon16.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
    //Username
    JLabel lblusername= new JLabel("Username:");
    lblusername.setBounds(40,30,100,20);
    add(lblusername);
    tfusername= new JTextField();
    tfusername.setBounds(150, 30, 150, 20);
    add(tfusername);
    //Password
    JLabel lblpassword= new JLabel("Password:");
    lblpassword.setBounds(40,90,100,20);
    add(lblpassword);
    tfpassword= new JPasswordField();
    tfpassword.setBounds(150,90,150,20);
    add(tfpassword);
    setSize(600,275);
    setLocation(350,175);
    //LoginButtons
    login = new JButton("Login");
    login.setBounds(40, 160, 120, 30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    login.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(login);
    //CancelButtons
    cancel = new JButton("Cancel");
    cancel.setBounds(180, 160, 120, 30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(cancel);   
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    //setVisible(false);
                }
                c.s.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String []args){
        new Login();
    }
}
