package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import query.QueryBuilder;

/**
 *
 * @author luizh
 * @param <T> Entities
 * @param <Q> Query
 */
public abstract class DAODefault<T,Q> implements DAO<T, Q> {
    
    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private final ConnectionFactory cf;
    
    //==========================================================================
    //CONSTRUTORES
    //==========================================================================
    public DAODefault(ConnectionFactory cf) {
        this.cf = cf;
    }
    
    //==========================================================================
    //MÉTODOS ABSTRATOS
    //==========================================================================
    protected abstract String getTableName();
    protected abstract void prepareQuery(QueryBuilder builder, Q query);
    protected abstract T convertToEntity(ResultSet resultSet) throws Exception;
    
    //==========================================================================
    //MÉTODOS PÚBLICOS
    //==========================================================================
    @Override
    public List<T> list(Q query) throws DAOException {
        try (Connection con = cf.createConnection()) {
            List<T> entityList = new ArrayList<>();
            QueryBuilder builder = new QueryBuilder(getTableName(), "t");
            prepareQuery(builder, query);
            
            PreparedStatement stmt = con.prepareStatement(builder.toString());
            int index = 0;
            for (Object param: builder.listParams()){
                stmt.setObject(++index, param);
            }
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                T entity = convertToEntity(rs);
                entityList.add(entity);
            }
            return Collections.unmodifiableList(entityList);
        }   catch (Exception ex) {
            throw new DAOException(ex);
        }
    }

    @Override
    public List<T> listAll() throws DAOException {
        return list(null);
    }
    
}
