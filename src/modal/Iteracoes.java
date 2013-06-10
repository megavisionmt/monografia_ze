package modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_iteracoes")
public class Iteracoes implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	@Column
	private Date data;
	@Column
	private int fichaRef;
	@Column
	private String solucao;
	@JoinColumn(name="id")
	@OneToOne
	private Usuarios usuario;
	
	public Iteracoes(){
		this.id = 0;
		this.data = new Date();
		this.fichaRef = 0;
		this.solucao = "";
		this.usuario = new Usuarios();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getFichaRef() {
		return fichaRef;
	}

	public void setFichaRef(int fichaRef) {
		this.fichaRef = fichaRef;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Iteracoes))
			return false;
		Iteracoes other = (Iteracoes) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
