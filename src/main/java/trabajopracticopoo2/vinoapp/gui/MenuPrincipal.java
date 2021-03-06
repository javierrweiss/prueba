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
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import trabajopracticopoo2.vinoapp.connectors.Connector;
import trabajopracticopoo2.vinoapp.entidades.Vino;
import trabajopracticopoo2.vinoapp.entidades.Bodega;
import trabajopracticopoo2.vinoapp.entidades.Ranking;
import trabajopracticopoo2.vinoapp.enumerados.Categoria;
import trabajopracticopoo2.vinoapp.enumerados.Color;
import trabajopracticopoo2.vinoapp.enumerados.RankingEnum;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.interfaces.I_VinoRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.BodegaRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.RankingRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.UsuarioRepositorio;
import trabajopracticopoo2.vinoapp.repositorios.jdbc.VinoRepositorio;

public class MenuPrincipal extends javax.swing.JFrame {
    I_BodegaRepositorio br;
    I_UsuarioRepositorio ur;
    I_RankingRepositorio rr;
    I_VinoRepositorio vr;
    Ranking ranking;
    Table table = new Table();
    private static List<Vino> lista_de_vinos_por_usuario=new ArrayList<>();
    private static List<Bodega> lista_de_bodegas_por_usuario=new ArrayList<>();
    public MenuPrincipal() {
        initComponents();
        new Thread(new ServidorChatR(txaCompartir)).start();
        br=new BodegaRepositorio(Connector.getConnection());
        ur=new UsuarioRepositorio(Connector.getConnection());
        rr=new RankingRepositorio(Connector.getConnection());
        vr=new VinoRepositorio(Connector.getConnection());
        cargarBoxes();
        cargar_notas_de_cata();
        cargar_vinos_del_usuario();
        
    }
    
    public void cargar_notas_de_cata(){
        try {
           String usuario_conectado=ur.getConnectedUser(JInicio.txtUsuario.getText()).getCuenta_usuario();
           int usuario_conectadoInt=ur.getConnectedUser(JInicio.txtUsuario.getText()).getUsuario_id();
           int last_vino_by_usuario=rr.getVinoByUser(usuario_conectadoInt)
             .stream()
             .max(Comparator.comparing(Ranking::getVino_id))
             .get()
             .getVino_id();
     txaNotaDeCata.append(usuario_conectado+" publicó una nota de cata: \n"
             +"Vino: \n"+vr.getById(last_vino_by_usuario).getNombre()+"\n"
                +ur.getConnectedUser(usuario_conectado).getNota_de_cata()); 
        } catch (Exception e) {
        e.printStackTrace();
        txaNotaDeCata.append("Usted no tiene ninguna nota de cata registrada");
        }
    }
    
    public void cargar_vinos_del_usuario(){
        List<String> listavacia = new ArrayList<>();
        try {
            table.cargar(tblVinos, lista_de_vinos_por_usuario);
            table.cargar(tblBodega, lista_de_bodegas_por_usuario);
            //cargar vinos del repositorio
            /*
    La listaranking equivale a un select * from rankings where usuario_id=? => usuario conectado
             */
            List<Ranking> listaranking = new ArrayList<>();
            listaranking = rr.getVinoByUser(ur.getConnectedUser(JInicio.txtUsuario.getText()).getUsuario_id());
            List<Vino> listaresultadovino = new ArrayList<>();
            for (Ranking r : listaranking) {
                int vino_obtenido = r.getVino_id();
                listaresultadovino.add(vr.getById(vino_obtenido));
            }
            table.cargar(tblVinos, listaresultadovino);
            //cargar bodegas del repositorio
            List<Bodega> listaresultadobodega = new ArrayList<>();
            for (Vino v : listaresultadovino) {
                int bodega_obtenida = v.getBodega_id();
                listaresultadobodega.add(br.getById(bodega_obtenida));
            }
            table.cargar(tblBodega, listaresultadobodega);
        } catch (Exception e) {
            e.printStackTrace();
        //Se carga una tabla vacía en caso que el usuario sea nuevo y así capturar una NoSuchElementException
            table.cargar(tblVinos, listavacia);
            table.cargar(tblBodega, listavacia);
        }
    }
    
