package Travel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Test extends JFrame implements ActionListener{  

    JPanel p1;
    JLabel label,view;
    JButton logout,tpi,ti,back;
    
    //Get information from the database 
    //RowData is used to store rowData 
    //ColumnNames hold columnNames 
    Vector rowData,columnNames;  
    JTable jt=null;  
    JScrollPane jsp=null;  
      
    //Define the variables required by the database  
    PreparedStatement ps=null;  
    Connection ct=null;  
    ResultSet rs=null;  
    
    
    public static void main(String[] args) {  
          
        Test test=new Test();  
  
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==back)
        {
            Baseline demo = new Baseline();
            demo.setVisible(true);
            dispose();
        }
        if(e.getActionCommand().equals("Logout"))
        {
            LoginFrame demo = new LoginFrame();
            dispose();
        }
    }
    
    //Constructor
        public Test(){  
        
        p1 = new JPanel();
        p1.setBounds(0, -50, 800, 800);
        p1.setBackground(Color.white);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        label.setBounds(100, 80, 575, 284);
        p1.add(label);
        
        view = new JLabel();
        view.setText("Tour Packages Records");              //insert text
        view.setBounds(270, 230, 300, 100);                 //from x , from y , ,  
        view.setForeground(Color.blue);                     //set color
        view.setFont(new java.awt.Font("Dialog",1,39));     //set size
        
        logout  = new JButton("Logout");
        logout.setBounds(316, 620, 160,50);
        logout.setFont(new Font("宋体",Font.CENTER_BASELINE,32));    //setFont
        logout.setForeground(Color.white);      
        logout.setBackground(Color.DARK_GRAY);
        logout.setFocusPainted(false);
        logout.setVisible(true);
        logout.addActionListener(this);
        
        back  = new JButton("back");
        back.setBounds(316, 520, 160,50);
        back.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        back.setForeground(Color.white);
        back.setBackground(Color.DARK_GRAY);
        back.setFocusPainted(false);
        back.setVisible(true);
        back.addActionListener(this);
        
        setLayout(new FlowLayout());
        
        add(view);
        add(p1);
        add(logout);
        add(back);
        
        setTitle("Travel");
        setVisible(true);
        setSize(600,900);
            
              
            columnNames = new Vector();  
            //Set the column name 
            columnNames.add("Package Name");  
            columnNames.add("Package Number");  
            columnNames.add("Country");  
            columnNames.add("Number of Days");  
            columnNames.add("Itinerary");
            
            rowData = new Vector();  
            //RowData can hold multiple rows and start fetching from the database  
            
            try {  
                //load driver  
                Class.forName("org.apache.derby.jdbc.ClientDriver");  
                //Get the connection  
                ct=DriverManager.getConnection("jdbc:derby://localhost:1527/univ","univ","univ");  
                  
                ps=ct.prepareStatement("select * from stu");    // stu is one database name
                
                rs=ps.executeQuery();  
                  
                while(rs.next()){  
                    //RowData can store multiple rows
                    Vector hang=new Vector();  
                    hang.add(rs.getString(1));  
                    hang.add(rs.getString(2));  
                    hang.add(rs.getString(3));  
                    hang.add(rs.getString(4));  
                    hang.add(rs.getString(5));  
                    
                    //insert in RowData 
                    rowData.add(hang);  
                }  
            } 
            
            catch (Exception e) 
            {  
                e.printStackTrace();  
            }
            
            finally{  
                    try 
                    {  
                        if(rs!=null){  
                        rs.close();  
                        }  
                        if(ps!=null){  
                            ps.close();  
                        }  
                        if(ct!=null){  
                            ct.close();  
                        }  
                    } 
                    catch (SQLException e) 
                    {  
                        e.printStackTrace();  
                    }  
            }  
              
                          
            //Initialize Jtable
            jt = new JTable(rowData,columnNames);  
            
            //Initialize jsp  
            jsp = new JScrollPane(jt);  
            
            //Put the JSP into the Jframe
            this.add(jsp);  
            this.setSize(600,900);  
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setVisible(true);  
              
        } 
}