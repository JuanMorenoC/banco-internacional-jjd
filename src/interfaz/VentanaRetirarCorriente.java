package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import logica.Persistencia;

public class VentanaRetirarCorriente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroBancario;
	private JTextField tfCantidad;


	public VentanaRetirarCorriente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElMonto = DefaultComponentFactory.getInstance().createLabel("ingrese el monto a retirar");
		lblIngreseElMonto.setBounds(53, 104, 164, 14);
		contentPane.add(lblIngreseElMonto);
		
		tfNumeroBancario = new JTextField();
		tfNumeroBancario.setBounds(250, 52, 146, 20);
		contentPane.add(tfNumeroBancario);
		tfNumeroBancario.setColumns(10);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Numero bancario");
		lblNewJgoodiesLabel.setBounds(53, 55, 132, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(250, 101, 146, 20);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);
		
		JButton btnRetirar = new JButton("RETIRAR");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double cantidad = Double.parseDouble(tfCantidad.getText());
				Persistencia p = new Persistencia();
				try {
					p.retirar(tfNumeroBancario.getText(), cantidad);
					tfCantidad.setText("");
					tfNumeroBancario.setText("");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRetirar.setBounds(107, 184, 89, 23);
		contentPane.add(btnRetirar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			VentanaCuentaCorriente vcc = new VentanaCuentaCorriente();
			vcc.setVisible(true);
			setVisible(false);
			}
		});
		btnVolver.setBounds(256, 184, 89, 23);
		contentPane.add(btnVolver);
	}
}
