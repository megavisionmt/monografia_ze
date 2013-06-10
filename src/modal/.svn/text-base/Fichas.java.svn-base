package modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_fichas")
public class Fichas implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numero;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	@Column
	private String departamento;
	@JoinColumn(name="usuario")
	@ManyToOne
	private Usuarios usuario;
	@Column
	private String sistema;
	@Column
	private String assunto;
	@Column
	private String problema;
	@Column
	private String status;
	
	public Fichas(){
		this.numero = 0;
		this.data = new Date();
		this.departamento = "";
		this.usuario = new Usuarios();
		this.sistema = "";
		this.assunto = "";
		this.problema = "";
		this.status = "A";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Fichas))
			return false;
		Fichas other = (Fichas) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

}
