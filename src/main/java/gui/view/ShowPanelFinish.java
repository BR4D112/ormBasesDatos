package gui.view;

import entities.Transacciones;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import manageTransaccion.ManageTransaccion;

public class ShowPanelFinish extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable jTable;
    // private Product product;

    // private InvoiceBody invoiceBody;
    //  private ListUptc<InvoiceBody> listInvoiceBody;
    //private Integer quantityAux;
    public ShowPanelFinish() {
        this.setLayout(new GridBagLayout());
        Color color = new Color(192, 220, 220);
        setBackground(color);
        this.initComponents();
        //   listInvoiceBody = new ListUptc<>();
    }

    private void initComponents() {
        addTable();
    }

    private void addTable() {
        jTable = new JTable(0, 7);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBounds(30, 110, 800, 300);
        jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
        this.setLayout(new BorderLayout());
        tableHeader(jTable.getTableHeader());
        add(scrollPane, BorderLayout.CENTER);
        jTable.repaint();
        loadData();
    }
    public List<Transacciones> transacciones;
    private void tableHeader(JTableHeader header) {
        header.getColumnModel().getColumn(0).setHeaderValue("Id_transacción");
        header.getColumnModel().getColumn(1).setHeaderValue("Fecha");
        header.getColumnModel().getColumn(2).setHeaderValue("Estado");
        header.getColumnModel().getColumn(3).setHeaderValue("Total");
        header.getColumnModel().getColumn(4).setHeaderValue("Id vendedor");
        header.getColumnModel().getColumn(5).setHeaderValue("Id comprador");
        header.getColumnModel().getColumn(6).setHeaderValue("Cantidad unidades");

    }

    private void clearTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.getDataVector().removeAllElements();
    }

//    public void setProduct(Product product1){
//        product = product1;
//    }
//    public void setQuantity(Integer quantity){
//        System.out.println(quantity);
//        quantityAux = quantity;
//    }
    public void loadData() {
        ManageTransaccion manageTransaccion = new ManageTransaccion();
        List<Transacciones> transacciones = manageTransaccion.getTransacc(manageTransaccion.initSesionfactory());
        clearTable();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        for (Transacciones transaccione : transacciones) {
            model.addRow(new Object[]{transaccione.getId(), transaccione.getFechaTransaccion(),
                transaccione.getEstadoTransaccion(), transaccione.getTotalTransaccion(),
                this.getValueOutNull(transaccione.getPersonaVende() == null ? "null" : transaccione.getPersonaVende().getIdPersona()),
                this.getValueOutNull(transaccione.getPersonaCompra() == null ? "null" : transaccione.getPersonaCompra().getIdPersona()),
                this.getValueOutNull(transaccione.getCantidadUnidProd() == 0 ? "0" : transaccione.getCantidadUnidProd())
            });
        }
        jTable.setModel(model);
    }

    public Object getValueOutNull(Object aux) {
        try {
            return aux;
        } catch (NullPointerException e) {
            return "null";
        }
    }
//    public void addProducts(Product product, Integer quantity){
//        Integer valueTotal = quantity * product.getValue();
//        InvoiceBody invoice = new InvoiceBody(product, valueTotal, quantity);
//        listInvoiceBody.add(invoice);
//    }
//
//    public ListUptc<InvoiceBody> getListInvoiceBody() {
//        return listInvoiceBody;
//    }
//
//    public InvoiceBody getInvoiceBody() {
//        return invoiceBody;
//    }

}
