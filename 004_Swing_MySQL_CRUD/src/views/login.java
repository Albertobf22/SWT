package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import config.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frmAccesoADatos;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmAccesoADatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoADatos = new JFrame();
		frmAccesoADatos.getContentPane().setBackground(new Color(0, 191, 255));
		frmAccesoADatos.setTitle("Acceso a datos\r\n");
		frmAccesoADatos.setBounds(100, 100, 450, 300);
		frmAccesoADatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoADatos.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(37, 53, 64, 20);
		frmAccesoADatos.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(37, 116, 79, 38);
		frmAccesoADatos.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(201, 54, 138, 20);
		frmAccesoADatos.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 126, 138, 20);
		frmAccesoADatos.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acceder();
			}
		});
		btnNewButton.setBounds(267, 189, 138, 49);
		frmAccesoADatos.getContentPane().add(btnNewButton);
	}
	private void acceder() {
		Connection conn = new Conexion().conectar();
		
		try {
			PreparedStatement ps= conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1, textField.getText());
			ps.setString(2,  textField_1.getText());
			
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs.next());
			
			if(rs.next()) {
				Principal p = new Principal();
				p.frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "error de login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
