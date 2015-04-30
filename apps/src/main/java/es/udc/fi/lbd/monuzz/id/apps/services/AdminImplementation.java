package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.List;

import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;

public class AdminImplementation implements AdminService {
	
	public void registrarNuevoTipoApp (TipoApp miTipo) {
		//@TODO
		
	}
	
	public void borrarTipoApp(TipoApp miTipo) {  							// Salta excepcion si aun hay apps ligadas al tipo
		//@TODO
		
	}
	
	public TipoApp buscarTipoAppPorId(Long id) {
		//@TODO
		return null;
	}
	
	public TipoApp buscarTipoAppPorNombre(String nombre) {
		//@TODO
		return null;
	}
	
	public List<TipoApp> buscarTodosTipoApp() {
		//@TODO
		return null;
	}
	
	public void registrarNuevaCategoria (Categoria miCategoria) {
		//@TODO

	}
	
	public void modificarCategoria (Categoria miCategoria) {
		//@TODO
		
	}
	
	public void borrarCategoria (Categoria miCategoria) {  					// Salta excepcion si aun hay apps ligadas a la categoria (o sus subcategorias)
		//@TODO
		
	}
	
	public Categoria buscarCategoriaPorId(Long id) {
		//@TODO
		return null;
	}
	
	public Categoria buscarCategoriaPorNombre(String nombre) {
		//@TODO
		return null;
	}
	
	public List<Categoria> buscarCategoriasPrincipales() { 					// Categorias de nivel 1 (no son subcategorias de ninguna otra)
		//@TODO
		return null;
	}
	
	public List<Categoria> buscarSubcategorias(Categoria miCategoria) {  	// Subcategorias directas
		//@TODO
		return null;
	}
	
	public Long calcularNumAppsCategoria (Categoria miCategoria) { 			// TODAS las apps, incluidas las de subcategorias
		//@TODO
		return null;
	}
	
	public List<App> buscarAppsCategoria (Categoria miCategoria) {			// TODAS las apps, incluidas las de subcategorias
		//@TODO
		return null;
	}

}
