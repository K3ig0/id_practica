package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import es.udc.fi.lbd.monuzz.id.apps.daos.AppDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.CategoriaDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.TipoAppDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.UsuarioDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.VersionDAO;
import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;

public class AdminImplementation implements AdminService {

	static Logger log = Logger.getLogger("apps");
	
	@Autowired
	private TipoAppDAO tipoAppDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	
	@Override
	public void registrarNuevoTipoApp(TipoApp miTipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarTipoApp(TipoApp miTipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoApp buscarTipoAppPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoApp buscarTipoAppPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoApp> buscarTodosTipoApp() {
		// TODO Auto-generated method stub
		return null;
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
