package br.com.transportadora.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQueries({
	@NamedQuery(name = "Produto.buscarPorCodigo",query="SELECT produto FROM Produto produto where produto.codigo = :codigo")

})
public class Produto {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idProduto")
    private Long codigo;
	
	private String descricao;
    
    @Column(name="peso", nullable=false, precision=22, scale=0)
    private double peso;
    
    @Column(name="valor", nullable=false, precision=22, scale=0)
    private double valor;

   public Produto() {
   }

   public String getDescricao() {
	return descricao;
}
   public void setDescricao(String descricao) {
	this.descricao = descricao;
}
   public Produto(double peso, double valor) {
      this.peso = peso;
      this.valor = valor;
   }  

   public double getPeso() {
       return this.peso;
   }
   
   public void setPeso(double peso) {
       this.peso = peso;
   }
   
   public double getValor() {
       return this.valor;
   }
   
   public void setValor(double valor) {
       this.valor = valor;
   }
   public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
   public Long getCodigo() {
	return codigo;
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
	Produto other = (Produto) obj;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
	return true;
}

@Override
public String toString() {
	return "Produto [codigo=" + codigo + ", peso=" + peso + ", valor=" + valor
			+ "]";
}
   
   
}

