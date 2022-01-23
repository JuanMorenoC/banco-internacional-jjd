package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CuentaAhorro;
import logica.Persistencia;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaCosignacionesAhorro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroAConsignar;
	private JTextField tfMontoAConsignar;
	private Persistencia p ;
	private VentanaCuentaAhorro vca;

	public VentanaCosignacionesAhorro() {
		
		p=new Persistencia();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsignaciones = new JLabel("Consignaciones");
		lblConsignaciones.setBounds(164, 11, 111, 14);
		contentPane.add(lblConsignaciones);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de la cuenta a consignar");
		lblIngreseElNumero.setBounds(30, 70, 231, 14);
		contentPane.add(lblIngreseElNumero);
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de dineor a consignar");
		lblIngreseLaCantidad.setBounds(30, 128, 213, 14);
		contentPane.add(lblIngreseLaCantidad);
		
		tfNumeroAConsignar = new JTextField();
		tfNumeroAConsignar.setBounds(298, 67, 163, 20);
		contentPane.add(tfNumeroAConsignar);
		tfNumeroAConsignar.setColumns(10);
		
		tfMontoAConsignar = new JTextField();
		tfMontoAConsignar.setBounds(298, 125, 163, 20);
		contentPane.add(tfMontoAConsignar);
		tfMontoAConsignar.setColumns(10);
		
		JButton btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(tfMontoAConsignar.getText());
				try {
					p.consignar(tfNumeroAConsignar.getText(), a);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vca=new VentanaCuentaAhorro();
				vca.setVisible(true);
				setVisible(false);
			}
		});
		btnConsignar.setBounds(177, 176, 89, 23);
		contentPane.add(btnConsignar);
	}

}