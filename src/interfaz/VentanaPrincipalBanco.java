package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.security.auth.login.Configuration;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import logica.OlvidoContraseña;
import logica.Persistencia;
import logica.VentanaLoginUsuario;

import java.awt.Color;
import java.awt.Font;
public class VentanaPrincipalBanco extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfContraseña;
	public VentanaRegistrar vr;
	public VentanaRegistrarEmpresa vre;
	ResourceBundle m;
	String idioma;
	OlvidoContraseña oc;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalBanco frame = new VentanaPrincipalBanco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaPrincipalBanco() {
		
		
		setTitle("BANCO");
		 Persistencia p = new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(34, 70, 74, 14);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(118, 67, 175, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(34, 106, 74, 14);
		contentPane.add(lblContrasea);
		
		tfContraseña = new JTextField();
		tfContraseña.setBounds(118, 103, 175, 20);
		contentPane.add(tfContraseña);
		tfContraseña.setColumns(10);
		
		JLabel lblLogin = new JLabel("BANCO INTERNACIONAL JJD");
		lblLogin.setBackground(Color.ORANGE);
		lblLogin.setFont(new Font("Algerian", Font.ITALIC, 16));
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setBounds(87, 27, 245, 14);
		contentPane.add(lblLogin);
		
		JComboBox comboTipoUsuario = new JComboBox();
		comboTipoUsuario.setBounds(118, 134, 175, 20);
		comboTipoUsuario.addItem("--------");
		comboTipoUsuario.addItem("Cliente");
		comboTipoUsuario.addItem("Administrador");
		comboTipoUsuario.addItem("Empresa");
		contentPane.add(comboTipoUsuario);
		
		JButton btnIniciarSeccion = new JButton("Iniciar Seccion");
		btnIniciarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean verificar = false;
				try 
				{
					String tipo = (String) comboTipoUsuario.getSelectedItem();
					if(!tfUsuario.getText().equals("") && !tfContraseña.getText().equals(""))
					{
						if (tipo.equalsIgnoreCase("Cliente") && p.validarSeccionPersona(tfUsuario.getText(),tfContraseña.getText()) == true) 
					{
						verificar=true;
						VentanaLoginUsuario vlu = new VentanaLoginUsuario();
						vlu.setVisible(true);
						setVisible(false);
				    }else
					{
						if (tipo.equalsIgnoreCase("Empresa") && p.validarSeccionEmpresa(tfUsuario.getText(),tfContraseña.getText()) == true) 
						{
							VentanaLoginEmpresa vle = new VentanaLoginEmpresa();
							vle.setVisible(true);
							setVisible(false);
							verificar=true;
						}
							else
						{
							if (tipo.equalsIgnoreCase("Administrador") && p.validarSeccionAdministrador(tfUsuario.getText(),
									tfContraseña.getText()) == true) 
							{
								VentanaLoginAdministrador vla= new VentanaLoginAdministrador();
								vla.setVisible(true);
								setVisible(false);
								verificar=true;
							
						}
							else
						{
							if(verificar == false)
							{
								JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
							}
							
						}
					}
						}
					}else
					{
							JOptionPane.showMessageDialog(null, "llene los campos por favor");
					}
					
				} catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				}
			}
		});
		btnIniciarSeccion.setBounds(34, 196, 173, 23);
		contentPane.add(btnIniciarSeccion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String tipo = (String) comboTipoUsuario.getSelectedItem();
				if(tipo.equalsIgnoreCase("Cliente") || tipo.equalsIgnoreCase("Administrador"))
				{					
					String cadena= tipo;
					vr = new VentanaRegistrar(cadena);
					vr.setVisible(true);
					setVisible(false);
				}else
				{
					if(tipo.equalsIgnoreCase("Empresa"))
					{
						vre = new VentanaRegistrarEmpresa();
						vre.setVisible(true);
						setVisible(false);
					}else
					{
						JOptionPane.showMessageDialog(null, "Seleccione una opcion");
					}
				}
				
			}
		});
		btnRegistrar.setBounds(234, 196, 148, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnolvidoContrasea = new JButton("\u00BFOlvido Contrase\u00F1a?");
		btnolvidoContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try 
				{
					String tipo = (String) comboTipoUsuario.getSelectedItem();
					if (tipo.equalsIgnoreCase("Cliente") && p.validarUsuario(tfUsuario.getText())== true)
					{
						
						oc= new OlvidoContraseña(p.buscarPregunta(tfUsuario.getText()), tfContraseña.getText());
					    oc.setVisible(true);
					    setVisible(false);
						
							
					}else
					{
							if (tipo.equalsIgnoreCase("administrador") && p.validarUsuario(tfUsuario.getText())== true)
							{
								
							}else
							{
								JOptionPane.showMessageDialog(null, "INGRESE EL USUARIO COMO  MINIMO"+JOptionPane.WARNING_MESSAGE);
								tfContraseña.setText("");
								tfUsuario.setText("");
							}
						}
					
				}catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		btnolvidoContrasea.setBounds(34, 256, 173, 23);
		contentPane.add(btnolvidoContrasea);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(234, 256, 148, 23);
		contentPane.add(btnSalir);
	}

}
