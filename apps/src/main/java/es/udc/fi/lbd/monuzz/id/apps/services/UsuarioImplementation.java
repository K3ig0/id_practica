package es.udc.fi.lbd.monuzz.id.apps.services;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fi.lbd.monuzz.id.apps.daos.AppDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.UsuarioDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.VersionDAO;
import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Categoria;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;

@Service
public class UsuarioImplementation implements UsuarioService {

	static Logger log = Logger.getLogger("apps");
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AppDAO appDAO;
	
	@Autowired
	private VersionDAO versionDAO;
	
	
	public void registrarNuevoUsuario(Usuario miUsuario) {
		try {
			usuarioDAO.create(miUsuario);
			log.info("UsuarioImplementation ==> Registrado el usuario: "+miUsuario.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]UsuarioImplementation ==> No se pudo registrar el usuario: "+miUsuario.toString());
			throw e;
		}	
		catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]UsuarioImplementation ==> No se pudo registrar al usuario");
		}
	}

	public void actualizarUsuario(Usuario miUsuario) {
		try {
			usuarioDAO.update(miUsuario);
			log.info("UsuarioImplementation ==> Actualizado el usuario: "+miUsuario.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]UsuarioImplementation ==> No se pudo actualizar el usuario: "+miUsuario.toString());
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]UsuarioImplementation ==> No se pudo actualizar al usuario");
		}		
	}

	public void borrarUsuario(Usuario miUsuario) {
		try {
			usuarioDAO.remove(miUsuario);
			log.info("UsuarioImplementation ==> Borrado el usuario: "+miUsuario.toString());
		}
		catch (DataAccessException e){
			log.error("[Error]UsuarioImplementation ==> No se pudo borrar el usuario: "+miUsuario.toString());
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]UsuarioImplementation ==> No se pudo borrar al usuario");
		}			
	}

	public Usuario autenticarUsuario(String login, String password) {
		return null;
	}

	public Usuario buscarUsuarioPorId(Long id) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.findById(id);
			log.info("UsuarioImplementation ==> Encontrado al usuario: "
					+ usuario.toString());

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation ==> No se pudo encontrar el usuario con el id: "
					+ id);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]Usuarioplementation ==> No se pudo encontrar el usuario con el id: "
					+ id);
		}
		return usuario;
	}

	public Usuario buscarUsuarioPorLogin(String login) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.findByNombreDeUsuario(login);
			log.info("UsuarioImplementation ==> Encontrado al usuario: "
					+ usuario.toString());

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation ==> No se pudo encontrar el usuario con el login: "
					+ login);
			throw e;
		} catch (RuntimeException e) { // se lanza en el DAO si es nulo
			log.error("[Error]Usuarioplementation ==> No se pudo encontrar el usuario con el login: "
					+ login);
		}
		return usuario;
	}

	public List<Usuario> obtenerListaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Programador> obtenerListaProgramadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	public void borrarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	public App buscarAppPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public App buscarAppPorTitulo(String miTitulo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<App> obtenerAppsProgramador(Programador miProgramador) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<App> obtenerAppsCliente(Cliente miCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> obtenerClientesApp(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelarClientes(App miApp) {
		// TODO Auto-generated method stub
		
	}

	public void registrarNuevaVersion(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	public void borrarVersion(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	public Version BuscarVersionPorId(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Version> obtenerListaVersiones(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Version obtenerUltimaVersion(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
