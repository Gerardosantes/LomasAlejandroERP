package mx.com.lomas.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItem extends JPanel {

    private final JLabel lblTexto;

    private final Color colorNormal;
    private final Color colorHover;
    private final Color colorSeleccionado;

    private boolean seleccionado;

    public MenuItem(String texto, Runnable accion) {

        colorNormal = new Color(34, 91, 46);
        colorHover = new Color(45, 120, 62);
        colorSeleccionado = new Color(58, 145, 75);

        seleccionado = false;

        setLayout(null);

        setPreferredSize(new Dimension(230, 48));
        setMinimumSize(new Dimension(230, 48));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));

        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(colorNormal);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblTexto = new JLabel(texto);
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTexto.setForeground(Color.WHITE);
        lblTexto.setBounds(25, 0, 190, 48);

        add(lblTexto);

        agregarEventos(accion);
    }

    private void agregarEventos(Runnable accion) {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent evento) {

                if (!seleccionado) {
                    setBackground(colorHover);
                }
            }

            @Override
            public void mouseExited(MouseEvent evento) {

                if (!seleccionado) {
                    setBackground(colorNormal);
                }
            }

            @Override
            public void mouseClicked(MouseEvent evento) {

                if (accion != null) {
                    accion.run();
                }
            }
        });
    }

    public void setSeleccionado(boolean seleccionado) {

        this.seleccionado = seleccionado;

        if (seleccionado) {
            setBackground(colorSeleccionado);
        } else {
            setBackground(colorNormal);
        }
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public String getTexto() {
        return lblTexto.getText();
    }
}
