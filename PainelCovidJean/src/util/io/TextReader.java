package util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author luizh
 */
public class TextReader {
    
    //==========================================================================
    //VARIÁVEIS
    //==========================================================================
    private final File file;
    
    //==========================================================================
    //CONSTRUTORES
    //==========================================================================
    public TextReader(File file) {
        this.file = file;
    }
    
    //==========================================================================
    //MÉTODOS PÚBLICOS
    //==========================================================================
    public String readAll() throws FileNotFoundException, IOException {
        try (InputStream is = new FileInputStream(file)){
            StringBuilder builder = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[4096];
            int len;
            while ((len=reader.read(buffer))>0){
                builder.append(buffer, 0, len);
            }
            return builder.toString();
        }
    }
    
}
