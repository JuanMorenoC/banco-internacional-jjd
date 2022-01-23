package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaNomina;
import logica.CuentaNomina;
import logica.Persistencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaRegistrarNomina extends JFrame {

	private JPanel contentPane;
	private JTextField tfNroCuenta;
	private JTextField tfCantidadDinero;
	private JTextField tfFechaCreacion;
	private String datos="";
	private ventanaCuentaNomina vn;
	private CuentaNomina cn;
	private Persistencia p;

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarNomina() {
		p =new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroNomina = new JLabel("Registro nomina");
		lblRegistroNomina.setBounds(157, 11, 99, 14);
		contentPane.add(lblRegistroNomina);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la cuenta");
		lblIngreseElNumero.setBounds(10, 49, 171, 14);
		contentPane.add(lblIngreseElNumero);
		
		tfNroCuenta = new JTextField();
		tfNroCuenta.setBounds(220, 46, 179, 20);
		contentPane.add(tfNroCuenta);
		tfNroCuenta.setColumns(10);
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de  dinero inicial");
		lblIngreseLaCantidad.setBounds(10, 119, 189, 14);
		contentPane.add(lblIngreseLaCantidad);
		
		tfCantidadDinero = new JTextField();
		tfCantidadDinero.setBounds(220, 116, 179, 20);
		contentPane.add(tfCantidadDinero);
		tfCantidadDinero.setColumns(10);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha de creacion");
		lblIngreseLaFecha.setBounds(10, 86, 171, 14);
		contentPane.add(lblIngreseLaFecha);
		
		tfFechaCreacion = new JTextField();
		tfFechaCreacion.setBounds(220, 85, 179, 20);
		contentPane.add(tfFechaCreacion);
		tfFechaCreacion.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a=Double.parseDouble(tfCantidadDinero.getText());
				try {
					p.registroNomina(tfNroCuenta.getText(), tfFechaCreacion.getText(), a);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro realizado");
				vn=new ventanaCuentaNomina();
				vn.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrar.setBounds(167, 227, 89, 23);
		contentPane.add(btnRegistrar);
		
//		JButton btnIngresarCuentasAsociadas = new JButton("Ingresar cuentas asociadas ");
//		btnIngresarCuentasAsociadas.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				int c=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de cuentas"));
//				String v="";
//				
//				for (int i = 0; i < c; i++) {
//					v=JOptionPane.showInputDialog("Ingrese el numero de cuenta a registrar");
//					datos+=v+";";
//				}
//				JOptionPane.showMessageDialog(null, "Guardadas con exito");
//			}
//		});
//		btnIngresarCuentasAsociadas.setBounds(40, 157, 248, 23);
//		contentPane.add(btnIngresarCuentasAsociadas);
	}
}