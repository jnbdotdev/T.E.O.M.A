package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Person;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings("serial")
public class Settings extends JFrame {

	String filePath;
	Person pp = new Person();
	private JPanel contentPane;
	private JTextField txtDirectory;

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
					Settings frame = new Settings();
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
	public Settings() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Settings.class.getResource("/frontend/logo.png")));
		setTitle("Monsmalters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 120);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblDirectorySelection = new JLabel("Select a directory:");
		lblDirectorySelection.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDirectorySelection.setBounds(10, 11, 115, 14);
		contentPane.add(lblDirectorySelection);
		
		txtDirectory = new JTextField();
		txtDirectory.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtDirectory.setBounds(126, 9, 217, 20);
		contentPane.add(txtDirectory);
		txtDirectory.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				filePath = pp.fileFinder()+"\\";
				txtDirectory.setText(filePath);
				pp.setDirectory(filePath);
				System.out.println(pp.getDirectory());
			
			}
		});
		btnSearch.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSearch.setBounds(353, 8, 71, 23);
		contentPane.add(btnSearch);
		
		JButton btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				pp.setDirectory(filePath);
				MainScreen ms = new MainScreen();
				Settings.this.dispose();
				ms.setVisible(true);
			
			}
		});
		btnDone.setBounds(192, 47, 57, 23);
		contentPane.add(btnDone);
	}
}
