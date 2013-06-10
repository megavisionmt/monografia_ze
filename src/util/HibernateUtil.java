package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory fabrica;
	private static EntityManager sessao;
		
	private static void Iniciar(){		
		try 
		{
			fabrica = Persistence.createEntityManagerFactory("suporte");
			sessao = fabrica.createEntityManager();

		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		}		
	}
	
	public static EntityManager getManagerFactory(){
		HibernateUtil.Iniciar();
		return sessao;
	}
}
