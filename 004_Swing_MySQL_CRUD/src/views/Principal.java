package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal{

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccesoOk = new JLabel("ACCESO OK");
		lblAccesoOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccesoOk.setBounds(147, 11, 128, 76);
		frame.getContentPane().add(lblAccesoOk);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"id", "uduario", "contrase\u00F1a", "estado"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(82, 100, 255, 114);
		frame.getContentPane().add(table);
	}

}
