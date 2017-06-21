package br.com.transportadora.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "caminhao")
@NamedQueries({
	@NamedQuery(name = "Caminhao.buscarPorCodigo",query="SELECT caminhao FROM Caminhao caminhao where caminhao.codigo = :codigo")

})
public class Caminhao{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCaminhao")
     private Long codigo;	

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idMotorista", nullable=false)
     private Motorista motorista;
	
	@Column(nullable = false)
     private String placa;
	
	@Column(nullable=false, precision=22, scale=0)
     private double pesoMax;
	
	@Column(nullable= false)
     private boolean disponivel;

    public Caminhao() {
    }

    public Caminhao(Motorista motorista, String placa, double pesoMax, boolean disponivel) {
       this.motorista = motorista;
       this.placa = placa;
       this.pesoMax = pesoMax;
       this.disponivel = disponivel;
    }     
    
        
   

    public Motorista getMotorista() {
        return this.motorista;
    }
    
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    public double getPesoMax() {
        return this.pesoMax;
    }
    
    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }
    
    public boolean isDisponivel() {
        return this.disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		Caminhao other = (Caminhao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caminhao [codigo=" + codigo + ", motorista=" + motorista
				+ ", placa=" + placa + ", pesoMax=" + pesoMax + ", disponivel="
				+ disponivel + "]";
	}

	


}
