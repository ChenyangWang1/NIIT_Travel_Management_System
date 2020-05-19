package Travel;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
// This class help you to add 
public class HomePage extends JFrame implements ActionListener{
    
    JPanel p1;
    JLabel label,view;
    JButton logout,tpi,ti,vr;

    public HomePage() {
        
        p1 = new JPanel();
        p1.setBounds(0, -50, 800, 800);
        p1.setBackground(Color.white);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("dream-travel.jpg"))); //
        label.setBounds(100, 80, 575, 284);
        p1.add(label);
        
        view = new JLabel();
        view.setText("Welcome Admin");
        view.setBounds(270, 230, 400, 100);     //离x轴，离y轴， ， 
        view.setForeground(Color.blue);         //字体颜色
        view.setFont(new java.awt.Font("Dialog",1,39));     //字体大小
        
        tpi  = new JButton("Tour Packages");
        tpi.setBounds(new Rectangle(200, 380, 400,50));     ///
        tpi.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        tpi.setForeground(Color.white);
        tpi.setBackground(Color.blue);
        tpi.setFocusPainted(false);
        tpi.addActionListener(this);        //************************
        
        ti  = new JButton("Tourist Records");
        ti.setBounds(200, 450, 400,50);         ////
        ti.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        ti.setForeground(Color.white);
        ti.setBackground(Color.blue);
        ti.setFocusPainted(false);
        ti.addActionListener(this);
        
        vr  = new JButton("View Records");
        vr.setBounds(200, 520, 400,50);         ////
        vr.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        vr.setForeground(Color.white);
        vr.setBackground(Color.blue);
        vr.setFocusPainted(false);
        vr.addActionListener(this);
        
        logout  = new JButton("Logout");
        logout.setBounds(316, 590, 160,50);   ////
        logout.setFont(new Font("宋体",Font.CENTER_BASELINE,32));
        logout.setForeground(Color.white);
        logout.setBackground(Color.DARK_GRAY);
        logout.setFocusPainted(false);
        logout.setVisible(true);
        logout.addActionListener(this);
        
        setLayout(null);
        
        add(view);
        add(p1);
        add(tpi);
        add(ti);
        add(vr);
        add(logout);
        
        setTitle("Travel");
        setVisible(true);
        setSize(800,800);
        
        
    }
    
    public static void main(String[] args) {
        HomePage demo = new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Tour Packages"))
        {
            TourPackages demo = new TourPackages();
            dispose();
        }
        
        if(e.getActionCommand().equals("Tourist Records"))
        {
            TouristRecords demo = new TouristRecords();
            dispose();
        }
        
        if(e.getActionCommand().equals("View Records"))
        {
            Baseline demo = new Baseline();
            dispose();
        }
        
        if(e.getActionCommand().equals("Logout"))
        {
            LoginFrame demo = new LoginFrame();
            dispose();
        }
        
    }
    
}
