package trabajopracticopoo2.vinoapp.gui;

import ar.org.centro8.curso.java.utils.Validator;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.entidades.Usuario;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;

public class FormularioDeRegistro extends javax.swing.JDialog{
    I_UsuarioRepositorio ur;
    private static JPasswordField psw=new JPasswordField("", 8);
    protected static char[] clave=psw.getPassword();
    Validator val=new Validator();
    Usuario u = new Usuario();
    public static String username=""; 
    public FormularioDeRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        ur= new UsuarioRepositorio(Connector.getConnection());
    }
    
    public void cargar(){
        MenuPrincipal mP = new MenuPrincipal();
        mP.setVisible(true);
        JOptionPane.showMessageDialog(this, "Estimado "+txtNombre.getText()+" su cuenta de usuario"
                + " se ha registrado satisfactoriamente");
        this.dispose();
    }
    
    public boolean validar(){
        if(!new Validator(txtCuentaUsuario).length(2, 45) & !new Validator(txtNombre).length(2, 35) 
           & !new Validator(txtApellido).length(2, 35) & !new Validator(txtRegion).length(4, 35)
        & !new Validator(txtCiudad).length(4, 45) & !new Validator(txtCodPostal).length(4, 12)) return false;
        return true;
    }
    
    public void saveInRepository(){
        var u = new Usuario(txtCuentaUsuario.getText(), txtNombre.getText(), 
                txtApellido.getText(), cmbPais.getItemAt(cmbPais.getSelectedIndex()), txtRegion.getText(), 
                txtCiudad.getText(), txtEmail.getText(), txtCodPostal.getText(), 
                null);
                ur.save(u);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtRegion = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCuentaUsuario = new javax.swing.JTextField();
        txtCodPostal = new javax.swing.JTextField();
        pswContraseñaI = new javax.swing.JPasswordField();
        cmbPais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Por favor complete todos los datos que se solicitan a continuación");

        jLabel2.setText("Cuenta de usuario");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("País");

        jLabel6.setText("Región");

        jLabel7.setText("Ciudad");

        jLabel8.setText("Correo electrónico");

        jLabel9.setText("Código Postal");

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        jLabel10.setText("Clave");

        txtNombre.setToolTipText("El campo Nombre debe tener entre 2 y 35 caracteres.");

        txtApellido.setToolTipText("El campo apellido debe tener entre 2 y 35 caracteres.");

        txtRegion.setToolTipText("El campo Región debe tener entre 4 y 45 caracteres.\n");

        txtCiudad.setToolTipText("El campo ciudad debe tener entre 4 y 45 caracteres");

        txtEmail.setToolTipText("Asegúrese de ingresar una dirección de e-mail válida");

        txtCuentaUsuario.setToolTipText("El campo Cuenta de usuario debe tener entre 2 y 45 caracteres.");

        txtCodPostal.setToolTipText("El campo Código postal no puede tener más de doce caracteres.");

        pswContraseñaI.setToolTipText("La contraseña debe tener un máximo de 8 caracteres");

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ", "    Afganistán", "    Albania", "    Alemania", "    Andorra", "    Angola", "    Antigua y Barbuda", "    Arabia Saudita", "    Argelia", "    Argentina", "    Armenia", "    Australia", "    Austria", "    Azerbaiyán", "    Bahamas", "    Bangladés", "    Barbados", "    Baréin", "    Bélgica", "    Belice", "    Benín", "    Bielorrusia", "    Birmania", "    Bolivia", "    Bosnia y Herzegovina", "    Botsuana", "    Brasil", "    Brunéi", "    Bulgaria", "    Burkina Faso", "    Burundi", "    Bután", "    Cabo Verde", "    Camboya", "    Camerún", "    Canadá", "    Catar", "    Chad", "    Chile", "    China", "    Chipre", "    Ciudad del Vaticano", "    Colombia", "    Comoras", "    Corea del Norte", "    Corea del Sur", "    Costa de Marfil", "    Costa Rica", "    Croacia", "    Cuba", "    Dinamarca", "    Dominica", "    Ecuador", "    Egipto", "    El Salvador", "    Emiratos Árabes Unidos", "    Eritrea", "    Eslovaquia", "    Eslovenia", "    España", "    Estados Unidos", "    Estonia", "    Etiopía", "    Filipinas", "    Finlandia", "    Fiyi", "    Francia", "    Gabón", "    Gambia", "    Georgia", "    Ghana", "    Granada", "    Grecia", "    Guatemala", "    Guyana", "    Guinea", "    Guinea ecuatorial", "    Guinea-Bisáu", "    Haití", "    Honduras", "    Hungría", "    India", "    Indonesia", "    Irak", "    Irán", "    Irlanda", "    Islandia", "    Islas Marshall", "    Islas Salomón", "    Israel", "    Italia", "    Jamaica", "    Japón", "    Jordania", "    Kazajistán", "    Kenia", "    Kirguistán", "    Kiribati", "    Kuwait", "    Laos", "    Lesoto", "    Letonia", "    Líbano", "    Liberia", "    Libia", "    Liechtenstein", "    Lituania", "    Luxemburgo", "    Macedonia del Norte", "    Madagascar", "    Malasia", "    Malaui", "    Maldivas", "    Malí", "    Malta", "    Marruecos", "    Mauricio", "    Mauritania", "    México", "    Micronesia", "    Moldavia", "    Mónaco", "    Mongolia", "    Montenegro", "    Mozambique", "    Namibia", "    Nauru", "    Nepal", "    Nicaragua", "    Níger", "    Nigeria", "    Noruega", "    Nueva Zelanda", "    Omán", "    Países Bajos", "    Pakistán", "    Palaos", "    Panamá", "    Papúa Nueva Guinea", "    Paraguay", "    Perú", "    Polonia", "    Portugal", "    Reino Unido", "    República Centroafricana", "    República Checa", "    República del Congo", "    República Democrática del Congo", "    República Dominicana", "    República Sudafricana", "    Ruanda", "    Rumanía", "    Rusia", "    Samoa", "    San Cristóbal y Nieves", "    San Marino", "    San Vicente y las Granadinas", "    Santa Lucía", "    Santo Tomé y Príncipe", "    Senegal", "    Serbia", "    Seychelles", "    Sierra Leona", "    Singapur", "    Siria", "    Somalia", "    Sri Lanka", "    Suazilandia", "    Sudán", "    Sudán del Sur", "    Suecia", "    Suiza", "    Surinam", "    Tailandia", "    Tanzania", "    Tayikistán", "    Timor Oriental", "    Togo", "    Tonga", "    Trinidad y Tobago", "    Túnez", "    Turkmenistán", "    Turquía", "    Tuvalu", "    Ucrania", "    Uganda", "    Uruguay", "    Uzbekistán", "    Vanuatu", "    Venezuela", "    Vietnam", "    Yemen", "    Yibuti", "    Zambia", "    Zimbabue" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCuentaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(pswContraseñaI)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(141, 141, 141))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(124, 124, 124)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(123, 123, 123)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido)
                                    .addComponent(txtRegion)
                                    .addComponent(txtCiudad)
                                    .addComponent(cmbPais, 0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodPostal)
                                    .addComponent(txtEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegistrarse)
                                .addGap(47, 47, 47)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuentaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(pswContraseñaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarse)
                .addGap(38, 38, 38))
        );

        txtNombre.getAccessibleContext().setAccessibleName("Nombre");
        txtNombre.getAccessibleContext().setAccessibleDescription("Este campo debe tener entre 2 y 35 caracteres\n");
        txtApellido.getAccessibleContext().setAccessibleName("Apellido");
        txtRegion.getAccessibleContext().setAccessibleName("Región");
        txtCiudad.getAccessibleContext().setAccessibleName("Ciudad");
        txtEmail.getAccessibleContext().setAccessibleName("Correo electrónico");
        txtCuentaUsuario.getAccessibleContext().setAccessibleName("Cuenta usuario");
        txtCuentaUsuario.getAccessibleContext().setAccessibleDescription("Este campo puede tener entre 2 y 45 caracteres");
        txtCodPostal.getAccessibleContext().setAccessibleName("Código Postal");
        pswContraseñaI.getAccessibleContext().setAccessibleName("Contraseña");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        //Evento registrar
       if(!validar()) return; 
       saveInRepository();
       cargar();
       username=txtCuentaUsuario.getText();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormularioDeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioDeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioDeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioDeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioDeRegistro dialog = new FormularioDeRegistro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField pswContraseñaI;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtCuentaUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegion;
    // End of variables declaration//GEN-END:variables
}
