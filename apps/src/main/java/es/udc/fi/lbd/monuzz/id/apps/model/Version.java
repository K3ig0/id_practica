package es.udc.fi.lbd.monuzz.id.apps.model;

import java.sql.Timestamp;


public class Version {

	private Long idVersion;
	private String numVersion;
	private Timestamp fechaDePublicacion;
	private App app;
	
	@SuppressWarnings("unused")
	private Version() {}
	
	
	public Version(String numVersion, Timestamp fechaDePublicacion, App app) {
		this.numVersion = numVersion;
		this.fechaDePublicacion = fechaDePublicacion;
		app.getVersiones().add(this);
		this.app = app;
		app.getVersiones().add(this);
	}

	public Long getIdVersion() {
		return idVersion;
	}
	public String getNumVersion() {
		return numVersion;
	}
	public Timestamp getFechaDePublicacion() {
		return fechaDePublicacion;
	}
	public App getApp() {
		return app;
	}

	@SuppressWarnings("unused")
	private void setIdVersion(Long idVersion) {
		this.idVersion = idVersion;
	}
	public void setNumVersion(String numVersion) {
		this.numVersion = numVersion;
	}
	public void setFechaDePublicacion(Timestamp fechaPublicacion) {
		this.fechaDePublicacion = fechaPublicacion;
	}
	public void setApp(App app) {
		this.app = app;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + ((app == null) ? 0 : app.hashCode());
		result = prime
				* result
				+ ((numVersion == null) ? 0 : numVersion.hashCode());
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
		Version other = (Version) obj;
		if (app == null) {
			if (other.app != null)
				return false;
		} else if (!app.equals(other.app))
			return false;
		if (fechaDePublicacion == null) {
			if (other.fechaDePublicacion != null)
				return false;
		} else if (!fechaDePublicacion.equals(other.fechaDePublicacion))
			return false;
		return true;
	}

	
	
}
