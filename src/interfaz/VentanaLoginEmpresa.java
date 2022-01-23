package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLoginEmpresa extends JFrame {

	private JPanel contentPane;

	public VentanaLoginEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpresaEn = DefaultComponentFactory.getInstance().createLabel("EMPRESA EN ");
		lblEmpresaEn.setForeground(Color.RED);
		lblEmpresaEn.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblEmpresaEn.setBounds(45, 25, 349, 86);
		contentPane.add(lblEmpresaEn);
		
		JLabel lblMantenimiento = DefaultComponentFactory.getInstance().createLabel("MANTENIMIENTO");
		lblMantenimiento.setForeground(Color.RED);
		lblMantenimiento.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMantenimiento.setBounds(96, 122, 247, 61);
		contentPane.add(lblMantenimiento);
		
		JButton btnRegistrarNomina = new JButton("Nomina");
		btnRegistrarNomina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			ventanaCuentaNomina vcn = new ventanaCuentaNomina();
			vcn.setVisible(true);
			setVisible(false);
			}
		});
		btnRegistrarNomina.setBounds(145, 190, 140, 23);
		contentPane.add(btnRegistrarNomina);
	}
}
