package model.dao;

import java.util.List;

/**
 *
 * @author luizh
 * @param <T> Entities
 * @param <F> Filters
 */
public interface DAO<T, F> {
    
    public List<T> list(F filters) throws DAOException;
    public List<T> listAll() throws DAOException;
    
    
}
