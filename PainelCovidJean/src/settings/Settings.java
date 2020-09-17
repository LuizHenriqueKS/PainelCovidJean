package settings;

/**
 *
 * @author luizh
 */
public class Settings {
    
    //==========================================================================
    //VARIÁVEIS//
    //=========//
    private String dbHost;
    private String dbName;
    private Integer dbPort;
    private String dbUsername;
    private String dbPassword;
    
    //==========================================================================
    //GETTERS E SETTERS//
    //=================//
    public String getDbHost() {
        return dbHost;
    }
    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public String getDbName() {
        return dbName;
    }
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Integer getDbPort() {
        return dbPort;
    }
    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUsername() {
        return dbUsername;
    }
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
    
}
