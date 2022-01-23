package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import logica.VentanaLoginUsuario;

public class VentanaCuentaAhorro extends JFrame {

	private JPanel contentPane;
	private VentanaRegistroAhorro vra;
	private VentanaCosignacionesAhorro vca;

	public VentanaCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vra=new VentanaRegistroAhorro();
				vra.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistro.setBounds(32, 150, 89, 23);
		contentPane.add(btnRegistro);
		
		JButton btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vca=new VentanaCosignacionesAhorro();
				vca.setVisible(true);
				setVisible(false);
			}
		});
		btnConsignar.setBounds(159, 150, 118, 23);
		contentPane.add(btnConsignar);
		
		JLabel lblCuentaDeAhorro = new JLabel("Cuenta de Ahorro");
		lblCuentaDeAhorro.setForeground(Color.RED);
		lblCuentaDeAhorro.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblCuentaDeAhorro.setBounds(74, 25, 291, 37);
		contentPane.add(lblCuentaDeAhorro);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			VentanaLoginUsuario vlu = new VentanaLoginUsuario();
			vlu.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(305, 150, 89, 23);
		contentPane.add(btnVolver);
	}

}

