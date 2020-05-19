package Travel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JOptionPane;

public class TourPackages extends JFrame implements ActionListener,ItemListener{
    JTabbedPane jtp;
    JPanel jp1,jp2,jp3;
    JLabel PN,PC,C,ND,It,image;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JComboBox city1,city2,city3,city11;
    JButton submit,reset,logout,back;
    JButton submit1,reset1,logout1,back1;
    JButton delete,reset2,logout2,back2;
    String uname;
    
 TourPackages(){
        jtp=new JTabbedPane(JTabbedPane.TOP);
        jp1=new JPanel();
        jp1.setBackground(Color.white);
        image = new JLabel();
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        image.setBounds(100, 0, 575, 284);
        jp1.add(image);
        PN=new JLabel("Package Name:");
        PN.setBounds(280,300,150,20);
        jtf1=new JTextField();// package name
        //jtf1.setText("");
        jtf1.setBounds(400,300,100,20);
        PC=new JLabel("Package Code :");
        PC.setBounds(280,340,150,20);
        jtf2=new JTextField();// package code
        //jtf2.setText("");
        jtf2.setBounds(400,340,100,20);
        C=new JLabel("Country             :");
        C.setBounds(280,380,150,20);
        jtf3=new JTextField();// contry
        //jtf3.setText("");
        jtf3.setBounds(400,380,100,20);
        ND=new JLabel("NO. of Days      :");
        ND.setBounds(280,420,150,20);
        jtf4=new JTextField();
       // jtf4.setText("");
        jtf4.setBounds(400,420,100,20);
        It=new JLabel("Itinerary            :");
        It.setBounds(280,460,150,20);
        city1=new JComboBox();
        city1.addItem("Day 1:DubaiMall");
        city1.addItem("Day 2:DisNey World");
        city1.addItem("Day 3:Mount Fuji");
        city1.addItem("Day 4:Taj Mahal");
        city1.addItem("Day 5:Bali");
        city1.addItem("Day 6:Angkor Wat");
        city1.addItem("Day 7:Borobudur");
        city1.setBounds(400,460,100,20);
        submit=new JButton("Submit");
        submit.setBounds(200,570,80,20);
        submit.addActionListener(this);
        reset=new JButton("Reset");
        reset.addActionListener(this);
        reset.setBounds(350,570,80,20);
        logout=new JButton("Logout");
        logout.setBounds(500,570,80,20);
        logout.addActionListener(this);
        back=new JButton("back");
        back.setBounds(650,570,80,20);
        back.addActionListener(this);
        jp1.setLayout(null);
        jp1.add(PN);
        jp1.add(PC);
        jp1.add(C);
        jp1.add(ND);
        jp1.add(It);
        jp1.add(jtf1);
        jp1.add(jtf2);
        jp1.add(jtf3);
        jp1.add(jtf4);
        jp1.add(city1);
        jp1.add(submit);
        jp1.add(reset);
        jp1.add(logout);
        jp1.add(back);
        setVisible(true);
        setSize(800,800);
        add(jp1);
        
        jp2=new JPanel();
        jp2.setBackground(Color.white);
        image = new JLabel();
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        image.setBounds(100, 0, 575, 284);
        jp2.add(image);
        PN=new JLabel("Package Name:");
        PN.setBounds(280,300,150,20);
        city2=new JComboBox();
        getPackage();
        city2.setBounds(400,300,100,20);
        city2.addItemListener(this);
        PC=new JLabel("Package Code :");
        PC.setBounds(280,340,150,20);
        jtf5=new JTextField();
        jtf5.setBounds(400,340,100,20);
        C=new JLabel("Country             :");
        C.setBounds(280,380,150,20);
        jtf6=new JTextField();
        jtf6.setBounds(400,380,100,20);
        ND=new JLabel("NO. of Days      :");
        ND.setBounds(280,420,150,20);
        jtf7=new JTextField();
        jtf7.setBounds(400,420,100,20);
        It=new JLabel("Itinerary            :");
        It.setBounds(280,460,150,20);
        city11=new JComboBox();
        city11.addItem("Day 1:DubaiMall");
        city11.addItem("Day 2:DisNey World");
        city11.addItem("Day 3:Mount Fuji");
        city11.addItem("Day 4:Taj Mahal");
        city11.addItem("Day 5:Bali");
        city11.addItem("Day 6:Angkor Wat");
        city11.addItem("Day 7:Borobudur");
        city11.setBounds(400,460,100,20);
        city11.setBounds(400,460,100,20);
        submit1=new JButton("Update");
        submit1.setBounds(200,570,80,20);
        submit1.addActionListener(this);
        reset1=new JButton("Reset");
        reset1.setBounds(350,570,80,20);
        reset1.addActionListener(this);
        logout1=new JButton("Logout");
        logout1.setBounds(500,570,80,20);
        
        back1=new JButton("back");
        back1.setBounds(650,570,80,20);
        back1.addActionListener(this);
        
        jp2.setLayout(null);
        jp2.add(PN);
        jp2.add(PC);
        jp2.add(C);
        jp2.add(ND);
        jp2.add(It);
        jp2.add(jtf5);
        jp2.add(jtf6);
        jp2.add(jtf7);
        jp2.add(city11);
        jp2.add(city2);
        jp2.add(submit1);
        jp2.add(reset1);
        jp2.add(logout1);
        jp2.add(back1);
        setVisible(true);
        setSize(800,800);
        add(jp2);
        
        jp3=new JPanel();
        jp3.setBackground(Color.white);
        image = new JLabel();
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        image.setBounds(100, 0, 575, 284);
        jp3.add(image);
        PN=new JLabel("Package Name:");
        PN.setBounds(280,300,150,20);
        city3=new JComboBox();
        getPackage1();
        city3.addItemListener(this);
        city3.setBounds(400,300,100,20);
        
        PC=new JLabel("Package Code :");
        PC.setBounds(280,340,150,20);
        jtf8=new JTextField();
        jtf8.setBounds(400,340,140,20);
        delete=new JButton("Delete");
        delete.setBounds(200,450,80,20);
        delete.addActionListener(this);
        reset2=new JButton("Reset");
        reset2.addActionListener(this);
        reset2.setBounds(350,450,80,20);
        logout2=new JButton("Logout");
        logout2.setBounds(500,450,80,20);
        back2=new JButton("back");
        back2.setBounds(650,450,80,20);
        back2.addActionListener(this);
        jp3.setLayout(null);
        jp3.add(PN);
        jp3.add(PC);
        jp3.add(jtf8);
        jp3.add(city3);
        jp3.add(delete);
        jp3.add(reset2);
        jp3.add(logout2);
        jp3.add(back2);
        setVisible(true);
        setSize(500,500);
        add(jp3);
        

        jtp.addTab("Add",jp1);     
        jtp.addTab("Edit",jp2);
        jtp.addTab("Delete",jp3);
        jtp.setSize(800,800);
        
        this.setTitle("");
        this.setVisible(true);
        this.setSize(800,800);
        this.add(jtp);
  
        
    }

