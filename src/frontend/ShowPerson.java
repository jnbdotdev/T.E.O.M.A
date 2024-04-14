package frontend;

import backend.Person;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;

import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

@SuppressWarnings({ "serial", "unused" })
public class ShowPerson extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRarity;
	private JTextField txtType;
	private JTextField txtPpower;
	private JTextField txtPatack;
	private JTextField txtPat;

	JSpinner spnLevel = new JSpinner();
	JSpinner spnStature = new JSpinner();
	JSpinner spnPower = new JSpinner();
	JSpinner spnMana = new JSpinner();
	JSpinner spnAge = new JSpinner();
	JLabel lblImg = new JLabel("");
	JList<String> jList = new JList<String>();
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	public static Person person = new Person();
	
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
	
	String fileSelectedPath = "";
	
	String filePath;
	ImageIcon img;
	private JTextField txtSearch;
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
					ShowPerson frame = new ShowPerson();
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
	@SuppressWarnings("removal")
	public ShowPerson() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowPerson.class.getResource("/frontend/logo.png")));
		setResizable(false);
		setTitle("Monsmalters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.setBounds(548, 11, 226, 379);
		contentPane.add(panel);

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
		btnUpload.setFocusPainted(false);
		btnUpload.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnUpload.setBounds(0, 356, 226, 23);
		panel.add(btnUpload);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 245, 395);
		contentPane.add(scrollPane);
		
		jList.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String name = jList.getSelectedValue();
				txtName.setText(name);
				searchPerson();
			
			}
		});
		scrollPane.setViewportView(jList);
		jList.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(315, 11, 147, 40);
		contentPane.add(txtName);
		txtName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Name ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchPerson();
				}
				
			}
		});
		
		JLabel lblMonsmalterLevel = new JLabel("Monsmalter Level:");
		lblMonsmalterLevel.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblMonsmalterLevel.setBounds(270, 62, 116, 20);
		contentPane.add(lblMonsmalterLevel);
		
		spnLevel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnLevel.setBounds(468, 62, 70, 20);
		contentPane.add(spnLevel);
		
		txtRarity = new JTextField();
		txtRarity.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtRarity.setColumns(10);
		txtRarity.setBounds(334, 124, 204, 20);
		contentPane.add(txtRarity);
		
		JLabel lblRarity = new JLabel("Rarity");
		lblRarity.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblRarity.setBounds(270, 124, 54, 20);
		contentPane.add(lblRarity);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblType.setBounds(270, 93, 54, 20);
		contentPane.add(lblType);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtType.setColumns(10);
		txtType.setBounds(334, 93, 204, 20);
		contentPane.add(txtType);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(270, 155, 268, 2);
		contentPane.add(separator);
		
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblAge.setBounds(270, 168, 55, 20);
		contentPane.add(lblAge);
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setHorizontalAlignment(SwingConstants.CENTER);
		lblMana.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblMana.setBounds(484, 168, 55, 20);
		contentPane.add(lblMana);
		
		JLabel lblStature = new JLabel("Stature");
		lblStature.setHorizontalAlignment(SwingConstants.CENTER);
		lblStature.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblStature.setBounds(335, 168, 55, 20);
		contentPane.add(lblStature);
		
		JLabel lblPower = new JLabel("Power");
		lblPower.setHorizontalAlignment(SwingConstants.CENTER);
		lblPower.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPower.setBounds(419, 168, 55, 20);
		contentPane.add(lblPower);

		spnAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnAge.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnAge.setBounds(270, 199, 55, 20);
		contentPane.add(spnAge);

		spnStature.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnStature.setModel(new SpinnerNumberModel(new Double(1.01), new Double(1.00), null, new Double(0.01)));
		spnStature.setBounds(334, 199, 55, 20);
		contentPane.add(spnStature);

		spnPower.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnPower.setBounds(418, 199, 55, 20);
		contentPane.add(spnPower);

		spnMana.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		spnMana.setBounds(483, 199, 55, 20);
		contentPane.add(spnMana);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(270, 242, 268, 2);
		contentPane.add(separator_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addMouseListener(new MouseAdapter() {
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
				
				try {
					ImageIO.write(bi, "jpg", new File(name+".jpg"));
					pp.savePerson();
					JOptionPane.showMessageDialog(null, "Character Updated Successfully!");
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		btnUpdate.setBounds(548, 401, 226, 49);
		contentPane.add(btnUpdate);
		
		txtPpower = new JTextField();
		txtPpower.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPpower.setColumns(10);
		txtPpower.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Principal Power ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtPpower.setBounds(270, 261, 268, 49);
		contentPane.add(txtPpower);
		
		txtPatack = new JTextField();
		txtPatack.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPatack.setColumns(10);
		txtPatack.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Principal Atack ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtPatack.setBounds(270, 327, 268, 49);
		contentPane.add(txtPatack);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ShowPerson.this.dispose();
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
		btnBack.setBounds(270, 15, 35, 35);
		contentPane.add(btnBack);

		JButton btnSearchPath = new JButton("");
		btnSearchPath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				fillList();
				
			}
		});
		btnSearchPath.setIcon(new ImageIcon(ShowPerson.class.getResource("/frontend/icons8-search-23.png")));
		btnSearchPath.setBounds(10, 11, 35, 33);
		btnSearchPath.setFocusPainted(false);
		contentPane.add(btnSearchPath);
		
		txtPat = new JTextField();
		txtPat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtPat.setColumns(10);
		txtPat.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " P.A.T ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtPat.setBounds(270, 394, 268, 49);
		contentPane.add(txtPat);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				searchPerson();
			}
		});
		btnSearch.setBounds(472, 16, 66, 32);
		contentPane.add(btnSearch);
		
		txtSearch = new JTextField(person.getDirectory());
		fillFirstList();
		txtSearch.setBounds(55, 11, 200, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
	}
	
	public String fileFinder() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem (.jpg, .png, .jpeg)", "jpg","png","jpeg");
		
		String baseDirectory = System.getProperty("user.home")+"/Downloads";
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
	
	public void searchPerson() {
		Person pp = new Person();
		String data = pp.showPerson(txtName.getText(),txtSearch.getText());
		
		txtPat.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " P.A.T ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		StringBuilder sb = new StringBuilder("");
		sb.append(data);
		String[] linhas = sb.toString().split("\\r?\\n");
		name = linhas[0];
		stature = Double.parseDouble(linhas[1]);
		age = Integer.parseInt(linhas[2]);
		power = Integer.parseInt(linhas[3]);
		mana = Integer.parseInt(linhas[4]);
		ppower = linhas[5];
		patack = linhas[6];
		pat = linhas[7];
		type = linhas[8];
		rarity = linhas[9];
		mlevel = Integer.parseInt(linhas[10]);

		txtName.setText(name);
		spnStature.setValue(stature);
		spnAge.setValue(age);
		spnPower.setValue(power);
		spnMana.setValue(mana);
		txtPpower.setText(ppower);
		txtPatack.setText(patack);
		txtPat.setText(pat);
		txtType.setText(type);
		txtRarity.setText(rarity);
		spnLevel.setValue(mlevel);
		
		filePath = txtSearch.getText()+name+".jpg";
		
		img = new ImageIcon(filePath);
		img.setImage(img.getImage().getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),1));
		lblImg.setIcon(img);
	}
	
	public void fillList() {
		
		Person pp = new Person();
		fileSelectedPath = pp.fileFinder()+"\\";
		if(!fileSelectedPath.equals("\\")) {
			txtSearch.setText(fileSelectedPath);
			listModel = pp.reviewFiles2(fileSelectedPath);
			jList.setModel(listModel);
		}
		
	}
	
	public void fillFirstList() {
		
		Person pp = new Person();
		fileSelectedPath = pp.getDirectory()+"\\";
		if(!fileSelectedPath.equals("\\")) {
			txtSearch.setText(fileSelectedPath);
			listModel = pp.reviewFiles2(fileSelectedPath);
			jList.setModel(listModel);
		}
		
		
	}
}
