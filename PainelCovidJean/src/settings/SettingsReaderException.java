package settings;

import java.io.IOException;

/**
 *
 * @author luizh
 */
public class SettingsReaderException extends IOException {

    public SettingsReaderException() {
    }

    public SettingsReaderException(String message) {
        super(message);
    }

    public SettingsReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingsReaderException(Throwable cause) {
        super(cause);
    }
    
}
