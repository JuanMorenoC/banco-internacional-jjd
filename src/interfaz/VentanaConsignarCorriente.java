package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaCorriente;
import logica.Persistencia;
import logica.VentanaLoginUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaConsignarCorriente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroConsignar;
	private JTextField tfMontoAConsignar;
	private VentanaLoginUsuario vlu;
	private Persistencia p;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaConsignarCorriente() {
		
		p= new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsignaciones = new JLabel("CONSIGNACIONES");
		lblConsignaciones.setForeground(Color.ORANGE);
		lblConsignaciones.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblConsignaciones.setBounds(92, 11, 281, 41);
		contentPane.add(lblConsignaciones);
		
		JLabel lblNumeroBancarioA = new JLabel("Numero bancario a consignar");
		lblNumeroBancarioA.setBounds(21, 89, 252, 14);
		contentPane.add(lblNumeroBancarioA);
		
		JLabel lblCantidadAConsignar = new JLabel("Cantidad a consignar");
		lblCantidadAConsignar.setBounds(21, 146, 174, 14);
		contentPane.add(lblCantidadAConsignar);
		
		tfNumeroConsignar = new JTextField();
		tfNumeroConsignar.setBounds(235, 86, 174, 20);
		contentPane.add(tfNumeroConsignar);
		tfNumeroConsignar.setColumns(10);
		
		tfMontoAConsignar = new JTextField();
		tfMontoAConsignar.setBounds(235, 143, 174, 20);
		contentPane.add(tfMontoAConsignar);
		tfMontoAConsignar.setColumns(10);
		
		JButton btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(tfMontoAConsignar.getText());
				try {
					p.consignarCorriente(tfNumeroConsignar.getText(), a);
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
		btnConsignar.setBounds(73, 191, 136, 23);
		contentPane.add(btnConsignar);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			VentanaLoginUsuario vlu = new VentanaLoginUsuario();
			vlu.setVisible(true);
			setVisible(false);
			
			}
		});
		btnNewButton.setBounds(258, 191, 129, 23);
		contentPane.add(btnNewButton);
	}

}