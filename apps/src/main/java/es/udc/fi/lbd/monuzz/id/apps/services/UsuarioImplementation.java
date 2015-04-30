package es.udc.fi.lbd.monuzz.id.apps.services;
import java.util.List;






import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;

public class UsuarioImplementation implements UsuarioService {
		
	public void registrarNuevoUsuario (Usuario miUsuario) {
		//@TODO
	}
	
	public void actualizarUsuario (Usuario miUsuario) {
		//@TODO
	}
	
	public void borrarUsuario (Usuario miUsuario) {		// Salta excepcion si aún hay apps ligadas a un programador. Para los clientes, cancela sus subscripciones y borra los clientes
		//@TODO
	}
	
	public Usuario autenticarUsuario (String login, String password) {
		//@TODO
		return null;
	}
	
	public Usuario buscarUsuarioPorId(Long id) {
		//@TODO
		return null;
	}
	
	public Usuario buscarUsuarioPorLogin(String login) {
		//@TODO
		return null;
	}
	
	public List<Usuario> obtenerListaUsuarios() {
		//@TODO
		return null;
	}
	
	public List<Cliente> obtenerListaClientes() {
		//@TODO
		return null;
	}
	
	public List<Programador> obtenerListaProgramadores() {
		//@TODO
		return null;
	}
	
	public void registrarApp (App miApp) {
		//@TODO
		
	}
	
	public void actualizarApp (App miApp) {
		//@TODO
		
	}
	
	public void borrarApp(App miApp) {					// Salta excepcion si aun hay clientes ligados a la App
		//@TODO
		
	}
	
	public App buscarAppPorId(Long id) {
		//@TODO
		return null;
	}
	
	public App buscarAppPorTitulo(String miTitulo) {
		//@TODO
		return null;
	}
	
	public List<App> obtenerAppsProgramador (Programador miProgramador) {
		//@TODO
		return null;
	}
	
	public List<App> obtenerAppsCliente (Cliente miCliente) {
		//@TODO
		return null;
	}
	
	public List<Cliente> obtenerClientesApp (App miApp) {
		//@TODO
		return null;
	}
	
	public void cancelarClientes (App miApp) {
		//@TODO
		
	}
	
	public void registrarNuevaVersion (Version miVersion) {
		//@TODO
		
	}
	
	public void borrarVersion (Version miVersion) {		// Salta excepcion si es la última versión de una app: no se debería borrar
		//@TODO
		
	}
	
	public Version BuscarVersionPorId (Long Id) {
		//@TODO
		return null;
	}
	
	public List<Version> obtenerListaVersiones(App miApp) {
		//@TODO
		return null;
	}
	
	public Version obtenerUltimaVersion (App miApp) {
		//@TODO
		return null;
	}
}
