package College_ERP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    private JLabel imageLabel;
    private Timer timer;
    private int currentImageIndex = 0;

    private ImageIcon[] imageIcons = {
            new ImageIcon(ClassLoader.getSystemResource("icons/college.jpg")),
            new ImageIcon(ClassLoader.getSystemResource("icons/new.jpg")),
            new ImageIcon(ClassLoader.getSystemResource("icons/ucer.jpg")),
            new ImageIcon(ClassLoader.getSystemResource("icons/nurture.jpg"))
            // Add more image icons as needed
    };
    
    Project(){
    setSize(1300,750);
    setBounds(-7,-2,1300,750);
    //Image
    imageLabel = new JLabel();
    imageLabel.setBounds(350, 0, 200, 200);
    
    add(imageLabel);
            // Set up Timer to change images every 2000 milliseconds (2 seconds)
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        timer.start();

    //MenuBar
    JMenuBar mb=new JMenuBar();
    mb.setBackground(Color.blue);
    //information
    JMenu newInformation= new JMenu("New Information");
    newInformation.setForeground(Color.white);
    mb.add(newInformation);
    //info_items
    JMenuItem facultyInfo= new JMenuItem("New Faculty Details");
    facultyInfo.setBackground(Color.white);
    facultyInfo.addActionListener(this);
    newInformation.add(facultyInfo);
    
    JMenuItem studentInfo= new JMenuItem("New Student Details");
    studentInfo.setBackground(Color.white);
    studentInfo.addActionListener(this);
    newInformation.add(studentInfo);
    
    //details
    JMenu details= new JMenu("View Details");
    details.setForeground(Color.white);
    mb.add(details);
    //details_items
    JMenuItem facultydetails= new JMenuItem("Faculty Details");
    facultydetails.setBackground(Color.white);
    facultydetails.addActionListener(this);
    details.add(facultydetails);
    
    JMenuItem studentdetails= new JMenuItem("Student Details");
    studentdetails.setBackground(Color.white);
    studentdetails.addActionListener(this);
    details.add(studentdetails); 
    
    //leave
    JMenu leave= new JMenu("Apply Leave");
    leave.setForeground(Color.white);
    mb.add(leave);
    //leave_items
    JMenuItem facultyleave= new JMenuItem("Faculty Leave");
    facultyleave.setBackground(Color.white);
    facultyleave.addActionListener(this);
    leave.add(facultyleave);
    
    JMenuItem studentleave= new JMenuItem("Student Leave");
    studentleave.setBackground(Color.white);
    studentleave.addActionListener(this);
    leave.add(studentleave);
    
    //leavedetails
    JMenu leavedetails= new JMenu("Leave Status");
    leavedetails.setForeground(Color.white);
    mb.add(leavedetails);
    //leavedetails_items
    JMenuItem facultyleavedetails= new JMenuItem("Faculty Leave Details");
    facultyleavedetails.setBackground(Color.white);
    facultyleavedetails.addActionListener(this);
    leavedetails.add(facultyleavedetails);
    
    JMenuItem studentleavedetails= new JMenuItem("Student Leave Details");
    studentleavedetails.setBackground(Color.white);
    studentleavedetails.addActionListener(this);
    leavedetails.add(studentleavedetails);
    
    //exams
    JMenu exam= new JMenu("Examination");
    exam.setForeground(Color.white);
    mb.add(exam);
    //exams_items
    JMenuItem examdetails= new JMenuItem("Display Marks");
    examdetails.setBackground(Color.white);
    examdetails.addActionListener(this);
    exam.add(examdetails);
    
    JMenuItem addmarks= new JMenuItem("Add Marks");
    addmarks.setBackground(Color.white);
    addmarks.addActionListener(this);
    exam.add(addmarks);
    
    //updateinfo
    JMenu updateinfo= new JMenu("Update Detials");
    updateinfo.setForeground(Color.white);
    mb.add(updateinfo);
    //updateinfo_items
    JMenuItem updatefacultyinfo= new JMenuItem("Update Faculty Details");
    updatefacultyinfo.setBackground(Color.white);
    updatefacultyinfo.addActionListener(this);
    updateinfo.add(updatefacultyinfo);
    
    JMenuItem updatestudentinfo= new JMenuItem("Update Student Details");
    updatestudentinfo.setBackground(Color.white);
    updatestudentinfo.addActionListener(this);
    updateinfo.add(updatestudentinfo);
    
    //fee
    JMenu fee= new JMenu("Fee Status");
    fee.setForeground(Color.white);
    mb.add(fee);
    //fee_items
    JMenuItem feestructure= new JMenuItem("Fee Structure");
    feestructure.setBackground(Color.white);
    feestructure.addActionListener(this);
    fee.add(feestructure);
    
    JMenuItem feeform= new JMenuItem("Fee Portal");
    feeform.addActionListener(this);
    feeform.setBackground(Color.white);
    fee.add(feeform);
    
    //Utility
    JMenu utility= new JMenu("Utility");
    utility.setForeground(Color.white);
    mb.add(utility);
    //utility_items
    JMenuItem notepad= new JMenuItem("Notepad");
    notepad.setBackground(Color.white);
    notepad.addActionListener(this);
    utility.add(notepad);
    
    JMenuItem calci= new JMenuItem("Calculator");
    calci.setBackground(Color.white);
    calci.addActionListener(this);
    utility.add(calci);
    
    JMenuItem aboutus= new JMenuItem("About Us");
    aboutus.setBackground(Color.white);
    aboutus.addActionListener(this);
    utility.add(aboutus);
    
    JMenuItem ex= new JMenuItem("Logout");
    ex.setBackground(Color.RED);
    ex.setForeground(Color.WHITE);
    ex.addActionListener(this);
    utility.add(ex);
    
    
    setJMenuBar(mb);
    setVisible(true);
    }
    
    private void showNextImage() {
    currentImageIndex = (currentImageIndex + 1) % imageIcons.length;

    // Scale the image to fit the JLabel using SCALE_DEFAULT
    ImageIcon currentIcon = imageIcons[currentImageIndex];
    Image scaledImage = currentIcon.getImage().getScaledInstance(1300,700, Image.SCALE_DEFAULT);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    // Set the scaled image as the icon for the JLabel
    imageLabel.setIcon(scaledIcon);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();      
        if(msg.equals("Logout")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){}
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){}
        }
        else if(msg.equals("New Faculty Details")){
            new AddTeacher();
        }
        else if(msg.equals("New Student Details")){
            new AddStudent();
        }
        else if(msg.equals("Faculty Details")){
            new TeacherDetails();
        }
        else if(msg.equals("Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }
        else if(msg.equals("Add Marks")){
            new EnterMarks();
        }
        else if(msg.equals("Display Marks")){
            new ExaminationDetails();
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("About Us")){
            new AboutUs();
        }
        else if(msg.equals("Fee Portal")){
            new StudentFeeForm();
        }
   
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Project();
            }
        });
    }
}