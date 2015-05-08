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
			if (miUsuario != null) {
				usuarioDAO.create(miUsuario);
				log.info("[Info]UsuarioImplementation[registrarNuevoUsuario(<Clase> Usuario)] ==> Registrado el usuario: "
						+ miUsuario.toString());
			} else
				log.error("[Error]UsuarioImplementation[registrarNuevoUsuario(<Clase> Usuario)] ==> usuario = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[registrarNuevoUsuario(<Clase> Usuario)] ==> No se pudo registrar el usuario");
			throw e;
		}
	}

	public void actualizarUsuario(Usuario miUsuario) {
		try {
			if (miUsuario != null) {
				usuarioDAO.update(miUsuario);
				log.info("[Info]UsuarioImplementation[actualizarUsuario(<Clase> Usuario)] ==> Actualizado el usuario: "
						+ miUsuario.toString());
			} else
				log.error("[Error]UsuarioImplementation[actualizarUsuario(<Clase> Usuario)] ==> usuario = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[actualizarUsuario(<Clase> Usuario)] ==> No se pudo actualizar el usuario");
			throw e;
		}
	}

	public void borrarUsuario(Usuario miUsuario) {
		try {
			if (miUsuario != null) {
				usuarioDAO.remove(miUsuario);
				log.info("[Info]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> Borrado el usuario: "
						+ miUsuario.toString());
			} else
				log.error("[Error]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> usuario = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> No se pudo borrar el usuario");
			throw e;
		}
	}

	public Usuario autenticarUsuario(String login, String password) {
		return null;
	}

	public Usuario buscarUsuarioPorId(Long id) {
		Usuario usuario = null;
		try {
			if (id != null) {
				usuario = usuarioDAO.findById(id);
				if (usuario == null)
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorId((<Long> id)] ==> No se ha encontrado al usuario con el id: "
							+ id);
				else
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorId(<Long> id)] ==> Encontrado el usuario: "
							+ usuario.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarUsuarioPorId(<Long> id)] ==> id = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarUsuarioPorId(<Long> id)] ==> No se pudo encontrar el usuario con el id: "
					+ id);
			throw e;
		}
		return usuario;
	}

	public Usuario buscarUsuarioPorLogin(String login) {
		Usuario usuario = null;
		/*
		 * try { usuario = usuarioDAO.findByNombreDeUsuario(login);
		 * log.info("UsuarioImplementation ==> Encontrado al usuario: " +
		 * usuario.toString());
		 * 
		 * } catch (DataAccessException e) { log.error(
		 * "[Error]UsuarioImplementation ==> No se pudo encontrar el usuario con el login: "
		 * + login); throw e; } catch (RuntimeException e) { // se lanza en el
		 * DAO si es nulo log.error(
		 * "[Error]Usuarioplementation ==> No se pudo encontrar el usuario con el login: "
		 * + login); } return usuario;
		 */
		try {
			if (login != null) {
				usuario = usuarioDAO.findByNombreDeUsuario(login);
				if (usuario == null)
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorLogin((<Long> login)] ==> No se ha encontrado al usuario con el login: "
							+ login);
				else
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorLogin(<Long> login)] ==> Encontrado el usuario: "
							+ usuario.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarUsuarioPorLogin(<Long> login)] ==> login = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarUsuarioPorLogin(<Long> login)] ==> No se pudo encontrar el usuario con el login: "
					+ login);
			throw e;
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
