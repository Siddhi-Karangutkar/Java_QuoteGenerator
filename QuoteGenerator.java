
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Generator extends JFrame{
	Container c;
	JButton  btnCoding,btnConfidence,btnHappy,btnWork;
	TextArea taMsg;
	
	Generator(){

		c = getContentPane();
		c.setLayout(null);
		
		btnCoding = new JButton("Coding Quotes");
		btnConfidence = new JButton("Confidence Quotes");
		btnHappy = new JButton("Happy Quotes");
		btnWork = new JButton("Work Quotes");
		taMsg = new TextArea(2,40);
		
		Font f = new Font("Comic Sans MS",Font.BOLD,30);
		btnCoding.setFont(f);
		btnConfidence.setFont(f);
		btnHappy.setFont(f);
		btnWork.setFont(f);
		taMsg.setFont(f);
	
		
		btnCoding.setBounds(100,100,600,100);
		btnConfidence.setBounds(100,250,600,100);
		btnHappy.setBounds(800,100,600,100);
		btnWork.setBounds(800,250,600,100);
		taMsg.setBounds(100,450,1300,100);


		c.add(btnCoding);
		c.add(btnConfidence);
		c.add(btnHappy);
		c.add(btnWork);
		c.add(taMsg);

		ActionListener a = (ae)->{
		
		try{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/quotes_july25";
			Connection con = DriverManager.getConnection(url,"root","root");
			
			String sql = "select * from quotes where category =  'coding' order by RAND() LIMIT 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			String quote = "";
			
			while(rs.next()){
			 quote = rs.getString("quote");
			}
			
			taMsg.setText(quote);
			rs.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"issue: "+e);
		}

		};
		btnCoding.addActionListener(a);
		


		ActionListener b = (ae)->{
		try{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/quotes_july25";
			Connection con = DriverManager.getConnection(url,"root",{your_password});
			
			String sql = "select * from quotes where category =  'confidence' order by RAND() LIMIT 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			String quote = "";
			
			while(rs.next()){
			 quote = rs.getString("quote");
			}
			
			taMsg.setText(quote);
			rs.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"issue: "+e);
		}
		};
		btnConfidence.addActionListener(b);



		ActionListener c = (ae)->{
		try{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/quotes_july25";
			Connection con = DriverManager.getConnection(url,"root","root");
			
			String sql = "select * from quotes where category =  'happy' order by RAND() LIMIT 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			String quote = "";
			
			while(rs.next()){
			 quote = rs.getString("quote");
			}
			
			taMsg.setText(quote);
			rs.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"issue: "+e);
		}
		};
		btnHappy.addActionListener(c);



		ActionListener d = (ae)->{
		try{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/quotes_july25";
			Connection con = DriverManager.getConnection(url,"root","root");
			
			String sql = "select * from quotes where category =  'work' order by RAND() LIMIT 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			String quote = "";
			
			while(rs.next()){
			 quote = rs.getString("quote");
			}
			
			taMsg.setText(quote);
			rs.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"issue: "+e);
		}
		};
		btnWork.addActionListener(d);
		
	
		setVisible(true);
		setSize(1500,1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quote Generator");
	
	}

}

class QuoteGenerator{
	public static void main(String args[]){
		Generator g = new Generator();
}

}
