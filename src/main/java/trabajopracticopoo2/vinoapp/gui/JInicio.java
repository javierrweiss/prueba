package trabajopracticopoo2.vinoapp.gui;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;

public class JInicio extends javax.swing.JFrame {
    UsuarioRepositorio ur;
    JPasswordField psw=new JPasswordField("########",8);
    FormularioDeRegistro fr = new FormularioDeRegistro(this,true);
    public JInicio() {
        initComponents();
        setLocationRelativeTo(null);
        ur = new UsuarioRepositorio(Connector.getConnection());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        pswContraseña = new javax.swing.JPasswordField(8);
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnRegistarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vinoapp");

        lblUsuario.setText("Usuario");

        lblContraseña.setText("Contraseña");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRegistarse.setText("Registrarse");
        btnRegistarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarseActionPerformed(evt);
            }
        });

        jLabel1.setText("¿No estás registrado?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContraseña)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(pswContraseña)
                            .addComponent(txtUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistarse, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)))))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(pswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(btnRegistarse)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarseActionPerformed
        // Evento resgistrarse
    fr.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnRegistarseActionPerformed
    /*
    He seguido las instrucciones y demos de la página de Oracle para configurar el JPasswordField 
    https://docs.oracle.com/javase/tutorial/uiswing/components/passwordfield.html
    Sin embargo, no logro conseguir que trabaje bien.
    */
    
    public boolean isPasswordCorrect(){
    boolean correct=true;
    char[] clave_registrada=fr.getpass();
    char[] clave_ingresada=psw.getPassword();
    if (clave_registrada.length != clave_ingresada.length) {
            correct = false;
        } else {
        correct= Arrays.equals(clave_ingresada, clave_registrada);
        }
    Arrays.fill(clave_registrada, '0');
    return correct;   
    }
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // Evento ingresar
        String usuario_ingresado=txtUsuario.getText(); 
        if(!ur.verifyUsuario(usuario_ingresado)) {  
         JOptionPane.showMessageDialog(this, "Usted ha introducido una contraseña incorrecta o un usuario inexistente");
         return; 
        }  
        if (isPasswordCorrect()) {
            JOptionPane.showMessageDialog(this, "Usted ha introducido una contraseña incorrecta o un usuario inexistente");
            return; 
        } else {
            JOptionPane.showMessageDialog(this, "El login se ha realizado exitosamente");
        }
            MenuPrincipal mP = new MenuPrincipal();
            mP.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnIngresarActionPerformed
 
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswContraseña;
    protected static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
