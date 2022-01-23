package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaNomina;
import logica.Persistencia;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ventanaCuentaNomina extends JFrame {

	private JPanel contentPane;
	private VentanaRegistrarNomina vrn;
	private Persistencia p;
	private VentanaConsignarNomina vcn;

	

	/**
	 * Create the frame.
	 */
	public ventanaCuentaNomina() 
	{
		p = new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarNomina = new JButton("Registrar Nomina");
		btnRegistrarNomina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				vrn=new VentanaRegistrarNomina();
				vrn.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarNomina.setBounds(10, 81, 156, 23);
		contentPane.add(btnRegistrarNomina);
		
		JButton btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vcn=new VentanaConsignarNomina();
				vcn.setVisible(true);
				setVisible(false);
			}
		});
		btnConsignar.setBounds(228, 81, 101, 23);
		contentPane.add(btnConsignar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numeroCuenta=JOptionPane.showInputDialog("Ingrese el numero de cuenta de la nomina");
				try {
					JOptionPane.showMessageDialog(null,p.mostrarCuentaNomina(numeroCuenta));
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnMostrar.setBounds(387, 81, 101, 23);
		contentPane.add(btnMostrar);
		
		JLabel lblNomina = new JLabel("Nomina");
		lblNomina.setBounds(157, 11, 71, 14);
		contentPane.add(lblNomina);
	}
}
