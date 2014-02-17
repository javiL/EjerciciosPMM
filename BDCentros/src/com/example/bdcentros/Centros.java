package com.example.bdcentros;

public class Centros {
	
	private String codigoCentro;
	private String nombreCentro;
	private String dir;
	
	public Centros(String codigo, String nombre, String direccion)
	{
		setCodigoCentro(codigo);
		setNombreCentro(nombre);
		setDir(direccion);
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getCodigoCentro() {
		return codigoCentro;
	}

	public void setCodigoCentro(String codigoCentro) {
		this.codigoCentro = codigoCentro;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}
