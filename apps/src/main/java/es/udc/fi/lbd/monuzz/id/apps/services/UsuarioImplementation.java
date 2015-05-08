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
import es.udc.fi.lbd.monuzz.id.apps.model.TipoApp;
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
				log.info("[Info]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> Registrada la aplicación: "
						+ miApp.toString());
			} else
				log.error("[Error]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> app = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[registrarNuevoApp(<Clase> App)] ==> No se pudo registrar la aplicación");
			throw e;
		}
	}

	public void actualizarApp(App miApp) {
		try {
			if (miApp != null) {
				appDAO.update(miApp);
				log.info("[Info]UsuarioImplementation[actualizarApp(<Clase> App)] ==> Actualizada la aplicación: "
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
				appDAO.remove(miApp);
				log.info("[Info]UsuarioImplementation[borrarApp(<Clase> App)] ==> Borrada la aplicación: "
						+ miApp.toString());
			} else
				log.error("[Error]UsuarioImplementation[borrarApp(<Clase> App)] ==> app = null");
		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[borrarApp(<Clase> App)] ==> No se pudo borrar la aplicación");
			throw e;
		}
	}

	public App buscarAppPorId(Long id) {
		App app = null;
		try {
			if (id != null) {
				app = appDAO.findById(id);
				if (app == null)
					log.info("[Info]UsuarioImplementation[buscarAppPorId((<Long> id)] ==> No se ha encontrado la aplicación con id: "
							+ id);
				else
					log.info("[Info]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> Encontrada la aplicación: "
							+ app.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> id = null");

		} catch (DataAccessException e) {
			log.error("[Error]UsuarioImplementation[buscarAppPorId(<Long> id)] ==> No se pudo encontrar la aplicación con id: "
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
					log.info("[Info]UsuarioImplementation[buscarAppPorTitulo((<Long> miTitulo)] ==> No se ha encontrado ninguna aplicación con el título: "
							+ miTitulo);
				else
					log.info("[Info]UsuarioImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> Encontrada la aplicación: "
							+ app.toString());
			} else
				log.error("[Error]UsuarioImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> miTitulo = null");

		} catch (DataAccessException e) {
			log.error("[Error]AppImplementation[buscarAppPorTitulo(<Long> miTitulo)] ==> No se pudo encontrar la aplicación con el título: "
					+ miTitulo);
			throw e;
		}
		return app;
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
