package br.com.transportadora.Cotroller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.transportadora.DAO.GenericDao;
import br.com.transportadora.DAO.GenericDaoImpl;
import br.com.transportadora.DAO.MotoristaDAO;
import br.com.transportadora.Model.Motorista;


@ManagedBean
@SessionScoped
public class MotoristaBean {
	private Motorista motoristaCadastro;
	private List<Motorista> listaMotorista;//lista utilizada para fazer as consultas
	private String acao;
	private Long codigo;

	public void salvar() {
		
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.save(motoristaCadastro);
			motoristaCadastro = new Motorista();
			FacesUtil.msgInfor("Cliente salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar salvar cliente: "
					+ ex.getMessage());
		}

	}

	public void pesquisarClientes() {
		MotoristaDAO dao = new MotoristaDAO();
		try {
			
				listaMotorista = dao.listar();
			
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao listar motoristas" + ex.getMessage());
		}

	}

	public void carregarMotorista() {
		
		try {
			if (codigo != null) {//verifica se o codigo estiver nulo então ele ira instanciar para salvar um novo
				MotoristaDAO dao = new MotoristaDAO();
				motoristaCadastro = dao.buscaPorCodigo(codigo);
			}else{
				motoristaCadastro = new Motorista();
			}
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao obter cliente" + ex.getMessage());
		}
	}	
	
	public void excluir() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.remove(motoristaCadastro);
			FacesUtil.msgInfor("Motorista removido com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar remover o motorista: "
					+ ex.getMessage());
		}

	}
	public void editar() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.update(motoristaCadastro);
			FacesUtil.msgInfor("Cliente editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar editar o cliente: "
					+ ex.getMessage());
		}

	}

	public Motorista getMotoristaCadastro() {
		if(motoristaCadastro==null){
			motoristaCadastro = new Motorista();
		}
		return motoristaCadastro;
	}

	public void setMotoristaCadastro(Motorista motoristaCadastro) {
		this.motoristaCadastro = motoristaCadastro;
	}

	public List<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(List<Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

}