    public static void main(String[] args) {
        TourPackages tp=new TourPackages ();
    }  
    
    
    
    
    public void getPackage()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
         
            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
             PreparedStatement pst = conn.prepareStatement("select * from STU");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
                 city2.addItem(rs.getString("packagename"));
                 
             }
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void getPackage1()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
         
            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
             PreparedStatement pst = conn.prepareStatement("select * from STU");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
                 city3.addItem(rs.getString("packagename"));
                 
             }
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    

    
@Override
    public void actionPerformed(ActionEvent e) {
        
     String buttonName = e.getActionCommand();
     
       if(e.getSource()==delete)
       {
       
       String key1 = city3.getSelectedItem().toString();
           
           try
           {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);        
            PreparedStatement org = conn.prepareStatement("delete from stu where packagename=?" );    //SQL     
            org.setString(1,key1);

            int row = org.executeUpdate();
            if(row==1)
            {
                JOptionPane.showMessageDialog(this,"Record delete successful!");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Sorry! Can not delete record");
            }
          
           }
           catch(Exception ex)
           {
               System.out.println(ex);
           }
           
        
       
       
       }
       
        if(e.getSource()==submit1)
        {        
           String PN = city2.getSelectedItem().toString();
            String PC = jtf5.getText();
            String C = jtf6.getText();
            String ND = jtf7.getText();
            String It = city3.getSelectedItem().toString();
   
         try
            {
              Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);            
            PreparedStatement pst = conn.prepareStatement("insert into STU(packagename,packageco,country,days,itinerary) values(?,?,?,?,?)");
           
            pst.setString(1,PN );
            pst.setString(2,PC);
            pst.setString(3,C);
            pst.setString(4,ND);
            pst.setString(5,It);
            
            int row = pst.executeUpdate();
            if(row==1)
            {
                JOptionPane.showMessageDialog(this,"Record updated successful!");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Sorry! Can not add record");
            }

            }
            catch(Exception ex)
            {
                System.out.println("Fails :"+ex);
            }
        
        
        }
        ////
        if(e.getSource()==submit)//inserting record
        {
            String PN = jtf1.getText();
            String PC = jtf2.getText();
            String C = jtf3.getText();
            String ND = jtf4.getText();
            String It = city1.getSelectedItem().toString();
            //add jdbc code.
            
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);            
            PreparedStatement pst = conn.prepareStatement("insert into STU(packagename,packageco,country,days,itinerary) values(?,?,?,?,?)");
           
            pst.setString(1,PN );
            pst.setString(2,PC);
            pst.setString(3,C);
            pst.setString(4,ND);
            pst.setString(5,It);
            
            int row = pst.executeUpdate();
            if(row==1)
            {
                JOptionPane.showMessageDialog(this,"Record added successful!");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Sorry! Can not add record");
            }

            }
            catch(Exception ex)
            {
                System.out.println("Fails :"+ex);
            }
               
        }

        else if(e.getSource()==reset)
        {
           jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
             jtf4.setText("");       
        }
        
        else if(e.getSource()==reset1)
        {
           jtf5.setText("");
            jtf6.setText("");
            jtf7.setText("");            
        }
        
        else if(e.getSource()==reset2)
        {
           jtf8.setText("");            
        }
        else if(e.getActionCommand().equals("Logout"))
        {
            LoginFrame demo = new LoginFrame();
            dispose();
        }
        else if(e.getActionCommand().equals("back"))
        {
            HomePage demo = new HomePage();
            dispose();
        }
        
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      String c2 = city2.getSelectedItem().toString();
       String c3=city3.getSelectedItem().toString();
        System.out.println(c2);
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
            PreparedStatement ps = conn.prepareStatement("select * from stu where packagename=?");
            ps.setString(1, c2);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                jtf5.setText(rs.getString("packageco"));
                jtf6.setText(rs.getString("country"));
                jtf7.setText(rs.getString("days"));
                
            }
            else
            {
                System.out.println("package not found");
            }
            
            
                        
            
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      
      
      
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
            PreparedStatement ps = conn.prepareStatement("select * from stu where packagename=?");
            ps.setString(1, c2);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                jtf8.setText(rs.getString("packageco"));
                
                
            }
            else
            {
                System.out.println("package not found");
            }
            
            
                        
            
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      
//      } 
      
    }
    
}

