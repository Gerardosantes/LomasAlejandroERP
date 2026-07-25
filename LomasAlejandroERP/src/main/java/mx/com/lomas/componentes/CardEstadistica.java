package mx.com.lomas.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardEstadistica extends JPanel {

    private final JLabel lblTitulo;
    private final JLabel lblValor;
    private final JLabel lblDescripcion;

    private final Color colorFondo;
    private final int radioBorde;

    public CardEstadistica(
            String titulo,
            String valor,
            String descripcion,
            Color colorFondo) {

        this.colorFondo = colorFondo;
        this.radioBorde = 20;

        setOpaque(false);
        setLayout(null);
        setPreferredSize(new Dimension(240, 130));

        lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTitulo.setForeground(new Color(70, 70, 70));
        lblTitulo.setBounds(20, 15, 200, 25);

        lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblValor.setForeground(new Color(34, 91, 46));
        lblValor.setBounds(20, 45, 200, 40);

        lblDescripcion = new JLabel(descripcion);
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDescripcion.setForeground(new Color(100, 110, 120));
        lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDescripcion.setBounds(20, 95, 200, 20);

        add(lblTitulo);
        add(lblValor);
        add(lblDescripcion);
    }

    @Override
    protected void paintComponent(Graphics grafico) {

        Graphics2D grafico2D = (Graphics2D) grafico.create();

        grafico2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        grafico2D.setColor(colorFondo);

        grafico2D.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radioBorde,
                radioBorde
        );

        grafico2D.dispose();

        super.paintComponent(grafico);
    }

    public void setValor(String valor) {
        lblValor.setText(valor);
    }

    public void setDescripcion(String descripcion) {
        lblDescripcion.setText(descripcion);
    }
}