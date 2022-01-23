package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaAhorro;
import logica.Persistencia;
import logica.VentanaLoginUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaRegistroAhorro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroCuenta;
	private JTextField tfFecha_Creacion;
	private JTextField tfConsignacion;
	private JButton btnRegistrar;
	private CuentaAhorro ca;
	private Persistencia p;
	private VentanaLoginUsuario vcs;

	/**
	 * Launch the application.
	 

	/**
	 * Create the frame.
	 */
	public VentanaRegistroAhorro() {
		p= new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroDeCuenta = new JLabel("Numero de Cuenta");
		lblNumeroDeCuenta.setBounds(24, 32, 105, 14);
		contentPane.add(lblNumeroDeCuenta);
		
		tfNumeroCuenta = new JTextField();
		tfNumeroCuenta.setBounds(247, 29, 123, 20);
		contentPane.add(tfNumeroCuenta);
		tfNumeroCuenta.setColumns(10);
		
		JLabel lblFechaDeCreasion = new JLabel("Fecha de creacion");
		lblFechaDeCreasion.setBounds(24, 106, 105, 14);
		contentPane.add(lblFechaDeCreasion);
		
		tfFecha_Creacion = new JTextField();
		tfFecha_Creacion.setBounds(247, 103, 123, 20);
		contentPane.add(tfFecha_Creacion);
		tfFecha_Creacion.setColumns(10);
		
		JLabel lblMonto = new JLabel("Ingrese la cantidad de dinero inicial");
		lblMonto.setBounds(24, 182, 213, 14);
		contentPane.add(lblMonto);
		
		tfConsignacion = new JTextField();
		tfConsignacion.setBounds(247, 179, 123, 20);
		contentPane.add(tfConsignacion);
		tfConsignacion.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a=Double.parseDouble(tfConsignacion.getText());
				ca=new CuentaAhorro(tfNumeroCuenta.getText(), tfFecha_Creacion.getText(), a);
				p=new Persistencia();
				
				try 
				{
					p.registroAhorros(tfNumeroCuenta.getText(), tfFecha_Creacion.getText(), a);
					JOptionPane.showMessageDialog(null, "Se registro con exito la cuenta de ahorros gracias por usar este banco");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vcs=new VentanaLoginUsuario();
				vcs.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrar.setBounds(153, 227, 89, 23);
		contentPane.add(btnRegistrar);
	}
}

