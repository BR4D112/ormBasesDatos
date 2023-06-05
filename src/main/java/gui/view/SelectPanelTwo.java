package gui.view;

import entities.Transacciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import manageTransaccion.ManageTransaccion;

public class SelectPanelTwo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel colorPanel;
    private JLabel idProducto;
    private JComboBox comboBox;
    private JButton searchIdButton, backButton;
    private ManageTransaccion manageTransaccion;

    public SelectPanelTwo(ActionListener listener) {
        this.setSize(1020, 900);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{173, 0};
        gridBagLayout.rowHeights = new int[]{300, 277, 50, 50, 50, -48, 162, 0, 14, 0};
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

        idProducto = new JLabel("Seleccione el id de la transacción");
        idProducto.setFont(new Font("Ebrima", Font.PLAIN, 16));
        idProducto.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_emailUsernameLabel = new GridBagConstraints();
        gbc_emailUsernameLabel.insets = new Insets(10, 0, 5, 0);
        gbc_emailUsernameLabel.gridx = 0;
        gbc_emailUsernameLabel.gridy = 2;
        add(idProducto, gbc_emailUsernameLabel);
        
        manageTransaccion = new ManageTransaccion();
        List<Transacciones> transacciones = manageTransaccion.getTransacc(manageTransaccion.initSesionfactory());
        List<Integer> listaEnteros = transacciones.stream().map(Transacciones::getId).collect(Collectors.toList());
        comboBox = new JComboBox(listaEnteros.toArray());
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 3;
        add(comboBox, gbc_comboBox);

        searchIdButton = new JButton("Eliminar");
        searchIdButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
        searchIdButton.setFocusPainted(false);
        searchIdButton.addActionListener(listener);
        searchIdButton.addActionListener(new ActionListenerDelete());
        searchIdButton.setActionCommand("eliminar");
        GridBagConstraints gbc_searchIdButton = new GridBagConstraints();
        gbc_searchIdButton.insets = new Insets(10, 0, 5, 0);
        gbc_searchIdButton.gridx = 0;
        gbc_searchIdButton.gridy = 4;
        add(searchIdButton, gbc_searchIdButton);

        backButton = new JButton("Atrás");
        backButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
        backButton.setFocusPainted(false);
        backButton.addActionListener(listener);
        backButton.setActionCommand("Atrás1");
        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.insets = new Insets(10, 0, 5, 0);
        gbc_backButton.gridx = 0;
        gbc_backButton.gridy = 5;
        add(backButton, gbc_backButton);
    }
    public class ActionListenerDelete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int Id_transaccion = (int)comboBox.getSelectedItem();
            manageTransaccion.deleteTransaccion(Id_transaccion, manageTransaccion.initSesionfactory().openSession());
            JOptionPane.showMessageDialog(null, "La transaccion con el id:"+Id_transaccion+" fue eliminada...");
        }
        
    }
}
