
package mx.com.lomas.vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.com.lomas.dao.UsuarioDAO;
import mx.com.lomas.modelo.Usuario;
import mx.com.lomas.vista.FrmPrincipal;


public class FrmLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmLogin.class.getName());

   
    public FrmLogin() {

    initComponents();

    txtContrasena.setText("");
    lblVersion.setText("Versión 0.4.0");
    setLocationRelativeTo(null);

    cargarLogo();

    }

     private void cargarLogo() {

    java.net.URL ruta =
            getClass().getResource("/imagenes/logo.png");

    if (ruta == null) {
        JOptionPane.showMessageDialog(
                this,
                "No se encontró el logo."
        );
        return;
    }

    ImageIcon iconoOriginal = new ImageIcon(ruta);

    int anchoOriginal = iconoOriginal.getIconWidth();
    int altoOriginal = iconoOriginal.getIconHeight();

    int anchoMaximo = 270;
    int altoMaximo = 270;

    double escala = Math.min(
            (double) anchoMaximo / anchoOriginal,
            (double) altoMaximo / altoOriginal
    );

    int nuevoAncho = (int) (anchoOriginal * escala);
    int nuevoAlto = (int) (altoOriginal * escala);

    Image imagenEscalada = iconoOriginal
            .getImage()
            .getScaledInstance(
                    nuevoAncho,
                    nuevoAlto,
                    Image.SCALE_SMOOTH
            );

    lblLogo.setIcon(new ImageIcon(imagenEscalada));
    lblLogo.setText("");
    lblLogo.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );
    lblLogo.setVerticalAlignment(
            javax.swing.SwingConstants.CENTER
    );
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIzquierdo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jblSubtitulo = new javax.swing.JLabel();
        jblTitulo1 = new javax.swing.JLabel();
        pnlDerecho = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jlbContrasena = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lomas Alejandro ERP - Inicio de sesión");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 650));
        setResizable(false);

        pnlIzquierdo.setBackground(new java.awt.Color(34, 91, 46));
        pnlIzquierdo.setForeground(new java.awt.Color(255, 255, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        lblLogo.setMaximumSize(new java.awt.Dimension(500, 500));
        lblLogo.setMinimumSize(new java.awt.Dimension(500, 522));
        lblLogo.setPreferredSize(new java.awt.Dimension(440, 422));

        jblSubtitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jblSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jblSubtitulo.setText("Sistema Integral de\n Administración para Viveros");

        jblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jblTitulo1.setText("LOMAS ALEJANDRO ERP");

        javax.swing.GroupLayout pnlIzquierdoLayout = new javax.swing.GroupLayout(pnlIzquierdo);
        pnlIzquierdo.setLayout(pnlIzquierdoLayout);
        pnlIzquierdoLayout.setHorizontalGroup(
            pnlIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzquierdoLayout.createSequentialGroup()
                .addGroup(pnlIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIzquierdoLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlIzquierdoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlIzquierdoLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlIzquierdoLayout.setVerticalGroup(
            pnlIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzquierdoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(34, 91, 46));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(34, 91, 46));
        jLabel1.setText("BIENVENIDO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 122, 122));
        jLabel2.setText("Inicia sesión para continuar");

        lblUsuario.setText("Usuario");

        jlbContrasena.setText("Contraseña");

        lblVersion.setText("version");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtContrasena.setText("jPasswordField1");

        btnIniciarSesion.setBackground(new java.awt.Color(0, 102, 0));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesion");
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDerechoLayout = new javax.swing.GroupLayout(pnlDerecho);
        pnlDerecho.setLayout(pnlDerechoLayout);
        pnlDerechoLayout.setHorizontalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                        .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDerechoLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDerechoLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblVersion)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDerechoLayout.setVerticalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jlbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDerecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
       String usuario = txtUsuario.getText().trim();
String contrasena = new String(txtContrasena.getPassword());

if (usuario.isEmpty() || contrasena.isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Ingresa tu usuario y contraseña.",
            "Campos vacíos",
            JOptionPane.WARNING_MESSAGE
    );

    return;
}

UsuarioDAO usuarioDAO = new UsuarioDAO();

Usuario usuarioEncontrado =
        usuarioDAO.iniciarSesion(usuario, contrasena);

if (usuarioEncontrado != null) {

    FrmPrincipal frmPrincipal = new FrmPrincipal();

    frmPrincipal.setLocationRelativeTo(null);
    frmPrincipal.setVisible(true);

    this.dispose();



} else {

    JOptionPane.showMessageDialog(
            this,
            "Usuario o contraseña incorrectos.",
            "Error de inicio de sesión",
            JOptionPane.ERROR_MESSAGE
    );
}
        
        
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jblSubtitulo;
    private javax.swing.JLabel jblTitulo1;
    private javax.swing.JLabel jlbContrasena;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlDerecho;
    private javax.swing.JPanel pnlIzquierdo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
