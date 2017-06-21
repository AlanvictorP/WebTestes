package br.com.transportadora.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDaoImpl implements GenericDao  {

    @Override
    public void save(Object obj) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(obj);
        t.commit();
    }

    @Override
    public Object getObject(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Object> list(Object obj) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<Object> lista = session.createQuery("from"+ obj.toString()).list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Object obj) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(obj);
        t.commit();
        session.close();
    }

    @Override
    public void update(Object obj) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(obj);
        t.commit();
        session.close();
    }
}