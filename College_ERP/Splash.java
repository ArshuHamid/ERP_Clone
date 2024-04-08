package College_ERP;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front1.jpg"));
        Image i2= i1.getImage().getScaledInstance(1300,750,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        t=new Thread(this);
        t.start();
        setVisible(true);

        int x=1;
        for(int i=2;i<=750; i+=4,x+=1){
        setLocation(807-(i+x/3),360-(i/2));
        setSize(i+3*x-15,i+x-10);
        
        try{
            Thread.sleep(8);
        }
        catch(Exception e) {}
        }
    }
    
    public void run(){
        try{
            Thread.sleep(4000);
            //setVisible(false);
            //Next Frame
            new Login();
            Thread.sleep(60000);
            setVisible(false);
        }
        catch(Exception e){
        }
    }
    
    public static void main(String []args){
        Splash splash = new Splash();
    }    
}