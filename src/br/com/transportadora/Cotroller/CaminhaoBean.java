package br.com.transportadora.Cotroller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.transportadora.DAO.CaminhaoDAO;
import br.com.transportadora.DAO.GenericDao;
import br.com.transportadora.DAO.GenericDaoImpl;
import br.com.transportadora.DAO.MotoristaDAO;
import br.com.transportadora.Model.Caminhao;
import br.com.transportadora.Model.Motorista;


@ManagedBean
@SessionScoped
public class CaminhaoBean {
	private Caminhao caminhaoCadastro;
	private List<Caminhao> listaCaminhao;//lista utilizada para fazer as consultas
	private List<Motorista> listaMotorista;
	private String acao;
	private Long codigo;

	public void salvar() {
		
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.save(caminhaoCadastro);
			caminhaoCadastro = new Caminhao();
			FacesUtil.msgInfor("Caminhão salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar salvar caminhão: "
					+ ex.getMessage());
		}

	}

	public void carregarMotoristas(){
		try{
			MotoristaDAO daoMotorista = new MotoristaDAO();
			listaMotorista = daoMotorista.listar();
						
		}catch(RuntimeException ex){
			FacesUtil.msgError("Erro ao obter Motorista" + ex.getMessage());
		}
	}
	public void pesquisarCaminhao() {
		CaminhaoDAO dao = new CaminhaoDAO();
		try {			
				listaCaminhao = dao.listar();
			
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao listar caminhões" + ex.getMessage());
		}

	}

	public void carregarCaminhao() {
		
		try {
			if (codigo != null) {//verifica se o codigo estiver nulo então ele ira instanciar para salvar um novo
				CaminhaoDAO dao = new CaminhaoDAO();
				caminhaoCadastro = dao.buscaPorCodigo(codigo);
			}else{
				caminhaoCadastro = new Caminhao();
			}
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao obter caminhão" + ex.getMessage());
		}
	}	
	
	public void excluir() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.remove(caminhaoCadastro);
			FacesUtil.msgInfor("Caminhão removido com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar remover o caminhão: "
					+ ex.getMessage());
		}

	}
	public void editar() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.update(caminhaoCadastro);
			FacesUtil.msgInfor("Cliente editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar editar o cliente: "
					+ ex.getMessage());
		}

	}

	public Caminhao getCaminhaoCadastro() {
		if(caminhaoCadastro == null){
			caminhaoCadastro = new Caminhao();
		}
		return caminhaoCadastro;
	}

	public void setCaminhaoCadastro(Caminhao caminhaoCadastro) {
		this.caminhaoCadastro = caminhaoCadastro;
	}

	public List<Caminhao> getListaCaminhao() {
		return listaCaminhao;
	}

	public void setListaCaminhao(List<Caminhao> listaCaminhao) {
		this.listaCaminhao = listaCaminhao;
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

	public List<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(List<Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	
	



}
