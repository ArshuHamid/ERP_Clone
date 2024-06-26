package College_ERP;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno){
        this.rollno=rollno;
        setSize(500,600);
        setLocation(400,75);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        JLabel heading= new JLabel("United College of Engineering & Research");
        heading.setBounds(26,10,600,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,21));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel subheading= new JLabel("Result of Examination 2023");
        subheading.setBounds(98,50,600,20);
        subheading.setFont(new Font("Tahoma",Font.BOLD,19));
        subheading.setForeground(Color.red);
        add(subheading);
        
        JLabel lblrollno= new JLabel("Roll Number: "+rollno);
        lblrollno.setBounds(60,100,600,20);
        lblrollno.setFont(new Font("Sherif",Font.PLAIN,18));
        add(lblrollno);
        
        JLabel lblsemester= new JLabel();
        lblsemester.setBounds(60,130,600,20);
        lblsemester.setFont(new Font("Sherif",Font.PLAIN,18));
        add(lblsemester);
        
        JLabel sub1= new JLabel();
        sub1.setBounds(100,200,600,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);
                
        JLabel sub2= new JLabel();
        sub2.setBounds(100,230,600,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3= new JLabel();
        sub3.setBounds(100,260,600,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4= new JLabel();
        sub4.setBounds(100,290,600,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5= new JLabel();
        sub5.setBounds(100,320,600,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);
        
        JLabel sub6= new JLabel();
        sub6.setBounds(100,350,600,20);
        sub6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub6);
        
        try{
            Conn c=new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                sub6.setText(rs1.getString("subject6"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));
                sub6.setText(sub6.getText() + "------------" + rs2.getString("marks6"));
                lblsemester.setText("Semester: " + rs2.getString("semester"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //CancelButtons
        cancel = new JButton("Cancel");
        cancel.setBounds(250,500,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel); 
        
        setVisible(true);
    }
            
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
     }
    
    public static void main(String []args){
      new Marks("");
    }
    
}
