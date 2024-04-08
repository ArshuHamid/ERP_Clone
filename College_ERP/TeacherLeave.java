package College_ERP;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class TeacherLeave extends JFrame implements ActionListener{
    
    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    TeacherLeave(){
        setSize(350,450);
        setLocation(400,100);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        JLabel heading= new JLabel("Teacher Leave");
        heading.setBounds(60,30,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lblempid= new JLabel("Search by Employee Id");
        lblempid.setBounds(60,100,220,20);
        lblempid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblempid);
        
        cempid=new Choice();
        cempid.setBounds(60,130,200,20);
        add(cempid);
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cempid.add(rs.getString("empid"));
                cempid.setFont(new Font("Tahoma",Font.PLAIN,16));
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate= new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldate); 
        
        dcdate=new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        JLabel lbltime= new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);
        
        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        ctime.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(ctime);
        
        //SubmitButtons
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        //CancelButtons
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);   
    
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String empid=cempid.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            
            String query="insert into teacherleave values('"+empid+"','"+date+"','"+duration+"')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Successful!");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String []args){
        new TeacherLeave();
    }
}
