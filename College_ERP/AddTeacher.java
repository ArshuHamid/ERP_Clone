package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField  tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbeducation,cbdepartment;
    JButton submit,cancel;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    
    AddTeacher(){
        getContentPane().setBackground(Color.CYAN);
        setSize(850,600);
        setLocation(200,15);
        setLayout(null); 
        JLabel heading= new JLabel("New Teacher Details");
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
        JLabel lblempid= new JLabel("Employee Id");
        lblempid.setBounds(50,200,200,30);
        lblempid.setFont(new Font("Tahoma",Font.BOLD,22));
        add(lblempid);
        
        labelempid= new JLabel("1000"+first4);
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("Tahoma",Font.BOLD,25));
        add(labelempid);
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
        JLabel lbleducation= new JLabel("Qualification");
        lbleducation.setBounds(50,400,200,30);
        lbleducation.setFont(new Font("Tahoma",Font.BOLD,22));
        add(lbleducation);
        
        String education[]={"B.Tech","M.Tech","B.Sc","M.Sc","BBA","MBA","B.Com","M.Com","BA","MA"};
        cbeducation=new JComboBox(education);
        cbeducation.setBounds(200, 400, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);
        //Department
        JLabel lbldepartment= new JLabel("Department");
        lbldepartment.setBounds(400,400,200,30);
        lbldepartment.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lbldepartment);
        
        String department[]={"Computer Science","IT","AI/ML","Mechanical Engg.","Civil Engg.","Electronics Engg.","Electrical Engg."};
        cbdepartment=new JComboBox(department);
        cbdepartment.setBounds(615, 400, 150, 30);
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);            
        //SubmitButtons
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
        String empid=labelempid.getText();
        String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String x=tfx.getText();
        String xii=tfxii.getText();
        String aadhar=tfaadhar.getText();
        String education=(String)cbeducation.getSelectedItem();
        String department=(String)cbdepartment.getSelectedItem();
        
        try{
            String query="insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+education+"','"+department+"')";
            
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
        new AddTeacher();
    }
}
