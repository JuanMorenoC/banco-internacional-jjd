package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import logica.Registro;

public class VentanaRegistrar extends JFrame {

	private JPanel contentPane;
	public JTextField tfNombre;
	public JTextField tfCedula;
	public JTextField tfFechaNac;
	public JTextField tfUsuario;
	public JTextField tfContraseña;
	public JTextField tfRespuesta;
	private ResourceBundle m;
	private VentanaPrincipalBanco vbp;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCedula;
	private JLabel lblFechaNac;
	private JLabel lblSexo;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JLabel lblPreguntaDeSeguridad;
	private JLabel lblRespuesta;
	private JButton btnRegistrar;
	private JButton btnVolver;
	public JComboBox comboSexo = new JComboBox();
	public JComboBox comboSeg = new JComboBox();
	public JTextField tfApellido;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRegistrar(String cadena) 
	{
		setTitle("REGISTRAR");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 559, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 28, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(170, 25, 215, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 59, 46, 14);
		contentPane.add(lblApellido);	
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(28, 95, 46, 14);
		contentPane.add(lblCedula);
		
		tfCedula = new JTextField();
		tfCedula.setBounds(170, 92, 215, 20);
		contentPane.add(tfCedula);
		tfCedula.setColumns(10);
		
		lblFechaNac = new JLabel("Fecha de Nacimiento:");
		lblFechaNac.setBounds(28, 123, 144, 14);
		contentPane.add(lblFechaNac);
		
		tfFechaNac = new JTextField();
		tfFechaNac.setBounds(170, 120, 139, 20);
		contentPane.add(tfFechaNac);
		tfFechaNac.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(28, 169, 46, 14);
		contentPane.add(lblSexo);
		
		lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(28, 220, 101, 14);
		contentPane.add(lblNombreDeUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(170, 217, 177, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(28, 256, 86, 14);
		contentPane.add(lblContrasea);
		
		tfContraseña = new JTextField();
		tfContraseña.setBounds(170, 253, 215, 20);
		contentPane.add(tfContraseña);
		tfContraseña.setColumns(10);
		
	    comboSexo = new JComboBox();
		comboSexo.setBounds(170, 166, 139, 20);
		comboSexo.addItem("--------");
		comboSexo.addItem("Masculino");
		comboSexo.addItem("Femenino");
		contentPane.add(comboSexo);
		
		lblPreguntaDeSeguridad = new JLabel("Pregunta de Seguridad:");
		lblPreguntaDeSeguridad.setBounds(28, 287, 158, 14);
		contentPane.add(lblPreguntaDeSeguridad);
		
	    comboSeg = new JComboBox();
		comboSeg.setBounds(170, 284, 265, 20);
		comboSeg.addItem("---------");
		comboSeg.addItem("¿Cual es su Nickname?");
		comboSeg.addItem("¿Cual fue el primer nombre de su mascota?");
		comboSeg.addItem("¿Como se llama el colegio en que se graduo?");
		contentPane.add(comboSeg);
		
		lblRespuesta = new JLabel("Respuesta:");
		lblRespuesta.setBounds(28, 312, 111, 14);
		contentPane.add(lblRespuesta);
		
		tfRespuesta = new JTextField();
		tfRespuesta.setBounds(170, 309, 185, 20);
		contentPane.add(tfRespuesta);
		tfRespuesta.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			try {
				char sexo = comboSexo.getSelectedItem().toString().charAt(0);
				String sexo1= (String) comboSexo.getSelectedItem();
				String pregunta = (String) comboSeg.getSelectedItem();
				
				if(!tfApellido.getText().equals("") && !tfCedula.getText().equals("")&& !tfContraseña.getText().equals("")&&
						!tfFechaNac.getText().equals("")&& !tfNombre.getText().equals("") && !tfRespuesta.getText().equals("") &&
						!tfUsuario.getText().equals("") && !sexo1.equals("") && !pregunta.equals(""))
			        	{
		
					Registro r= new Registro();
					
					
					r.registroPersona(cadena, tfNombre.getText(), tfApellido.getText(), sexo , tfCedula.getText(), tfUsuario.getText(),
							tfContraseña.getText(), comboSeg.getSelectedItem().toString(), tfRespuesta.getText());
					
					tfApellido.setText("");
					tfUsuario.setText("");
					tfCedula.setText("");
					tfContraseña.setText("");
					tfFechaNac.setText("");
					tfNombre.setText("");
					tfRespuesta.setText("");

			        	}else
			        	{
			        		JOptionPane.showMessageDialog(null, "POR FAVOR LLENE TODOS LOS CAMPOS NO SEA BESTIA"  + JOptionPane.WARNING_MESSAGE);
			        		tfApellido.setText("");
							tfUsuario.setText("");
							tfCedula.setText("");
							tfContraseña.setText("");
							tfFechaNac.setText("");
							tfNombre.setText("");
							tfRespuesta.setText("");
			        	}
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		btnRegistrar.setBounds(156, 343, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				VentanaPrincipalBanco vpb = new VentanaPrincipalBanco();
				vpb.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(258, 343, 89, 23);
		contentPane.add(btnVolver);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(170, 56, 215, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
	}
}
