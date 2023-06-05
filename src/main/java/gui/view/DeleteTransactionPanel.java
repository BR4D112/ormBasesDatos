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
import javax.swing.JTextField;

public class DeleteTransactionPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel colorPanel;
	private JTextField transactionText;
	
	private JButton deleteTransactionButton;
	private JButton backButton;
	
	public DeleteTransactionPanel(ActionListener listener) {
		setSize(1020, 800);
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

		transactionText = new JTextField();

		
	}
	
	
	
}
