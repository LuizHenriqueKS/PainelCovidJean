package model.filters;

/**
 *
 * @author luizh
 */
public class PainelQuery {
    
    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private String municipioLike;
    
    //==========================================================================
    //GETTERS E SETTERS
    //==========================================================================
    public String getMunicipioLike() {
        return municipioLike;
    }
    public PainelQuery setMunicipioLike(String municipioLike) {
        this.municipioLike = municipioLike;
        return this;
    }
    
}
