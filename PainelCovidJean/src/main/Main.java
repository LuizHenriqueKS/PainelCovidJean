package main;

import connection.ConnectionFactory;
import connection.ConnectionFactoryPostgres;
import java.io.File;
import java.io.IOException;
import settings.Settings;
import settings.SettingsReader;
import view.Tela;

/**
 *
 * @author luizh
 */
public class Main {

    public static void main(String args[]) throws IOException {
        loadSkin();
        Settings settings = new SettingsReader().read(new File("settings.json"));
        ConnectionFactory cf = new ConnectionFactoryPostgres(settings);
        new Tela(cf).setVisible(true);
    }
    
    private static void loadSkin(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
