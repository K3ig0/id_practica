package es.udc.fi.lbd.monuzz.id.apps.services;
import java.util.List;






import es.udc.fi.lbd.monuzz.id.apps.model.App;
import es.udc.fi.lbd.monuzz.id.apps.model.Cliente;
import es.udc.fi.lbd.monuzz.id.apps.model.Programador;
import es.udc.fi.lbd.monuzz.id.apps.model.Usuario;
import es.udc.fi.lbd.monuzz.id.apps.model.Version;

public class UsuarioImplementation implements UsuarioService {

	@Override
	public void registrarNuevoUsuario(Usuario miUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarUsuario(Usuario miUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarUsuario(Usuario miUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario autenticarUsuario(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuarioPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obtenerListaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Programador> obtenerListaProgramadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarApp(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public App buscarAppPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App buscarAppPorTitulo(String miTitulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> obtenerAppsProgramador(Programador miProgramador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> obtenerAppsCliente(Cliente miCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> obtenerClientesApp(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelarClientes(App miApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarNuevaVersion(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarVersion(Version miVersion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Version BuscarVersionPorId(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Version> obtenerListaVersiones(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Version obtenerUltimaVersion(App miApp) {
		// TODO Auto-generated method stub
		return null;
	}
		
	}
