package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modal.Usuarios;

import util.HibernateUtil;

public class UsuarioDao {
	private EntityManager sessao;

	public UsuarioDao(){
		this.setSessao(HibernateUtil.getManagerFactory());
	}
	
	public EntityManager getSessao() {
		return sessao;
	}

	public void setSessao(EntityManager sessao) {
		this.sessao = sessao;
	}

	public Usuarios VerificarUsuario(String login, String senha){
		Usuarios usuario = new Usuarios();
		
		try {			
			Query consulta = sessao.createQuery("Select user From Usuarios user Where user.login = ? AND user.senha = ?");
			consulta.setParameter(1, login);
			consulta.setParameter(2, senha);
			usuario = (Usuarios)consulta.getSingleResult();	
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return usuario;
	}
	
}
