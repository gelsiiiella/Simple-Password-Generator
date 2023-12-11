package myPackage;

import java.awt.EventQueue;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.datatransfer.StringSelection;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Password_Generator extends JFrame {

	private JPanel contentPane;
	private Color startColor;
	private Color endColor;
	private Timer timer;
	private float fraction;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JComboBox<Integer> comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JLabel lblNewLabel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password_Generator frame = new Password_Generator();
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
	public Password_Generator() {
		setTitle("Password Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 454);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D)g;
				int w = getWidth();
				int h = getHeight();
				
				
				
				int midX = (int) (w * fraction);
				int midY = (int) (h * fraction);
				
				GradientPaint gradient = new GradientPaint (0,0,startColor,w,h,endColor);
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, w, h);
				
			}
	};
				
	    
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		startColor = Color.BLACK;
		endColor = Color.DARK_GRAY;
		fraction = 0.0f;
		
		timer = new Timer (50,new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				fraction += 0.01f;
				if (fraction >= 1.0f) {
					fraction = 0.0f;
				}
				contentPane.repaint();
				timer.start();
			}
		});
			
		
		JLabel pg_Title = new JLabel("PASSWORD GENERATOR");
		pg_Title.setForeground(new Color(255, 255, 255));
		pg_Title.setIcon(new ImageIcon("C:\\Users\\Angela\\Downloads\\icons8-lock-64 (2).png"));
		pg_Title.setFont(new Font("Digital-7 Mono", Font.BOLD, 25));
		pg_Title.setBounds(87, 11, 335, 89);
		contentPane.add(pg_Title);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(53, 266, 341, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel(" Number of Characters");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Digital-7 Mono", Font.PLAIN, 11));
		lblNewLabel.setBounds(26, 119, 182, 14);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {4, 5, 8, 11, 12}));
		comboBox.setBounds(141, 116, 51, 22);
		contentPane.add(comboBox);
		
		chckbxNewCheckBox = new JCheckBox("AlphaNumeric");
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Digital-7 Mono", Font.PLAIN, 12));
		chckbxNewCheckBox.setBackground(new Color(0,0,0));
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(238, 115, 136, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("GENERATE PASSWORD");
		tglbtnNewToggleButton.setBackground(UIManager.getColor("CheckBox.light"));
		tglbtnNewToggleButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate_password();
				tglbtnNewToggleButton.setBackground(new Color(255, 192, 203));
			}
		});
		tglbtnNewToggleButton.setBounds(166, 184, 168, 39);
		contentPane.add(tglbtnNewToggleButton);
		
		JButton copy_Button = new JButton("");
		copy_Button.setBackground(UIManager.getColor("Button.disabledShadow"));
		copy_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String copy_password = textField.getText();
				if (copy_password != null && !copy_password.isEmpty()) {
					StringSelection string_selection = new StringSelection(copy_password);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(string_selection, null);
					JOptionPane.showMessageDialog(null,"Password copied to clipboard!");
				}else {
					JOptionPane.showMessageDialog(null, "No Password Generated!");
				}
				
				
				
			}
		});
		copy_Button.setIcon(new ImageIcon("C:\\Users\\Angela\\Downloads\\icons8-copy-24 (1).png"));
		copy_Button.setBounds(392, 266, 46, 32);
		contentPane.add(copy_Button);
		
		chckbxNewCheckBox_1 = new JCheckBox("Numerical");
		chckbxNewCheckBox_1.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("Digital-7 Mono", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBackground(new Color(0,0,0));
		chckbxNewCheckBox_1.setOpaque(false);
		chckbxNewCheckBox_1.setBounds(388, 115, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				chckbxNewCheckBox.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				comboBox.setSelectedItem(null);
				btnRefresh.setBackground(new Color(0,0,0));
				
			}
		});
		btnRefresh.setBackground(new Color(0,0,0));
		btnRefresh.setBorder(null);
		btnRefresh.setOpaque(false);
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\Angela\\Downloads\\icons8-reset-24 (3).png"));
		btnRefresh.setBounds(380, 43, 81, 32);
		btnRefresh.setFocusPainted(false);
		contentPane.add(btnRefresh);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Angela\\Downloads\\background_1_AdobeExpress (2).gif"));
		lblNewLabel_2.setBounds(-17, -48, 562, 529);
		contentPane.add(lblNewLabel_2);
	}
	
	
	private void generate_password() {
		Object select_length = (Integer) comboBox.getSelectedItem();
			if (select_length == null || !(select_length instanceof Integer)) {
				JOptionPane.showMessageDialog(this,"Please select number of characters");
			}
		int password_length = (Integer) select_length;
		boolean isAlphaNumeric = chckbxNewCheckBox.isSelected();
		boolean isNumerical = chckbxNewCheckBox_1.isSelected();
		String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:/=+}{][*&^#@!~><?;0123456789";
		
		if (isAlphaNumeric) {
			character += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		}
		if (isNumerical) {
			character = "0123456789";
		}
		if (isAlphaNumeric && isNumerical) {
			character += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		}
		
		
	
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		
		for (int i = 0; i < password_length; i++) {
			int randomIndex = random.nextInt(character.length());
			password.append(character.charAt(randomIndex));
		}
		
		textField.setText(password.toString());
	}
}

