package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.UsuarioDao;

import modal.Usuarios;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private Usuarios usuario;
	private UsuarioDao usuarioDao;
	
	
	public UsuarioBean(){
		this.usuario = new Usuarios();
		this.usuarioDao = new UsuarioDao();		
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
	public String Logar(){
		String retornar = "/login.xhtml";
		
		this.usuario = this.usuarioDao.VerificarUsuario(this.usuario.getLogin(), this.usuario.getSenha()); 
		
		if (this.usuario.getId() > 0){
			
			if (this.usuario.getTipo().equals("C")){
				System.out.println("Retornar Pagina de Clientes");
				System.out.println(this.usuario.getTipo());
				retornar = "/menu_clientes";
			} else {
				
				System.out.println("Retornar Pagina de Técnicos");
				System.out.println(this.usuario.getTipo());
				retornar = "/menu_tecnicos";
			}
		}

		return retornar;
	}

}
