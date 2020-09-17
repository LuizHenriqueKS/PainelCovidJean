package query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.Util;

/**
 *
 * @author luizh
 */
public class QueryBuilder {
    
    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private final List<String> selectionList;
    private String table;
    private String tableAlias;
    private final List<QueryFilter> filterList;
    private final List<String> sortList;
    
    //==========================================================================
    //CONSTRUTORES
    //==========================================================================
    public QueryBuilder() {
        selectionList = new ArrayList<>();
        filterList = new ArrayList<>();
        sortList = new ArrayList<>();
    }
    
    public QueryBuilder(String table, String tableAlias) {
        this();
        this.table = table;
        this.tableAlias = tableAlias;
    }
    
    //==========================================================================
    //MÉTODOS PÚBLICOS
    //==========================================================================
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        appendSelect(builder);
        builder.append(" FROM ");
        builder.append(table);
        appendTableAlias(builder);
        appendWhere(builder);
        appendOrderBy(builder);
        return builder.toString();
    }
    
    public void addFilter(String expression, Object... params){
        filterList.add(new QueryFilter(expression, params));
    }
    
    public void addFilterLike(String field, String value) {
        if (Util.hasContent(value)){
            String exp = "lower("+field+") like ?";
            String val = "%"+value.toLowerCase().replace(" ", "%")+"%";
            addFilter(exp, val);
        }
    }

    public List<Object> listParams() {
        return filterList.stream()
                         .flatMap(f->Stream.of(f.getParams()))
                         .collect(Collectors.toList());
    }
    
    //==========================================================================
    //MÉTODOS PRIVADOS
    //==========================================================================
    private void appendTableAlias(StringBuilder builder) {
        if (Util.hasContent(tableAlias)){
            builder.append(" AS ");
            builder.append(tableAlias);
        }
    }

    private void appendSelect(StringBuilder builder) {
        if (Util.hasContent(selectionList)){
            builder.append(selectionList.stream().reduce((a,b)->a+", "+b).get());
        } else {
            builder.append("*");
        }
    }
    
    private void appendWhere(StringBuilder builder) {
        if (Util.hasContent(filterList)){
            builder.append(" WHERE ");
            builder.append(filterList.stream().map(f->f.getExpression()).reduce((a,b)->a+" AND "+b).get());
        }
    }

    private void appendOrderBy(StringBuilder builder) {
        if (Util.hasContent(sortList)){
            builder.append(" ORDER BY ");
            builder.append(sortList.stream().reduce((a,b)->a+", "+b).get());
        }
    }
    
    //==========================================================================
    //GETTERS E SETTERS
    //==========================================================================
    public List<String> getSelectionList() {
        return selectionList;
    }
    
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }

    public String getTableAlias() {
        return tableAlias;
    }
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public List<QueryFilter> getFilterList() {
        return filterList;
    }
    
    public List<String> getSortList() {
        return sortList;
    }
    
}
