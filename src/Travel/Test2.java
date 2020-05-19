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

public class Test2 extends JFrame implements ActionListener{  

    JPanel p1;
    JLabel label,view;
    JButton logout,tpi,ti,back;
    //从数据库中取出信息  
    //rowData用来存放行数据  
    //columnNames存放列名  
    Vector rowData,columnNames;  
    JTable jt=null;  
    JScrollPane jsp=null;  
      
    //定义数据库需要的全局变量  
    PreparedStatement ps=null;  
    Connection ct=null;  
    ResultSet rs=null;  
      
      
    public static void main(String[] args) {  
          
        Test2 test=new Test2();  
  
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
    
    //构造函数  
        public Test2(){  
            
            p1 = new JPanel();
        p1.setBounds(0, -50, 800, 800);
        p1.setBackground(Color.white);

        label = new JLabel();
        
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        label.setBounds(100, 80, 575, 284);
        p1.add(label);
        
        view = new JLabel();
        view.setText("Tourists Records");      /////////////////////////////////////////////////////////////////////
        view.setBounds(270, 230, 300, 100);     //离x轴，离y轴， ， 
        view.setForeground(Color.blue);         //字体颜色
        view.setFont(new java.awt.Font("Dialog",1,39));     //字体大小
        
        logout  = new JButton("Logout");
        logout.setBounds(316, 620, 160,50);
        logout.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        logout.setForeground(Color.white);
        logout.setBackground(Color.DARK_GRAY);
        logout.setFocusPainted(false);
        logout.setVisible(true);
        logout.addActionListener(this);
        
        back  = new JButton("back");
        back.setBounds(316, 520, 160,50); ////
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
            
              
            columnNames=new Vector();  
            //设置列名  
            columnNames.add("Name");  
            columnNames.add("Number");  
            columnNames.add("Address");  
            columnNames.add("Nationality");  
            columnNames.add("Passport");
              
            rowData = new Vector();  
            //rowData可以存放多行,开始从数据库里取  
              
            try {  
                //加载驱动  
                Class.forName("org.apache.derby.jdbc.ClientDriver");  
                //得到连接  
                ct=DriverManager.getConnection("jdbc:derby://localhost:1527/univ","univ","univ");  
                  
                ps=ct.prepareStatement("select * from stu2");  
                  
                rs=ps.executeQuery();  
                  
                while(rs.next()){  
                    //rowData可以存放多行  
                    Vector hang=new Vector();  
                    hang.add(rs.getString(1));  
                    hang.add(rs.getString(2));  
                    hang.add(rs.getString(3));  
                    hang.add(rs.getString(4));  
                    hang.add(rs.getString(5));  
                      
                    //加入到rowData  
                    rowData.add(hang);  
                }  
            } 
            
            catch (Exception e) {  
                e.printStackTrace();  
            } 
            
            finally{  
                    try {  
                        if(rs!=null){  
                        rs.close();  
                        }  
                        if(ps!=null){  
                            ps.close();  
                        }  
                        if(ct!=null){  
                            ct.close();  
                        }  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
            }  
              
                          
            //初始化Jtable  
            jt = new JTable(rowData,columnNames);  
              
            //初始化 jsp  
            jsp = new JScrollPane(jt);  
              
            //把jsp放入到jframe  
            this.add(jsp);  
              
            this.setSize(600,900);
              
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setVisible(true);  
              
        } 
}