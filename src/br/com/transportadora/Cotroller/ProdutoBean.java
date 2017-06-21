package br.com.transportadora.Cotroller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.transportadora.DAO.GenericDao;
import br.com.transportadora.DAO.GenericDaoImpl;
import br.com.transportadora.DAO.ProdutoDAO;
import br.com.transportadora.Model.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {
	private Produto produtoCadastro;
	private List<Produto> listaProduto;//lista utilizada para fazer as consultas
	private String acao;
	private Long codigo;
	private ProdutoFiltro filtro;

	public void salvar() {
		
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.save(produtoCadastro);
			produtoCadastro = new Produto();
			FacesUtil.msgInfor("Produto salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar salvar produto: "
					+ ex.getMessage());
		}

	}

	public void pesquisarProduto() {
		ProdutoDAO dao = new ProdutoDAO();
		
		try {
			if(produtoCadastro.getPeso() != 0 && produtoCadastro.getValor() !=0){
				listaProduto = dao.listarPorPrecoEPeso(produtoCadastro);
			}else if(produtoCadastro.getPeso() !=0 && produtoCadastro.getValor() ==0){
				listaProduto = dao.listarPorPeso(produtoCadastro);
			}else if(produtoCadastro.getPeso() == 0 && produtoCadastro.getValor() != 0){
				listaProduto = dao.listarPorPreco(produtoCadastro);
			}else{
			listaProduto = dao.listar();
			}
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao listar produtos" + ex.getMessage());
		}

	}

	public void carregarProduto() {
		
		try {
			if (codigo != null) {//verifica se o codigo estiver nulo então ele ira instanciar para salvar um novo
				ProdutoDAO dao = new ProdutoDAO();
				produtoCadastro = dao.buscaPorCodigo(codigo);
			}else{
				produtoCadastro = new Produto();
			}
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao obter produto" + ex.getMessage());
		}
	}	
	
	public void excluir() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.remove(produtoCadastro);
			FacesUtil.msgInfor("Produto removido com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar remover o produto: "
					+ ex.getMessage());
		}

	}
	public void editar() {
		try {
			GenericDao dao = new GenericDaoImpl();
			dao.update(produtoCadastro);
			FacesUtil.msgInfor("Produto editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgError("Erro ao tentar editar o produto: "
					+ ex.getMessage());
		}

	}
	
	public ProdutoFiltro getFiltro() {
		return filtro;
	}
	public void setFiltro(ProdutoFiltro filtro) {
		this.filtro = filtro;
	}

	public Produto getProdutoCadastro() {
		if (produtoCadastro == null){
			produtoCadastro = new Produto();
		}
		return produtoCadastro;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
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
