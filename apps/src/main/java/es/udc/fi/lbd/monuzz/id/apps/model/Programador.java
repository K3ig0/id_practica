package es.udc.fi.lbd.monuzz.id.apps.model;

import java.util.ArrayList;
import java.util.List;


public class Programador extends Usuario {
	
	private Long numVotos;
	private List<App> apps = new ArrayList<App>();


	public Programador() {
	}

	public Programador(String nombreUsuario, String password, String nombre,
			String apellido1, String apellido2, String nombreEnPantalla) {
		this.nombreDeUsuario = nombreUsuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombreEnPantalla = nombreEnPantalla;
		this.numVotos=new Long(0);
	}
		
	public Long getNumVotos() {
		return numVotos;
	}
	public List<App> getApps() {
		return apps;
	}


	public void setNumVotos(Long numVotos) {
		this.numVotos = numVotos;
	}
	public void setApps(List<App> apps) {
		this.apps = apps;
	}
	@Override
	public String toString() {
		return (super.toString() + "  [Programador: numVotos=" + numVotos  + "]");
	}

	
	
}
