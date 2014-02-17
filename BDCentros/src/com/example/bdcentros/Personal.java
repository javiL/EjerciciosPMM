package com.example.bdcentros;

public class Personal {
	private String codigoCentro;
	private String DNI;
	private String apellidos;
	
	public Personal(String codigo, String dni, String apellidoss){
		setCodigoCentro(codigo);
		setDNI(dni);
		setApellidos(apellidoss);
	}

	public String getCodigoCentro() {
		return codigoCentro;
	}

	public void setCodigoCentro(String codigoCentro) {
		this.codigoCentro = codigoCentro;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
