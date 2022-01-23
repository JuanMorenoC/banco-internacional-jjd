package logica;

import java.io.Serializable;

public class CuentaNomina implements Serializable{

private String numeroCuenta;
private String fechaCreacion;

private double monto;

public CuentaNomina(String numeroCuenta, String fechaCreacion,double monto) {

	this.numeroCuenta=numeroCuenta;
	this.fechaCreacion=fechaCreacion;
	this.monto = monto;
}
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
 * @return the numeroCuenta
 */
public String getNumeroCuenta() {
	return numeroCuenta;
}

/**
 * @param numeroCuenta the numeroCuenta to set
 */
public void setNumeroCuenta(String numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
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




}