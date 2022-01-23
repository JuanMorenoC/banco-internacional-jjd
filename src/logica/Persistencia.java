package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import logica.CuentaCorriente;
import logica.CDT;
import logica.CuentaCorriente;

public class Persistencia {
	private BufferedWriter bw;
	private BufferedReader br;
	private FileReader archivoEntrada;
	private FileWriter fw;
	private ArrayList<Cliente> cliente;
	private ArrayList<String> usuarios;
	private ArrayList<String> claves;
	public FileOutputStream fos;
	public ObjectOutputStream oos;
	public FileInputStream fis;
	public ObjectInputStream ois;
	public Cliente c;
	private String nombre;
	private String apellido;
	private String cedula;
	private String usuario;
	private String contraseña;
	private String pregunta;
	private String respuesta;
	private char sexo;
	private FileWriter archivoSalida;
	private ArrayList<CuentaAhorro> cuentaAhorro;
	private File archivo, archivo2, archivo3, archivo4, archivo5, archivo6;
	private double porcentajeIntereses;
	private ArrayList<CuentaCorriente> cuentaCorriente;
	private ArrayList<CDT> CDT;
	private CuentaNomina cn;
	private ArrayList<CuentaNomina> cuentaN = new ArrayList<>();
	

	public Persistencia() {
		cliente = new ArrayList();
		usuarios = new ArrayList<String>();
		claves = new ArrayList<String>();
		archivo = new File("RegistroPersona.txt");
		archivo2 = new File("RegistroAdministrador.txt");

		cuentaAhorro = new ArrayList<>();
		archivo3 = new File("CuentaAhorro.txt");

		cuentaCorriente = new ArrayList<>();
		archivo4 = new File("CuentaCorriente.txt");

		archivo5 = new File("CDT'S.txt");
		CDT = new ArrayList<>();

		archivo6 = new File("CuentaNomina.txt");

	}

	public String mostrarCuentaNomina(String nroCuentaABuscar) throws IOException, ClassNotFoundException {
		fis = new FileInputStream(archivo6);
		ois = new ObjectInputStream(fis);
		cuentaN = (ArrayList<CuentaNomina>) ois.readObject();
		ois.close();
		String mostrar = "";
		for (int i = 0; i < cuentaN.size(); i++) {
			if (cuentaN.get(i).getNumeroCuenta().equals(nroCuentaABuscar)) {
				mostrar = cuentaN.get(i).getNumeroCuenta() + ";" + cuentaN.get(i).getFechaCreacion() + ";"
						+ cuentaN.get(i).getMonto();
			}

		}
		return mostrar;
		// +cuentaN.get(i).getCh().getNumeroBancario()+";"+cuentaN.get(i).getCc().getNumeroBancario()+";"
	}

