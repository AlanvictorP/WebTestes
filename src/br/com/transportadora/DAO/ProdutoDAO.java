package br.com.transportadora.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.transportadora.Model.Produto;

public class ProdutoDAO {
	

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
        
	    Session session = NewHibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
	        List<Produto> lista = session.createQuery("from Produto").list();
	        t.commit();
	        session.close();
			return lista;
	}
	        
	      
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarPorPeso(Produto produto) {
        
	    Session session = NewHibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
	        List<Produto> lista = session.createQuery("from Produto as p where p.peso = :peso").setParameter("peso", produto.getPeso()).list();
	        t.commit();
	        session.close();
	        
	        return lista;
	    }
	
@SuppressWarnings("unchecked")
public List<Produto> listarPorPreco(Produto produto) {
        
	    Session session = NewHibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
	        List<Produto> lista = session.createQuery("from Produto as p where p.valor = :valor").setParameter("valor", produto.getValor()).list();
	        t.commit();
	        session.close();
	        
	        return lista;
	    }
@SuppressWarnings("unchecked")
public List<Produto> listarPorPrecoEPeso(Produto produto) {
    
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<Produto> lista = session.createQuery("from Produto as p where p.valor = :valor AND p.peso = :peso").setParameter("valor", produto.getValor()).setParameter("peso", produto.getValor()).list();
        t.commit();
        session.close();
        
        return lista;
    }

public Produto buscaPorCodigo(Long codigo) {
	Session sessao = NewHibernateUtil.getSessionFactory().openSession();
	Produto produto = null;

	try {
		Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
		consulta.setLong("codigo", codigo);

		produto = (Produto) consulta.uniqueResult();

	} catch (RuntimeException ex) {

		throw ex;
	} finally {
		sessao.close();
	}
	return produto;
}


}
