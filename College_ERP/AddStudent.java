package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField  tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    
    AddStudent(){
        getContentPane().setBackground(Color.CYAN);
        setSize(850,600);
        setLocation(200,15);
        setLayout(null);
        JLabel heading= new JLabel("New Student Details");
        heading.setBounds(200,30,500,50);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,45));
        add(heading);
        //Name
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblname);
        
        tfname= new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        //Father's Name
        JLabel lblfname= new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblfname);
        
        tffname= new JTextField();
        tffname.setBounds(615,150,150,30);
        add(tffname);
        //Roll no
        JLabel lblrollno= new JLabel("Roll No.");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblrollno);
        
        labelrollno= new JLabel("6121"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("Tahoma",Font.BOLD,25));
        add(labelrollno);
        //DOB
        JLabel lbldob= new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lbldob);
                
        dcdob=new JDateChooser();
        dcdob.setBounds(615,200,150,30);
        add(dcdob);
        //Address
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lbladdress);
        
        tfaddress= new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        //Phone
        JLabel lblphone= new JLabel("Mobile No.");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblphone);
        
        tfphone= new JTextField();
        tfphone.setBounds(615,250,150,30);
        add(tfphone);
        //Email
        JLabel lblemail= new JLabel("Email ID");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        //10th
        JLabel lblx= new JLabel("Class X");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblx);
        
        tfx= new JTextField();        
        tfx.setBounds(615,300,150,30);
        add(tfx);
        //Aadhar
        JLabel lblaadhar= new JLabel("Aadhar No.");
        lblaadhar.setBounds(50,350,200,30);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblaadhar);
        
        tfaadhar= new JTextField();
        tfaadhar.setBounds(200,350,150,30);
        add(tfaadhar);
        //12th
        JLabel lblxii= new JLabel("Class XII");
        lblxii.setBounds(400,350,200,30);
        lblxii.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblxii);
        
        tfxii= new JTextField();        
        tfxii.setBounds(615,350,150,30);
        add(tfxii);
        //Course
        JLabel lblcourse= new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblcourse);
        
        String course[]={"B.Tech","M.Tech","B.Sc","M.Sc","BBA","MBA","B.Com","M.Com","BA","MA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        //Coursebranch
        JLabel lblbranch= new JLabel("Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblbranch);
        
        String branch[]={"Computer Science","IT","AI/ML","Mechanical Engg.","Civil Engg.","Electronics Engg.","Electrical Engg."};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(615, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);            
        //LoginButtons
        submit = new JButton("Submit");
        submit.setBounds(230,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        //CancelButtons
        cancel = new JButton("Cancel");
        cancel.setBounds(540,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);   
    
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        String name=tfname.getText();
        String fname=tffname.getText();
        String rollno=labelrollno.getText();
        String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String x=tfx.getText();
        String xii=tfxii.getText();
        String aadhar=tfaadhar.getText();
        String course=(String)cbcourse.getSelectedItem();
        String branch=(String)cbbranch.getSelectedItem();
        
        try{
            String query="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
            
            Conn con=new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details updated successfully!");
            setVisible(false);
        }   
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else{
        setVisible(false);
    }
    
    }
    
    public static void main(String []args){
        new AddStudent();
    }
}
