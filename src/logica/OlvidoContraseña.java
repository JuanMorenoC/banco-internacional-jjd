package logica;

import interfaz.VentanaPrincipalBanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class OlvidoContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField tfRespuesta;
	private JTextField tfContraseña;
	private JTextField tfNueva;
	private Persistencia p;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public OlvidoContraseña(String pregunta, String usuario) throws IOException 
	{
		p = new Persistencia();
		String preg = pregunta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			VentanaPrincipalBanco vpb = new VentanaPrincipalBanco();
			vpb.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(267, 332, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnCambiarContrasea = new JButton("CAMBIAR CONTRASE\u00D1A");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					if(p.validarRespuesta(tfRespuesta.getText()) == true)
					{
						if(tfContraseña.getText().equals(tfNueva.getText()))
						{
							if(!tfContraseña.getText().equals("") && !tfNueva.getText().equals("") && !tfRespuesta.getText().equals(""))
							{
									p.modificarContraseña(usuario,tfContraseña.getText());
							JOptionPane.showMessageDialog(null, "contraseña Guardada");
							tfContraseña.setText("");
							tfNueva.setText("");
							tfRespuesta.setText("");
							}else
							{
								JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
								tfContraseña.setText("");
								tfNueva.setText("");
								tfRespuesta.setText("");
							}
						
						}else
						{
							JOptionPane.showMessageDialog(null, "las contraseñas no coinsiden o la respuesta a la pregunta no es valida");
							tfContraseña.setText("");
							tfNueva.setText("");
							tfRespuesta.setText("");
						}
					}else
					{
						JOptionPane.showMessageDialog(null, "La respuesta a la pregunta no es valida");
						tfContraseña.setText("");
						tfNueva.setText("");
						tfRespuesta.setText("");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCambiarContrasea.setBounds(43, 332, 182, 23);
		contentPane.add(btnCambiarContrasea);
		
		JLabel lblPregunta = DefaultComponentFactory.getInstance().createLabel("PREGUNTA");
		lblPregunta.setBounds(43, 71, 92, 14);
		contentPane.add(lblPregunta);
		
		JLabel lblRespuesta = DefaultComponentFactory.getInstance().createLabel("RESPUESTA");
		lblRespuesta.setBounds(43, 123, 92, 14);
		contentPane.add(lblRespuesta);
		
		tfRespuesta = new JTextField();
		tfRespuesta.setBounds(167, 120, 217, 20);
		contentPane.add(tfRespuesta);
		tfRespuesta.setColumns(10);
		
		JLabel lblContraseaNueva = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A NUEVA");
		lblContraseaNueva.setBounds(43, 187, 133, 14);
		contentPane.add(lblContraseaNueva);
		
		tfContraseña = new JTextField();
		tfContraseña.setBounds(200, 184, 184, 20);
		contentPane.add(tfContraseña);
		tfContraseña.setColumns(10);
		
		tfNueva = new JTextField();
		tfNueva.setColumns(10);
		tfNueva.setBounds(200, 229, 184, 20);
		contentPane.add(tfNueva);
		
		JLabel lblRepitaContrasea = DefaultComponentFactory.getInstance().createLabel("REPITA CONTRASE\u00D1A");
		lblRepitaContrasea.setBounds(43, 232, 147, 14);
		contentPane.add(lblRepitaContrasea);
		
	
		JLabel lblIohwefhoiwef = DefaultComponentFactory.getInstance().createLabel("" + p.buscarPregunta(usuario));
		lblIohwefhoiwef.setBounds(167, 71, 205, 14);
		contentPane.add(lblIohwefhoiwef);
	}
}
