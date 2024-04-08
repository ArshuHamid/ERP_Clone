package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{
        
        FeeStructure(){
            setSize(1000,400);
            setLocation(150,100);
            setLayout(null);
            getContentPane().setBackground(Color.black);
            
            JLabel heading= new JLabel("Fee Structure");
            heading.setBounds(375,15,400,30);
            heading.setFont(new Font("Sherif",Font.BOLD,37));
            heading.setForeground(Color.WHITE);
            add(heading);
            
            JTable table=new JTable();
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            JScrollPane jsp=new JScrollPane(table);
            jsp.setBounds(0, 60, 1000, 700);
            add(jsp);
            
            setVisible(true);
            
        }
    
    public static void main(String []args){
        new FeeStructure();
    }
    
}