	public void registroNomina(String numeroCuenta, String fechaCreacion, double monto)
			throws IOException, ClassNotFoundException {

		cn = new CuentaNomina(numeroCuenta, fechaCreacion, monto);
		cuentaN.add(cn);
		fos = new FileOutputStream(archivo6);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(cuentaN);
		oos.close();

	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * 
	 */
	public void consignarNomina(String nroCuentaBancaria, double montoAConsignar)
			throws IOException, ClassNotFoundException {
		ArrayList<CuentaAhorro> cuentaH = new ArrayList<>();
		ArrayList<CuentaCorriente> cuentaC = new ArrayList<>();
		fis = new FileInputStream(archivo3);
		ois = new ObjectInputStream(fis);
		cuentaH = (ArrayList<CuentaAhorro>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaH.size(); i++) {
			if (cuentaH.get(i).getNumeroBancario().equals(nroCuentaBancaria)) {
				double k = cuentaH.get(i).getMonto() + montoAConsignar;
				cuentaH.get(i).setMonto(k);
				fos = new FileOutputStream(archivo3);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaH);
				oos.close();

				fis = new FileInputStream(archivo6);
				ois = new ObjectInputStream(fis);
				cuentaN = (ArrayList<CuentaNomina>) ois.readObject();
				ois.close();
				double mo = cuentaN.get(i).getMonto() - montoAConsignar;
				cuentaN.get(i).setMonto(mo);
				System.out.println(cuentaN.get(i).getMonto());
				fos = new FileOutputStream(archivo6);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaN);
				oos.close();

			}
		}
		fis = new FileInputStream(archivo4);
		ois = new ObjectInputStream(fis);
		cuentaC = (ArrayList<CuentaCorriente>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaC.size(); i++) {
			if (cuentaC.get(i).getNumeroBancario().equals(nroCuentaBancaria)) {
				double k = cuentaC.get(i).getConsignacion() + montoAConsignar;
				cuentaC.get(i).setConsignacion(k);
				fos = new FileOutputStream(archivo4);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaC);
				oos.close();

				fis = new FileInputStream(archivo6);
				ois = new ObjectInputStream(fis);
				cuentaN = (ArrayList<CuentaNomina>) ois.readObject();
				ois.close();
				double mo = cuentaN.get(i).getMonto() - montoAConsignar;
				cuentaN.get(i).setMonto(mo);
				System.out.println(cuentaN.get(i).getMonto());
				fos = new FileOutputStream(archivo6);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaN);
				oos.close();
			}
			
		}
	}

	public void crearCDT(String usuario, String cedula, double montoInversion, String fechaCreacion, int duracion,
			int porcentaje, String tipoPago) throws IOException {
		CDT ejem = new CDT(usuario, cedula, montoInversion, fechaCreacion, duracion, porcentaje, tipoPago);

		CDT.add(ejem);
		fos = new FileOutputStream(archivo5);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(CDT);
		oos.close();
	}

	public double mostrarGanancia(String cedula) throws IOException, ClassNotFoundException {
		fis = new FileInputStream(archivo5);
		ois = new ObjectInputStream(fis);
		CDT = (ArrayList<CDT>) ois.readObject();
		ois.close();
		double a = 0;
		for (int i = 0; i < CDT.size(); i++) {

			if (CDT.get(i).getCedula().equals(cedula)) {
				a = ((CDT.get(i).getMontoInversion() / 100) * (100 + CDT.get(i).getPorcentaje()))
						* CDT.get(i).getDuracion();
				CDT.get(i).setMontoInversion(a);
				JOptionPane.showMessageDialog(null,
						"Tu ganancia es de: \n " + "   " + (CDT.get(i).getMontoInversion()));
				fos = new FileOutputStream(archivo5);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(CDT);
				oos.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuario invalido VERIFIQUE" + JOptionPane.WARNING_MESSAGE);
			}
		}
		return a;
	}

	public void retirar(String numeroBancario, double cantidad) throws ClassNotFoundException, IOException {

		fis = new FileInputStream(archivo4);
		ois = new ObjectInputStream(fis);
		cuentaCorriente = (ArrayList<CuentaCorriente>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaCorriente.size(); i++) {
			if (cuentaCorriente.get(i).getNumeroBancario().equals(numeroBancario)) {
				double a = cuentaCorriente.get(i).getMonto() - cantidad;
				cuentaCorriente.get(i).setMonto(a);
				JOptionPane.showMessageDialog(null,
						"La cuenta cuenta con un saldo de: " + cuentaCorriente.get(i).getMonto());
				fos = new FileOutputStream(archivo4);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaCorriente);
				oos.close();
			}

		}
	}

	public void cuotaManejo(String numeroBancario) throws ClassNotFoundException, IOException {
		fis = new FileInputStream(archivo4);
		ois = new ObjectInputStream(fis);
		cuentaCorriente = (ArrayList<CuentaCorriente>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaCorriente.size(); i++) {
			if (cuentaCorriente.get(i).getNumeroBancario().equals(numeroBancario)) {
				double a = cuentaCorriente.get(i).getMonto() - 5000;
				cuentaCorriente.get(i).setMonto(a);
				System.out.println(cuentaCorriente.get(i).getMonto());
				fos = new FileOutputStream(archivo4);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaCorriente);
				oos.close();
			}

		}

	}

	public void registroCorriente(String numeroBancario, String fechaCreacion, double monto)
			throws ClassNotFoundException, IOException {
		CuentaCorriente cu = new CuentaCorriente(numeroBancario, fechaCreacion, monto);
		cuentaCorriente.add(cu);
		fos = new FileOutputStream(archivo4);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(cuentaCorriente);
		oos.close();
	}

	public void consignarCorriente(String numeroBancario, double cantidad) throws ClassNotFoundException, IOException {
		fis = new FileInputStream(archivo4);
		ois = new ObjectInputStream(fis);
		cuentaCorriente = (ArrayList<CuentaCorriente>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaCorriente.size(); i++) {
			if (cuentaCorriente.get(i).getNumeroBancario().equals(numeroBancario)) {
				double a = cuentaCorriente.get(i).getMonto() + cantidad;
				cuentaCorriente.get(i).setMonto(a);
				JOptionPane.showMessageDialog(null,
						"El dinero con el que cuenta ahora la cuenta es: " + (cuentaCorriente.get(i).getMonto()));
				fos = new FileOutputStream(archivo4);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaCorriente);
				oos.close();
			}

		}
	}

	public void registroAhorros(String numeroBancario, String fechaCreacion, double monto) throws IOException {
		CuentaAhorro cu = new CuentaAhorro(numeroBancario, fechaCreacion, monto);
		cuentaAhorro.add(cu);
		fos = new FileOutputStream(archivo3);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(cuentaAhorro);
		oos.close();
	}

	public void consignar(String numeroBancario, double montoConsignar) throws ClassNotFoundException, IOException {
		fis = new FileInputStream(archivo3);
		ois = new ObjectInputStream(fis);
		cuentaAhorro = (ArrayList<CuentaAhorro>) ois.readObject();
		ois.close();
		for (int i = 0; i < cuentaAhorro.size(); i++) {
			if (cuentaAhorro.get(i).getNumeroBancario().equals(numeroBancario)) {
				double a = cuentaAhorro.get(i).getMonto() + montoConsignar;
				cuentaAhorro.get(i).setMonto(a);

				fos = new FileOutputStream(archivo3);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(cuentaAhorro);
				oos.close();
				JOptionPane.showMessageDialog(null,
						"El dinero con el que cuenta ahora la cuenta es: " + cuentaAhorro.get(i).getMonto());
			} else {
				JOptionPane.showMessageDialog(null, "La consignacion no se realizo numeor de cuenta invalido: ");
			}

		}
	}

	public void almacenarDatosCliente(String archivo2, String nombre, String apellido, char sexo, String cedula,
			String usuario, String contraseña, String pregunta, String respuesta) throws IOException {

		FileWriter archivoSalida;

		String registroUsuario = nombre + ";" + apellido + ";" + sexo + ";" + cedula + ";" + usuario + ";" + contraseña
				+ ";" + pregunta + ";" + respuesta;

		archivoSalida = new FileWriter(archivo2, true);
		bw = new BufferedWriter(archivoSalida);
		bw.write(registroUsuario);
		bw.newLine();
		bw.close();
		usuarios.add(usuario);
		claves.add(contraseña);
	}

	public void almacenarDatosEmpresa(String razonSocial, String Nit) throws IOException {

		String registroUsuario = razonSocial + ";" + Nit;

		archivoSalida = new FileWriter("RegistroEmpresa.txt", true);
		bw = new BufferedWriter(archivoSalida);
		bw.write(registroUsuario);
		bw.newLine();
		bw.close();

	}

	public void almacenarDatosAdministrador(String archivo2, String nombre, String apellido, char sexo, String cedula,
			String usuario, String contraseña, String pregunta, String respuesta) throws IOException {

		FileWriter archivoSalida;

		String registroUsuario = nombre + ";" + apellido + ";" + sexo + ";" + cedula + ";" + usuario + ";" + contraseña
				+ ";" + pregunta + ";" + respuesta;

		archivoSalida = new FileWriter(archivo2, true);
		bw = new BufferedWriter(archivoSalida);
		bw.write(registroUsuario);
		bw.newLine();
		bw.close();
	}

	public boolean validarSeccionPersona(String usuario, String clave) throws IOException {

		String pregunta = "";
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		long numLineas = 0;

		while ((cadena = br.readLine()) != null) {
			if (cadena.contains(usuario) && cadena.contains(clave)) {
				return true;
			}

		}

		br.close();
		return false;

	}

	public boolean validarSeccionEmpresa(String usuario, String clave) throws IOException {
		FileReader archivoEntrada = new FileReader("RegistroEmpresa.txt");
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		while ((cadena = br.readLine()) != null) {
			if (cadena.contains(usuario) && cadena.contains(clave)) {
				return true;
			}
		}
		br.close();
		return false;
	}

	public boolean validarSeccionAdministrador(String usuario, String clave) throws IOException {
		FileReader archivoEntrada = new FileReader("RegistroAdministrador.txt");
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		while ((cadena = br.readLine()) != null) {
			if (cadena.contains(usuario) && cadena.contains(clave)) {
				return true;
			}
		}
		br.close();
		return false;
	}

	public boolean validarUsuario(String usuario) throws IOException {
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		long numLineas = 0;

		while ((cadena = br.readLine()) != null) {
			if (cadena.contains(usuario)) {
				return true;
			}

		}

		br.close();
		return false;
	}

	public String buscarPregunta(String usuario) throws IOException {
		String pregunta = "";
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		long numLineas = 0;

		while ((cadena = br.readLine()) != null) {
			String cad[] = cadena.split(";");
			numLineas++;

			for (int i = 0; i < numLineas; i++) {
				if (cadena.contains(usuario)) {
					pregunta = cad[6];
				}

			}

		}

		br.close();
		return pregunta;
	}

	public void modificar(String nombre, String apellido, char sexo, String cedula, String usuario, String contraseña,
			String pregunta, String respuesta) throws IOException {
		String cadena = "";
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		ArrayList<String> cad = new ArrayList<String>();
		while ((cadena = br.readLine()) != null) {
			if (!cadena.contains(cedula)) {
				cad.add(cadena);
			} else {
				cad.add(nombre + ";" + apellido + ";" + sexo + ";" + cedula + ";" + usuario + ";" + contraseña + ";"
						+ pregunta + ";" + respuesta);
			}
		}
		for (int i = 0; i < cad.size(); i++) {
			if (i == 0) {
				archivo = new File("RegistroPersona.txt");
				fw = new FileWriter(archivo);
				bw = new BufferedWriter(fw);
				bw.write(cad.get(i));
				bw.newLine();
				bw.close();
			} else {
				archivo = new File("RegistroPersona.txt");
				fw = new FileWriter(archivo, true);
				bw = new BufferedWriter(fw);
				bw.write(cad.get(i));
				bw.newLine();
				bw.close();
			}
		}

	}

	public boolean validarRespuesta(String respuesta) throws IOException {
		String pregunta = "";
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		String cadena = "";
		long numLineas = 0;

		while ((cadena = br.readLine()) != null) {
			if (cadena.contains(respuesta)) {
				return true;
			}
		}

		br.close();
		return false;
	}

	public void modificarContraseña(String usuario, String contraseña) throws IOException, ClassNotFoundException {

		String cadena = "";
		archivoEntrada = new FileReader(archivo);
		br = new BufferedReader(archivoEntrada);
		ArrayList<String> cad = new ArrayList<String>();
		long numLineas = 0;
		while ((cadena = br.readLine()) != null) {
			String arreglo[] = cadena.split(";");
			numLineas++;

			if (!cadena.contains(usuario)) {
				cad.add(cadena);
			} else {
				nombre = arreglo[0];
				apellido = arreglo[1];
				sexo = arreglo[2].charAt(0);
				cedula = arreglo[3];
				usuario = arreglo[4];
				pregunta = arreglo[6];
				respuesta = arreglo[7];
				cad.add(nombre + ";" + apellido + ";" + sexo + ";" + cedula + ";" + usuario + ";" + contraseña + ";"
						+ pregunta + ";" + respuesta);
			}

		}
		for (int i = 0; i < cad.size(); i++) {
			if (i == 0) {
				archivo = new File("RegistroPersona.txt");
				fw = new FileWriter(archivo);
				bw = new BufferedWriter(fw);
				bw.write(cad.get(i));
				bw.newLine();
				bw.close();
			} else {
				archivo = new File("RegistroPersona.txt");
				fw = new FileWriter(archivo, true);
				bw = new BufferedWriter(fw);
				bw.write(cad.get(i));
				bw.newLine();
				bw.close();
			}
		}
	}
}
