package mx.com.lomas.componentes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenu extends JPanel {

    public PanelMenu(
            Runnable accionDashboard,
            Runnable accionUsuarios) {

        configurarPanel();

        agregarTitulo();

        agregarOpciones(
                accionDashboard,
                accionUsuarios
        );
    }

    private void configurarPanel() {

        setBackground(new Color(34, 91, 46));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(250, 800));
    }

    private void agregarTitulo() {

        JLabel titulo = new JLabel("LOMAS ALEJANDRO ERP");

        titulo.setForeground(Color.WHITE);

        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        titulo.setAlignmentX(CENTER_ALIGNMENT);

        titulo.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 50)
        );

        titulo.setFont(
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.BOLD,
                        18
                )
        );

        add(Box.createVerticalStrut(30));

        add(titulo);

        add(Box.createVerticalStrut(40));
    }

    private void agregarOpciones(
            Runnable accionDashboard,
            Runnable accionUsuarios) {

        add(new MenuItem(
                "Dashboard",
                accionDashboard
        ));

        add(new MenuItem(
                "Usuarios",
                accionUsuarios
        ));

        add(new MenuItem(
                "Clientes",
                null
        ));

        add(new MenuItem(
                "Proveedores",
                null
        ));

        add(new MenuItem(
                "Inventario",
                null
        ));

        add(new MenuItem(
                "Compras",
                null
        ));

        add(new MenuItem(
                "Ventas",
                null
        ));

        add(new MenuItem(
                "Reportes",
                null
        ));

        add(new MenuItem(
                "Configuración",
                null
        ));

        add(Box.createVerticalGlue());

        add(new MenuItem(
                "Cerrar sesión",
                null
        ));

        add(Box.createVerticalStrut(20));
    }
}