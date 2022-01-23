package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import logica.Persistencia;
import logica.VentanaLoginUsuario;

public class VentanaCuentaCorriente extends JFrame {

	private JPanel contentPane;
	private VentanaRegistroCuentaCorriente vr;
	private VentanaConsignarCorriente vcc;

	public VentanaCuentaCorriente() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUENTA CORRIENTE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(63, 25, 318, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vr=new VentanaRegistroCuentaCorriente();
				vr.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistro.setBounds(35, 122, 89, 23);
		contentPane.add(btnRegistro);
		
		JButton btnConsigacion = new JButton("Consigacion");
		btnConsigacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcc=new VentanaConsignarCorriente();
				vcc.setVisible(true);
				setVisible(false);
			}
		});
		btnConsigacion.setBounds(151, 122, 109, 23);
		contentPane.add(btnConsigacion);
		
		JButton btnRetiro = new JButton("Retiro");
		btnRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			VentanaRetirarCorriente vrc = new VentanaRetirarCorriente();
			vrc.setVisible(true);
			setVisible(false);
			}
		});
		btnRetiro.setBounds(292, 122, 89, 23);
		contentPane.add(btnRetiro);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			VentanaLoginUsuario vlu = new VentanaLoginUsuario();
			vlu.setVisible(true);
			setVisible(false);
			}
		});
		btnNewButton.setBounds(160, 181, 89, 23);
		contentPane.add(btnNewButton);
	}
}

