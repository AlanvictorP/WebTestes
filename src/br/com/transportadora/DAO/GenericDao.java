package br.com.transportadora.DAO;

import java.util.List;

public interface GenericDao {

    public void save(Object obj);
    public Object getObject(long id);
    public List<Object> list(Object obj);
    public void remove(Object obj);
    public void update(Object obj);

}

