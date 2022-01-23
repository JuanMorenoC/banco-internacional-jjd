package logica;

import java.util.Date;

public class Administrador
{
	 private String nombre;
	    private String apellido;
	    private char sexo;
	    private String cedula;
	    private String cargo;
	    private String usuario;
	    private String contraseña;
	    private String pregunta;
	    private String respuesta;
	    public Banco banco1;

	    
 public Administrador(String nombre, String apellido, char sexo, String cargo,
 		String cedula, String usuario, String contraseña,String pregunta,String respuesta) 
 {
 	this.nombre=nombre;
 	this.apellido=apellido;
 	this.sexo=sexo;
 	this.cedula=cedula;
 	this.usuario=usuario;
 	this.contraseña=contraseña;
 	this.pregunta=pregunta;
 	this.respuesta=respuesta;
 	this.cargo = cargo;
 }


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}


	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public String getCedula() {
		return cedula;
	}


	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}


	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}


	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}


	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
