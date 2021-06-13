
package bung;

/**
 *
 * @author Sergio Ameen
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class manager extends JFrame {
int len;
    FileInputStream fin;

    void h(){
this.dispose();}
String[] columnNames = {"BNumber", "Reservation Date", "Reservation End","Reserver"};
    DefaultTableModel model = new DefaultTableModel();
    static JTable table;
    ///////////////////////////////
    String[] columnNames2 = {"Name", "Family Name", "Telephione ","Email"};
    DefaultTableModel model2 = new DefaultTableModel();
    static JTable table2;
    manager(){
	  super("Home");
          JPanel p2=new JPanel();JLabel lp2=new JLabel("Bangalows services");
JFileChooser file = new JFileChooser();
    ////////////////////
    JLabel l11=new JLabel("Bangalow Name");
    JLabel l22=new JLabel("Family name");
    
JLabel l8=new JLabel("picture");

    String a=null;
    JLabel l0=new JLabel(a);

    ///////////////////////////////////////////////////
    ImageIcon pic=new ImageIcon("images/pic.png");
    ImageIcon add=new ImageIcon("images/add.jpg");
    ImageIcon ser=new ImageIcon("images/ser.jpg");

    

    
    JButton b2=new JButton(add);
    JButton b5=new JButton(pic);

    JButton b3=new JButton(ser);
        JButton b4=new JButton("display");



    JTextField t11=new JTextField(12);
    JTextField t22=new JTextField(12);
    ///////////////////////////////////////////////////
    

	  JPanel panel = new JPanel();
                    panel.setLayout(null);
          panel.add(l22);panel.add(t22);
          panel.add(b3);panel.add(b4);

	 //////////////////////////////////////////////////////////////////////////////
                    JPanel panel3 = new JPanel();
          panel3.setLayout(null);
          panel3.add(b2);
          panel3.add(b5);
          panel3.add(l8);
          
          panel3.add(l11);panel3.add(t11);
  
b2.setBounds(500,440,170,170);b3.setBounds(30,10,200,200);
    
    b4.setBounds(470,170,150,150);
    
    b5.setBounds(20,280,150,150);
        l8.setBounds(300,200,300,300);
     l11.setBounds(20,60,150,30);t11.setBounds(20,90,120,25);
        l22.setBounds(270,60,150,30);t22.setBounds(270,90,120,25);
        l0.setBounds(1100,80,400,400);
////////////////////////////Table/////////////////////////
         model.setColumnIdentifiers(columnNames);
         model2.setColumnIdentifiers(columnNames2);

         table = new JTable();
         table2 = new JTable();

         table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table2.setModel(model2);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        JScrollPane scroll2 = new JScrollPane(table2);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(table);panel.add(table2);table.setBounds(0,430,700,900);table2.setBounds(0,530,700,900);

JLabel l=new JLabel(new ImageIcon("images/add.png"));
	  JTabbedPane tp=new  JTabbedPane();
	    tp.addTab("add", panel3);
	    tp.add("display", panel);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = getContentPane();
            b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            String h=null;

            try
            {
               Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");
                
                PreparedStatement ps=connection.prepareStatement("Insert into b values(?,?,?,?,?,?,?)");
                             ps.setString(1, null);
                ps.setString(2, t11.getText());
                ps.setInt(3, 0);
                ps.setString(4, null);
                ps.setString(5, null);
                ps.setString(6, null);
                ps.setBlob(7, fin, len); 
                 
        ps.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"Insert seccessfuly");
t11.setText("");t22.setText("");l8.setText("");

                connection.close();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
                System.err.println("Problem Connecting!");
            }
        }});
	       b5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
{
	Object ob=e.getSource();
		if(ob==b5)

		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(f);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              ImageIcon m=new ImageIcon(path);
		              l8.setIcon(m);
            try { 
                 fin=new FileInputStream(selectedFile);
                       len=(int)selectedFile.length();

               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
		          }
else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");}


}});
	    tp.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				 if (e.getSource() instanceof JTabbedPane) {
                     JTabbedPane pane = (JTabbedPane) e.getSource();
if(pane.getSelectedIndex()==1) {
	
}
else if(pane.getSelectedIndex()==0) {
}
				 }
			}
		});
            b4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bung","root","12345678");

                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM bek where status=1");
                int i =0;
                if(rs.next())
                {
                    int id = rs.getInt("Bnum");
                    String rd = rs.getString("Rdate");
                    String	ld = rs.getString("Ldate");
                    String name = rs.getString("lName");
String Aid="B"+id;
                    model.addRow(new Object[]{Aid, rd,ld,name});
                    i++;
                }
                if(i <1)
                {
                    JOptionPane.showMessageDialog(null, "No Record Found","Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(i ==1)
                {
                    System.out.println(i+" Record Found");
                }
                else
                {
                    System.out.println(i+" Records Found");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }


        }});
             b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bung","root","12345678");

                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM reg WHERE  `lName` = "+t22.getText());
                int i =0;
                if(rs.next())
                {
                    String name = rs.getString("fName");
                    String fname = rs.getString("lName");
                    int	tel = rs.getInt("tel");
                    String email = rs.getString("email");
                    

                    model.addRow(new Object[]{name, fname,tel,email});
                    i++;
                }
                if(i <1)
                {
                    JOptionPane.showMessageDialog(null, "No Record Found","Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(i ==1)
                {
                    System.out.println(i+" Record Found");
                }
                else
                {
                    System.out.println(i+" Records Found");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }


        }});
	    content.add(tp, BorderLayout.CENTER);
	    setSize(700, 700);
	    setVisible(true);
  }

  public static void main(String args[]) {
	
      new manager();
    
  }
}
