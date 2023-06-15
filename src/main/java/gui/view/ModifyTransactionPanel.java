package gui.view;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import manageTransaccion.ManageTransaccion;

public class ModifyTransactionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel colorPanel;
    private JLabel logoLabel;
    private JLabel idPersonaCompraLabel, idPersonaVendeLabel, listProductsLabel;
    private JTextField idPersonaCompra, idPersonaVende, listProducts;
    private PromptText idPersonaCompraPrompt, idPersonaVendeLabelPrompt, listProductsPrompt;
    private JComboBox<String> productsComboBox;
    private JButton backButton, okButton;

    private int valueIDTransaccion;

    public void setValueIDTransaccion(int valueIDTransaccion) {
        this.valueIDTransaccion = valueIDTransaccion;
    }

    public ModifyTransactionPanel(ActionListener listener) {
        setSize(1020, 800);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{173, 0};
        gridBagLayout.rowHeights = new int[]{254, 0, 0, 0, 0, 64, 0, 0, 49, 0};
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

        idPersonaCompraLabel = new JLabel("Costo transporte de la transacción");
        idPersonaCompraLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idPersonaCompraLabel.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_idPersonaCompraLabel = new GridBagConstraints();
        gbc_idPersonaCompraLabel.anchor = GridBagConstraints.WEST;
        gbc_idPersonaCompraLabel.insets = new Insets(0, 10, 5, 10);
        gbc_idPersonaCompraLabel.fill = GridBagConstraints.VERTICAL;
        gbc_idPersonaCompraLabel.gridx = 0;
        gbc_idPersonaCompraLabel.gridy = 2;
        add(idPersonaCompraLabel, gbc_idPersonaCompraLabel);

        idPersonaCompra = new JTextField();
        idPersonaCompra.setColumns(30);
        idPersonaCompra.setForeground(new Color(128, 128, 128));
        idPersonaCompra.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idPersonaCompra.setBorder(new CompoundBorder(idPersonaCompra.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        idPersonaCompraPrompt = new PromptText("Ingrese el costo del transporte de la transacción", idPersonaCompra);
        idPersonaCompraPrompt.changeStyle(Font.PLAIN);
        idPersonaCompraPrompt.changeAlpha(128);
        GridBagConstraints gbc_loginEmailUsernameField = new GridBagConstraints();
        gbc_loginEmailUsernameField.insets = new Insets(0, 10, 5, 10);
        gbc_loginEmailUsernameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_loginEmailUsernameField.gridx = 0;
        gbc_loginEmailUsernameField.gridy = 3;
        add(idPersonaCompra, gbc_loginEmailUsernameField);

        idPersonaVendeLabel = new JLabel("Unidades del producto en la transacción");
        idPersonaVendeLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idPersonaVendeLabel.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_idPersonaVendeLabel = new GridBagConstraints();
        gbc_idPersonaVendeLabel.anchor = GridBagConstraints.WEST;
        gbc_idPersonaVendeLabel.insets = new Insets(0, 10, 5, 10);
        gbc_idPersonaVendeLabel.fill = GridBagConstraints.VERTICAL;
        gbc_idPersonaVendeLabel.gridx = 0;
        gbc_idPersonaVendeLabel.gridy = 4;
        add(idPersonaVendeLabel, gbc_idPersonaVendeLabel);

        idPersonaVende = new JTextField();
        idPersonaVende.setColumns(30);
        idPersonaVende.setForeground(new Color(128, 128, 128));
        idPersonaVende.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idPersonaVende.setBorder(new CompoundBorder(idPersonaCompra.getBorder(), new EmptyBorder(5, 0, 5, 0)));
        idPersonaVendeLabelPrompt = new PromptText("Ingrese las nuevas unidades del producto en la transacción", idPersonaVende);
        idPersonaVendeLabelPrompt.changeStyle(Font.PLAIN);
        idPersonaVendeLabelPrompt.changeAlpha(128);
        GridBagConstraints gbc_idPersonaVendeField = new GridBagConstraints();
        gbc_idPersonaVendeField.insets = new Insets(0, 10, 5, 10);
        gbc_idPersonaVendeField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idPersonaVendeField.gridx = 0;
        gbc_idPersonaVendeField.gridy = 5;
        add(idPersonaVende, gbc_idPersonaVendeField);

        /*listProductsLabel = new JLabel("Lista de productos");
		listProductsLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		GridBagConstraints gbc_listProductsLabel = new GridBagConstraints();
		gbc_listProductsLabel.gridwidth = 2;
		gbc_listProductsLabel.insets = new Insets(20, 0, 5, 0);
		gbc_listProductsLabel.gridx = 0;
		gbc_listProductsLabel.gridy = 6;
		add(listProductsLabel, gbc_listProductsLabel);

		productsComboBox = new JComboBox<String>();
		productsComboBox.setFont(new Font("Ebrima", Font.PLAIN, 16));
		productsComboBox.setEditable(false);
		GridBagConstraints gbc_productsComboBox = new GridBagConstraints();
		gbc_productsComboBox.gridwidth = 2;
		gbc_productsComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_productsComboBox.gridx = 0;
		gbc_productsComboBox.gridy = 7;
		add(productsComboBox, gbc_productsComboBox);*/
        backButton = new JButton("Atrás");
        backButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
        backButton.setFocusPainted(false);
        backButton.addActionListener(listener);
        backButton.setActionCommand("Atrás2");
        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.insets = new Insets(10, 0, 5, 0);
        gbc_backButton.gridx = 0;
        gbc_backButton.gridy = 9;
        add(backButton, gbc_backButton);

        okButton = new JButton("Actualizar");
        okButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
        okButton.setFocusPainted(false);
        okButton.addActionListener(listener);
        okButton.addActionListener(new ActionListenerActualizar());
        okButton.setActionCommand("Actualizar");
        GridBagConstraints gbc_okButton = new GridBagConstraints();
        gbc_okButton.insets = new Insets(10, 0, 5, 0);
        gbc_okButton.gridx = 0;
        gbc_okButton.gridy = 8;
        add(okButton, gbc_okButton);
    }

    public class ActionListenerActualizar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, valueIDTransaccion);
            //Transacciones trx = new ManageTransaccion().getTransaccion(valueIDTransaccion);
            ManageTransaccion man =new ManageTransaccion();
            man.updateTransaccion(Float.parseFloat(idPersonaCompra.getText()), Float.parseFloat(idPersonaVende.getText()), valueIDTransaccion, man.initSesionfactory().openSession());
        }

    }
}
