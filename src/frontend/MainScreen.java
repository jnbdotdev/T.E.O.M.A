package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Person;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	
	private JPanel contentPane;
	
	ImageIcon btnSaveI;
	ImageIcon btnSaveClickedI;
	ImageIcon btnSaveRolloverI;
	ImageIcon btnShowI;
	ImageIcon btnShowClickedI;
	ImageIcon btnShowRolloverI;

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
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/frontend/logo.png")));
		setResizable(false);
		setTitle("Monsmalters");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 306);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 539, 172);
		ImageIcon img = new ImageIcon(MainScreen.class.getResource("/frontend/tittle.png"));
		img.setImage(img.getImage().getScaledInstance(lblTitle.getWidth(),lblTitle.getHeight(),1));
		lblTitle.setIcon(img);
		contentPane.add(lblTitle);
		
		btnSaveI = new ImageIcon(MainScreen.class.getResource("/frontend/btnSave.png"));
		btnSaveClickedI = new ImageIcon(MainScreen.class.getResource("/frontend/btnSaveClicked.png"));
		btnSaveRolloverI = new ImageIcon(MainScreen.class.getResource("/frontend/btnSaveRollover.png"));
		
		btnShowI = new ImageIcon(MainScreen.class.getResource("/frontend/btnShow.png"));
		btnShowClickedI = new ImageIcon(MainScreen.class.getResource("/frontend/btnShowClicked.png"));
		btnShowRolloverI = new ImageIcon(MainScreen.class.getResource("/frontend/btnShowRollover.png"));
		
		JButton btnSave = new JButton("");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Person pp = new Person();
				System.out.println(pp.getDirectory());
				MainScreen.this.dispose();
				Screen savePerson = new Screen();
				savePerson.setVisible(true);
				
			}
		});
		btnSave.setBounds(10, 194, 211, 61);
		btnSave.setIcon(btnSaveI);
		btnSave.setPressedIcon(btnSaveClickedI);
		btnSave.setRolloverIcon(btnSaveRolloverI);
		contentPane.add(btnSave);
		
		JButton btnShow = new JButton("");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				MainScreen.this.dispose();
				ShowPerson sp = new ShowPerson();
				sp.setVisible(true);
			
			}
		});
		btnShow.setBounds(338, 194, 211, 61);
		btnShow.setIcon(btnShowI);
		btnShow.setPressedIcon(btnShowClickedI);
		btnShow.setRolloverIcon(btnShowRolloverI);
		contentPane.add(btnShow);
		
		btnSave.setFocusPainted(false);
		btnShow.setFocusPainted(false);
		
		JButton btnSetting = new JButton("");
		btnSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Settings set = new Settings();
				MainScreen.this.dispose();
				set.setVisible(true);
			
			}
		});
		btnSetting.setIcon(new ImageIcon(MainScreen.class.getResource("/frontend/btnSettings.png")));
		btnSetting.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/frontend/btnSettingsRollover.png")));
		btnSetting.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/frontend/btnSettingsClicked.png")));
		btnSetting.setBounds(249, 194, 61, 61);
		contentPane.add(btnSetting);
	}
}
