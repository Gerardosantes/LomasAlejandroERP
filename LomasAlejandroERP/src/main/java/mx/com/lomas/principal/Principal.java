package mx.com.lomas.principal;

import com.formdev.flatlaf.FlatLightLaf;
import mx.com.lomas.vista.FrmLogin;

public class Principal {

    public static void main(String[] args) {

        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {

            FrmLogin login = new FrmLogin();
            login.setVisible(true);

        });
    }
}