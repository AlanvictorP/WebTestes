package br.com.transportadora.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.transportadora.Model.Motorista;


public class MotoristaDAO {
  

    @SuppressWarnings("unchecked")
	public List<Motorista> listarPorCPF(Motorista motorista) {
        
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<Motorista> lista = session.createQuery("from Motorista as m where m.cpf = :cpf").setParameter("cpf", motorista.getCpf()).list();
        t.commit();
        session.close();
        
        return lista;
    }
    @SuppressWarnings("unchecked")
	public List<Motorista> listarPorNome(Motorista motorista) {
        
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<Motorista> lista = session.createQuery("from Motorista as m where m.nome = :nome").setParameter("nome", motorista.getNome()).list();
        t.commit();
        session.close();
        
        return lista;
    }
    @SuppressWarnings("unchecked")
 	public List<Motorista> listarPorNomeECPF(Motorista motorista) {
         
     Session session = NewHibernateUtil.getSessionFactory().openSession();
         Transaction t = session.beginTransaction();
         List<Motorista> lista = session.createQuery("from Motorista as m where m.nome = :nome AND m.cpf = :cpf").setParameter("nome", motorista.getNome()).setParameter("cpf", motorista.getCpf()).list();
         t.commit();
         session.close();
         
         return lista;
     }
    
      @SuppressWarnings("unchecked")
	public List<Motorista> listar() {
        
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
     
        List<Motorista> lista = session.createQuery("from Motorista ").list();
        t.commit();
        session.close();
        
        return lista;
    }
      
  	public Motorista buscaPorCodigo(Long codigo) {
		Session sessao = NewHibernateUtil.getSessionFactory().openSession();
		Motorista motorista = null;

		try {
			Query consulta = sessao.getNamedQuery("Motorista.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			motorista = (Motorista) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();
		}
		return motorista;
	}
}
