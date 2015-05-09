package es.udc.fi.lbd.monuzz.id.apps.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_APP")
public class TipoApp {

	private Long idTipoApp;
	private String nombre;
	private String descripcion;
	private byte[] icono;
	
	@SuppressWarnings("unused")
	private TipoApp() {
	}

	public TipoApp(String nombre, String descripcion, byte[] icono) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.icono = icono;
	}
	
	@Id
	@SequenceGenerator(name = "idTipoApp", sequenceName = "id_tipo_app_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idTipoApp")
	@Column (name="id_tipo_app", nullable=false, unique=true)	
	public Long getIdTipoApp() {
		return idTipoApp;
	}
	
	@Column (name="nombre", nullable=false, unique=true)
	public String getNombre() {
		return nombre;
	}
	
	@Column (name="descripcion", nullable=false, unique=false)
	public String getDescripcion() {
		return descripcion;
	}
	
	@Column (name="icono", nullable=true, unique=false)
	public byte[] getIcono() {
		return icono;
	}

	@SuppressWarnings("unused")
	private  void setIdTipoApp(Long idTipoApp) {
		this.idTipoApp = idTipoApp;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}

	@Override
	public String toString() {
		return "TipoAplicacion [idTipoAplicacion=" + idTipoApp
				+ ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", icono=" + Arrays.toString(icono) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoApp other = (TipoApp) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}