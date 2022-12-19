package ma.supmti.ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

public class CalculateAge extends JFrame implements ActionListener{
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldBODYear;
	private JLabel lblResult ;
	
	CalculateAge(){
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerJFrame(this);
		JLabel lblNewLabel = new JLabel("Prénom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(171, 65, 74, 20);
		getContentPane().add(lblNewLabel);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(255, 63, 164, 22);
		getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(255, 107, 164, 22);
		getContentPane().add(textFieldLastName);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(171, 107, 74, 20);
		getContentPane().add(lblNom);
		
		textFieldBODYear = new JTextField();
		textFieldBODYear.setColumns(10);
		textFieldBODYear.setBounds(255, 153, 164, 22);
		getContentPane().add(textFieldBODYear);
		
		JLabel lblAnne = new JLabel("Année : ");
		lblAnne.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnne.setBounds(171, 155, 74, 20);
		getContentPane().add(lblAnne);
		
		lblResult = new JLabel("label");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResult.setBounds(134, 301, 327, 20);
		getContentPane().add(lblResult);
		
		JButton btnCalcAge = new JButton("Mon age");
		btnCalcAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcAge.setForeground(new Color(255, 255, 255));
		btnCalcAge.setBackground(new Color(0, 0, 0));
		btnCalcAge.setBounds(213, 210, 178, 30);
		btnCalcAge.addActionListener(this);
		btnCalcAge.setBorder(null);
		
		getContentPane().add(btnCalcAge);
		
		
		
	
		
	}
	
	public void centerJFrame(JFrame jframe) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int newWidth = dimension.width/2 - jframe.getSize().width/2; 
		int newHeight = dimension.height/2 - jframe.getSize().height/2;
		jframe.setLocation(newWidth, newHeight);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
		      public void run(){
		    	  new CalculateAge();
		      }
		    });
		
	}
	public boolean IsInt(String s) {
		int year;
		try {
		    year = Integer.parseInt(s);
		    return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Le champs année doit être un nombre!");
			return false;
		}
	}

	public boolean validateFields() {
		boolean valid = true;
		if("".equals(textFieldLastName.getText()) || "".equals(textFieldFirstName.getText()) || "".equals(textFieldBODYear.getText())) {
			JOptionPane.showMessageDialog(this, "Vous devez remplire tous les champs!");
			valid = false;
		}
		else if(!IsInt(textFieldBODYear.getText())) {
			valid = false;
		}
		else if(Integer.parseInt(textFieldBODYear.getText()) >= 2022) {
				JOptionPane.showMessageDialog(this, "La date doit être inferieure à 2022!");
				valid = false;
			}
		return valid;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(validateFields()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Date date = new Date();
			int age = Integer.parseInt(dateFormat.format(date))  - Integer.parseInt(textFieldBODYear.getText());
			String firstName = textFieldFirstName.getText();
			String lastName = textFieldLastName.getText();
			
			lblResult.setText(firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + lastName.toUpperCase() + ", vous avez " + age + " ans.");
		}
	}
}

