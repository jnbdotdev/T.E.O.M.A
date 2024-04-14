package frontend;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.Person;

import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.*;

@SuppressWarnings("serial")
public class Screen extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRarity;
	private JTextField txtType;
	private JTextField txtPpower;
	private JTextField txtPatack;
	private JTextField txtPat;

	JSpinner spnMana = new JSpinner();
	JSpinner spnPower = new JSpinner();
	JSpinner spnStature = new JSpinner();
	JSpinner spnAge = new JSpinner();
	JSpinner spnLevel = new JSpinner();
	JLabel lblImg = new JLabel("");
	
	public static String name;
	public static double stature;
	public static int age;
	public static int power;
	public static int mana;
	public static String ppower;
	public static String patack;
	public static String pat;
	public static String type;
	public static String rarity;
	public static int mlevel;
	
	String filePath;
	ImageIcon img;
	
	JFileChooser fc = new JFileChooser();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Windows".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	        	System.err.println(ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	
	public Screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Screen.class.getResource("/frontend/logo.png")));
		setResizable(false);
		setTitle("Monsmalters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(288, 11, 226, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(0, 0, 226, 355);
		panel.add(lblImg);
		
		JButton btnUpload = new JButton("UPLOAD IMAGE");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				filePath = fileFinder();
				img = new ImageIcon(filePath);
				img.setImage(img.getImage().getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),1));
				lblImg.setIcon(img);
				
			}
		});
		btnUpload.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnUpload.setBounds(0, 356, 226, 23);
		panel.add(btnUpload);
		btnUpload.setFocusPainted(false);
		btnUpload.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtName.setBounds(74, 58, 204, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblName.setBounds(10, 58, 54, 20);
		contentPane.add(lblName);
		
		JLabel lblMonsmalterLevel = new JLabel("Monsmalter Level:");
		lblMonsmalterLevel.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblMonsmalterLevel.setBounds(74, 20, 116, 20);
		contentPane.add(lblMonsmalterLevel);

		spnLevel.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLevel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnLevel.setBounds(224, 20, 54, 20);
		contentPane.add(spnLevel);
		
		txtRarity = new JTextField();
		txtRarity.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtRarity.setColumns(10);
		txtRarity.setBounds(74, 120, 204, 20);
		contentPane.add(txtRarity);
		
		JLabel lblRarity = new JLabel("Rarity");
		lblRarity.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblRarity.setBounds(10, 120, 54, 20);
		contentPane.add(lblRarity);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblType.setBounds(10, 89, 54, 20);
		contentPane.add(lblType);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtType.setColumns(10);
		txtType.setBounds(74, 89, 204, 20);
		contentPane.add(txtType);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 268, 2);
		contentPane.add(separator);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblAge.setBounds(10, 173, 55, 20);
		contentPane.add(lblAge);
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setHorizontalAlignment(SwingConstants.CENTER);
		lblMana.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblMana.setBounds(223, 173, 55, 20);
		contentPane.add(lblMana);
		
		JLabel lblStature = new JLabel("Stature");
		lblStature.setHorizontalAlignment(SwingConstants.CENTER);
		lblStature.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblStature.setBounds(74, 173, 55, 20);
		contentPane.add(lblStature);
		
		JLabel lblPower = new JLabel("Power");
		lblPower.setHorizontalAlignment(SwingConstants.CENTER);
		lblPower.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPower.setBounds(158, 173, 55, 20);
		contentPane.add(lblPower);

		spnAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnAge.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnAge.setBounds(10, 204, 55, 20);
		contentPane.add(spnAge);

		spnStature.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnStature.setModel(new SpinnerNumberModel(new Double(1.01), new Double(1.00), null, new Double(0.01)));
		spnStature.setBounds(74, 204, 55, 20);
		contentPane.add(spnStature);

		spnPower.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnPower.setBounds(158, 204, 55, 20);
		contentPane.add(spnPower);
		
		spnMana.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnMana.setBounds(223, 204, 55, 20);
		contentPane.add(spnMana);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 248, 268, 2);
		contentPane.add(separator_1);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				name = txtName.getText();
				stature = (double)spnStature.getValue();
				age = (int)spnAge.getValue();
				power = (int)spnPower.getValue();
				mana = (int)spnMana.getValue();
				ppower = txtPpower.getText();
				patack = txtPatack.getText();
				pat = txtPat.getText();
				type = txtType.getText();
				rarity = txtRarity.getText();
				mlevel = (int)spnLevel.getValue();
				
				Person pp = new Person(name, stature, age, power, mana, ppower, patack, pat, type, rarity, mlevel);
				
				BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.createGraphics();
				img.paintIcon(null, g, 0,0);
				g.dispose();
				String directoryDestination = pp.getDirectory();
				
				try {
					ImageIO.write(bi, "jpg", new File(directoryDestination+name+".jpg"));
					pp.savePerson();
					JOptionPane.showMessageDialog(null, "Character Saved Successfully!");
					clearFields();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		btnSave.setBounds(288, 401, 226, 49);
		contentPane.add(btnSave);
		
		txtPpower = new JTextField();
		txtPpower.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPpower.setColumns(10);
		txtPpower.setBounds(10, 261, 268, 49);
		contentPane.add(txtPpower);
		txtPpower.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Principal Power ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtPatack = new JTextField();
		txtPatack.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPatack.setColumns(10);
		txtPatack.setBounds(10, 327, 268, 49);
		contentPane.add(txtPatack);
		txtPatack.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Principal Atack ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtPat = new JTextField();
		txtPat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPat.setColumns(10);
		txtPat.setBounds(10, 394, 268, 49);
		txtPat.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " P.A.T ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(txtPat);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Screen.this.dispose();
				MainScreen ms = new MainScreen();
				ms.setVisible(true);
			
			}
		});
		btnBack.setIcon(new ImageIcon(Screen.class.getResource("/frontend/left.png")));
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setOpaque(false);
		btnBack.setRolloverIcon(new ImageIcon(Screen.class.getResource("/frontend/left (1).png")));
		btnBack.setPressedIcon(new ImageIcon(Screen.class.getResource("/frontend/left.png")));
		btnBack.setBounds(10, 11, 35, 35);
		contentPane.add(btnBack);
		
	}
	
	public String fileFinder() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem (.jpg, .png, .jpeg)", "jpg","png","jpeg");
		
		String baseDirectory = System.getProperty("user.home")+"/Pictures";
		File dir = new File(baseDirectory);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(dir);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(filter);
		String filePath = "";
		
		int openFile = chooser.showOpenDialog(null);
		if(openFile == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getAbsolutePath();
		}
		
		return filePath;
	}
	
	public void clearFields() {
		
		spnLevel.setValue(1);
		txtName.setText("");
		txtType.setText("");
		txtRarity.setText("");
		spnAge.setValue(1);
		spnStature.setValue(1.01);
		spnPower.setValue(0);
		spnMana.setValue(0);
		txtPpower.setText("");
		txtPatack.setText("");
		txtPat.setText("");
		lblImg.setIcon(null);
		
	}
}
