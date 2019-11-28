package trabajopracticopoo2.vinoapp.gui;
import ar.org.centro8.curso.java.utils.Table;
import chat.ServidorChatR;
import java.awt.event.KeyEvent;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.entidades.Vino;
import trabajopracticopoo2.vinoapp.entidades.Bodega;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.enumerados.Color;
import static trabajopracticopoo2.vinoapp.gui.FormularioDeRegistro.username;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_PremiosRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_TiendaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_VinoRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.PremioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.TiendaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.VinoRepositorio;

public class MenuPrincipal extends javax.swing.JFrame {
    I_BodegaRepositorio br;
    I_PremiosRepositorio pr;
    I_UsuarioRepositorio ur;
    I_TiendaRepositorio tr;
    I_RankingRepositorio rr;
    I_VinoRepositorio vr;
    Bodega b = new Bodega();
    Vino v = new Vino();
    public MenuPrincipal() {
        initComponents();
        new Thread(new ServidorChatR(txaCompartir)).start();
        br=new BodegaRepositorio(Connector.getConnection());
        pr=new PremioRepositorio(Connector.getConnection());
        ur=new UsuarioRepositorio(Connector.getConnection());
        tr=new TiendaRepositorio(Connector.getConnection());
        rr=new RankingRepositorio(Connector.getConnection());
        vr=new VinoRepositorio(Connector.getConnection());
        cargar();
    }
    
    
    public void cargar(){
        //Carga de comboBoxes
        cmbCategoria.removeAllItems();
        for (Categoria cat : Categoria.values()) cmbCategoria.addItem(cat.toString());
        
        cmbColor.removeAllItems();
        for (Color co : Color.values()) cmbColor.addItem(co.toString());
        
        //Carga de lista de notas de cata
                
}
    
    public void guardarBodega(){
        b.setNombre_bodega(txtBodegaNV.getText());
        b.setFundacion((int) ftxtFundacion.getValue());
        br.save(b);
    }
    
    public void guardarVino(){
        var v = new Vino(txtNombreNV.getText(), txtCepasNV.getText(), Color.tinto, (int) ftxtCosecha.getText(), Categoria.reserva, username, SOMEBITS, username)
//        Color color = (Color) cmbColor.getSelectedItem();
//        Categoria categoria=(Categoria) cmbCategoria.getSelectedItem();
//        v.setNombre(txtNombreNV.getText());
//        v.setCepas(txtCepasNV.getText());
//        v.setColor(color);
//        v.setCosecha((int) ftxtCosecha.getValue());
//        v.setCategoria(categoria);
//        v.setEnologo(txtEnologoNV.getText());
//        v.setBodega_id(0);
//        v.setTerruno(txtTerrunoNV.getText());
        vr.save(v);
        
    }
    
    public void guardarRanking(){
    
    
    }
    
    public void limpiarBusqueda(){
    txtBodega.setText("");
    txtCategoria.setText("");
    txtCepas.setText("");
    txtCosecha.setText("");
    txtEnologo.setText("");
    txtTerruno.setText("");
    txtVino.setText("");
    txtVino.requestFocusInWindow();
    }
    
    public void limpiarComentario(){
    txtComentar.setText(""+"\n");
    txtComentar.requestFocusInWindow();
    }
    
    public void limpiarNuevoVino(){
    txtBodegaNV.setText("");
    txtCepasNV.setText("");
    ftxtCosecha.setText("");
    txtEnologoNV.setText("");
    ftxtFundacion.setText("");
    txtNombreNV.setText("");
    txtTerrunoNV.setText("");
    txtNombreNV.requestFocusInWindow();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVinos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaListaNotasDeCata = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtVino = new javax.swing.JTextField();
        txtBodega = new javax.swing.JTextField();
        txtCosecha = new javax.swing.JTextField();
        txtCepas = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtEnologo = new javax.swing.JTextField();
        txtTerruno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaResultadoBusqueda = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreNV = new javax.swing.JTextField();
        txtCepasNV = new javax.swing.JTextField();
        txtEnologoNV = new javax.swing.JTextField();
        txtBodegaNV = new javax.swing.JTextField();
        txtTerrunoNV = new javax.swing.JTextField();
        cmbColor = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbPais = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnPublicar = new javax.swing.JButton();
        btnEscribirNota = new javax.swing.JButton();
        ftxtCosecha = new javax.swing.JFormattedTextField();
        ftxtFundacion = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnComentar = new javax.swing.JButton();
        txtComentar = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaCompartir = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel3.setText("Esta la lista de los vinos que has registrado en la aplicación");

        tblVinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblVinos);

