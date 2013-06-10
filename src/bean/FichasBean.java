package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FichaDao;

import modal.Departamentos;
import modal.Fichas;
import modal.Iteracoes;
import modal.Sistemas;
import modal.Usuarios;

@ManagedBean
@SessionScoped
public class FichasBean {
	private Fichas fichaSelecionada;
	private Iteracoes iteracaoSelecionada;
	private FichaDao fichaDao;
	private List<Sistemas> sistemas;
	private List<Departamentos> departamentos;
	private List<Fichas> filtroFichas;
	private Usuarios usuario;	
	
	
	//Construtor
	public FichasBean(){
		this.limparFichas();
		this.carregar_departamentos();
		this.carregar_sistemas();
		this.allFichasTodas();
	}
	
	public Fichas getFichaSelecionada() {
		return fichaSelecionada;
	}

	public void setFichaSelecionada(Fichas fichaSelecionada) {
		this.fichaSelecionada = fichaSelecionada;
	}

	public Iteracoes getIteracaoSelecionada() {
		return iteracaoSelecionada;
	}

	public void setIteracaoSelecionada(Iteracoes iteracaoSelecionada) {
		this.iteracaoSelecionada = iteracaoSelecionada;
	}

	public FichaDao getFichaDao() {
		return fichaDao;
	}

	public void setFichaDao(FichaDao fichaDao) {
		this.fichaDao = fichaDao;
	}

	public List<Sistemas> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<Sistemas> sistemas) {
		this.sistemas = sistemas;
	}

	public List<Fichas> getFiltroFichas() {
		return filtroFichas;
	}

	public void setFiltroFichas(List<Fichas> filtroFichas) {
		this.filtroFichas = filtroFichas;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<Departamentos> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamentos> departamentos) {
		this.departamentos = departamentos;
	}

	
	//------------------------

	public void limparFichas(){
		this.departamentos = new ArrayList<Departamentos>();
		this.sistemas = new ArrayList<Sistemas>();
		this.fichaSelecionada = new Fichas();
		this.iteracaoSelecionada = new Iteracoes();
		this.usuario = new Usuarios();
		this.fichaDao = new FichaDao();
		this.filtroFichas = new ArrayList<Fichas>();
	}
	
	public String nova_ficha(){
		this.fichaSelecionada = new Fichas();
		return "/fichas.xhtml";
	}
	
	public void carregar_departamentos(){
		this.departamentos = this.fichaDao.list_departamentos(); 		
	}
	
	public void carregar_sistemas(){
		this.sistemas = this.fichaDao.list_sistemas(); 		
	}
	
	public void allFichasAbertas(){		
		this.filtroFichas = this.fichaDao.list_fichas_byStatus("A");
	}
	public void allFichasBaixadas(){		
		this.filtroFichas = this.fichaDao.list_fichas_byStatus("F");
	}
	public void allFichasTodas(){		
		this.filtroFichas = getAllFichasByUsuario();
	}
	
	public List<Fichas> getAllFichasByUsuario(){
		return this.fichaDao.list_fichas_byUsuario(this.usuario);
	}
	
	public List<Iteracoes> getAllIteracoesByFicha(){		
		return this.fichaDao.list_iteracoes_byFicha(this.fichaSelecionada.getNumero());
	}
	
	public String salvar(){
		String retorno = "falha";
		
		if (this.fichaDao.inserir(this.fichaSelecionada)){
			this.fichaSelecionada = new Fichas();
			retorno = "/menu_clientes.xhtml";
		}
		
		return retorno;
	}
	
	public String mostrarIteracoes(){		
		return "/iteracoes_ficha.xhtml";
	}

	public String getTeste(){
		System.out.println(this.usuario.getNome());
		return "/menu_clientes.xhtml";
	}

}