    public void cargarBoxes(){
        //Carga de comboBoxes
        cmbCategoria.removeAllItems();
        for (Categoria cat : Categoria.values()) cmbCategoria.addItem(cat.toString());
        cmbColor.removeAllItems();
        for (Color co : Color.values()) cmbColor.addItem(co.toString());
        cmbRanking.removeAllItems();
        for (RankingEnum ra : RankingEnum.values()) cmbRanking.addItem(ra.toString());
        cmbCategoriaBusqueda.removeAllItems();
        for (Categoria cate : Categoria.values()) cmbCategoriaBusqueda.addItem(cate.toString());
    }
    
    public void limpiarBusqueda(){
    txtBodega.setText("");
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
    txtCosechaNV.setText("");
    txtEnologoNV.setText("");
    txtFundacion.setText("");
    txtNombreNV.setText("");
    txtTerrunoNV.setText("");
    txaUbicacion.setText("");
    cmbCategoria.removeAllItems();
    cmbColor.removeAllItems();
    cmbRanking.removeAllItems();
    cmbPais.removeAllItems();
    txtNombreNV.requestFocusInWindow();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngAgruparRanking = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnComentar = new javax.swing.JButton();
        txtComentar = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaCompartir = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreNV = new javax.swing.JTextField();
        txtCepasNV = new javax.swing.JTextField();
        txtEnologoNV = new javax.swing.JTextField();
        txtBodegaNV = new javax.swing.JTextField();
        txtTerrunoNV = new javax.swing.JTextField();
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
        btnGuardar = new javax.swing.JButton();
        btnPublicar = new javax.swing.JButton();
        btnEscribirNota = new javax.swing.JButton();
        cmbColor = new javax.swing.JComboBox<>();
        txtCosechaNV = new javax.swing.JTextField();
        txtFundacion = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaUbicacion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        cmbRanking = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNotaDeCata = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVinos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblBodega = new javax.swing.JTable();
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
        txtEnologo = new javax.swing.JTextField();
        txtTerruno = new javax.swing.JTextField();
        BuscarBodega = new javax.swing.JButton();
        BuscarCosecha = new javax.swing.JButton();
        BuscarCepas = new javax.swing.JButton();
        BuscarCategoria = new javax.swing.JButton();
        BuscarEnologo = new javax.swing.JButton();
        BuscarTerruno = new javax.swing.JButton();
        BuscarVino = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblBusqueda = new javax.swing.JTable();
        cmbCategoriaBusqueda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

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
                .addContainerGap(785, Short.MAX_VALUE)
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
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

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

        cmbColor.removeAllItems();
        for (Color co : Color.values()) cmbColor.addItem(co.toString());

        txaUbicacion.setColumns(20);
        txaUbicacion.setRows(5);
        jScrollPane3.setViewportView(txaUbicacion);

        jLabel14.setText("Dirección Bodega");

        cmbRanking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decente", "Buenísimo", "Destacado", "Excelente", "¡¡¡Extraordinario!!!" }));

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
                        .addGap(67, 67, 67)
                        .addComponent(btnGuardar)
                        .addGap(213, 213, 213)
                        .addComponent(btnPublicar)
                        .addGap(150, 150, 150)
                        .addComponent(btnEscribirNota))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cmbRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(55, 55, 55)
                                        .addComponent(txtTerrunoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(58, 58, 58)
                                        .addComponent(txtBodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(55, 55, 55)
                                        .addComponent(txtEnologoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtCepasNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(122, 122, 122)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel18))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addGap(59, 59, 59)
                                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addGap(88, 88, 88))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCosechaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(txtFundacion))
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtCosechaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
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
                                    .addComponent(jLabel19))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtTerrunoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscribirNota)
                    .addComponent(btnPublicar)
                    .addComponent(btnGuardar))
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Nuevo Vino", jPanel1);

        jLabel2.setText("Acá puedes ver tus notas de cata");

        txaNotaDeCata.setColumns(20);
        txaNotaDeCata.setRows(5);
        jScrollPane2.setViewportView(txaNotaDeCata);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mis notas", jPanel4);

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
        tblVinos.setToolTipText("");
        jScrollPane5.setViewportView(tblVinos);

        tblBodega.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBodega.setToolTipText("");
        jScrollPane6.setViewportView(tblBodega);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addGap(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mis vinos", jPanel3);

        jLabel4.setText("Vino");

        jLabel5.setText("Bodega");

        jLabel6.setText("Cosecha");

        jLabel7.setText("Cepas");

        jLabel8.setText("Categoría");

        jLabel9.setText("Enólogo");

        jLabel10.setText("Terruño");

        BuscarBodega.setText("Buscar");
        BuscarBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBodegaActionPerformed(evt);
            }
        });

        BuscarCosecha.setText("Buscar");
        BuscarCosecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCosechaActionPerformed(evt);
            }
        });

        BuscarCepas.setText("Buscar");
        BuscarCepas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCepasActionPerformed(evt);
            }
        });

        BuscarCategoria.setText("Buscar");
        BuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCategoriaActionPerformed(evt);
            }
        });

        BuscarEnologo.setText("Buscar");
        BuscarEnologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarEnologoActionPerformed(evt);
            }
        });

        BuscarTerruno.setText("Buscar");
        BuscarTerruno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarTerrunoActionPerformed(evt);
            }
        });

        BuscarVino.setText("Buscar");
        BuscarVino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarVinoActionPerformed(evt);
            }
        });

        tblBusqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblBusqueda);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVino, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCosecha, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(txtBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(txtCepas, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(txtEnologo, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(txtTerruno, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(cmbCategoriaBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarEnologo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarCepas, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarVino, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarTerruno, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                            .addComponent(txtVino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(BuscarVino))
                                                        .addGap(40, 40, 40)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(BuscarBodega))))
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(BuscarCosecha)))
                                            .addComponent(jLabel6))
                                        .addGap(68, 68, 68))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtCepas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BuscarCepas)))
                                .addGap(35, 35, 35)
                                .addComponent(BuscarCategoria))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cmbCategoriaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEnologo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarEnologo)))
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTerruno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarTerruno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", jPanel5);

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
            txaCompartir.append("\n"+ur.getConnectedUser(JInicio.txtUsuario.getText()).getCuenta_usuario()
                    +" escribió: " + "\n"
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
                txaCompartir.append("\n"+ur.getConnectedUser(JInicio.txtUsuario.getText()).getCuenta_usuario()
                        +" escribió: " + "\n"
                        + txtComentar.getText() + "\n" + fechayhora+"\n");
                if (txtComentar.getText().isBlank()) {
                    JOptionPane.showMessageDialog(this, "Usted está enviando un mensaje vacío");
                }
                limpiarComentario();
            } catch (Exception e) {e.printStackTrace();}
        }
    }//GEN-LAST:event_txtComentarKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Evento guardar 
                //guardar bodega
        if(txtFundacion.getText().equals("")) txtFundacion.setText("0000"); //Para evitar que la base de datos mande una NumberFormatException
        if(txtFundacion.getText().matches("//*{5}")) JOptionPane.showMessageDialog(this, "Esta no es una fecha correcta");
        if(txtBodegaNV.getText().isBlank()) JOptionPane.showMessageDialog(this, "Debe completar este campo");
        var b= new Bodega(txtBodegaNV.getText(), 
                         cmbPais.getItemAt(cmbPais.getSelectedIndex()), 
                         txaUbicacion.getText(), 
                         Integer.parseInt(txtFundacion.getText())
                    );
        br.save(b);
        
                //guardar vino
        int bodega_id=b.getBodega_id();
        
        if(txtCosechaNV.getText().matches("//*{5}")) JOptionPane.showMessageDialog(this, "Esta no es una fecha correcta");
        if(txtNombreNV.getText().isBlank()) JOptionPane.showMessageDialog(this, "Debe completar este campo");
        Vino v = new Vino(txtNombreNV.getText(), 
                          txtCepasNV.getText(), 
                          Color.valueOf((String) cmbColor.getSelectedItem()), 
                          Integer.parseInt(txtCosechaNV.getText()),
                          Categoria.valueOf((String) cmbCategoria.getSelectedItem()), 
                          txtEnologoNV.getText(),
                          bodega_id,
                          txtTerrunoNV.getText()
                    );
        vr.save(v);
                        
                        //Recuperar usuario_id del usuario conectado
        int usuario_id=ur.getConnectedUser(JInicio.txtUsuario.getText()).getUsuario_id(); 
         
                        //Recuperar vino_id del vino recién guardado
        int vino_id=v.getVino_id();
         
         /*
         Recuperar tienda_id: dado que esta funcionalidad no está habilitada en la aplicación vamos a hardcodear
         el id tomando aleatoriamente uno de la base de datos
         */
        
                //guardar ranking
            Ranking r = new Ranking(RankingEnum.valueOf((String) cmbRanking.getSelectedItem()),
                 usuario_id, 
                 vino_id, 
                 9);
            rr.save(r); //Está arrojando una SQLIntegrityConstraintViolationException. Para evitarlo cambiar el id de la Tienda
            //rr.update(r);        
        
                //crear lista con datos ingresados y cargar vino a la tabla
             int last_vino_by_usuario2=rr.getVinoByUser(usuario_id)
             .stream()
             .max(Comparator.comparing(Ranking::getVino_id))
             .get()
             .getVino_id();
                lista_de_vinos_por_usuario.add(vr.getById(last_vino_by_usuario2));
                table.cargar(tblVinos, lista_de_vinos_por_usuario);
        
                int bodega_from_last_vino=vr.getById(last_vino_by_usuario2).getBodega_id();
                lista_de_bodegas_por_usuario.add(br.getById(bodega_from_last_vino));
                table.cargar(tblBodega, lista_de_bodegas_por_usuario);
        
        JOptionPane.showMessageDialog(this, "Los datos se han guardado satisfactoriamente. "
                + "Ahora puede verlos en la sección Mis Vinos");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        // Evento publicar vino en panel de Inicio
      try (Socket so = new Socket(InetAddress.getLocalHost(), 8900)) {
            txaCompartir.append("\n"+ur.getConnectedUser(JInicio.txtUsuario.getText()).getCuenta_usuario()
                    +" compartió un nuevo vino: "+"\n"+
                    vr.getUltimo()
                    .toStringView()
                    .concat(br.getLastBodegaId()
                    .toStringBodegaView())
                    .concat(rr.getLastRankingid()
                    .toStringRankingView())+"\n");
       } catch (Exception e) {e.printStackTrace();}
        limpiarNuevoVino();
        JOptionPane.showMessageDialog(this, "¡El vino registrado se ha compartido exitosamente!");
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnEscribirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscribirNotaActionPerformed
        // Evento nota de cata
        NotaDeCata nDC = new NotaDeCata(this, true);
        nDC.setVisible(true);
        limpiarNuevoVino();
        this.dispose();
    }//GEN-LAST:event_btnEscribirNotaActionPerformed

    private void BuscarBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBodegaActionPerformed
        // Evento buscar bodega
        List<Bodega> listabodega=new ArrayList<>();
        listabodega=br.getLikeNombre(txtBodega.getText());
        table.cargar(tblBusqueda, listabodega);
        if (listabodega.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtBodega.setText("");
        }
    }//GEN-LAST:event_BuscarBodegaActionPerformed

    private void BuscarCosechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCosechaActionPerformed
        // Evento buscar cosecha
        List<Vino> listacosecha=new ArrayList<>();
        listacosecha=vr.getByCosecha(Integer.parseInt(txtCosecha.getText()));
        table.cargar(tblBusqueda, listacosecha);
        if (listacosecha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtCosecha.setText("");
        }
    }//GEN-LAST:event_BuscarCosechaActionPerformed

    private void BuscarCepasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCepasActionPerformed
        // Evento buscar cepas
        List<Vino> listacepas=new ArrayList<>();
        listacepas=vr.getByCepas(txtCepas.getText());
        table.cargar(tblBusqueda, listacepas);
        if (listacepas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtCepas.setText("");
        }
    }//GEN-LAST:event_BuscarCepasActionPerformed

    private void BuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCategoriaActionPerformed
        //Evento buscar categoria
        List<Vino>listacategoria=new ArrayList<>();
        listacategoria=vr.getByCategoria(Categoria.valueOf(cmbCategoriaBusqueda.getItemAt(cmbCategoriaBusqueda.getSelectedIndex())));
        table.cargar(tblBusqueda, listacategoria);
        if (listacategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
        }
    }//GEN-LAST:event_BuscarCategoriaActionPerformed

    private void BuscarEnologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarEnologoActionPerformed
        // Evento buscar enólogo
        List<Vino> listaenologo=new ArrayList<>();
        listaenologo=vr.getLikeEnologo(txtEnologo.getText());
        table.cargar(tblBusqueda, listaenologo);
        if (listaenologo.isEmpty() | listaenologo==null) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtEnologo.setText("");
        }
    }//GEN-LAST:event_BuscarEnologoActionPerformed

    private void BuscarTerrunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarTerrunoActionPerformed
        // Evento buscar terruno
        List<Vino>listaterruno=new ArrayList<>();
        listaterruno=vr.getLikeTerruno(txtTerruno.getText());
        table.cargar(tblBusqueda, listaterruno);
        if (listaterruno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtTerruno.setText("");
        }
    }//GEN-LAST:event_BuscarTerrunoActionPerformed

    private void BuscarVinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarVinoActionPerformed
        //Evento buscar vino
        List<Vino>listavino=new ArrayList<>();
        listavino=vr.getByNombre(txtVino.getText());
        table.cargar(tblBusqueda, listavino);
        if (listavino.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados");
            txtVino.setText("");
        }
    }//GEN-LAST:event_BuscarVinoActionPerformed

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
    private javax.swing.JButton BuscarBodega;
    private javax.swing.JButton BuscarCategoria;
    private javax.swing.JButton BuscarCepas;
    private javax.swing.JButton BuscarCosecha;
    private javax.swing.JButton BuscarEnologo;
    private javax.swing.JButton BuscarTerruno;
    private javax.swing.JButton BuscarVino;
    private javax.swing.JButton btnComentar;
    private javax.swing.JButton btnEscribirNota;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup btngAgruparRanking;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCategoriaBusqueda;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBodega;
    private javax.swing.JTable tblBusqueda;
    private javax.swing.JTable tblVinos;
    private javax.swing.JTextArea txaCompartir;
    private javax.swing.JTextArea txaNotaDeCata;
    private javax.swing.JTextArea txaUbicacion;
    private javax.swing.JTextField txtBodega;
    private javax.swing.JTextField txtBodegaNV;
    private javax.swing.JTextField txtCepas;
    private javax.swing.JTextField txtCepasNV;
    private javax.swing.JTextField txtComentar;
    private javax.swing.JTextField txtCosecha;
    private javax.swing.JTextField txtCosechaNV;
    private javax.swing.JTextField txtEnologo;
    private javax.swing.JTextField txtEnologoNV;
    private javax.swing.JTextField txtFundacion;
    private javax.swing.JTextField txtNombreNV;
    private javax.swing.JTextField txtTerruno;
    private javax.swing.JTextField txtTerrunoNV;
    private javax.swing.JTextField txtVino;
    // End of variables declaration//GEN-END:variables
}
