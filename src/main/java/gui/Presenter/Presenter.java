package gui.Presenter;

import gui.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Presenter implements ActionListener {

    private View view;

    public Presenter() {
        view = new View(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Mostrar tabla de transacciones":
                view.setDefaultAddTableTransactionPanelButton();
                view.changePanel("showPanelFinish");
                break;
            case "Modificar transacci�n":
                view.setDefaultAddModifyTransactionPanelButton();
                view.changePanel("selectTransactionIdPanel");
                break;
            case "Eliminar transacci�n":
                view.setDefaultAddDeleteTransactionButton();
                view.changePanel("selectDeleteTransaction");
                break;
            case "Agregar transacci�n":
                view.setDefaultAddTransactionPanelButton();
                view.changePanel("addTransactionPanel");
                break;
            case "Atr�s1":
                view.setDefaultAddDeleteTransactionButton();
                view.changePanel("welcomePanel");
                break;
            case "BuscarId":
                view.setDefaultAddTransactionPanelButton();
                view.changePanel("informationTransactionPanel");
                view.updateValue();
                break;
            case "seguirAModificar":
                view.setDefaultAddTransactionPanelButton();
                view.changePanel("modifyTransactionPanel");
                break;
            case "eliminar":
                view.setDefaultAddTransactionPanelButton();
                view.changePanel("welcomePanel");
                break;
            case "Atr�s2":
                view.setDefaultAddTransactionPanelButton();
                view.changePanel("selectTransactionIdPanel");
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
