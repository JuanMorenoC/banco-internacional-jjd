package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.omg.CORBA.PERSIST_STORE;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import logica.Persistencia;

public class VentanaRegistrarEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField tfRazon;
	private JTextField tfNit;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarEmpresa() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfRazon = new JTextField();
		tfRazon.setBounds(216, 48, 208, 20);
		contentPane.add(tfRazon);
		tfRazon.setColumns(10);
		
		tfNit = new JTextField();
		tfNit.setColumns(10);
		tfNit.setBounds(216, 115, 208, 20);
		contentPane.add(tfNit);
		
		JButton btnRegistrarEmpresa = new JButton("REGISTRAR EMPRESA");
		btnRegistrarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			Persistencia persistencia = new Persistencia();
			try {
				persistencia.almacenarDatosEmpresa(tfRazon.getText(), tfNit.getText());
				JOptionPane.showMessageDialog(null, "LA EMPRESA SE REGISTRO CON EXITO");
				tfNit.setText("");
				tfRazon.setText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnRegistrarEmpresa.setBounds(53, 186, 167, 23);
		contentPane.add(btnRegistrarEmpresa);
		
		JLabel lblRazonSocial = DefaultComponentFactory.getInstance().createLabel("RAZON SOCIAL");
		lblRazonSocial.setBounds(53, 51, 111, 14);
		contentPane.add(lblRazonSocial);
		
		JLabel lblNit = DefaultComponentFactory.getInstance().createLabel("NIT");
		lblNit.setBounds(53, 118, 92, 14);
		contentPane.add(lblNit);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			VentanaPrincipalBanco vpb = new VentanaPrincipalBanco();
			vpb.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(283, 186, 89, 23);
		contentPane.add(btnVolver);
	}
}
