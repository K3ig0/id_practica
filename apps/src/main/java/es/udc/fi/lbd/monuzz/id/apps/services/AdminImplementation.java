package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	
	@Transactional(value = "miTransactionManager")
	public void registrarNuevoTipoApp(TipoApp miTipo) {
		try {
			if (miTipo != null) {
				tipoAppDAO.create(miTipo);
				log.info("[Info]AdminImplementation[registrarNuevoTipoApp(<Clase> TipoApp)] ==> Registrado el tipo de app: "
						+ miTipo.toString());
			} else
				log.error("[Error]AdminImplementation[registrarNuevoTipoApp(<Clase> TipoApp)] ==> tipoApp = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[registrarNuevoTipoApp(<Clase> TipoApp)] ==> No se pudo registrar el tipo de app");
			throw e;
		}
	}

	@Transactional(value = "miTransactionManager")
	public void borrarTipoApp(TipoApp miTipo) {
		try {
			if (miTipo != null) {
				log.info("[Info]AdminImplementation[borrarTipoApp(<Clase> TipoApp)] ==> Borrando el tipo de app: "
						+ miTipo.toString());
				tipoAppDAO.remove(miTipo);
				log.info("[Info]AdminImplementation[borrarTipoApp(<Clase> TipoApp)] ==> ...Tipo de app borrada satisfactoriamente");
			} else
				log.error("[Error]AdminImplementation[borrarTipoApp(<Clase> TipoApp)] ==> tipoApp = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[borrarTipoApp(<Clase> TipoApp)] ==> No se pudo borrar el tipo de app");
			throw e;
		}
	}

	@Transactional(value = "miTransactionManager")
	public TipoApp buscarTipoAppPorId(Long id) {
		TipoApp tipoApp = null;
		try {
			if (id != null) {
				tipoApp = tipoAppDAO.findById(id);
				if (tipoApp == null)
					log.info("[Info]AdminImplementation[buscarTipoAppPorId(<Long> id)] ==> No se encontró el tipo de app");
				else
					log.info("[Info]AdminImplementation[buscarTipoAppPorId(<Long> id)] ==> Encontrado el tipo de app: "
							+ tipoApp.toString());
			} else
				log.info("[Error]AdminImplementation[buscarTipoAppPorId(<Long> id)] ==> id = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarTipoAppPorId(<Long> id)] ==> No se pudo encontrar el tipo de app con el id: "
					+ id);
			throw e;
		}
		return tipoApp;
	}

	@Transactional(value = "miTransactionManager")
	public TipoApp buscarTipoAppPorNombre(String nombre) {
		TipoApp tipoApp = null;
		try {
			if (nombre != null) {
				tipoApp = tipoAppDAO.findByNombre(nombre);
				if (tipoApp == null)
					log.info("[Info]AdminImplementation[buscarTipoAppPorNombre(<String> nombre)] ==> No se encontró el tipo de app con el nombre: "
							+ nombre);
				else
					log.info("[Info]AdminImplementation[buscarTipoAppPorNombre(<String> nombre)] ==> Encontrado el tipo de app: "
							+ tipoApp.toString());
			} else
				log.error("[Error]AdminImplementation[buscarTipoAppPorNombre(<String> nombre)] ==> nombre = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarTipoAppPorNombre(<String> nombre)] ==> No se pudo encontrar el tipo de app con el nombre: "
					+ nombre);
			throw e;
		}
		return tipoApp;
	}

	@Transactional(value = "miTransactionManager")
	public List<TipoApp> buscarTodosTipoApp() {
		List<TipoApp> tipoApps;
		try {
			tipoApps = tipoAppDAO.findAll();
			log.info("[Info]AdminImplementation[buscarTodosTipoApp()] ==> Recuperada a lista de tipos de app correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarTodosTipoApp()] ==> No se pudo encontrar ningún tipo de app");
			throw e;
		}
		return tipoApps;
	}

	@Transactional(value = "miTransactionManager")
	public void registrarNuevaCategoria(Categoria miCategoria) {
		try {
			if (miCategoria != null) {
				categoriaDAO.create(miCategoria);
				log.info("[Info]AdminImplementation[registrarNuevaCategoria(<Clase> categoria)] ==> Registrada la categoría: "
						+ miCategoria.toString());
				
				//CascadeType.PERSIST manualmente (creación)
				/*Set<Categoria> subCategorias = miCategoria.getSubcategorias();

				if (!subCategorias.isEmpty())
					for (Categoria subCat : subCategorias) {
						registrarNuevaCategoria(subCat);
					}*/
			} else
				log.error("[Error]AdminImplementation[registrarNuevaCategoria(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[registrarNuevaCategoria(<Clase> categoria)] ==> No se pudo registrar la categoría");
			throw e;
		}
	}

	@Transactional(value = "miTransactionManager")
	public void modificarCategoria(Categoria miCategoria) {
		try {
			if (miCategoria != null) {
				categoriaDAO.update(miCategoria);
				log.info("[Info]AdminImplementation[modificarCategoria(<Clase> categoria)] ==> Modificada la categoría: "
						+ miCategoria.toString() + "y sus subcategorías");
			} else
				log.error("[Error]AdminImplementation[modificarCategoria(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[modificarCategoria(<Clase> categoria)] ==> No se pudo modificar la categoría: "
					+ miCategoria.toString() + " ni sus subcategorías");
			throw e;
		}
	}

	@Transactional(value = "miTransactionManager")
	public void borrarCategoria(Categoria miCategoria) {
		try {
			if (miCategoria != null) {
				log.info("[Info]AdminImplementation[borrarCategoria(<Clase> categoria)] ==> Borrando la categoría: "
						+ miCategoria.toString() + "y sus subcategorías ...");
				categoriaDAO.remove(miCategoria);
				log.info("[Info]AdminImplementation[borrarCategoria(<Clase> categoria)] ==> ... Categoría borrada satisfactoriamente");
			} else
				log.error("[Error]AdminImplementation[borrarCategoria(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[borrarCategoria(<Clase> categoria)] ==> No se pudo borrar la categoría: "
					+ miCategoria.toString() + " ni sus subcategorías");
			throw e;
		}
	}

	@Transactional(value = "miTransactionManager")
	public Categoria buscarCategoriaPorId(Long id) {
		Categoria categoria = null;
		try {
			if (id != null) {
				categoria = categoriaDAO.findById(id);
				if (categoria == null)
					log.info("[Info]AdminImplementation[buscarCategoriaPorId(<Long> id)] ==> No se encontró la categoría");
				else
					log.info("[Info]AdminImplementation[buscarCategoriaPorId(<Long> id)] ==> Encontrada la categoría: "
							+ categoria.toString());
			} else
				log.info("[Error]AdminImplementation[buscarCategoriaPorId(<Long> id)] ==> id = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarCategoriaPorId(<Long> id)] ==> No se pudo encontrar la categoría con el id: "
					+ id);
			throw e;
		}
		return categoria;
	}

	@Transactional(value = "miTransactionManager")
	public Categoria buscarCategoriaPorNombre(String nombre) {
		Categoria categoria = null;
		try {
			if (nombre != null) {
				categoria = categoriaDAO.findByNombre(nombre);
				if (categoria == null)
					log.info("[Info]AdminImplementation[buscarCategoriaPorNombre(<String> nombre)] ==> No se encontró la categoría con el nombre: "
							+ nombre);
				else
					log.info("[Info]AdminImplementation[buscarCategoriaPorNombre(<String> nombre)] ==> Encontrado la categoría: "
							+ categoria.toString());
			} else
				log.error("[Error]AdminImplementation[buscarCategoriaPorNombre(<String> nombre)] ==> nombre = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarCategoriaPorNombre(<String> nombre)] ==> No se pudo encontrar la categoría con el nombre: "
					+ nombre);
			throw e;
		}
		return categoria;
	}

	@Transactional(value = "miTransactionManager")
	public List<Categoria> buscarCategoriasPrincipales() {
		List<Categoria> categorias = null;
		try {
			categorias = categoriaDAO.findFirstLevel();
			log.info("[Info]AdminImplementation[buscarCategoriasPrincipales()] ==> Lista de categorías principales encontradas correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarCategoriasPrincipales()] ==> No se pudo encontrar ninguna categoría");
			throw e;
		}
		return categorias;
	}

	@Transactional(value = "miTransactionManager")
	public List<Categoria> buscarSubcategorias(Categoria miCategoria) {
		List<Categoria> subCategorias = null;
		try {
			if (miCategoria != null) {
				subCategorias = categoriaDAO.findSubcategories(miCategoria);
				log.info("[Info]AdminImplementation[buscarSubcategorias(<Clase> categoria)] ==> Lista de subcategorías encontrada correctamente");
			} else
				log.error("[Error]AdminImplementation[buscarSubcategorias(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarSubcategorias(<Clase> categoria)] ==> No se pudo encontrar ninguna subcategoría");
			throw e;
		}
		return subCategorias;
	}

	@Transactional(value = "miTransactionManager")
	public Long calcularNumAppsCategoria(Categoria miCategoria) {
		Long n = new Long(0);
		try {
			if (miCategoria != null) {
				List<Categoria> subcategorias = categoriaDAO.findSubcategories(miCategoria);
				if (!subcategorias.isEmpty())
					for (Categoria c : subcategorias)
						n += categoriaDAO.getNumApps(c);
				else
					n = categoriaDAO.getNumApps(miCategoria);
				
				log.info("[Info]AdminImplementation[calcularNumAppsCategorias(<Clase> categoria)] ==> Número de Apps de la categoría "
						+ miCategoria.toString() + " encontradas con éxito");
			} else
				log.error("[Error]AdminImplementation[calcularNumAppsCategorias(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[calcularNumAppsCategorias(<Clase> categoria)] ==> No se pudo calcular el número de Apps para la categoría "
					+ miCategoria.toString());
			throw e;
		}
		return n;
	}

	@Transactional(value = "miTransactionManager")
	public List<App> buscarAppsCategoria(Categoria miCategoria) {
		List<App> apps = null;
		try {
			if (miCategoria != null) {
				apps = categoriaDAO.getApps(miCategoria);
				List<Categoria> subcategorias = categoriaDAO.findSubcategories(miCategoria);
				if (!subcategorias.isEmpty())
					for (Categoria c : subcategorias) {
						List<App> apps_subcat = categoriaDAO.getApps(c);
						for (App a : apps_subcat) //se añade la app de cada subcategoría
							apps.add(a);
					}
				log.info("[Info]AdminImplementation[buscarAppsCategorias(<Clase> categoria)] ==> Apps de la categoría "
						+ miCategoria.toString() + " encontradas con éxito");
			} else
				log.error("[Error]AdminImplementation[buscarAppsCategorias(<Clase> categoria)] ==> categoria = null");
		} catch (DataAccessException e) {
			log.error("[Error]AdminImplementation[buscarAppsCategoria(<Clase> categoria)] ==> No se pudo encontrar ninguna app para la categoría "
					+ miCategoria.toString());
			throw e;
		}
		//ordenar por votos en orden descendiente (mejor sería hacer una consulta recursiva como la de findSubcategorias que
		 // obtuviese las apps de cada categoría y sus subcategorías y ordenarlo ya por votos en orden descendiente en la consulta)
		    Collections.sort(apps, new Comparator<App>() {
		        @Override
		        public int compare(final App a1, final App a2) {
		            return a2.getVotos().compareTo(a1.getVotos());
		        }
		       } );
				
		return apps;
	}
}
