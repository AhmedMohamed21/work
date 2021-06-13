
package bung;

/**
 *
 * @author Sergio Ameen
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

public class reg extends JFrame{
	
	/**
	 * 
	 */
void h(){
this.hide();}
	public reg (){
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int x=screensize.height;
        int y=screensize.width;

        final JFrame f1 =new JFrame("Sign To Get Access");
        f1.setResizable(false);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBounds((y/2)-250,(x/2)-250,500,500);
f1.setBackground(Color.green);
        JLabel title=new JLabel("wellcome to house services");
        title.setLayout(null);
        title.setBounds(70,-160,500,500);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
JMenuBar m=new JMenuBar();
JMenu r=new JMenu("Register");
JMenu log=new JMenu("Login");
        final JTextField fName=new JTextField();
        JLabel l1= new JLabel("First Name :");
        final JTextField lName=new JTextField();
        JLabel l2= new JLabel("Family Name :");
        final JTextField usern=new JTextField();
        JLabel l3= new JLabel("User Name :");
        final JPasswordField pass=new JPasswordField();
        JLabel l4= new JLabel("Password :");
        final JTextField tel=new JTextField();
        JLabel l5= new JLabel("Telephone :");
        final JTextField email=new JTextField();
        JLabel l6= new JLabel("Email Address :");
        JButton signUp=new JButton("SignUp ");
       // f1.add(title);
        m.add(r);
        m.add(log);
        f1.add(m);
f1.add(signUp);f1.add(fName);f1.add(lName);f1.add(usern);f1.add(pass);f1.add(tel);f1.add(email);
f1.add(l1);f1.add(l2);f1.add(l3);f1.add(l4);f1.add(l5);f1.add(l6);
m.setBounds(0, 0, 500, 40);
fName.setBounds(200,100,150,30 );
        lName.setBounds(200,140,150,30 );
        usern.setBounds(200,180,150,30 );
        tel.setBounds(200,260,150,30 );
        email.setBounds(200,300,150,30 );
        pass.setBounds(200,220,150,30);
l1.setBounds(100,90,150,50);l2.setBounds(100,130,150,50);l3.setBounds(100,170,150,50);l4.setBounds(100,210,150,50);
l5.setBounds(100,250,150,50);l6.setBounds(100,290,150,50);

        

        signUp.setBounds(300,350,180,60);

        setLookAndFeel();
       


        JPanel foter=new JPanel();
        JLabel foter2=new JLabel(" Contact : 05338856799, E-mail :Hrent21@gmail.com");
        foter2.setFont(new Font("Serif", Font.PLAIN, 11));
        foter.setBackground(Color.white);
        foter.setBounds(0,435,500,25);
        foter.add(foter2);
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");


                Statement statement = connection.createStatement();
                String str = "INSERT INTO reg(fName, lName, usern,pass, tel,email)" +
                        "VALUES('"+fName.getText()+"',"  + "'"+lName.getText()+"',"
                        + "'"+usern.getText()+"',"+ "'"+pass.getText().toString()+"',"+ "'"+tel.getText()+"',"+ "'"+email.getText()+"')";



                statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Insert seccessfuly");
//t11.setText("");t22.setText("");t33.setText("");t55.setText("");t66.setText("");

                connection.close();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
                System.err.println("Problem Connecting!");
            }
            }
        });
    log.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
h();
                new Bung();
            }

    });
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLookAndFeel();
                new reg();
	}

}

