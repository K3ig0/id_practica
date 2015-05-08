package es.udc.fi.lbd.monuzz.id.apps.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import es.udc.fi.lbd.monuzz.id.apps.daos.AppDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.UsuarioDAO;
import es.udc.fi.lbd.monuzz.id.apps.daos.VersionDAO;
import es.udc.fi.lbd.monuzz.id.apps.model.App;
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
				log.info("[Info]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> Borrando el usuario: "
						+ miUsuario.toString() + " ...");
				usuarioDAO.remove(miUsuario);
				log.info("[Info]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> ...Usuario borrado satisfactoriamente");
			} else
				log.error("[Error]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> usuario = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[borrarUsuario(<Clase> Usuario)] ==> No se pudo borrar el usuario");
			throw e;
		}
	}

	public Usuario autenticarUsuario(String login, String password) {
		Usuario usuario = buscarUsuarioPorLogin(login);
		if (usuario == null)
			log.error("[Error]UsuarioImplementation[autenticarUsuario(<String> login, <String> password)] ==> Datos de acceso incorrectos");
		else {
			if (usuario.getPassword().equals(password)) {
				log.info("[Info]UsuarioImplementation[autenticarUsuario(<String> login, <String> password)] ==> Ha accedido correctamente");
				return usuario;
			} else
				// pass incorrecto
				log.error("[Error]UsuarioImplementation[autenticarUsuario(<String> login, <String> password)] ==> Datos de acceso incorrectos");
		}
		return null; //solo devuelve el usuario si su password es correcto
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
		try {
			if (login != null) {
				usuario = usuarioDAO.findByNombreDeUsuario(login);
				if (usuario == null)
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorLogin((<Long> login)] ==> No se ha encontrado al usuario con el login: "
							+ login);
				else {
					log.info("[Info]UsuarioImplementation[buscarUsuarioPorLogin(<Long> login)] ==> Encontrado el usuario: "
							+ usuario.toString());
					return usuario;
				}
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
		List<Usuario> usuarios;
		try {
			usuarios = usuarioDAO.findAll();
			log.info("[Info]UsuarioImplementation[obtenerListaUsuarios()] ==> Recuperada la lista de usuarios correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[obtenerListaUsuarios()] ==> No se pudo encontrar a ningún usuario");
			throw e;
		}
		return usuarios;
	}

	public List<Cliente> obtenerListaClientes() {
		List<Cliente> clientes;
		try {
			clientes = usuarioDAO.findAllClientes();
			log.info("[Info]UsuarioImplementation[obtenerListaClientes()] ==> Recuperada la lista de clientes correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[obtenerListaClientes()] ==> No se pudo encontrar a ningún cliente");
			throw e;
		}
		return clientes;
	}

	public List<Programador> obtenerListaProgramadores() {
		List<Programador> programadores;
		try {
			programadores = usuarioDAO.findAllProgramadores();
			log.info("[Info]UsuarioImplementation[obtenerListaProgramadores()] ==> Recuperada la lista de programadores correctamente");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[obtenerListaProgramadores()] ==> No se pudo encontrar a ningún programador");
			throw e;
		}
		return programadores;
	}

	public void registrarApp(App miApp) {
		try {
			if (miApp != null) {
				appDAO.create(miApp);
				log.info("[Info]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> Registrada la app: "
						+ miApp.toString());
			} else
				log.error("[Error]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> app = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> No se pudo registrar la app");
			throw e;
		}
	}

	public void actualizarApp(App miApp) {
		try {
			if (miApp != null) {
				appDAO.update(miApp);
				log.info("[Info]UsuarioImplementation[actualizarApp(<Clase> App)] ==> Actualizada la app: "
						+ miApp.toString());
			} else
				log.error("[Error]UsuarioImplementation[actualizarApp(<Clase> App)] ==> app = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[actualizarApp(<Clase> App)] ==> No se pudo actualizar el app");
			throw e;
		}
	}

	public void borrarApp(App miApp) {
		try {
			if (miApp != null) {
				log.info("[Info]UsuarioImplementation[borrarApp(<Clase> App)] ==> Borrando la app: "
						+ miApp.toString() + " ...");
				appDAO.remove(miApp);
				log.info("[Info]UsuarioImplementation[borrarApp(<Clase> App)] ==> ...App borrada satisfactoriamente");
			} else
				log.error("[Error]UsuarioImplementation[borrarApp(<Clase> App)] ==> app = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[borrarApp(<Clase> App)] ==> No se pudo borrar la app");
			throw e;
		}
	}

	public App buscarAppPorId(Long id) {
		App app = null;
		try {
			if (id != null) {
				app = appDAO.findById(id);
				if (app == null)
					log.info("[Info]UsuarioImplementation[buscarAppPorId((<Long> id)] ==> No se ha encontrado la app con id: "
							+ id);
				else
					log.info("[Info]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> Encontrada la app: "
							+ app.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> id = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> No se pudo encontrar la app con id: "
					+ id);
			throw e;
		}
		return app;
	}

	public App buscarAppPorTitulo(String miTitulo) {
		App app = null;
		try {
			if (miTitulo != null) {
				app = appDAO.findByTitulo(miTitulo);
				if (app == null)
					log.info("[Info]UsuarioImplementation[buscarAppPorTitulo((<Long> miTitulo)] ==> No se ha encontrado ninguna app con el título: "
							+ miTitulo);
				else
					log.info("[Info]UsuarioImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> Encontrada la app: "
							+ app.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> miTitulo = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> No se pudo encontrar la app con el título: "
					+ miTitulo);
			throw e;
		}
		return app;
	}

	public List<App> obtenerAppsProgramador(Programador miProgramador) {
		List<App> apps = null;
		if (miProgramador != null) {
			apps = miProgramador.getApps();
			log.info("[Info]UsuarioImplementation[obtenerAppsProgramador(<Class> Programador)] ==> Recuperada correctamente la lista de apps del programador: "+miProgramador.toString());
			return apps;
		}
		log.error("[Error]UsuarioImplementation[obtenerAppsProgramador(<Class> Programador)] ==> miProgramador = null");
		return apps;
	}

	public List<App> obtenerAppsCliente(Cliente miCliente) {
		List<App> apps = null;
		if (miCliente != null) {
			apps = miCliente.getApps();
			log.info("[Info]UsuarioImplementation[obtenerAppsCliente(<Class> Cliente)] ==> Recuperada correctamente la lista de appps del cliente: "+miCliente.toString());
			return apps;
		}
		log.error("[Error]UsuarioImplementation[obtenerAppsCliente(<Class> Cliente)] ==> miCliente = null");
		return apps;
	}

	public List<Cliente> obtenerClientesApp(App miApp) {
		List<Cliente> clientes = null;
		/*if (miApp != null) {
			Long id_app = miApp.getIdApp(); //necesario para consultar en la tabla N:M clientes-apps
			clientes = QUERY
			log.info("[Info]UsuarioImplementation[obtenerClientesApp(<Class> App)] ==> Recuperada correctamente la lista de clientes para la app: "+miApp.toString());
			return clientes;
		}
		log.error("[Error]UsuarioImplementation[obtenerClientesApp(<Class> App)] ==> No se pudo encontrar ningún cliente ligado a la app solicitada");
		*/
		return clientes;
	}

	public void cancelarClientes(App miApp) {
		if (miApp != null) {
			Long id_app = miApp.getIdApp(); //necesario para consultar en la tabla N:M clientes-apps
			//clientes = appDAO.findAllClientes(miApp);
			//quitar la app de la lista del usuario con SetApps, luego hacer usuarioDAO.update() y lanzar un remove de que dicho usuario ya no está ligado a dicha app en cli_app
			// TODO 
			log.info("[Info]UsuarioImplementation[cancelarClientes(<Class> App)] ==> Cancelados los clientes de la app: "+miApp.toString());
		}
		log.error("[Error]UsuarioImplementation[cancelarClientes(<Class> App)] ==> miApp = null");
	}

	public void registrarNuevaVersion(Version miVersion) {
		try {
			if (miVersion != null) {
				versionDAO.create(miVersion);
				log.info("[Info]UsuarioImplementation[registrarNuevaVersion(<Clase> Version)] ==> Registrada la versión: "
						+ miVersion.toString());
			} else
				log.error("[Error]UsuarioImplementation[registrarNuevaVersion(<Clase> Version)] ==> version = null");
		} catch (DataAccessException e) {
			log.error("[Error]VUsuarioImplementation[registrarNuevaVersion(<Clase> Version)] ==> No se pudo registrar la versión");
			throw e;
		}
	}

	public void borrarVersion(Version miVersion) {
		try {
			if (miVersion != null) {
				log.info("[Info]UsuarioImplementation[borrarVersion(<Clase> Version)] ==> Borrando la versión: "
						+ miVersion.toString() + " ...");
				versionDAO.remove(miVersion);
				log.info("[Info]UsuarioImplementation[borrarVersion(<Clase> Version)] ==> ...Versión borrada satisfactoriamente");
			} else
				log.error("[Error]UsuarioImplementation[borrarVersion(<Clase> Version)] ==> version = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[borrarVersion(<Clase> Version)] ==> No se pudo registrar la versión");
			throw e;
		}
	}

	public Version BuscarVersionPorId(Long id) {
		Version version = null;
		try {
			if (id != null) {
				version = versionDAO.findById(id);
				if (version == null)
					log.info("[Info]UsuarioImplementation[buscarVersionPorId((<Long> id)] ==> No se ha encontrado la versión con id: "
							+ id);
				else
					log.info("[Info]UsuarioImplementation[buscarVersionPorId(<Long> id)] ==> Encontrada la versión: "
							+ version.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarVersionPorId(<Long> id)] ==> id = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarVersionPorId(<Long> id)] ==> No se pudo encontrar la versión con id: "
					+ id);
			throw e;
		}
		return version;
	}

	public List<Version> obtenerListaVersiones(App miApp) {
		List<Version> versiones = null;
		if (miApp != null) {
			versiones = miApp.getVersiones();
			log.info("[Info]UsuarioImplementation[obtenerListaVersiones(<Class> App)] ==> Recuperada correctamente la lista de versiones del cliente: "+miApp.toString());
			return versiones;
		}
		log.error("[Error]UsuarioImplementation[obtenerListaVersiones(<Class> App)] ==> miApp = null");
		return versiones;
	}

	public Version obtenerUltimaVersion(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

}
