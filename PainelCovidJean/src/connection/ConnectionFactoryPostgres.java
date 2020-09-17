package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import settings.Settings;

/**
 *
 * @author luizh
 */
public class ConnectionFactoryPostgres implements ConnectionFactory {

    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private final Settings settings;

    //==========================================================================
    //CONSTRUTORES
    //==========================================================================
    public ConnectionFactoryPostgres(Settings settings) {
        this.settings = settings;
    }
    
    //==========================================================================
    //MÉTODOS PÚBLICOS SOBRESCRITOS
    //==========================================================================
    @Override
    public Connection createConnection() throws ConnectionException {
        try {
            String driver = "org.postgresql.Driver";
            String url = String.format("jdbc:postgresql://%s:%d/%s", settings.getDbHost(), settings.getDbPort(), settings.getDbName());
            String user = settings.getDbUsername();
            String pass = settings.getDbPassword();
            
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException|SQLException ex) {
            throw new ConnectionException(ex);
        }
    }

}
