package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField  tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelrollno;      
    JButton submit,cancel;
    Choice crollno;
    
    UpdateStudent(){
        getContentPane().setBackground(Color.CYAN);
        setSize(850,600);
        setLocation(200,15);
        setLayout(null);
        JLabel heading= new JLabel("Update Student Details");
        heading.setBounds(150,10,700,50);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,45));
        add(heading);
        
        JLabel lblrollnumber= new JLabel("Select Roll Number");
        lblrollnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblrollnumber.setBounds(50,100,200,25);
        add(lblrollnumber);
        
        crollno=new Choice();
        crollno.setBounds(250,100,200,20);
        add(crollno);
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
                crollno.setFont(new Font("Tahoma",Font.PLAIN,18));
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Name
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblname);
        
        JLabel labelname= new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelname);
        //Father's Name
        JLabel lblfname= new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblfname);
        
        JLabel labelfname= new JLabel();
        labelfname.setBounds(615,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelfname);
        //Roll no
        JLabel lblrollno= new JLabel("Roll No.");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblrollno);
        
        labelrollno= new JLabel();
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelrollno);
        //DOB
        JLabel lbldob= new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lbldob);
                
        JLabel labeldob=new JLabel();
        labeldob.setBounds(615,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labeldob);
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
        lblphone.setFont(new Font("Tahoma",Font.BOLD,22));
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
        
        JLabel labelx= new JLabel();        
        labelx.setBounds(615,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelx);
        //Aadhar
        JLabel lblaadhar= new JLabel("Aadhar No.");
        lblaadhar.setBounds(50,350,200,30);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblaadhar);
        
        JLabel labelaadhar= new JLabel();
        labelaadhar.setBounds(200,350,200,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(labelaadhar);
        //12th
        JLabel lblxii= new JLabel("Class XII");
        lblxii.setBounds(400,350,200,30);
        lblxii.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblxii);
        
        JLabel labelxii= new JLabel();        
        labelxii.setBounds(615,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(labelxii);
        //Course
        JLabel lblcourse= new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblcourse);
        
        tfcourse=new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);
        //Coursebranch
        JLabel lblbranch= new JLabel("Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,25));
        add(lblbranch);
        
        tfbranch=new JTextField();
        tfbranch.setBounds(615, 400, 150, 30);
        add(tfbranch);           
        
        try{
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        //LoginButtons
        submit = new JButton("Update");
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
        String rollno=labelrollno.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String course=tfcourse.getText();
        String branch=tfbranch.getText();
        
        try{
            String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', branch='"+branch+"' where rollno='"+rollno+"'";
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
        new UpdateStudent();
    }
}
