package mx.com.lomas.vista;
import java.awt.Color;
import java.awt.FlowLayout;
import mx.com.lomas.componentes.CardEstadistica;


public class PanelDashboard extends javax.swing.JPanel {

   
    public PanelDashboard() {

    initComponents();

    configurarTarjetas();
}
        private void configurarTarjetas() {

    pnlTarjetas.setLayout(
            new FlowLayout(
                    FlowLayout.LEFT,
                    20,
                    10
            )
    );

    CardEstadistica tarjetaVentas =
            new CardEstadistica(
                    "Ventas del día",
                    "$0.00",
                    "Sin ventas registradas",
                    Color.WHITE
            );

    CardEstadistica tarjetaInventario =
            new CardEstadistica(
                    "Productos en inventario",
                    "0",
                    "Productos registrados",
                    Color.WHITE
            );

    CardEstadistica tarjetaClientes =
            new CardEstadistica(
                    "Clientes registrados",
                    "0",
                    "Clientes activos",
                    Color.WHITE
            );

    CardEstadistica tarjetaCompras =
            new CardEstadistica(
                    "Compras del mes",
                    "0",
                    "Compras registradas",
                    Color.WHITE
            );

    pnlTarjetas.removeAll();

    pnlTarjetas.add(tarjetaVentas);
    pnlTarjetas.add(tarjetaInventario);
    pnlTarjetas.add(tarjetaClientes);
    pnlTarjetas.add(tarjetaCompras);

    pnlTarjetas.revalidate();
    pnlTarjetas.repaint();
}
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBienvenida = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        lblResumen = new javax.swing.JLabel();
        pnlTarjetas = new javax.swing.JPanel();
        pnlSeccionInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(245, 247, 250));

        pnlBienvenida.setBackground(new java.awt.Color(245, 247, 250));

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblBienvenida.setText("¡Bienvenido, Gerardo!");

        lblResumen.setBackground(new java.awt.Color(100, 110, 120));
        lblResumen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResumen.setText("Aquí tienes un resumen general de tu empresa.");

        javax.swing.GroupLayout pnlBienvenidaLayout = new javax.swing.GroupLayout(pnlBienvenida);
        pnlBienvenida.setLayout(pnlBienvenidaLayout);
        pnlBienvenidaLayout.setHorizontalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBienvenidaLayout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );
        pnlBienvenidaLayout.setVerticalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblResumen)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pnlTarjetas.setBackground(new java.awt.Color(245, 247, 250));

        javax.swing.GroupLayout pnlTarjetasLayout = new javax.swing.GroupLayout(pnlTarjetas);
        pnlTarjetas.setLayout(pnlTarjetasLayout);
        pnlTarjetasLayout.setHorizontalGroup(
            pnlTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTarjetasLayout.setVerticalGroup(
            pnlTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        pnlSeccionInferior.setBackground(new java.awt.Color(245, 247, 250));

        javax.swing.GroupLayout pnlSeccionInferiorLayout = new javax.swing.GroupLayout(pnlSeccionInferior);
        pnlSeccionInferior.setLayout(pnlSeccionInferiorLayout);
        pnlSeccionInferiorLayout.setHorizontalGroup(
            pnlSeccionInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSeccionInferiorLayout.setVerticalGroup(
            pnlSeccionInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSeccionInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTarjetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeccionInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblResumen;
    private javax.swing.JPanel pnlBienvenida;
    private javax.swing.JPanel pnlSeccionInferior;
    private javax.swing.JPanel pnlTarjetas;
    // End of variables declaration//GEN-END:variables
}
