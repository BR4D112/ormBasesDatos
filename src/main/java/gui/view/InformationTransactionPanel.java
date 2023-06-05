package gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationTransactionPanel extends JPanel{
        public static String textoFactura = "El ID de la factura seleccionada es: ";
	private static final long serialVersionUID = 1L;
	private JPanel colorPanel;
	private JLabel transactionSelected;
	private JButton backButton, okButton;
	
	public InformationTransactionPanel(ActionListener listener) {
		setSize(1020, 800);
		initComponents(listener);
	}

    public JLabel getTransactionSelected() {
        return transactionSelected;
    }
	
	public void initComponents(ActionListener listener) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 173, 0 };
		gridBagLayout.rowHeights = new int[] { 123, 314, 105, 75, 0, 0, 0, 0, 185, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		colorPanel = new JPanel();
		colorPanel.setBackground(new Color(103, 175, 50));
		GridBagConstraints gbc_colorPanel = new GridBagConstraints();
		gbc_colorPanel.insets = new Insets(0, 0, 5, 0);
		gbc_colorPanel.fill = GridBagConstraints.BOTH;
		gbc_colorPanel.gridx = 0;
		gbc_colorPanel.gridy = 0;
		add(colorPanel, gbc_colorPanel);
		
		transactionSelected = new JLabel(textoFactura);
		transactionSelected.setFont(new Font("Ebrima", Font.PLAIN, 16));
		transactionSelected.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_transactionSelectedLabel = new GridBagConstraints();
		gbc_transactionSelectedLabel.insets = new Insets(10, 0, 5, 0);
		gbc_transactionSelectedLabel.gridx = 0;
		gbc_transactionSelectedLabel.gridy = 2;
		add(transactionSelected, gbc_transactionSelectedLabel);
		
		backButton = new JButton("Atrás");
		backButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		backButton.setFocusPainted(false);
		backButton.addActionListener(listener);
		backButton.setActionCommand("Atrás1");
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(10, 0, 5, 0);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 6;
		add(backButton, gbc_backButton);
		
		okButton = new JButton("Siguiente");
		okButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		okButton.setFocusPainted(false);
		okButton.addActionListener(listener);
		okButton.setActionCommand("seguirAModificar");
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(10, 0, 5, 0);
		gbc_okButton.gridx = 0;
		gbc_okButton.gridy = 4;
		add(okButton, gbc_okButton);
	}

}
