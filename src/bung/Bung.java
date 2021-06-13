
package bung;

/**
 *
 * @author Sergio Ameen
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

import javax.swing.*;



public class Bung extends JFrame {
    String userna;
   // JLabel use;
	private boolean val(String username,String password) {
   try{           
       Class.forName("com.mysql.jdbc.Driver"); 
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");     
       PreparedStatement pst = conn.prepareStatement("Select * from reg where usern=? and pass=?");
       pst.setString(1, username); 
       pst.setString(2, password);
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())  {          
           JOptionPane.showMessageDialog(null, "login successful");	
			h();
			customer c=new customer();
                        userna=rs.getString("lName");
                       // use.setText(userna);
                        System.out.println("ghjgfghjg    "+userna);
			c.setVisible(true);
       }   
       else if(username.equals("admin")&&password.equals("1234")){
	           JOptionPane.showMessageDialog(null, "Wellcome Admin");	
		
       manager h=new manager();
			h.setVisible(true);
           }else {JOptionPane.showMessageDialog(null, "wrong input");}            
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }       
            return false;
}
void h(){
this.dispose();}	
public Bung()
{
Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int x=screensize.height;
int y=screensize.width;
	
final JFrame f1 =new JFrame("Login to Continue");
f1.setResizable(false);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.setBounds((y/2)-250,(x/2)-250,500,500);
//f1.setResizable(true);
//f1.setBounds(x, y, 700, 700);
//System.out.println(x+" "+y);
JLabel title=new JLabel("wellcome to house services"); ////YOUR TITLE

title.setLayout(null);
title.setBounds(70,-150,500,500);
title.setFont(new Font("Serif", Font.PLAIN, 25));

final JTextField usern=new JTextField("User-name");
final JPasswordField pass=new JPasswordField("Password");
JMenuBar m=new JMenuBar();
JMenu r=new JMenu("Register");
JMenu lo=new JMenu("Login");

usern.setBounds(90,210,300,50 );
pass.setBounds(90,270,300,50);
m.setBounds(0, 0, 500, 40);

JButton log=new JButton("Login");

ImageIcon icon = new ImageIcon("images/login.jpg");
ImageIcon icon2 = new ImageIcon("images/login2.jpg");

log.setBounds(160,350,180,60);

log.setBorderPainted(false);
log.setBorder(null);
log.setMargin(new Insets(0, 0, 0, 0));
log.setContentAreaFilled(false);
log.setIcon(icon2);
log.setRolloverIcon(icon2);
log.setPressedIcon(icon);
log.setDisabledIcon(icon);


JPanel foter=new JPanel();
JLabel foter2=new JLabel(" Contact : 05338856799, E-mail :Hrent21@gmail.com");
foter2.setFont(new Font("Serif", Font.PLAIN, 11));
foter.setBackground(Color.white);
foter.setBounds(0,435,500,25);
foter.add(foter2);
 m.add(r);
        m.add(lo);
        f1.add(m);

ActionListener al=new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		String user=usern.getText();
		String passw=String.valueOf(pass.getPassword());
               if( val(user,passw)){			//JOptionPane.showMessageDialog(null, "login successful");	
               }
		
	}
};


log.addActionListener(al);

usern.addMouseListener(new MouseAdapter()
{
	public void mousePressed(MouseEvent e)
	{
		String temp=usern.getText();
		if(temp.equals("User-name")){
		
		usern.setText("");}
	}
});

pass.addMouseListener(new MouseAdapter()
{
	public void mousePressed(MouseEvent ae)
	{
		pass.setText("");
	}
	
});

usern.addKeyListener(new KeyAdapter()
{
	public void keyPressed(KeyEvent e)
	{
	if(e.getKeyCode()==KeyEvent.VK_ENTER)	
	{
		 pass.requestFocusInWindow(); 
	}
	}
});

usern.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusGained(java.awt.event.FocusEvent evt) {
        usern.selectAll();
    }

}	);

pass.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusGained(java.awt.event.FocusEvent evt) {
        pass.selectAll();
    }

}	);

pass.addKeyListener(new KeyAdapter()
{
	public void keyPressed(KeyEvent e)
	{
	if(e.getKeyCode()==KeyEvent.VK_ENTER)	
	{
		String user=usern.getText();
		String passw=String.valueOf(pass.getPassword());
		if(user.equals("admin")&&passw.equals("admin"))
		{
			System.out.println("Login Successful");
			f1.dispose();
			
		manager h=new manager();
		h.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "Wrong Username Or Password");	
			usern.requestFocusInWindow();
				
		}
	}
	}
});
r.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
h();
        new reg();
    }

});
f1.setLayout(null);
f1.add(title);
f1.add(usern);
f1.add(pass);
f1.setVisible(true);
f1.add(log);
f1.add(foter);
}
private static void setLookAndFeel() {
         try {
             UIManager.setLookAndFeel(
                 "javax.swing.plaf.nimbus.NimbusLookAndFeel"
             );
         } catch (Exception exc) {
             System.out.println(exc.getMessage());
         }
     }

public static void main(String arg[]) {
    // setLookAndFeel();
    new Bung();
}
}
