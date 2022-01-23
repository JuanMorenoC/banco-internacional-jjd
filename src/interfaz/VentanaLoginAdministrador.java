package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class VentanaLoginAdministrador extends JFrame {

	private JPanel contentPane;

	public VentanaLoginAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVentanaAdministrador = DefaultComponentFactory.getInstance().createLabel("VENTANA");
		lblVentanaAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblVentanaAdministrador.setBounds(113, 38, 215, 78);
		contentPane.add(lblVentanaAdministrador);
		
		JLabel lblAdministrador = DefaultComponentFactory.getInstance().createLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdministrador.setBounds(85, 152, 283, 40);
		contentPane.add(lblAdministrador);
	}
}
