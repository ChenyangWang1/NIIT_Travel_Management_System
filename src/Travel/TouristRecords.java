package Travel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Statement;

public class TouristRecords extends JFrame implements ActionListener,ItemListener{
    JTabbedPane obj;
    JLabel name,con,add,nation,port,name1,pass,add1,nation1,con1,pass2,name2,image;
    JPanel jp1,jp2,jp3;
    JTextField stu1,stu2,stu3,stu4,arg1,arg2,arg3,fied;
    JComboBox choicc,cho1,cho2,tree;
    JButton sub,re,log,subb,ree,logg,delete,reset,logout,back;
    String keyword;
    
    public TouristRecords()
    {
        
        //add
        name=new JLabel("Name              :");
        name.setForeground(Color.blue);
         con=new JLabel("Contact No    :");
         con.setForeground(Color.blue);
         add=new JLabel("Address         :");
         add.setForeground(Color.blue);
         nation=new JLabel("Nationality      :");
         nation.setForeground(Color.blue);
         port=new JLabel("Passport No   :");
         port.setForeground(Color.blue);
         
         stu1=new JTextField("");
         stu2=new JTextField("");
         stu3=new JTextField("");
         stu4=new JTextField("");
             
         choicc=new JComboBox();
         choicc.addItem("Amarican");
         choicc.addItem("China");
         choicc.addItem("British");
         choicc.addItem("French");
         
         sub=new JButton("Submit");
         sub.setBackground(Color.CYAN);
         sub.addActionListener(this);
         re=new JButton("Reset");
         re.setBackground(Color.CYAN);
         re.addActionListener(this);
         log=new JButton("back");
         log.setBackground(Color.CYAN);
         log.addActionListener(this);
         
         
        jp1=new JPanel();
        image=new JLabel();
        jp1.add(image);
        jp1.setBackground(Color.white);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg")));
        image.setBounds(50,0,500,200);
        
        
        //edit
        name1=new JLabel("Name              :");
        name1.setForeground(Color.blue);
        pass=new JLabel("Passport No   :");
        pass.setForeground(Color.blue);
        add1=new JLabel("Address         :");
        add1.setForeground(Color.blue);
        nation1=new JLabel("Nationality      :");
        nation1.setForeground(Color.blue);
        con1=new JLabel("Contact No    :");
        con1.setForeground(Color.blue);
        
        cho1=new JComboBox();
        getPackage();
        cho2=new JComboBox();
        cho2.addItem("Amarican");
        cho2.addItem("China");
        cho2.addItem("British");
        cho2.addItem("French");
        
        arg1=new JTextField("");
        arg2=new JTextField("");
        arg3=new JTextField("");
        
        subb=new JButton("Submit");
        subb.setBackground(Color.CYAN);
        subb.addActionListener(this);
        ree=new JButton("Reset");
        ree.setBackground(Color.CYAN);
        ree.addActionListener(this);
        logg=new JButton("back");
        logg.addActionListener(this);
        logg.setBackground(Color.CYAN);
  
        jp2=new JPanel();
        image=new JLabel();
        jp2.add(image);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg")));
        image.setBounds(50,0,500,200);
        
        
        
        
        //delete
        pass2=new JLabel("Passport No   :");
        pass2.setForeground(Color.blue);
        name2=new JLabel("Name              :");
        name2.setForeground(Color.blue);
        
        fied=new JTextField("");
        tree=new JComboBox();
        getPackages();
        tree.addItemListener(this);
        
        delete=new JButton("Delete");
        delete.setBackground(Color.CYAN);
        delete.addActionListener(this);
        reset=new JButton("Reset");
        reset.setBackground(Color.CYAN);
        reset.addActionListener(this);
        logout=new JButton("back");
        logout.addActionListener(this);
        logout.setBackground(Color.CYAN);
        logout.addActionListener(this);
        
        jp3=new JPanel();
        image=new JLabel();
        jp3.add(image);
        jp3.setBackground(Color.white);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg")));
        image.setBounds(50,0,500,200);
        //The three Table 
        obj=new JTabbedPane(JTabbedPane.TOP);
        obj.addTab("ADD",jp1);
        obj.addTab("Edit",jp2);
        obj.addTab("DELETE",jp3);
        obj.setSize(100,100);
        
      //ADDname,con,add,nation,port,sub,re,log,
        jp1.add(name);
        name.setBounds(250,115,150,200);
        jp1.add(con);
        con.setBounds(250,150,150,200);
        jp1.add(add);
        add.setBounds(250,185,150,200);
        jp1.add(nation);
        nation.setBounds(250,220,150,200);
        jp1.add(port);
        port.setBounds(250,255,150,200);
        
        jp1.add(stu1);
        stu1.setBounds(340,205,110,20);
        jp1.add(stu2);
        stu2.setBounds(340,240,110,20);
        jp1.add(stu3);
        stu3.setBounds(340,275,110,20);
        jp1.add(stu4);
        stu4.setBounds(340,345,110,20);
        
        jp1.add(choicc);
        choicc.setBounds(340,310,110,20);
        
        jp1.add(sub);
        sub.setBounds(240,400,95,20);
        jp1.add(re);
        re.setBounds(400,400,95,20);
        jp1.add(log);
        log.setBounds(600,150,75,20);
      //EDITname1,pass,add1,nation1,con1
        jp2.add(pass);
        pass.setBounds(250,115,150,200);
         jp2.add(name1);
        name1.setBounds(250,150,150,200);
        jp2.add(add1);
        add1.setBounds(250,185,150,200);
        jp2.add(nation1);
        nation1.setBounds(250,220,150,200);
        jp2.add(con1);
        con1.setBounds(250,255,150,200);
        jp2.add(cho1);
        
        cho1.setBounds(340,210,110,20);
        cho1.addItemListener(this);
        jp2.add(cho2);
        cho2.setBounds(340,310,110,20);
        jp2.add(arg1);
        arg1.setBounds(340,245,110,20);
        jp2.add(arg2);
        arg2.setBounds(340,280,110,20);
        jp2.add(arg3);
        arg3.setBounds(340,345,110,20);
        
        jp2.add(subb);
        subb.setBounds(240,400,95,20);
        jp2.add(ree);
        ree.setBounds(400,400,95,20);
        jp2.add(logg);
        logg.setBounds(600,150,75,20);
        //DELETE
        jp3.add(pass2);
        pass2.setBounds(250,160,150,200);
        jp3.add(name2);
        name2.setBounds(250,205,150,200);
        
        jp3.add(tree);
        tree.setBounds(350,253,110,20);
        
        jp3.add(fied);
        fied.setBounds(350,297,110,20);
        
        
        jp3.add(delete);
        delete.setBounds(240,360,85,20);
        jp3.add(reset);
        reset.setBounds(400,360,85,20);
        jp3.add(logout);
        logout.setBounds(600,150,85,20);
        
      //
        add(obj);
        
        jp1.setLayout(null);
        jp2.setLayout(null);
        jp3.setLayout(null);
        setTitle("Tourst record");
        setSize(800,800);
        setVisible(true);
      
        
        
        
    }
  
