package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;    
    JButton search,print,update,add,cancel;
    
    TeacherLeaveDetails(){
        setSize(1000,500);
        setLocation(150,100);
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        JLabel heading= new JLabel("Search by Employee Id");
        heading.setBounds(20,20,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        add(heading);
        
        cempid=new Choice();
        cempid.setBounds(220,20,150,20);
        add(cempid);
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while(rs.next()) {
                cempid.add(rs.getString("empid"));
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        table=new JTable();
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.white);
        add(print);
                      
        cancel=new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacherleave where empid = '"+cempid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
