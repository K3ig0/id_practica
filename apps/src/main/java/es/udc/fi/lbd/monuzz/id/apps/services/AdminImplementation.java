package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.udc.fi.lbd.monuzz.id.apps.daos.CategoriaDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.TipoAppDAO;
import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;

@Service
public class AdminImplementation implements AdminService {

	static Logger log = Logger.getLogger("apps");

	@Autowired
	private TipoAppDAO tipoAppDAO;

	@Autowired
	private CategoriaDAO categoriaDAO;

	public void registrarNuevoTipoApp(TipoApp miTipo) {
		try {
			tipoAppDAO.create(miTipo);
			log.info("AdminImplementation ==> Registrado el tipo de app: "
					+ miTipo.toString());
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo registrar el tipo de app: "
					+ miTipo.toString());
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo registrar el tipo de app");
		}
	}

	public void borrarTipoApp(TipoApp miTipo) {
		try {
			tipoAppDAO.remove(miTipo);
			log.info("AdminImplementation ==> Borrado el tipo de app: "
					+ miTipo.toString());
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo borrar el tipo de app: "
					+ miTipo.toString());
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo borrar el tipo de app");
		}
	}

	public TipoApp buscarTipoAppPorId(Long id) {
		TipoApp tipoApp = null;
		try {
			tipoApp = tipoAppDAO.findById(id);
			log.info("AdminImplementation ==> Encontrado el tipo de app: "
					+ tipoApp.toString());
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar el tipo de app con el id: "
					+ id);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo encontrar el tipo de app con el id: "
					+ id);
		}
		return tipoApp;
	}

	public TipoApp buscarTipoAppPorNombre(String nombre) {
		TipoApp tipoApp = null;
		try {
			tipoApp = tipoAppDAO.findByNombre(nombre);
			log.info("AdminImplementation ==> Encontrado el tipo de app: "
					+ tipoApp.toString());
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar el tipo de app con el nombre: "
					+ nombre);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo registrar el tipo de app con el nombre: "
					+ nombre);
		}
		return tipoApp;
	}

	public List<TipoApp> buscarTodosTipoApp() {
		List<TipoApp> tipoApps;
		try {
			tipoApps = tipoAppDAO.findAll();
			log.info("AdminImplementation ==> Recuperada a lista de tipos de app correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar ningún tipo de app");
			throw e;
		}
		return tipoApps;
	}

	// Implementado para N niveles
	public void registrarNuevaCategoria(Categoria miCategoria) {
		try {
			categoriaDAO.create(miCategoria);
			log.info("AdminImplementation ==> Registrada la categoría: "
					+ miCategoria.toString());

			Set<Categoria> subCategorias = miCategoria.getSubcategorias();

			if (!subCategorias.isEmpty())
				for (Categoria subCat : subCategorias) {
					registrarNuevaCategoria(subCat);
				}
			
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo registrar la categoría: "
					+ miCategoria.toString());
			throw e;
		}
	}

	public void modificarCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub

	}

	public void borrarCategoria(Categoria miCategoria) {
		try {
			categoriaDAO.remove(miCategoria);
			log.info("AdminImplementation ==> Borrada la categoría: "
					+ miCategoria.toString() + "y sus subcategorías");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo borrar la categoría: "
					+ miCategoria.toString() + "ni sus subcategorías");
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo borrar la categoría ni sus subcategorías");
		}
	}

	public Categoria buscarCategoriaPorId(Long id) {
		Categoria categoria = null;
		try {
			categoria = categoriaDAO.findById(id);
			log.info("AdminImplementation ==> Encontrada la categoría: "
					+ categoria.toString());

		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar la categoría con el id: "
					+ id);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo encontrar la categoría con el id: "
					+ id);
		}

		return categoria;
	}

	public Categoria buscarCategoriaPorNombre(String nombre) {
		Categoria categoria = null;
		try {
			categoria = categoriaDAO.findByNombre(nombre);
			log.info("AdminImplementation ==> Encontrada la categoría: "
						+ categoria.toString());

		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar la categoría: "
					+ nombre);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation ==> No se pudo encontrar la categoría: "
					+ nombre);
		}
		return categoria;
	}

	public List<Categoria> buscarCategoriasPrincipales() {
		List<Categoria> categorias = null;
		try {
			categorias = categoriaDAO.findFirstLevel();
			log.info("AdminImplementation ==> Lista de categorías principales encontrada correctamente");

		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar ninguna categoría");
			throw e;
		}
		return categorias;
	}

	public List<Categoria> buscarSubcategorias(Categoria miCategoria) {
		List<Categoria> subCategorias = null;
		try {
			subCategorias = categoriaDAO.findSubcategories(miCategoria);
			log.info("AdminImplementation ==> Lista de subcategorías encontrada correctamente");

		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation ==> No se pudo encontrar ninguna categoría");
			throw e;
			
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]AdminImplementation(buscarSubcategorias) ==> No se pudo encontrar ninguna categoría");
		}
		return subCategorias;
	}

	public Long calcularNumAppsCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<App> buscarAppsCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
