package br.com.transportadora.Cotroller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LogarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public void logar(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
