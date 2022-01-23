package logica;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * 
 */
public class Registro extends Empresa {

	public File miArchivo, nuevoArchivo, Credito;
	public FileOutputStream fos;
	public ObjectOutputStream oos;
	public FileInputStream fis;
	public ObjectInputStream ois;
	public Cliente cliente;
	public ArrayList<Cliente> misClientes;
	
	  String formato;
	    Persistencia persistencia;
    public Registro() throws ClassNotFoundException, IOException   
    {
    
    	misClientes = new ArrayList();
		miArchivo = new File("clientes.txt");
		persistencia=new Persistencia();
		
    }

    public void registroPersona(String cadena, String nombre, String apellido, char sexo,
    		String cedula,String usuario, String contraseña,String pregunta,String respuesta) throws ClassNotFoundException, IOException {

        String archivoCliente = "RegistroPersona.txt";
        String archivoAdministrador = "RegistroAdministrador.txt";
        String Sexo = ""+sexo;
        

        try {
        	if(cadena.equalsIgnoreCase("cliente"))
        	{	
        		
        		 persistencia.almacenarDatosCliente(archivoCliente, nombre, apellido, sexo, cedula, 
                		usuario, contraseña, pregunta, respuesta);
                JOptionPane.showMessageDialog(null, "El registro se hizo correctamente");   
        	}else
        	{
        		if(cadena.equalsIgnoreCase("Administrador"))
        		{
        		persistencia.almacenarDatosAdministrador(archivoAdministrador, nombre, apellido, sexo, cedula,
        				usuario, contraseña, pregunta, respuesta);	
        		 JOptionPane.showMessageDialog(null, "el registro se realizo correctamente");
        		}
        	}
        	

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al manipular el archivo "
                    + e.getMessage(), "Dialogo de error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public void serializable() throws IOException, ClassNotFoundException
	{
		try
		{
			fos = new FileOutputStream("clientes.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(misClientes);
			oos.close();
			fos.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public void deserializable() throws IOException, ClassNotFoundException
	{
		try
		{
			fis = new FileInputStream("clientes.txt");
			ois = new ObjectInputStream(fis);
			misClientes = (ArrayList<Cliente>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
			JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			c.printStackTrace();
		}
	}

    /**
     * @param Cliente Object
     */
    public void ingresoPersona(Cliente Object) {
        // TODO implement here
    }

    /**
     * @param Cliente Object
     */
    public void recuperarContraseña(Cliente Object) {
        // TODO implement here
    }

    /**
     * @param Empresa Object
     */
    public void registroEmpresa(Empresa Object) {
        // TODO implement here
    }

}