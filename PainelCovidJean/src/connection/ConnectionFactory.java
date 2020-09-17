package connection;

import java.sql.Connection;

/**
 *
 * @author Jean
 */
public interface ConnectionFactory {
    
    public Connection createConnection() throws ConnectionException;
    
}

