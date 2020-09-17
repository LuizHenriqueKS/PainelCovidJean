package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entity.Painel;
import model.filters.PainelQuery;
import query.QueryBuilder;

/**
 *
 * @author Jean
 */
public class PainelDAO extends DAODefault<Painel, PainelQuery>{

    public PainelDAO(ConnectionFactory cf) {
        super(cf);
    }

    @Override
    protected String getTableName() {
        return "Painel";
    }

    @Override
    protected void prepareQuery(QueryBuilder builder, PainelQuery query) {
        builder.addFilterLike("t.municipio", query.getMunicipioLike());
    }

    @Override
    protected Painel convertToEntity(ResultSet rs) throws SQLException {
        Painel painel = new Painel();
        painel.setRegiao(rs.getString("regiao"));
        painel.setEstado(rs.getString("estado"));
        painel.setMunicipio(rs.getString("municipio"));
        painel.setData(rs.getString("data"));
        painel.setCasosAcumulado(rs.getInt("casosacumulado"));
        painel.setObitosAcumulado(rs.getInt("obitosacumulado"));                
        painel.setRecuperadosnovos(rs.getInt("recuperadosnovos"));
        return painel;
    }

}