        btnModificar.setText("Modificar registro seleccionado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mis vinos", jPanel3);

        txaListaNotasDeCata.setColumns(20);
        txaListaNotasDeCata.setRows(5);
        jScrollPane2.setViewportView(txaListaNotasDeCata);

        jLabel2.setText("Acá puedes ver tus notas de cata");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mis notas", jPanel4);

        jLabel4.setText("Vino");

        jLabel5.setText("Bodega");

        jLabel6.setText("Cosecha");

        jLabel7.setText("Cepas");

        jLabel8.setText("Categoría");

        jLabel9.setText("Enólogo");

        jLabel10.setText("Terruño");

        jButton1.setText("Buscar");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txaResultadoBusqueda.setColumns(20);
        txaResultadoBusqueda.setRows(5);
        jScrollPane4.setViewportView(txaResultadoBusqueda);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49)
                        .addComponent(txtVino, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCosecha, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtCepas, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtEnologo, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtTerruno, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel5)
                                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel4)
                                                                    .addComponent(txtVino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(40, 40, 40)
                                                                .addComponent(txtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(40, 40, 40)
                                                        .addComponent(txtCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel6))
                                                .addGap(68, 68, 68))
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(txtCepas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(35, 35, 35)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))
                                .addGap(40, 40, 40)
                                .addComponent(txtEnologo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txtTerruno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane4))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", jPanel5);

        jLabel11.setText("Para ingresar un nuevo vino a \"Mis vinos\" complete los datos solicitados a continuación");

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ", "    Afganistán", "    Albania", "    Alemania", "    Andorra", "    Angola", "    Antigua y Barbuda", "    Arabia Saudita", "    Argelia", "    Argentina", "    Armenia", "    Australia", "    Austria", "    Azerbaiyán", "    Bahamas", "    Bangladés", "    Barbados", "    Baréin", "    Bélgica", "    Belice", "    Benín", "    Bielorrusia", "    Birmania", "    Bolivia", "    Bosnia y Herzegovina", "    Botsuana", "    Brasil", "    Brunéi", "    Bulgaria", "    Burkina Faso", "    Burundi", "    Bután", "    Cabo Verde", "    Camboya", "    Camerún", "    Canadá", "    Catar", "    Chad", "    Chile", "    China", "    Chipre", "    Ciudad del Vaticano", "    Colombia", "    Comoras", "    Corea del Norte", "    Corea del Sur", "    Costa de Marfil", "    Costa Rica", "    Croacia", "    Cuba", "    Dinamarca", "    Dominica", "    Ecuador", "    Egipto", "    El Salvador", "    Emiratos Árabes Unidos", "    Eritrea", "    Eslovaquia", "    Eslovenia", "    España", "    Estados Unidos", "    Estonia", "    Etiopía", "    Filipinas", "    Finlandia", "    Fiyi", "    Francia", "    Gabón", "    Gambia", "    Georgia", "    Ghana", "    Granada", "    Grecia", "    Guatemala", "    Guyana", "    Guinea", "    Guinea ecuatorial", "    Guinea-Bisáu", "    Haití", "    Honduras", "    Hungría", "    India", "    Indonesia", "    Irak", "    Irán", "    Irlanda", "    Islandia", "    Islas Marshall", "    Islas Salomón", "    Israel", "    Italia", "    Jamaica", "    Japón", "    Jordania", "    Kazajistán", "    Kenia", "    Kirguistán", "    Kiribati", "    Kuwait", "    Laos", "    Lesoto", "    Letonia", "    Líbano", "    Liberia", "    Libia", "    Liechtenstein", "    Lituania", "    Luxemburgo", "    Macedonia del Norte", "    Madagascar", "    Malasia", "    Malaui", "    Maldivas", "    Malí", "    Malta", "    Marruecos", "    Mauricio", "    Mauritania", "    México", "    Micronesia", "    Moldavia", "    Mónaco", "    Mongolia", "    Montenegro", "    Mozambique", "    Namibia", "    Nauru", "    Nepal", "    Nicaragua", "    Níger", "    Nigeria", "    Noruega", "    Nueva Zelanda", "    Omán", "    Países Bajos", "    Pakistán", "    Palaos", "    Panamá", "    Papúa Nueva Guinea", "    Paraguay", "    Perú", "    Polonia", "    Portugal", "    Reino Unido", "    República Centroafricana", "    República Checa", "    República del Congo", "    República Democrática del Congo", "    República Dominicana", "    República Sudafricana", "    Ruanda", "    Rumanía", "    Rusia", "    Samoa", "    San Cristóbal y Nieves", "    San Marino", "    San Vicente y las Granadinas", "    Santa Lucía", "    Santo Tomé y Príncipe", "    Senegal", "    Serbia", "    Seychelles", "    Sierra Leona", "    Singapur", "    Siria", "    Somalia", "    Sri Lanka", "    Suazilandia", "    Sudán", "    Sudán del Sur", "    Suecia", "    Suiza", "    Surinam", "    Tailandia", "    Tanzania", "    Tayikistán", "    Timor Oriental", "    Togo", "    Tonga", "    Trinidad y Tobago", "    Túnez", "    Turkmenistán", "    Turquía", "    Tuvalu", "    Ucrania", "    Uganda", "    Uruguay", "    Uzbekistán", "    Vanuatu", "    Venezuela", "    Vietnam", "    Yemen", "    Yibuti", "    Zambia", "    Zimbabue" }));

        jLabel12.setText("Nombre");

        jLabel13.setText("Cepas");

        jLabel15.setText("Enólogo");

        jLabel16.setText("Bodega");

        jLabel17.setText("Terruño");

        jLabel18.setText("Color");

        jLabel19.setText("Categoría");

        jLabel20.setText("País");

        jLabel21.setText("Cosecha");

        jLabel22.setText("Fundación de Bodega");

        jLabel23.setText("Califique este vino");

        jRadioButton1.setText("Decente(1)");

        jRadioButton2.setText("Buenísimo(2)");

        jRadioButton3.setText("Excelente(3)");

        jRadioButton4.setText("Destacado(4)");

        jRadioButton5.setText("¡¡¡EXTRAORDINARIO!!!");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPublicar.setText("Publicar");
        btnPublicar.setToolTipText("Es recomendable guardar antes de publicar, pues de lo contrario el vino no quedará registrado en Mis vinos. ");
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });

        btnEscribirNota.setText("Escribir nota de cata");
        btnEscribirNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscribirNotaActionPerformed(evt);
            }
        });

        ftxtCosecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y"))));

        ftxtFundacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel12)
                                .addGap(56, 56, 56)
                                .addComponent(txtNombreNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3))
                                .addGap(287, 287, 287)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jRadioButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnGuardar)
                        .addGap(213, 213, 213)
                        .addComponent(btnPublicar)
                        .addGap(150, 150, 150)
                        .addComponent(btnEscribirNota))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTerrunoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEnologoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtCepasNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(122, 122, 122)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ftxtCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel18))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombreNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel13))
                                    .addComponent(txtCepasNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtEnologoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(ftxtFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTerrunoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(66, 66, 66)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jRadioButton5)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscribirNota)
                    .addComponent(btnPublicar)
                    .addComponent(btnGuardar))
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Nuevo Vino", jPanel1);

        jLabel1.setText("Mira lo que otros usuarios están compartiendo");

        btnComentar.setText("Comentar");
        btnComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarActionPerformed(evt);
            }
        });

        txtComentar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComentarKeyReleased(evt);
            }
        });

        btnSalir.setText("Salir de Vinoapp");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txaCompartir.setEditable(false);
        txaCompartir.setColumns(20);
        txaCompartir.setRows(5);
        jScrollPane1.setViewportView(txaCompartir);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(842, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnComentar)
                            .addGap(18, 18, 18)
                            .addComponent(txtComentar, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComentar)
                    .addComponent(txtComentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnSalir)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Evento salir
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarActionPerformed
        // Evento comentar
        try (Socket so = new Socket(InetAddress.getLocalHost(), 8900);
                OutputStream out = so.getOutputStream();) {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime lDT = LocalDateTime.now();
            String fechayhora=lDT.format(formatter);
            out.write(txtComentar.getText().getBytes());
            txaCompartir.append("\n"+username+" "+JInicio.usernameInicio+ " escribió: " + "\n"
                    + txtComentar.getText() + "\n" +fechayhora+"\n");
            if (txtComentar.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Usted está enviando un mensaje vacío");}
            limpiarComentario();
        } catch (Exception e) {e.printStackTrace();}
       
    }//GEN-LAST:event_btnComentarActionPerformed

    private void txtComentarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarKeyReleased
        // Evento comentar con enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try (Socket so = new Socket(InetAddress.getLocalHost(), 8900);
                    OutputStream out = so.getOutputStream();) {
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime lDT = LocalDateTime.now();
                String fechayhora=lDT.format(formatter);
                out.write(txtComentar.getText().getBytes());
                txaCompartir.append("\n"+username+" "+JInicio.usernameInicio+" escribió: " + "\n"
                        + txtComentar.getText() + "\n" + fechayhora+"\n");
                if (txtComentar.getText().isBlank()) {
                    JOptionPane.showMessageDialog(this, "Usted está enviando un mensaje vacío");
                }
                limpiarComentario();
            } catch (Exception e) {e.printStackTrace();}
        }
    }//GEN-LAST:event_txtComentarKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento guardar nuevo vino
        guardarVino();
        guardarBodega();
        //cargar vino a la tabla
        int ultimo_indicevino=vr.getAll().lastIndexOf(v);
        List<String>lista=new ArrayList<>();
        lista.add(
        vr.getAll().get(ultimo_indicevino).toStringView());
        Table table = new Table();
        table.cargar(tblVinos, lista);
        
        JOptionPane.showMessageDialog(this, "Los datos se han guardado satisfactoriamente. Ahora puede verlos en la sección Mis Vinos");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        // Evento publicar vino
        txaCompartir.append("\n"+username+" "+JInicio.usernameInicio+" compartió un nuevo vino: "+"\n"+v.toStringView()+"\n");
        limpiarNuevoVino();
        JOptionPane.showMessageDialog(this, "¡El vino registrado se ha compartido exitosamente!");
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnEscribirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscribirNotaActionPerformed
        // Evento nota de cata
        NotaDeCata nDC = new NotaDeCata(this, true);
        nDC.setVisible(true);
        limpiarNuevoVino();
    }//GEN-LAST:event_btnEscribirNotaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComentar;
    private javax.swing.JButton btnEscribirNota;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JFormattedTextField ftxtCosecha;
    private javax.swing.JFormattedTextField ftxtFundacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblVinos;
    private javax.swing.JTextArea txaCompartir;
    private javax.swing.JTextArea txaListaNotasDeCata;
    private javax.swing.JTextArea txaResultadoBusqueda;
    private javax.swing.JTextField txtBodega;
    private javax.swing.JTextField txtBodegaNV;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCepas;
    private javax.swing.JTextField txtCepasNV;
    private javax.swing.JTextField txtComentar;
    private javax.swing.JTextField txtCosecha;
    private javax.swing.JTextField txtEnologo;
    private javax.swing.JTextField txtEnologoNV;
    private javax.swing.JTextField txtNombreNV;
    private javax.swing.JTextField txtTerruno;
    private javax.swing.JTextField txtTerrunoNV;
    private javax.swing.JTextField txtVino;
    // End of variables declaration//GEN-END:variables
}
