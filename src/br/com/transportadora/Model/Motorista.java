package br.com.transportadora.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "motorista")
@NamedQueries({
	@NamedQuery(name = "Motorista.buscarPorCodigo",query="SELECT motorista FROM Motorista motorista where motorista.codigo = :codigo")

})

public class Motorista {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idMotorista" , nullable=false)
	 private Long codigo;
	
	@Column(nullable=false)
     private String nome;
	
	@Column(nullable=false)
     private String endereco;
	
	@Column(nullable=false)
     private String telefone;
	
	@Column(nullable=false)
     private String cpf;
	
	@Column(nullable=false)
     private String pis;
     
     @OneToMany(fetch=FetchType.EAGER, mappedBy="motorista")
     private List<Caminhao>caminhaos;

    public Motorista() {
    }

	
    public Motorista(String nome, String endereco, String telefone, String cpf, String pis) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.pis = pis;
    }   
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPis() {
        return this.pis;
    }
    
    public void setPis(String pis) {
        this.pis = pis;
    }


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public List<Caminhao> getCaminhaos() {
		return caminhaos;
	}


	public void setCaminhaos(List<Caminhao> caminhaos) {
		this.caminhaos = caminhaos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorista other = (Motorista) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Motorista [idMotorista=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + ", cpf=" + cpf + ", pis=" + pis + ", caminhaos=" + caminhaos + "]";
	}
    
   
}
