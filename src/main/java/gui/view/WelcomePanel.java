package gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WelcomePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel colorPanel;
	private JLabel logoLabel;
	
	private JButton tableTransactionButton;
	private JButton modifyTransactionButton;
	private JButton deleteTransactionButton;
	private JButton addTransactionButton;
	
	public WelcomePanel(ActionListener listener) {
		this.setSize(1020, 900);
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 173, 0 };
		gridBagLayout.rowHeights = new int[] { 600, 0, 0, 0, 0, 0, 0, 0, 14, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		tableTransactionButton = new JButton("Mostrar tabla de transacciones");
		tableTransactionButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		tableTransactionButton.setFocusPainted(false);
		tableTransactionButton.addActionListener(listener);
		tableTransactionButton.setActionCommand("Mostrar tabla de transacciones");
		GridBagConstraints gbc_tableTransactionButton = new GridBagConstraints();
		gbc_tableTransactionButton.insets = new Insets(10, 0, 5, 0);
		gbc_tableTransactionButton.gridx = 0;
		gbc_tableTransactionButton.gridy = 6;
		add(tableTransactionButton, gbc_tableTransactionButton);

		modifyTransactionButton = new JButton("Modificar transacción");
		modifyTransactionButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		modifyTransactionButton.setFocusPainted(false);
		modifyTransactionButton.addActionListener(listener);
		modifyTransactionButton.setActionCommand("Modificar transacción");
		GridBagConstraints gbc_modifyTransactionButton = new GridBagConstraints();
		gbc_modifyTransactionButton.insets = new Insets(0, 0, 430, 0);
		gbc_modifyTransactionButton.gridx = 0;
		gbc_modifyTransactionButton.gridy = 7;
		add(modifyTransactionButton, gbc_modifyTransactionButton);
		
		deleteTransactionButton = new JButton("Eliminar transacción");
		deleteTransactionButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		deleteTransactionButton.setFocusPainted(false);
		deleteTransactionButton.addActionListener(listener);
		deleteTransactionButton.setActionCommand("Eliminar transacción");
		GridBagConstraints gbc_deleteTransactionButton= new GridBagConstraints();
		gbc_deleteTransactionButton.insets = new Insets(0, 0, 355, 0);
		gbc_deleteTransactionButton.gridx = 0;
		gbc_deleteTransactionButton.gridy = 7;
		add(deleteTransactionButton, gbc_deleteTransactionButton);
		
		addTransactionButton = new JButton("Agregar transacción");
		addTransactionButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		addTransactionButton.setFocusPainted(false);
		addTransactionButton.addActionListener(listener);
		addTransactionButton.setActionCommand("Agregar transacción");
		GridBagConstraints gbc_addTransactionButton = new GridBagConstraints();
		gbc_addTransactionButton.insets = new Insets(0, 0, 280, 0);
		gbc_addTransactionButton.gridx = 0;
		gbc_addTransactionButton.gridy = 7;
		add(addTransactionButton, gbc_addTransactionButton);
	}
	
	public JButton getTableTransactionButton() {
		return tableTransactionButton;
	}
	
	public JButton getModifyTransactionButton() {
		return modifyTransactionButton;
	}
	
	public JButton getDeleteTransactionButton() {
		return deleteTransactionButton;
	}
	
	public JButton getAddTransactionButton() {
		return addTransactionButton;
	}
	
}
