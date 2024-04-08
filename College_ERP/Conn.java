package College_ERP;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///college_erp","root","1080");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
