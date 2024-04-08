package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit,cancel;
    JTable table;
    
    ExaminationDetails(){
        setSize(1000,475);
        setLocation(150,150);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        JLabel heading= new JLabel("Semester Result");
        heading.setBounds(350,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        add(heading);
        
        JLabel heading1= new JLabel("Search by Roll No");
        heading1.setBounds(70,80,180,50);
        heading1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading1);
        
        search=new JTextField();
        search.setBounds(250, 90, 200, 30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);
        //SubmitButtons
        submit = new JButton("Result");
        submit.setBounds(515,90,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        //CancelButtons
        cancel = new JButton("Back");
        cancel.setBounds(670,90,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel); 
        
        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
         });
        
        
        
        
        setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
            new Marks(search.getText());            
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String []args){
        new ExaminationDetails();
        
    }
}
