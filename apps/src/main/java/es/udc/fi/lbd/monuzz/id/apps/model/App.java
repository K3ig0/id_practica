package es.udc.fi.lbd.monuzz.id.apps.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class App  {
	
	private Long idApp;
	private String titulo;
	private Timestamp fechaDeAlta;
	private Float precio;
	private Programador autor;
	private TipoApp tipoApp;
	private Categoria categoria;
	private Long votos;
	private List<Version> versiones=new ArrayList<Version>();
	
	@SuppressWarnings("unused")
	private App() {}
	
	public App(String titulo, Timestamp fechaDeAlta, Float precio, Programador autor, Categoria categoria, TipoApp tipoApp) {
		super();
		this.titulo = titulo;
		this.fechaDeAlta = fechaDeAlta;
		this.precio=precio;
		this.autor = autor;
		this.categoria=categoria;
		this.tipoApp=tipoApp;
		this.votos=new Long(0);
	}
	

	public Long getIdApp() {
		return idApp;
	}
	public String getTitulo() {
		return titulo;
	}
	public Timestamp getFechaDeAlta() {
		return fechaDeAlta;
	}
	public Float getPrecio() {
		return precio;
	}
	public Programador getAutor() {
		return autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public TipoApp getTipoApp() {
		return tipoApp;
	}
	public List<Version> getVersiones() {
		return versiones;
	}
	public Long getVotos() {
		return votos;
	}
	
	@SuppressWarnings("unused")
	private void setIdApp(Long idApp) {
		this.idApp = idApp;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setFechaDeAlta(Timestamp fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public void setAutor(Programador autor) {
		this.autor = autor;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setTipoApp(TipoApp tipoApp) {
		this.tipoApp = tipoApp;
	}
	public void setVersiones(List<Version> versiones) {
		this.versiones=versiones;
	}
	public void setVotos(Long votos) {
		this.votos=votos;
	}
	
	
	@Override
	public String toString() {
		return "App [idApp=" + idApp + ", titulo=" + titulo + ", fechaDeAlta="
				+ fechaDeAlta + ", precio=" + precio + ", autor=" + autor.getApellido1()+" "+autor.getApellido2()+", "+autor.getNombre()
				+ ", tipoApp=" + tipoApp.getNombre() + ", categoria=" + categoria.getNombre() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result
				+ ((fechaDeAlta == null) ? 0 : fechaDeAlta.hashCode());
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
		App other = (App) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (fechaDeAlta == null) {
			if (other.fechaDeAlta != null)
				return false;
		} else if (!fechaDeAlta.equals(other.fechaDeAlta))
			return false;
		return true;
	}

	



}
