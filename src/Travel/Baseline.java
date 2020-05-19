package Travel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Baseline extends JFrame implements ActionListener{
    
    JPanel p1;
    JLabel label,view;
    JButton logout,tpi,ti,back;

    public Baseline() {
        
        p1 = new JPanel();
        p1.setBounds(0, -50, 800, 800);
        p1.setBackground(Color.white);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); 
        label.setBounds(100, 80, 575, 284);
        p1.add(label);
        
        view = new JLabel();
        view.setText("View Records");
        view.setBounds(270, 230, 300, 100);                 //离x轴，离y轴， ， 
        view.setForeground(Color.blue);                     //字体颜色
        view.setFont(new java.awt.Font("Dialog",1,39));     //字体大小
        
        tpi  = new JButton("Tour Packages Info");
        tpi.setBounds(new Rectangle(200, 380, 400,50));     
        tpi.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        tpi.setForeground(Color.white);
        tpi.setBackground(Color.blue);
        tpi.setFocusPainted(false);
        tpi.addActionListener(this);
        
        ti  = new JButton("Tourist Information");
        ti.setBounds(200, 450, 400,50);         
        ti.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        ti.setForeground(Color.white);
        ti.setBackground(Color.blue);
        ti.setFocusPainted(false);
        ti.addActionListener(this);
        
        logout  = new JButton("Logout");
        logout.setBounds(316, 520, 160,50);   
        logout.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        logout.setForeground(Color.white);
        logout.setBackground(Color.DARK_GRAY);
        logout.setFocusPainted(false);
        logout.setVisible(true);
        logout.addActionListener(this);
        
        back  = new JButton("back");
        back.setBounds(316, 590, 160,50); ////
        back.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        back.setForeground(Color.white);
        back.setBackground(Color.DARK_GRAY);
        back.setFocusPainted(false);
        back.setVisible(true);
        back.addActionListener(this);
        
        setLayout(null);
        
        add(view);
        add(p1);
        add(tpi);
        add(ti);
        add(logout);
        add(back);
        
        setTitle("Travel");
        setVisible(true);
        setSize(800,800);
        
        
    }
    
    public static void main(String[] args) {
        Baseline demo = new Baseline();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Tour Packages Info"))
        {
            Test demo = new Test();
            dispose();
        }
        
        if(e.getActionCommand().equals("Tourist Information"))
        {
            Test2 demo = new Test2();
            dispose();
        }
        
        if(e.getActionCommand().equals("Logout"))
        {
            LoginFrame demo = new LoginFrame();
            dispose();
        }
        
        if(e.getActionCommand().equals("back"))
        {
            HomePage demo = new HomePage();
            dispose();
        }
    }
    
}
