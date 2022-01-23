package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaNomina;
import logica.Persistencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class VentanaConsignarNomina extends JFrame {

	private JPanel contentPane;
	private JTextField tfCantidadAConsignar;
	private String datos="";
	private ventanaCuentaNomina vn;
	private Persistencia p;
	private JTextField tfNumeroConsignar;


	/**
	 * Create the frame.
	 */
	public VentanaConsignarNomina()
	{
		p =new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsignacionesNomina = new JLabel("Consignaciones Nomina");
		lblConsignacionesNomina.setBounds(133, 21, 142, 14);
		contentPane.add(lblConsignacionesNomina);
		
//		JButton btnIngresarNumeroDe = new JButton("Ingresar numero de cuentas asociadas ");
//		btnIngresarNumeroDe.addActionListener(new ActionListener() {
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
//		btnIngresarNumeroDe.setBounds(24, 63, 332, 23);
//		contentPane.add(btnIngresarNumeroDe);
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de dinero a consignar");
		lblIngreseLaCantidad.setBounds(24, 119, 238, 14);
		contentPane.add(lblIngreseLaCantidad);
		
		tfCantidadAConsignar = new JTextField();
		tfCantidadAConsignar.setBounds(279, 116, 166, 20);
		contentPane.add(tfCantidadAConsignar);
		tfCantidadAConsignar.setColumns(10);
		
		JButton btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double a=Double.parseDouble(tfCantidadAConsignar.getText());
				try {
					p.consignarNomina(tfNumeroConsignar.getText(), a);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Consignacion exitosa");
				vn=new ventanaCuentaNomina();
				vn.setVisible(true);
				setVisible(false);
			}
		});
		btnConsignar.setBounds(179, 186, 96, 23);
		contentPane.add(btnConsignar);
		
		JLabel lblIngreseElNumero = DefaultComponentFactory.getInstance().createLabel("Ingrese el numero de cuenta a consignar");
		lblIngreseElNumero.setBounds(24, 64, 238, 14);
		contentPane.add(lblIngreseElNumero);
		
		tfNumeroConsignar = new JTextField();
		tfNumeroConsignar.setBounds(279, 61, 142, 20);
		contentPane.add(tfNumeroConsignar);
		tfNumeroConsignar.setColumns(10);
	}
}
