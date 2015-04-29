package es.udc.fi.lbd.monuzz.id.apps.model;


public class Usuario {
	
	protected Long idUsuario;	
	protected String nombreDeUsuario;
	protected String password;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String nombreEnPantalla;

	

	public Long getIdUsuario() {
		return idUsuario;
	}
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public String getPassword() {
		return password;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getNombreEnPantalla() {
		return nombreEnPantalla;
	}

	@SuppressWarnings("unused")
	private void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	@SuppressWarnings("unused")
	private void setNombreDeUsuario(String nombreUsuario) {
		this.nombreDeUsuario = nombreUsuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setNombreEnPantalla(String nombreEnPantalla) {
		this.nombreEnPantalla = nombreEnPantalla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreDeUsuario="
				+ nombreDeUsuario + ", password=" + password + ", nombre="
				+ nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", nombreEnPantalla=" + nombreEnPantalla + "]";
	}
	

	

	


	
}
