package es.udc.fi.lbd.monuzz.id.apps.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@DiscriminatorValue("CLI")
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
	
	@Column (name="tipo_cliente", nullable=true, unique=false)
	public String getTipoCliente() {
		return tipoCliente;
	}
	
	@Column (name="saldo", nullable=true, unique=false)
	public Float getSaldo() {
		return saldo;
	}
	
	@ManyToMany
	@JoinTable (
			name="CLI_APP",
			joinColumns={@JoinColumn(name="id_app")},
			inverseJoinColumns = {@JoinColumn(name="id_usuario")}
			)
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
