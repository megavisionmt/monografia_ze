package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modal.Departamentos;
import modal.Fichas;
import modal.Iteracoes;
import modal.Sistemas;
import modal.Usuarios;

import util.HibernateUtil;

public class FichaDao {
	private EntityManager sessao;

	public FichaDao(){
		this.setSessao(HibernateUtil.getManagerFactory());
	}
	
	public EntityManager getSessao() {
		return sessao;
	}

	public void setSessao(EntityManager sessao) {
		this.sessao = sessao;
	}

	@SuppressWarnings("unchecked")
	public List<Departamentos> list_departamentos(){
		List<Departamentos> resultado = new ArrayList<Departamentos>();
		
		try {			
			Query consulta = sessao.createQuery("Select dep From Departamentos dep Order By dep.nome");			
			resultado = (List<Departamentos>)consulta.getResultList(); 
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Sistemas> list_sistemas(){
		List<Sistemas> resultado = new ArrayList<Sistemas>();
		
		try {			
			Query consulta = sessao.createQuery("Select sist From Sistemas sist Order By sist.nome");			
			resultado = (List<Sistemas>)consulta.getResultList(); 
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Fichas> list_fichas_byUsuario(Usuarios usuario){
		List<Fichas> fichas = new ArrayList<Fichas>();
		
		try {			
			Query consulta = sessao.createQuery("Select fi From Fichas fi Where fi.usuario = ?");	
			consulta.setParameter(1, usuario);
			fichas = (List<Fichas>)consulta.getResultList(); 
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return fichas;
	}

	@SuppressWarnings("unchecked")
	public List<Fichas> list_fichas_byStatus(String status){
		List<Fichas> fichas = new ArrayList<Fichas>();
		
		try {			
			Query consulta = sessao.createQuery("Select fi From Fichas fi Where fi.status = ?");
			consulta.setParameter(1, status);
			fichas = (List<Fichas>)consulta.getResultList(); 
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return fichas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Iteracoes> list_iteracoes_byFicha(int numero){
		List<Iteracoes> iteracoes = new ArrayList<Iteracoes>();
		
		try {			
			Query consulta = sessao.createQuery("Select it From Iteracoes it Where it.fichaRef = ?");
			consulta.setParameter(1, numero);
			iteracoes = (List<Iteracoes>)consulta.getResultList(); 
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return iteracoes;
	}

	public boolean inserir(Fichas ficha){
		boolean retorno = false;
		
		try {
			sessao.getTransaction().begin();
			sessao.persist(ficha);
			sessao.getTransaction().commit();
			retorno = true;
			
		} catch (Exception e) {
			sessao.getTransaction().rollback();
		}
		
		return retorno;
	}
}
