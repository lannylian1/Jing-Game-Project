import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class userScore extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userScore frame = new userScore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtName = new JTextField();
		txtName.setBounds(10, 39, 171, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtScore = new JTextField();
		txtScore.setBounds(10, 125, 171, 20);
		contentPane.add(txtScore);
		txtScore.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(10, 100, 46, 14);
		contentPane.add(lblScore);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/score","homestead","secret");
					
					PreparedStatement ps = conn.prepareStatement("insert into user_score(name,score) values(?,?);");
					ps.setString(1, txtName.getText());
					ps.setString(1, txtScore.getText());
					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Score entered Successfully..");
					} else {

						System.out.println("Score entered Failed..");
					}
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnSave.setBounds(10, 207, 89, 23);
		contentPane.add(btnSave);
	}
}
