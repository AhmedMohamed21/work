
package bung;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Vector;
import javafx.scene.control.DatePicker;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Sergio Ameen
 */
// Packages to import
import javax.swing.JFrame;

public class customer extends JFrame{
   
Bung b=new Bung();

    int pos=1;
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
int x=screensize.height;
int y=screensize.width;
               Vector rows = new Vector();
JLabel l1=new JLabel("House ID");
JLabel l6=new JLabel("picture");
JButton next = new JButton("Next");        
    JButton prev = new JButton("prev");
    JButton res = new JButton("Reserve");
        JDateChooser jd=new JDateChooser();
               JDateChooser jd2=new JDateChooser();
JPanel foter=new JPanel();
    
    JLabel foter2=new JLabel(" Contact : 05338856799, E-mail :Hrent21@gmail.com");


    public void gdata()
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");
			String sql = "select * from bek where Bnum='"+pos+"'";
			PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
	ResultSetMetaData data = rs.getMetaData();
       int colums = data.getColumnCount();		
            while(rs.next())
           {

               
                   
                   l1.setText("B"+rs.getInt("Bnum"));
                   
                   byte[] img=rs.getBytes("pic");
                   ImageIcon m=new ImageIcon(img);
                   l6.setIcon(m);
                  
		}
           
                }
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}			
	}    
    customer(){
    super("Banglows");
    Font f=new Font("Algerian",Font.BOLD,15);
    this.setBackground(new Color(0,100,100));
        setVisible(true);
        setBounds((y/2)-250,(x/2)-250,500,500);        gdata();
        setResizable(false);
        JLabel r1=new JLabel("reserve date");
         JLabel r2=new JLabel("end of reserve");



        JPanel c=new JPanel();

                c.setLayout(null);
                foter2.setFont(new Font("Serif", Font.PLAIN, 11));
foter.setBackground(Color.LIGHT_GRAY);
foter.setBounds(0,435,500,25);
foter.add(foter2);

        c.setBackground(Color.WHITE);
        c.add(foter);
        add(c);
        c.add(l1);c.add(l6);c.add(next);c.add(prev);c.add(res);c.add(jd);c.add(jd2);c.add(r1);c.add(r2);
        l1.setFont(f);next.setFont(f);prev.setFont(f);res.setFont(f);r1.setFont(f);r2.setFont(f);
        
        l1.setBounds(110,110,300,50 );l6.setBounds(250,100,200,200);res.setBounds(300,0,150,30);
        next.setBounds(300,360,150,30);prev.setBounds(100,360,150,30);
        jd.setBounds(80,150,150,30);        r1.setBounds(100,180,150,30);

        jd2.setBounds(80,250,150,30);        r2.setBounds(100,290,150,30);

next.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pos++;
            if(pos==10){
            pos=1;
            }
            try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bung","root","12345678");
			String sql = "select * from bek where Bnum='"+pos+"'and status=0";
			PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
	ResultSetMetaData data = rs.getMetaData();
       int colums = data.getColumnCount();		
            while(rs.next())
           {

               
                   
                   l1.setText("B"+rs.getInt("Bnum"));
                   
                   byte[] img=rs.getBytes("pic");
                   ImageIcon m=new ImageIcon(img);
                   l6.setIcon(m);
			
			
		}
            
                }
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
prev.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pos--;
            try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");
			String sql = "select * from bek where Bnum='"+pos+"'";
			PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
	ResultSetMetaData data = rs.getMetaData();
       int colums = data.getColumnCount();		
            while(rs.next())
           {

               
                   
                   l1.setText("B"+rs.getInt("Bnum"));
                   
                   byte[] img=rs.getBytes("pic");
                   ImageIcon m=new ImageIcon(img);
                   l6.setIcon(m);
			
			
		}
            
                }
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
res.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String d=jd.getDate().toString();
            String d2= jd2.getDate().toString();
            int x=1;
            String user=b.userna;
            System.out.println("user "+user);
                        System.out.println("bbbuser "+b.userna);


try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");


                Statement statement = connection.createStatement();
                String str = "UPDATE  bek SET   status='"+x+"', Rdate='"+d+"',Ldate='"+d2+"',lName='"+user+"' where Bnum='"+pos+"'"; 
                        
                       



                statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Reserved seccessfuly");
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());

        }}
    });
        }
	// Driver method
	public static void main(String[] args)
	{
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
		new customer();
	}
}

