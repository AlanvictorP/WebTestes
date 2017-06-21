package br.com.transportadora.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.transportadora.Model.Caminhao;
import br.com.transportadora.Model.Motorista;


public class CaminhaoDAO {

	 @SuppressWarnings("unchecked")
	 public List<Caminhao> listarCaminhaoPorMotorista(Motorista m) {

     Session session = NewHibernateUtil.getSessionFactory().openSession();
     Transaction t = session.beginTransaction();
     List<Caminhao> lista = session.createQuery("from Caminhao as c where c.motorista.cpf = :id").setParameter("id", m.getCpf()).list();
     t.commit();
     session.close();
     return lista;
 }
	 @SuppressWarnings("unchecked")
	public List<Caminhao> listar() {
	        
		    	Session session = NewHibernateUtil.getSessionFactory().openSession();
		        Transaction t = session.beginTransaction();
		        
		     
		        List<Caminhao> lista = session.createQuery("from Caminhao").list();
		        t.commit();
		        session.close();
		        
		        return lista;
		    }
		      
		  	public Caminhao buscaPorCodigo(Long codigo) {
				Session sessao = NewHibernateUtil.getSessionFactory().openSession();
				Caminhao caminhao = null;

				try {
					Query consulta = sessao.getNamedQuery("Caminhao.buscarPorCodigo");
					consulta.setLong("codigo", codigo);

					caminhao = (Caminhao) consulta.uniqueResult();

				} catch (RuntimeException ex) {

					throw ex;
				} finally {
					sessao.close();
				}
				return caminhao;
			}
}
