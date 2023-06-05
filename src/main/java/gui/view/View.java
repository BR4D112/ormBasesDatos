package gui.view;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {

    private final static String WELCOME_PANEL = "welcomePanel";
    private final static String SHOW_TRANSACTION_PANEL = "showTransactionPanel";
    private final static String MODIFIY_TRANSACTION_PANEL = "modifyTransactionPanel";
    private final static String DELETE_TRANSACTION_PANEL = "deleteTransactionPanel";
    private final static String ADD_TRANSACTION_PANEL = "addTransactionPanel";

    private final static String INFORMATION_TRANSACTION_PANEL = "informationTransactionPanel";
    private final static String SELECT_TRANSACTION_ID_PANEL = "selectTransactionIdPanel";
    private final static String SELECT_TRANSACTION_TWO = "selectDeleteTransaction";
    private final static String SHOW_TRANSACTION_PANEL_FINISh = "showPanelFinish";

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private WelcomePanel welcomePanel;
    private ModifyTransactionPanel modifyTransactionPanel;
    private DeleteTransactionPanel deleteTransactionPanel;
    private AddTransactionPanel addTransactionPanel;
    private SelectPanelTwo selectPanelTwo;
    private ShowPanelFinish showPanelFinish;

    private InformationTransactionPanel informationTransactionPanel;
    private SelectTransactionIdPanel selectTransactionIdPanel;

    public View(ActionListener listener) {
        super("INVENTARIO APP");
        setSize(1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo2.png"));
        initComponents(listener);
        initPanels();
        setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        contentPane = new JPanel();
        welcomePanel = new WelcomePanel(listener);
        modifyTransactionPanel = new ModifyTransactionPanel(listener);
        deleteTransactionPanel = new DeleteTransactionPanel(listener);
        addTransactionPanel = new AddTransactionPanel(listener);
        selectPanelTwo = new SelectPanelTwo(listener);
        informationTransactionPanel = new InformationTransactionPanel(listener);
        JLabel aux = informationTransactionPanel.getTransactionSelected();
        selectTransactionIdPanel = new SelectTransactionIdPanel(listener);
        selectTransactionIdPanel.setTransaccionselected(aux);

        showPanelFinish = new ShowPanelFinish();
        contentPane.setLayout(new CardLayout());
        setContentPane(contentPane);
    }

    public ShowPanelFinish getShowPanelFinish() {
        return showPanelFinish;
    }

    private void initPanels() {
        contentPane.add(welcomePanel, WELCOME_PANEL);
        contentPane.add(modifyTransactionPanel, MODIFIY_TRANSACTION_PANEL);
        contentPane.add(deleteTransactionPanel, DELETE_TRANSACTION_PANEL);
        contentPane.add(addTransactionPanel, ADD_TRANSACTION_PANEL);
        contentPane.add(selectPanelTwo, SELECT_TRANSACTION_TWO);
        contentPane.add(informationTransactionPanel, INFORMATION_TRANSACTION_PANEL);
        contentPane.add(selectTransactionIdPanel, SELECT_TRANSACTION_ID_PANEL);
        contentPane.add(showPanelFinish, SHOW_TRANSACTION_PANEL_FINISh);
    }

    public void updateValue() {
        selectTransactionIdPanel.setValue(modifyTransactionPanel);
    }

    public void changePanel(String command) {
        ((CardLayout) contentPane.getLayout()).show(contentPane, command);
    }

    /*
		public void setDefaultCreatePanelButton() {
			getRootPane().setDefaultButton(welcomePanel.getCreateButton());
		}
		
		public void setDefaultModifyPanelButton() {
			getRootPane().setDefaultButton(welcomePanel.getModifyButton());
		}
		
		public void setDefaultShowPanelButton() {
			getRootPane().setDefaultButton(welcomePanel.getShowButton());
		}
     */
    public void setDefaultAddTableTransactionPanelButton() {
        getRootPane().setDefaultButton(welcomePanel.getTableTransactionButton());
    }

    public void setDefaultAddModifyTransactionPanelButton() {
        getRootPane().setDefaultButton(welcomePanel.getModifyTransactionButton());
    }

    public void setDefaultAddDeleteTransactionButton() {
        getRootPane().setDefaultButton(welcomePanel.getDeleteTransactionButton());
    }

    public void setDefaultAddTransactionPanelButton() {
        getRootPane().setDefaultButton(welcomePanel.getAddTransactionButton());
    }

}
