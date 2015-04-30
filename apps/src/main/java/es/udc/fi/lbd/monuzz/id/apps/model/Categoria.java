package es.udc.fi.lbd.monuzz.id.apps.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="CATEGORIA")
public class Categoria {

	private Long idCategoria;
	private String nombre;
	private Categoria madre;
	private Set<Categoria> subcategorias=new HashSet<Categoria>();

	@SuppressWarnings("unused")
	private Categoria() {
	}
	public Categoria(String nombre) {
		this.nombre = nombre;
		this.madre=null;
	}
	
	@Id
	@SequenceGenerator(name = "idCategoria", sequenceName = "id_categoria_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idCategoria")
	@Column (name="id_categoria", nullable=false, unique=true)	
	public Long getIdCategoria() {
		return idCategoria;
	}
	
	@Column (name="nombre", nullable=false, unique=true)	
	public String getNombre() {
		return nombre;
	}
	
	@ManyToOne
	@JoinColumn(name="id_categoria_madre")
	public Categoria getmadre() {
		return madre;
	}
	
	@OneToMany(mappedBy="madre")
	public Set<Categoria> getSubcategorias() {
		return subcategorias;
	}
		
	
	@SuppressWarnings("unused")
	private  void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMadre(Categoria madre) {
		this.madre = madre;
	}
	public void setSubcategorias(Set<Categoria> subcategorias) {
		this.subcategorias=subcategorias;
	}
	
	public void addSubcategoria (Categoria subCat){
		if (subCat==null)
			throw new IllegalArgumentException("Intentando añadir categoria nula");
		if (subCat.getmadre()!=null) 
			subCat.getmadre().getSubcategorias().remove(subCat);
		subCat.setMadre(this);
		this.subcategorias.add(subCat);
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
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
		Categoria other = (Categoria) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}
