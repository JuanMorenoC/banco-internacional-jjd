package logica;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class CuentaAhorro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6932766887479877801L;
	private String numeroBancario;
    private  String fechaCreacion;
    private double monto;
	private double consignacion;

    public CuentaAhorro(String numeroBancario, String fechaCreacion, double monto)
    {
    	this.numeroBancario=numeroBancario;
    	this.fechaCreacion=fechaCreacion;
    	this.monto=monto;
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
	 * @return the consignacion
	 */
	public double getMonto() {
		return monto;
	}
	/**
	 * @param consignacion the consignacion to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	/**
	 * @return the consignacion
	 */
	public double getConsignacion() {
		return getConsignacion();
	}
	/**
	 * @param consignacion the consignacion to set
	 */
	public void setConsignacion(double consignacion) {
		this.consignacion = consignacion;
	}

}