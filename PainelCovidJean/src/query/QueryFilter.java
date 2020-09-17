package query;

/**
 *
 * @author luizh
 */
public class QueryFilter {
    
    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private String expression;
    private Object[] params;
    
    //==========================================================================
    //CONSTRUTORES
    //==========================================================================
    public QueryFilter(String expression, Object... params) {
        this.expression = expression;
        this.params = params;
    }

    public QueryFilter() {
        
    }
    
    //==========================================================================
    //GETTERS E SETTERS
    //==========================================================================
    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Object[] getParams() {
        return params;
    }
    public void setParams(Object[] params) {
        this.params = params;
    }
    
}
