package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.List;

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
	
	
	@Override
	public void registrarNuevoTipoApp(TipoApp miTipo) {
		try {
			tipoAppDAO.create(miTipo);
			log.info("AdminImplementation ==> Registrado el tipo de app: "+miTipo.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]AdminImplementation ==> No se pudo registrar el tipo de app: "+miTipo.toString());
			throw e;
		}
	}

	@Override
	public void borrarTipoApp(TipoApp miTipo) {
		try {
			tipoAppDAO.remove(miTipo);
			log.info("AdminImplementation ==> Borrado el tipo de app: "+miTipo.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]AdminImplementation ==> No se pudo borrar el tipo de app: "+miTipo.toString());
			throw e;
		}		
	}

	@Override
	public TipoApp buscarTipoAppPorId(Long id) {
		TipoApp tipoApp;
		try {
			tipoApp= tipoAppDAO.findById(id);
			log.info("AdminImplementation ==> Encontrado el tipo de app: "+tipoApp.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]AdminImplementation ==> No se pudo encontrar el tipo de app con el id: "+id);
			throw e;
		}	
		return tipoApp;
	}

	@Override
	public TipoApp buscarTipoAppPorNombre(String nombre) {
		TipoApp tipoApp = null;
		try {
			tipoApp= tipoAppDAO.findByNombre(nombre);
			log.info("AdminImplementation ==> Encontrado el tipo de app: "+tipoApp.toString());
		}
		catch (NullPointerException | DataAccessException e){
			log.error("[Error]AdminImplementation ==> No se pudo encontrar el tipo de app con el nombre: "+nombre);
		}	
		return tipoApp;
	}

	@Override
	public List<TipoApp> buscarTodosTipoApp() {
		List<TipoApp> tipoApps;
		try {
			tipoApps= tipoAppDAO.findAll();
			log.info("AdminImplementation ==> Recuperada a lista de tipos de app correctamente");
		}
		catch (DataAccessException e){
			log.error("[Error]AdminImplementation ==> No se pudo encontrar ningún tipo de app");
			throw e;
		}	
		return tipoApps;
	}

	@Override
	public void registrarNuevaCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria buscarCategoriaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscarCategoriaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> buscarCategoriasPrincipales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> buscarSubcategorias(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long calcularNumAppsCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> buscarAppsCategoria(Categoria miCategoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
