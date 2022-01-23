package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CDT;
import logica.Persistencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class VentanaCrearCDT extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombeUsuario;
	private JTextField tfCantidadIngresada;
	private JTextField tfFechaCreacion;
	private JTextField tfDuracion;
	private JTextField tfTipoPago;
	private CDT cd;
	private Persistencia p;
	private JTextField tfPorcentaje;
	private VentanaCDT vc;
	private JTextField tfcedula;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaCrearCDT() 
	{
		p= new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(39, 25, 110, 14);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblNewLabel = new JLabel("Cantidad de dinero a ingresar");
		lblNewLabel.setBounds(39, 106, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaDeCreacion = new JLabel("Fecha de creacion");
		lblFechaDeCreacion.setBounds(39, 137, 110, 14);
		contentPane.add(lblFechaDeCreacion);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(39, 185, 96, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago");
		lblTipoDePago.setBounds(39, 257, 75, 14);
		contentPane.add(lblTipoDePago);
		
		tfNombeUsuario = new JTextField();
		tfNombeUsuario.setBounds(248, 22, 153, 20);
		contentPane.add(tfNombeUsuario);
		tfNombeUsuario.setColumns(10);
		
		tfCantidadIngresada = new JTextField();
		tfCantidadIngresada.setBounds(248, 103, 153, 20);
		contentPane.add(tfCantidadIngresada);
		tfCantidadIngresada.setColumns(10);
		
		tfFechaCreacion = new JTextField();
		tfFechaCreacion.setBounds(248, 134, 153, 20);
		contentPane.add(tfFechaCreacion);
		tfFechaCreacion.setColumns(10);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(248, 179, 153, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		tfTipoPago = new JTextField();
		tfTipoPago.setBounds(248, 254, 153, 20);
		contentPane.add(tfTipoPago);
		tfTipoPago.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(tfCantidadIngresada.getText());
				int b=Integer.parseInt(tfDuracion.getText());
				int c=Integer.parseInt(tfPorcentaje.getText());
				cd=new CDT(tfNombeUsuario.getText(),tfcedula.getText(), a, tfFechaCreacion.getText(), b, c, tfTipoPago.getText());
				
				try {
					p.crearCDT(tfNombeUsuario.getText(),tfcedula.getText() ,a, tfFechaCreacion.getText(), b, c, tfTipoPago.getText());
					JOptionPane.showMessageDialog(null, "CDT creado con exito");
					
					 tfNombeUsuario.setText("");
					 tfCantidadIngresada.setText("");
					 tfFechaCreacion.setText("");
					 tfDuracion.setText("");
					 tfTipoPago.setText("");
					 tfcedula.setText("");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCrear.setBounds(83, 307, 89, 23);
		contentPane.add(btnCrear);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje");
		lblPorcentaje.setBounds(39, 232, 75, 14);
		contentPane.add(lblPorcentaje);
		
		tfPorcentaje = new JTextField();
		tfPorcentaje.setBounds(248, 223, 153, 20);
		contentPane.add(tfPorcentaje);
		tfPorcentaje.setColumns(10);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			VentanaCDT vc= new VentanaCDT();
			vc.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(260, 307, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblCedula = DefaultComponentFactory.getInstance().createLabel("Cedula");
		lblCedula.setBounds(39, 67, 92, 14);
		contentPane.add(lblCedula);
		
		tfcedula = new JTextField();
		tfcedula.setBounds(249, 64, 152, 20);
		contentPane.add(tfcedula);
		tfcedula.setColumns(10);
	}
}

