package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import logica  .*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class VentanaRegistroCuentaCorriente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroBancarioC;
	private JTextField tfFechaCreacionC;
	private CuentaCorriente cc;
	private CuentaCorriente cct;
	private JTextField tfMontoC;
	private VentanaLoginUsuario vlu;
	private Persistencia p;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaRegistroCuentaCorriente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el numero bancario");
		lblNewLabel.setBounds(27, 37, 196, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha de creacion");
		lblIngreseLaFecha.setBounds(27, 92, 175, 14);
		contentPane.add(lblIngreseLaFecha);
		
		tfNumeroBancarioC = new JTextField();
		tfNumeroBancarioC.setBounds(257, 34, 146, 20);
		contentPane.add(tfNumeroBancarioC);
		tfNumeroBancarioC.setColumns(10);
		
		tfFechaCreacionC = new JTextField();
		tfFechaCreacionC.setBounds(257, 89, 146, 20);
		contentPane.add(tfFechaCreacionC);
		tfFechaCreacionC.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(tfMontoC.getText());
				cc=new CuentaCorriente(tfNumeroBancarioC.getText(), tfFechaCreacionC.getText(), a);
				p =new Persistencia();
				try {
					p.registroCorriente(tfNumeroBancarioC.getText(), tfFechaCreacionC.getText(), a);
					JOptionPane.showMessageDialog(null,"Cuenta corriente creada con exito gracias por elegir nuestro banco");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vlu=new VentanaLoginUsuario();
				vlu.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrar.setBounds(153, 212, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el monto inicial");
		lblNewLabel_1.setBounds(27, 148, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		tfMontoC = new JTextField();
		tfMontoC.setBounds(257, 145, 146, 20);
		contentPane.add(tfMontoC);
		tfMontoC.setColumns(10);
	}
}

