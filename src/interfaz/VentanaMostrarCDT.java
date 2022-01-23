package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persistencia;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaMostrarCDT extends JFrame {

	private JPanel contentPane;
	private JTextField tfCedula;
	private Persistencia p;
	private VentanaCDT vcd;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaMostrarCDT() {
		p =new Persistencia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese la cedula de usuario");
		lblIngreseElNombre.setBounds(23, 57, 216, 14);
		contentPane.add(lblIngreseElNombre);
		
		tfCedula = new JTextField();
		tfCedula.setBounds(249, 54, 134, 20);
		contentPane.add(tfCedula);
		tfCedula.setColumns(10);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					p.mostrarGanancia(tfCedula.getText());
					tfCedula.setText("");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnMostrar.setBounds(72, 128, 102, 23);
		contentPane.add(btnMostrar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				vcd=new VentanaCDT();
				vcd.setVisible(true);
				setVisible(false);
			
			}
		});
		btnVolver.setBounds(267, 128, 89, 23);
		contentPane.add(btnVolver);
	}

}