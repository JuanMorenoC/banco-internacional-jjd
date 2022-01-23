package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CDT;


import logica.VentanaLoginUsuario;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaCDT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaCDT() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCuentaCdt = new JLabel("Cuenta CDT");
		lblCuentaCdt.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblCuentaCdt.setBounds(127, 54, 189, 33);
		contentPane.add(lblCuentaCdt);
		
		JButton btnCrearCdt = new JButton("Crear CDT");
		btnCrearCdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				VentanaCrearCDT vct = new VentanaCrearCDT();
				vct.setVisible(true);
				setVisible(false);
			}
		});
		btnCrearCdt.setBounds(54, 162, 116, 23);
		contentPane.add(btnCrearCdt);
		
		JButton btnMostrarGanancia = new JButton("Mostrar Ganancia");
		btnMostrarGanancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				VentanaMostrarCDT vmc = new VentanaMostrarCDT();
				vmc.setVisible(true);
				setVisible(false);
			
			}
		});
		btnMostrarGanancia.setBounds(220, 162, 156, 23);
		contentPane.add(btnMostrarGanancia);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			VentanaLoginUsuario vlu = new VentanaLoginUsuario();
			vlu.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(157, 211, 89, 23);
		contentPane.add(btnVolver);
	}

}
