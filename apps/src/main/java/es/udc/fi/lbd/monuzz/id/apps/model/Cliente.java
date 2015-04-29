package es.udc.fi.lbd.monuzz.id.apps.model;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Usuario {
	
	private String tipoCliente;
	private Float saldo;
	private List<App> apps = new ArrayList<App>();


	public Cliente() {
	}

	public Cliente(String nombreUsuario, String password, String nombre,
			String apellido1, String apellido2, String nombreEnPantalla, String tipoCliente, Float saldo) {
		this.nombreDeUsuario = nombreUsuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombreEnPantalla = nombreEnPantalla;
		this.tipoCliente=tipoCliente;
		this.saldo=saldo;
	}
	
		
	public String getTipoCliente() {
		return tipoCliente;
	}
	public Float getSaldo() {
		return saldo;
	}
	public List<App> getApps() {
		return apps;
	}


	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	@Override
	public String toString() {
		return (super.toString() + "  [Cliente: Tipo cliente=" + tipoCliente + ", saldo=" + saldo + "]");
	}
	
	
}
