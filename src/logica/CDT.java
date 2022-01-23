package logica;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class CDT implements Serializable {

	
    private String Usuario;
    private Double montoInversion;
    private String fechaCreacion;
    private int duracion;
    private int porcentaje;
    private String tipoPago;
    private String cedula;
   
    public CDT(String usuario,String cedula,double montoInversion,String fechaCreacion,int duracion,int porcentaje,String tipoPago) {
    	this.Usuario=usuario;
    	this.montoInversion=montoInversion;
    	this.fechaCreacion=fechaCreacion;
    	this.duracion=duracion;
    	this.porcentaje=porcentaje;
    	this.tipoPago=tipoPago;
    	this.cedula=cedula;

    }

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public Double getMontoInversion() {
		return montoInversion;
	}
	public void setMontoInversion(Double montoInversion) {
		this.montoInversion = montoInversion;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String isTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}