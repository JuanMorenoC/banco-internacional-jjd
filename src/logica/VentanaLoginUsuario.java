package logica;

import interfaz.ModificarDatos;
import interfaz.VentanaCDT;
import interfaz.VentanaCuentaAhorro;
import interfaz.VentanaCuentaCorriente;
import interfaz.VentanaPrincipalBanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class VentanaLoginUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginUsuario frame = new VentanaLoginUsuario();
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
	public VentanaLoginUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("CERRAR SECCION ");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				VentanaPrincipalBanco vpb = new VentanaPrincipalBanco();
				vpb.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(87, 324, 262, 44);
		contentPane.add(btnVolver);
		
		JButton btnCambiarLosDatos = new JButton("Cambiar  los datos");
		btnCambiarLosDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
		     ModificarDatos md = new ModificarDatos();
		     md.setVisible(true);
		     setVisible(false);
			
			}
		});
		btnCambiarLosDatos.setBounds(108, 78, 211, 23);
		contentPane.add(btnCambiarLosDatos);
		
		JButton btnNewButton = new JButton("Cuenta de ahorro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			VentanaCuentaAhorro vca = new VentanaCuentaAhorro();
			vca.setVisible(true);
			setVisible(false);
			}
		});
		btnNewButton.setBounds(108, 138, 211, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cuenta Corriente");
		btnNewButton_1.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
			{
			VentanaCuentaCorriente vcc = new VentanaCuentaCorriente();
			vcc.setVisible(true);
			setVisible(false);
			
			}
		});
		btnNewButton_1.setBounds(108, 198, 211, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnCdt = new JButton("CDT");
		btnCdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			VentanaCDT vc = new VentanaCDT();
			vc.setVisible(true);
			setVisible(false);
			}
		});
		btnCdt.setBounds(108, 255, 211, 23);
		contentPane.add(btnCdt);
	}
}
