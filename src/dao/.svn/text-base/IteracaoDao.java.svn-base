package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modal.Fichas;
import modal.Iteracoes;

import util.HibernateUtil;

public class IteracaoDao {
	private EntityManager sessao;

	public IteracaoDao(){
		this.setSessao(HibernateUtil.getManagerFactory());
	}

	public EntityManager getSessao() {
		return sessao;
	}

	public void setSessao(EntityManager sessao) {
		this.sessao = sessao;
	}
	
	
	public boolean inserir(Iteracoes iteracao, String statusChamado){
		boolean retorno = false;
		
		try {
			sessao.getTransaction().begin();
			sessao.persist(iteracao);
						
			if (statusChamado.equals("B")){				
				Fichas fic = new Fichas();
				Query q = sessao.createQuery("SELECT f FROM Fichas f WHERE f.numero = ?");
				q.setParameter(1, iteracao.getFichaRef());
				fic = (Fichas)q.getSingleResult();
				fic.setStatus("B");
				
				sessao.persist(fic);
			}
			
			sessao.getTransaction().commit();
			
			retorno = true;
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Falha: " + e.getMessage());
			sessao.getTransaction().rollback();
			
		}
		
		return retorno;
	}
}
