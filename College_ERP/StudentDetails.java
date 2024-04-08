package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;    
    JButton search,print,update,add,cancel;
    
    StudentDetails(){
        setSize(1000,500);
        setLocation(150,100);
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        JLabel heading= new JLabel("Search by Roll Number");
        heading.setBounds(20,20,180,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(210,20,150,20);
        add(crollno);
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        table=new JTable();
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        add=new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
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
        else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        }
        else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