    public static void main(String[] args) {
      TouristRecords stud=new TouristRecords();
      
    
     
    }
   public void getPackage()//input the value of passport into the Conbox of cho1
    {
        try
        {
             Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
             PreparedStatement pst = conn.prepareStatement("select * from stu2");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
                 cho1.addItem(rs.getString("passport"));
             }
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
/////////////////////////
   public void getPackages()//input the value of passport into the Conbox of tree
    {
        try
        {
             Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
             PreparedStatement pst = conn.prepareStatement("select * from stu2");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
                 tree.addItem(rs.getString("passport"));
             }
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

  /////////////////
    public void actionPerformed(ActionEvent e) {//achieve the function about the action
        
        String buttonName = e.getActionCommand();
         
         ///////////
        if(e.getActionCommand().equals("back"))
        {
            HomePage demo = new HomePage();
            dispose();
        }
        
        
         
         
        if(e.getSource()==sub)//input these vaules from the user into the table
        {
          String R1=stu1.getText();
          String R2=stu2.getText();
          String R3=stu3.getText();
          String R4=choicc.getSelectedItem().toString();
          String R5=stu4.getText();
          
          try
          {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
            PreparedStatement org = conn.prepareStatement("insert into stu2(name,number,address,nationality,passport) values(?,?,?,?,?)");
            
            org.setString(1,R1 );
            org.setString(2,R2);
            org.setString(3,R3);
            org.setString(4,R4);
            org.setString(5,R5);
            int row = org.executeUpdate();
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
              System.out.println(ex);
          }
        }
       
       if(e.getSource()==re)//to rset the TextField
          {
          stu1.setText("");
          stu2.setText("");
          stu3.setText("");
          stu4.setText("");
        
         }
       
       if(e.getActionCommand().equals("back"))
        {
            HomePage demo = new HomePage();
            dispose();
        }
      /////////////////// 
       if(e.getSource()==subb)//input or update these vaules from the user into the table
       {
         String U1=cho1.getSelectedItem().toString();
         String U2=arg1.getText();
         String U3=arg2.getText();
         String U4=cho2.getSelectedItem().toString();
         String U5=arg3.getText();
        try
          {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            
            PreparedStatement org = conn.prepareStatement("insert into stu2(name,number,address,nationality,passport) values(?,?,?,?,?)");
            
            org.setString(1,U1 );
            org.setString(2,U2);
            org.setString(3,U3);
            org.setString(4,U4);
            org.setString(5,U5);
            int row = org.executeUpdate();
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
              System.out.println(ex);
          }
       
       }
       if(e.getSource()==ree)//to rset the TextField
          {
          arg1.setText("");
          arg2.setText("");
          arg3.setText("");
          
        
         }
       ////////////////
       if(e.getSource()==reset)//to rset the TextField
           {
             fied.setText("");
          
        
         }
        /////////////
        
        
        
        //////////
        if(e.getSource()==delete)// to delete the special values of the table
        {
           String key1 = tree.getSelectedItem().toString();
           
           try
           {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement org = conn.prepareStatement("delete from stu2 where passport=?" );
            
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
        ///////////////////////////////
       
   
    
    }
    ////////////
    public void itemStatneChanged(ItemEvent e)//click the values of the Combox and input the related values
    {
      String a2=cho1.getSelectedItem().toString();
      //String a3=tree.getSelectedItem().toString();
      try
      {
      
          Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
          PreparedStatement rg = conn.prepareStatement("select * from stu2 where passport=?" );
          
          rg.setString(1,a2);
          ResultSet rs=rg.executeQuery();
          if(rs.next())
          {
             arg1.setText(rs.getString("name"));
             arg2.setText(rs.getString("address"));
             arg3.setText(rs.getString("number")); 
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
      
     
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       String a2=cho1.getSelectedItem().toString();
       String a3=tree.getSelectedItem().toString();
      try
      {
      
          Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String password = "univ";
            Connection conn = DriverManager.getConnection(url, user, password);
          PreparedStatement rg = conn.prepareStatement("select * from stu2 where passport=?" );
          
          rg.setString(1,a2);
          ResultSet rs=rg.executeQuery();
          if(rs.next())
          {
             arg1.setText(rs.getString("name"));
             arg2.setText(rs.getString("address"));
             arg3.setText(rs.getString("number")); 
          }
            
          else
          {
              System.out.println("package not found");
          }
          conn.close();
          rg.close();
          rs.close();
          
          
          
          
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
          PreparedStatement rg = conn.prepareStatement("select * from stu2 where passport=?" );
          
          rg.setString(1,a3);
          ResultSet rs=rg.executeQuery();
          if(rs.next())
          {
             fied.setText(rs.getString("name"));
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
    }
    
    
}
