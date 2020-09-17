package settings;

import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import util.io.TextReader;

/**
 *
 * @author luizh
 */
public class SettingsReader {
    
    //==========================================================================
    //MÉTODOS PÚBLICOS
    //==========================================================================
    public Settings read(File file) throws SettingsReaderException, IOException{
        String text = new TextReader(file).readAll();
        JSONObject jsonObject = new JSONObject(text);
        Settings settings = new Settings();
        settings.setDbHost(jsonObject.getString("dbHost"));
        settings.setDbPort(jsonObject.getInt("dbPort"));
        settings.setDbName(jsonObject.getString("dbName"));
        settings.setDbUsername(jsonObject.getString("dbUsername"));
        settings.setDbPassword(jsonObject.getString("dbPassword"));
        return settings;
    }
    
}
