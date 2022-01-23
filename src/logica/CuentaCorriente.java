package logica;

import java.io.Serializable;

public class CuentaCorriente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3540342100812284648L;
	private String numeroBancario;
    private String fechaCreacion;
    private double monto;
    private double consignacion;
    
    public CuentaCorriente(String numeroBancario, String fechaCreacion,double monto) {
    	this.numeroBancario=numeroBancario;
    	this.fechaCreacion=fechaCreacion;
    	this.monto=monto;
    }
    /**
	 * @return the consignacion
	 */
	public double getConsignacion() {
		return consignacion;
	}
	/**
	 * @param consignacion the consignacion to set
	 */
	public void setConsignacion(double consignacion) {
		this.consignacion = consignacion;
	}

	/**
	 * @return the numeroBancario
	 */
	public String getNumeroBancario() {
		return numeroBancario;
	}

	/**
	 * @param numeroBancario the numeroBancario to set
	 */
	public void setNumeroBancario(String numeroBancario) {
		this.numeroBancario = numeroBancario;
	}

	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}




}