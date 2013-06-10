package bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.IteracaoDao;

import modal.Iteracoes;


@ManagedBean
@ViewScoped
public class IteracaoBean {
	private Iteracoes iteracao;
	private IteracaoDao iteracaoDao;
	private String statusChamado;
	
	public IteracaoBean(){
		this.iteracao = new Iteracoes();
		this.iteracaoDao = new IteracaoDao();
		this.statusChamado = "A";
	}

	public Iteracoes getIteracao() {
		return iteracao;
	}

	public void setIteracao(Iteracoes iteracao) {
		this.iteracao = iteracao;
	}

	public IteracaoDao getIteracaoDao() {
		return iteracaoDao;
	}

	public void setIteracaoDao(IteracaoDao iteracaoDao) {
		this.iteracaoDao = iteracaoDao;
	}
		
	public String getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}

	
	
	public String salvar(){
		String retorno = "falha";
		
		if (this.iteracaoDao.inserir(this.iteracao, this.statusChamado)){
			this.iteracao = new Iteracoes();
			retorno = "/menu_tecnicos.xhtml";
		}
		
		return retorno;
	}
}
