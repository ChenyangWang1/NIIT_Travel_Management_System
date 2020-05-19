/*********   Start From Here   **********/

//  username  :    univ    ---------------------------
//  password  :    univ    ---------------------------

package Travel;

import java.awt.Color;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class LoginFrame extends JFrame implements ActionListener{
    
    JLabel userL,passL,picture,admin;
    JTextField userText;
    JPasswordField passText;
    JButton login;
    
    LoginFrame()
    {
        picture = new JLabel();
        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        picture.setBounds(100, 30, 575, 284);
        
        admin = new JLabel("Admin Login");
        admin.setBounds(320,300,300,100);
        admin.setForeground(Color.red);
        admin.setFont(new java.awt.Font("Dialog",1,30));
        
        userL = new JLabel("User Name");
        userL.setBounds(320, 480, 150, 20);
        userL.setForeground(new Color(218,112,214));
        userL.setFont(new java.awt.Font("Dialog",1,23));
        
        passL = new JLabel("Password");
        passL.setBounds(320, 500, 150, 20);
        passL.setForeground(new Color(218,112,214));
        passL.setFont(new java.awt.Font("Dialog",1,23));
        
        userText = new JTextField("");
        userText.setBounds(450, 480, 100, 20);
        
        passText = new JPasswordField("");
        passText.setBounds(450,500,100,20);
        
        login  = new JButton("Login");
        login.setBounds(350, 560, 80,20);
        
        add(picture);
        add(admin);
        add(userL);
        add(passL);
        add(userText);
        add(passText);
        add(login);
        
        login.addActionListener(this);
        
        setLayout(null);
        setTitle("Login");
        setBounds(200,150,800,800);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        LoginFrame demo = new LoginFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand()=="Login")
        {
            String username = userText.getText();
            String password = passText.getText();
            
            //JDBC Connection
            
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            //JDBC code.
            String url = "jdbc:derby://localhost:1527/univ";
            String user = "univ";
            String pass = "univ";
            Connection conn = DriverManager.getConnection(url, user, pass);
           
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from U where A='"+username+"' and B = '"+password+"'");
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this,"Login Success");
                HomePage demo = new HomePage();
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"fails");
            }
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
    }
    }
}
