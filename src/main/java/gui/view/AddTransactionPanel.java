package gui.view;

import entities.Personas;
import entities.Transacciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import manageTransaccion.ManageTransaccion;

public class AddTransactionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel colorPanel;
    private JLabel logoLabel;
    private JLabel idTransaction, fechaTransaction, estadoTransaction, idVendedor, idComprador, costoTransporte, totalTransaction, cantidadUnidadProducto;
    private JTextField idTransactionField, fechaTransactionField, estadoTransactionField, idvendedorTransactionField, idCompradorTransactionField, costoTransportField, totalTransactionField, cantidadUnidadProductoField;
    private PromptText idTransactionPrompt, fechaTransactionPrompt, estadoTransactionPrompt, idvendedorTransactionPromt, idCompradorTransactionPrompt, costoTransportPrompt, totalTransactionPrompt, cantidadUnidadProductoPrompt;
    private JButton uploadTransactionButton, backButton;

    public AddTransactionPanel(ActionListener listener) {
        this.setSize(1020, 900);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{173, 0};
        gridBagLayout.rowHeights = new int[]{600, 0, 0, 0, 0, 0, 0, 0, 14, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        colorPanel = new JPanel();
        colorPanel.setBackground(new Color(103, 175, 50));
        GridBagConstraints gbc_colorPanel = new GridBagConstraints();
        gbc_colorPanel.insets = new Insets(0, 0, 5, 0);
        gbc_colorPanel.fill = GridBagConstraints.BOTH;
        gbc_colorPanel.gridx = 0;
        gbc_colorPanel.gridy = 0;
        add(colorPanel, gbc_colorPanel);

        logoLabel = new JLabel("");
        logoLabel.setIcon(new ImageIcon("images/LogEmp.png"));
        GridBagConstraints gbc_logoLabel = new GridBagConstraints();
        gbc_logoLabel.insets = new Insets(10, 0, 5, 0);
        gbc_logoLabel.gridx = 0;
        gbc_logoLabel.gridy = 1;
        add(logoLabel, gbc_logoLabel);

        /*	ID	*/
        idTransaction = new JLabel("id Transacción");
        idTransaction.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idTransaction.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_emailUsernameLabel = new GridBagConstraints();
        gbc_emailUsernameLabel.anchor = GridBagConstraints.WEST;
        gbc_emailUsernameLabel.insets = new Insets(0, 10, 5, 10);
        gbc_emailUsernameLabel.fill = GridBagConstraints.VERTICAL;
        gbc_emailUsernameLabel.gridx = 0;
        gbc_emailUsernameLabel.gridy = 2;
        add(idTransaction, gbc_emailUsernameLabel);

        idTransactionField = new JTextField();
        idTransactionField.setColumns(30);
        idTransactionField.setForeground(new Color(128, 128, 128));
        idTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idTransactionField.setBorder(new CompoundBorder(idTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        idTransactionPrompt = new PromptText("ingrese el id de la transacción", idTransactionField);
        idTransactionPrompt.changeStyle(Font.PLAIN);
        idTransactionPrompt.changeAlpha(128);
        GridBagConstraints gbc_loginEmailUsernameField = new GridBagConstraints();
        gbc_loginEmailUsernameField.insets = new Insets(0, 10, 5, 10);
        gbc_loginEmailUsernameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_loginEmailUsernameField.gridx = 0;
        gbc_loginEmailUsernameField.gridy = 3;
        add(idTransactionField, gbc_loginEmailUsernameField);

        /*	NOMBRE	*/
        fechaTransaction = new JLabel("Fecha Transacción (FORMATO dd-mm-AAAA)");
        fechaTransaction.setFont(new Font("Ebrima", Font.PLAIN, 16));
        fechaTransaction.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_nombreProducto = new GridBagConstraints();
        gbc_nombreProducto.anchor = GridBagConstraints.WEST;
        gbc_nombreProducto.insets = new Insets(0, 10, 5, 10);
        gbc_nombreProducto.fill = GridBagConstraints.VERTICAL;
        gbc_nombreProducto.gridx = 0;
        gbc_nombreProducto.gridy = 4;
        add(fechaTransaction, gbc_nombreProducto);

        fechaTransactionField = new JTextField();
        fechaTransactionField.setColumns(30);
        fechaTransactionField.setForeground(new Color(128, 128, 128));
        fechaTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        fechaTransactionField.setBorder(new CompoundBorder(fechaTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        fechaTransactionPrompt = new PromptText("Ingrese la fecha de la transacción (obligatorio)", fechaTransactionField);
        fechaTransactionPrompt.changeStyle(Font.PLAIN);
        fechaTransactionPrompt.changeAlpha(128);
        GridBagConstraints gbc_loginNombreProductoField = new GridBagConstraints();
        gbc_loginNombreProductoField.insets = new Insets(0, 10, 5, 10);
        gbc_loginNombreProductoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_loginNombreProductoField.gridx = 0;
        gbc_loginNombreProductoField.gridy = 5;
        add(fechaTransactionField, gbc_loginNombreProductoField);

        /*	DESCR	*/
        estadoTransaction = new JLabel("Estado de la transacción (COM o VEN)");
        estadoTransaction.setFont(new Font("Ebrima", Font.PLAIN, 16));
        estadoTransaction.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_descrProducto = new GridBagConstraints();
        gbc_descrProducto.anchor = GridBagConstraints.WEST;
        gbc_descrProducto.insets = new Insets(0, 10, 5, 10);
        gbc_descrProducto.fill = GridBagConstraints.VERTICAL;
        gbc_descrProducto.gridx = 0;
        gbc_descrProducto.gridy = 6;
        add(estadoTransaction, gbc_descrProducto);

        estadoTransactionField = new JTextField();
        estadoTransactionField.setColumns(30);
        estadoTransactionField.setForeground(new Color(128, 128, 128));
        estadoTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        estadoTransactionField.setBorder(new CompoundBorder(estadoTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        estadoTransactionPrompt = new PromptText("ingrese el estado de la transacción(obligatorio y debe ser COM o VEN)", estadoTransactionField);
        estadoTransactionPrompt.changeStyle(Font.PLAIN);
        estadoTransactionPrompt.changeAlpha(128);
        GridBagConstraints gbc_descrProductoField = new GridBagConstraints();
        gbc_descrProductoField.insets = new Insets(0, 10, 5, 10);
        gbc_descrProductoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descrProductoField.gridx = 0;
        gbc_descrProductoField.gridy = 7;
        add(estadoTransactionField, gbc_descrProductoField);

        /*	VALOR	*/
        idVendedor = new JLabel("Id vendedor");
        idVendedor.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idVendedor.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_valorProducto = new GridBagConstraints();
        gbc_valorProducto.anchor = GridBagConstraints.WEST;
        gbc_valorProducto.insets = new Insets(0, 10, 5, 10);
        gbc_valorProducto.fill = GridBagConstraints.VERTICAL;
        gbc_valorProducto.gridx = 0;
        gbc_valorProducto.gridy = 8;
        add(idVendedor, gbc_valorProducto);

        idvendedorTransactionField = new JTextField();
        idvendedorTransactionField.setColumns(30);
        idvendedorTransactionField.setForeground(new Color(128, 128, 128));
        idvendedorTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idvendedorTransactionField.setBorder(new CompoundBorder(idvendedorTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        idvendedorTransactionPromt = new PromptText("ingrese el Id del vendedor", idvendedorTransactionField);
        idvendedorTransactionPromt.changeStyle(Font.PLAIN);
        idvendedorTransactionPromt.changeAlpha(128);
        GridBagConstraints gbc_valorProductoField = new GridBagConstraints();
        gbc_valorProductoField.insets = new Insets(0, 10, 5, 10);
        gbc_valorProductoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_valorProductoField.gridx = 0;
        gbc_valorProductoField.gridy = 9;

        add(idvendedorTransactionField, gbc_valorProductoField);

        idComprador = new JLabel("id Comprador");
        idComprador.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idComprador.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_idComprador = new GridBagConstraints();
        gbc_idComprador.anchor = GridBagConstraints.WEST;
        gbc_idComprador.insets = new Insets(0, 10, 5, 10);
        gbc_idComprador.fill = GridBagConstraints.VERTICAL;
        gbc_idComprador.gridx = 0;
        gbc_idComprador.gridy = 10;
        add(idComprador, gbc_idComprador);

        idCompradorTransactionField = new JTextField();
        idCompradorTransactionField.setColumns(30);
        idCompradorTransactionField.setForeground(new Color(128, 128, 128));
        idCompradorTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idCompradorTransactionField.setBorder(new CompoundBorder(idCompradorTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        idCompradorTransactionPrompt = new PromptText("ingrese el id del comprador", idCompradorTransactionField);
        idCompradorTransactionPrompt.changeStyle(Font.PLAIN);
        idCompradorTransactionPrompt.changeAlpha(128);
        GridBagConstraints gbc_idCompradorTransactionField = new GridBagConstraints();
        gbc_idCompradorTransactionField.insets = new Insets(0, 10, 5, 10);
        gbc_idCompradorTransactionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idCompradorTransactionField.gridx = 0;
        gbc_idCompradorTransactionField.gridy = 11;
        add(idCompradorTransactionField, gbc_idCompradorTransactionField);

        /*	NOMBRE	*/
        costoTransporte = new JLabel("Costo transporte");
        costoTransporte.setFont(new Font("Ebrima", Font.PLAIN, 16));
        costoTransporte.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_costoTransporte = new GridBagConstraints();
        gbc_costoTransporte.anchor = GridBagConstraints.WEST;
        gbc_costoTransporte.insets = new Insets(0, 10, 5, 10);
        gbc_costoTransporte.fill = GridBagConstraints.VERTICAL;
        gbc_costoTransporte.gridx = 0;
        gbc_costoTransporte.gridy = 12;
        add(costoTransporte, gbc_costoTransporte);

        costoTransportField = new JTextField();
        costoTransportField.setColumns(30);
        costoTransportField.setForeground(new Color(128, 128, 128));
        costoTransportField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        costoTransportField.setBorder(new CompoundBorder(costoTransportField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        costoTransportPrompt = new PromptText("Ingrese la costo de transporte", costoTransportField);
        costoTransportPrompt.changeStyle(Font.PLAIN);
        costoTransportPrompt.changeAlpha(128);
        GridBagConstraints gbc_costoTransportField = new GridBagConstraints();
        gbc_costoTransportField.insets = new Insets(0, 10, 5, 10);
        gbc_costoTransportField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costoTransportField.gridx = 0;
        gbc_costoTransportField.gridy = 13;
        add(costoTransportField, gbc_costoTransportField);

        /*	DESCR	*/
        totalTransaction = new JLabel("Total Transacción (OBLIGATORIO)");
        totalTransaction.setFont(new Font("Ebrima", Font.PLAIN, 16));
        totalTransaction.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_totalTransaction = new GridBagConstraints();
        gbc_totalTransaction.anchor = GridBagConstraints.WEST;
        gbc_totalTransaction.insets = new Insets(0, 10, 5, 10);
        gbc_totalTransaction.fill = GridBagConstraints.VERTICAL;
        gbc_totalTransaction.gridx = 0;
        gbc_totalTransaction.gridy = 14;
        add(totalTransaction, gbc_totalTransaction);

        totalTransactionField = new JTextField();
        totalTransactionField.setColumns(30);
        totalTransactionField.setForeground(new Color(128, 128, 128));
        totalTransactionField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        totalTransactionField.setBorder(new CompoundBorder(totalTransactionField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        totalTransactionPrompt = new PromptText("ingrese el valor total de la transacción (OBLIGATORIO)", totalTransactionField);
        totalTransactionPrompt.changeStyle(Font.PLAIN);
        totalTransactionPrompt.changeAlpha(128);
        GridBagConstraints gbc_totalTransactionField = new GridBagConstraints();
        gbc_totalTransactionField.insets = new Insets(0, 10, 5, 10);
        gbc_totalTransactionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_totalTransactionField.gridx = 0;
        gbc_totalTransactionField.gridy = 15;
        add(totalTransactionField, gbc_totalTransactionField);

        /*	VALOR	*/
        cantidadUnidadProducto = new JLabel("Cantidad productos");
        cantidadUnidadProducto.setFont(new Font("Ebrima", Font.PLAIN, 16));
        cantidadUnidadProducto.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_cantidadUnidadProducto = new GridBagConstraints();
        gbc_cantidadUnidadProducto.anchor = GridBagConstraints.WEST;
        gbc_cantidadUnidadProducto.insets = new Insets(0, 10, 5, 10);
        gbc_cantidadUnidadProducto.fill = GridBagConstraints.VERTICAL;
        gbc_cantidadUnidadProducto.gridx = 0;
        gbc_cantidadUnidadProducto.gridy = 16;
        add(idVendedor, gbc_cantidadUnidadProducto);

        cantidadUnidadProductoField = new JTextField();
        cantidadUnidadProductoField.setColumns(30);
        cantidadUnidadProductoField.setForeground(new Color(128, 128, 128));
        cantidadUnidadProductoField.setFont(new Font("Ebrima", Font.PLAIN, 16));
        cantidadUnidadProductoField.setBorder(new CompoundBorder(cantidadUnidadProductoField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        cantidadUnidadProductoPrompt = new PromptText("ingrese la cantidad de productos", cantidadUnidadProductoField);
        cantidadUnidadProductoPrompt.changeStyle(Font.PLAIN);
        cantidadUnidadProductoPrompt.changeAlpha(128);
        GridBagConstraints gbc_catidadUnidadProductoField = new GridBagConstraints();
        gbc_catidadUnidadProductoField.insets = new Insets(0, 10, 5, 10);
        gbc_catidadUnidadProductoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_catidadUnidadProductoField.gridx = 0;
        gbc_catidadUnidadProductoField.gridy = 17;
        add(idvendedorTransactionField, gbc_catidadUnidadProductoField);

        /*	UNIDADES	
		unidProd = new JLabel("unidades del producto");
		unidProd.setFont(new Font("Ebrima", Font.PLAIN, 16));
		unidProd.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_unidProducto = new GridBagConstraints();
		gbc_unidProducto.anchor = GridBagConstraints.WEST;
		gbc_unidProducto.insets = new Insets(0, 10, 5, 10);
		gbc_unidProducto.fill = GridBagConstraints.VERTICAL;
		gbc_unidProducto.gridx = 0;
		gbc_unidProducto.gridy = 10;
		add(unidProd, gbc_unidProducto);

		unidProdField = new JTextField();
		unidProdField.setColumns(30);
		unidProdField.setForeground(new Color(128, 128, 128));
		unidProdField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		unidProdField.setBorder(new CompoundBorder(unidProdField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		unidProdPrompt = new PromptText("ingrese las unidades del producto", unidProdField);
		unidProdPrompt.changeStyle(Font.PLAIN);
		unidProdPrompt.changeAlpha(128);
		GridBagConstraints gbc_unidProductoField = new GridBagConstraints();
		gbc_unidProductoField.insets = new Insets(0, 10, 5, 10);
		gbc_unidProductoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_unidProductoField.gridx = 0;
		gbc_unidProductoField.gridy = 11;
		add(unidProdField, gbc_unidProductoField);
         */
        uploadTransactionButton = new JButton("Cargar transacción");
        uploadTransactionButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
        uploadTransactionButton.setFocusPainted(false);
        uploadTransactionButton.addActionListener(listener);

        uploadTransactionButton.addActionListener(new TempActionEventAddTrans());
        /*new ActionListener() {
            ManageTransaccion man = new ManageTransaccion();
            boolean itWorks = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fechaTransactionField.getText().isBlank() || idTransactionField.getText().isBlank()
                        || estadoTransactionField.getText().isBlank() || totalTransactionField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "hace falta un campo obligatorio");
                    itWorks = false;
                } else {
                    String dateTrans = fechaTransactionField.getText();
                    String estadoTransax = estadoTransactionField.getText();
                    try {
                        int idTrans = Integer.parseInt(idTransactionField.getText());
                        if (!man.isNotTransaccionInDB(idTrans)) {
                            auxiliar.setId(idTrans);
                        } else {
                            JOptionPane.showMessageDialog(null, "El id de la transaccion ya existe");
                            itWorks = false;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El id no es un numero");
                        itWorks = false;
                    }
                    if (dvudf.isValid(dateTrans)) {
                        auxiliar.setFechaTransaccion(auxiliar.dateConvert(dateTrans));
                    }
                    if (Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans(estadoTransax)) {
                        auxiliar.setEstadoTransaccion(estadoTransax);
                    }
                    try {
                        int totalTrans = Integer.parseInt(totalTransactionField.getText());
                        auxiliar.setTotalTransaccion((float) totalTrans);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El total de la transaccion no es un numero");
                        itWorks = false;
                    }
                    idTransactionField.setText("");
                    fechaTransactionField.setText("");
                    estadoTransactionField.setText("");
                    totalTransactionField.setText("");
                    if (idvendedorTransactionField.getText().isBlank()
                            && idCompradorTransactionField.getText().isBlank()
                            && costoTransportField.getText().isBlank()
                            && cantidadUnidadProductoField.getText().isBlank()) {
                        if (itWorks) {
                            man.addTransaccion(auxiliar);
                        } else {
                            JOptionPane.showMessageDialog(null, "hubo algun error");
                        }
                    } else {
                        if (!idvendedorTransactionField.getText().isBlank()) {
                            try {
                                int idVendedor = Integer.parseInt(idvendedorTransactionField.getText());
                                Personas vendedor = man.getPersona(false, idVendedor, man.initSesionfactory().openSession());
                                if (vendedor == null) {
                                    JOptionPane.showMessageDialog(null, "La persona con el id: " + idVendedor + "no existe");
                                    itWorks = false;
                                } else {
                                    auxiliar.setPersonaVende(vendedor);
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "El id del vendedor debe ser un numero");
                                itWorks = false;
                            }
                            idvendedorTransactionField.setText("");
                        }
                        if (!idCompradorTransactionField.getText().isBlank()) {
                            try {
                                int idComprador = Integer.parseInt(idCompradorTransactionField.getText());
                                Personas comprador = man.getPersona(true, idComprador, man.initSesionfactory().openSession());
                                if (comprador == null) {
                                    JOptionPane.showMessageDialog(null, "La persona con el id: " + idComprador + "no existe");
                                    itWorks = false;
                                } else {
                                    auxiliar.setPersonaCompra(comprador);
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "El id del comprador debe ser un numero");
                                itWorks = false;
                            }
                            idCompradorTransactionField.setText("");
                        }
                        if (!costoTransportField.getText().isBlank()) {
                            try {
                                int costoTransp = Integer.parseInt(costoTransportField.getText());
                                auxiliar.setCostoTranspor((float) costoTransp);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "El costo del transporte que escribio no es un numero valido");
                                itWorks = false;
                            }
                            costoTransportField.setText("");
                        }
                        if (!cantidadUnidadProductoField.getText().isBlank()) {
                            try {
                                int cantidadUnidadTran = Integer.parseInt(cantidadUnidadProductoField.getText());
                                auxiliar.setCostoTranspor((float) cantidadUnidadTran);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "La unidad del producto no es un numero valido");
                                itWorks = false;
                            }
                            cantidadUnidadProductoField.setText("");
                        }
                        idTransactionField.setText("");
                        fechaTransactionField.setText("");
                        estadoTransactionField.setText("");
                        totalTransactionField.setText("");
                        if (itWorks) {
                            man.addTransaccion(auxiliar);
                        } else {
                            JOptionPane.showMessageDialog(null, "hubo algun error");
                        }
                    }

                }
            }
        }*/
        uploadTransactionButton.setActionCommand(
                "Upload transacción");
        GridBagConstraints gbc_loginButton = new GridBagConstraints();
        gbc_loginButton.insets = new Insets(10, 0, 5, 0);
        gbc_loginButton.gridx = 0;
        gbc_loginButton.gridy = 18;

        add(uploadTransactionButton, gbc_loginButton);

        backButton = new JButton("Atrás");

        backButton.setFont(
                new Font("Ebrima", Font.PLAIN, 16));
        backButton.setFocusPainted(
                false);
        backButton.addActionListener(listener);

        backButton.setActionCommand(
                "Atrás1");
        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.insets = new Insets(10, 0, 5, 0);
        gbc_backButton.gridx = 0;
        gbc_backButton.gridy = 119;

        add(backButton, gbc_backButton);
    }
    Transacciones auxiliar = new Transacciones();

    public class TempActionEventAddTrans implements ActionListener {

        DateValidatorUsingDateFormat dvudf = new DateValidatorUsingDateFormat("dd-mm-yyyy");
        ManageTransaccion man = new ManageTransaccion();
        boolean itWorks = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (fechaTransactionField.getText().isBlank() || idTransactionField.getText().isBlank()
                    || estadoTransactionField.getText().isBlank() || totalTransactionField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "hace falta un campo obligatorio");
                itWorks = false;
            } else {
                String dateTrans = fechaTransactionField.getText();
                String estadoTransax = estadoTransactionField.getText();
                try {
                    int idTrans = Integer.parseInt(idTransactionField.getText());
                    if (man.isNotTransaccionInDB(idTrans)) {
                        auxiliar.setId(idTrans);
                    } else {
                        JOptionPane.showMessageDialog(null, "El id de la transaccion ya existe");
                        itWorks = false;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El id no es un numero");
                    itWorks = false;
                }
                if (dvudf.isValid(dateTrans)) {
                    auxiliar.setFechaTransaccion(auxiliar.dateConvert(dateTrans));
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error con la fecha");
                }
                if (Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans(estadoTransax)) {
                    auxiliar.setEstadoTransaccion(estadoTransax);
                } else {
                    JOptionPane.showMessageDialog(null, "El estado de la transaccion debe ser COM o VEN");
                }
                try {
                    int totalTrans = Integer.parseInt(totalTransactionField.getText());
                    auxiliar.setTotalTransaccion((float) totalTrans);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El total de la transaccion no es un numero");
                    itWorks = false;
                }
                idTransactionField.setText("");
                fechaTransactionField.setText("");
                estadoTransactionField.setText("");
                totalTransactionField.setText("");
                if (idvendedorTransactionField.getText().isBlank()
                        && idCompradorTransactionField.getText().isBlank()
                        && costoTransportField.getText().isBlank()
                        && cantidadUnidadProductoField.getText().isBlank()) {
                    if (itWorks) {
                        man.addTransaccion(auxiliar);
                    } else {
                        JOptionPane.showMessageDialog(null, "hubo algun error");
                    }
                } else {
                    if (!idvendedorTransactionField.getText().isBlank()) {
                        try {
                            int idVendedor = Integer.parseInt(idvendedorTransactionField.getText());
                            Personas vendedor = man.getPersona(false, idVendedor, man.initSesionfactory().openSession());
                            if (vendedor == null) {
                                JOptionPane.showMessageDialog(null, "La persona con el id: " + idVendedor + " no existe");
                                itWorks = false;
                            } else {
                                auxiliar.setPersonaVende(vendedor);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El id del vendedor debe ser un numero");
                            itWorks = false;
                        }
                        idvendedorTransactionField.setText("");
                    }
                    if (!idCompradorTransactionField.getText().isBlank()) {
                        try {
                            int idComprador = Integer.parseInt(idCompradorTransactionField.getText());
                            Personas comprador = man.getPersona(true, idComprador, man.initSesionfactory().openSession());
                            if (comprador == null) {
                                JOptionPane.showMessageDialog(null, "La persona con el id: " + idComprador + " no existe");
                                itWorks = false;
                            } else {
                                auxiliar.setPersonaCompra(comprador);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El id del comprador debe ser un numero");
                            itWorks = false;
                        }
                        idCompradorTransactionField.setText("");
                    }
                    if (!costoTransportField.getText().isBlank()) {
                        try {
                            int costoTransp = Integer.parseInt(costoTransportField.getText());
                            auxiliar.setCostoTranspor((float) costoTransp);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El costo del transporte que escribio no es un numero valido");
                            itWorks = false;
                        }
                        costoTransportField.setText("");
                    }
                    if (!cantidadUnidadProductoField.getText().isBlank()) {
                        try {
                            int cantidadUnidadTran = Integer.parseInt(cantidadUnidadProductoField.getText());
                            auxiliar.setCostoTranspor((float) cantidadUnidadTran);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "La unidad del producto no es un numero valido");
                            itWorks = false;
                        }
                        cantidadUnidadProductoField.setText("");
                    }
                    idTransactionField.setText("");
                    fechaTransactionField.setText("");
                    estadoTransactionField.setText("");
                    totalTransactionField.setText("");
                    if (itWorks) {
                        man.addTransaccion(auxiliar);
                    } else {
                        JOptionPane.showMessageDialog(null, "hubo algun error");
                    }
                }
            }
        }
    }
}
