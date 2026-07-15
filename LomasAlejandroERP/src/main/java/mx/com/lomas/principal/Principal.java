package mx.com.lomas.principal;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mx.com.lomas.vista.FrmLogin;

public class Principal {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.out.println("No fue posible cargar FlatLaf.");
        }

        SwingUtilities.invokeLater(() -> {
            FrmLogin login = new FrmLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }
}