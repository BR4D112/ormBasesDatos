package entities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author Diego Alejandro Rubiano
 */
@Entity(name = "TRANSACCIONES")
@Table(name = "TRANSACCIONES")
public class Transacciones {

    @Column(name = "ID_TRANSACCION")
    private int id;
    @Column(name = "FECHA_TRANSACCION_DATE")
    private LocalDate fechaTransaccion;
    @Column(name = "TOTAL_TRANSACCION")
    private float totalTransaccion;
    @Column(name = "ESTADO_TRANSACCION")
    private ESTADO_TRANSACCION estadoTransaccion;
    @Column(name = "ID_PERSONA_VENDE")
    private int id_persVEN;
    @Column(name = "ID_PERSONA_ADQUIERE")
    private int idPersCOM;
    @Column(name = "COSTO_TRANSPORTE")
    private float costoTranspor;
    @Column(name = "CANTIDAD_UNID_PROD")
    private float cantidadUnidProd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public float getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(float totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }

    public ESTADO_TRANSACCION getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(ESTADO_TRANSACCION estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public int getId_persVEN() {
        return id_persVEN;
    }

    public void setId_persVEN(int id_persVEN) {
        this.id_persVEN = id_persVEN;
    }

    public int getIdPersCOM() {
        return idPersCOM;
    }

    public void setIdPersCOM(int idPersCOM) {
        this.idPersCOM = idPersCOM;
    }

    public float getCostoTranspor() {
        return costoTranspor;
    }

    public void setCostoTranspor(float costoTranspor) {
        this.costoTranspor = costoTranspor;
    }

    public float getCantidadUnidProd() {
        return cantidadUnidProd;
    }

    public void setCantidadUnidProd(float cantidadUnidProd) {
        this.cantidadUnidProd = cantidadUnidProd;
    }
    public Transacciones createTransaccion(int idIn, CharSequence dateCharSeq, float totalTransIn, String estado){
        Transacciones tempTrans = new Transacciones();
        tempTrans.setId(idIn);
        tempTrans.setFechaTransaccion(LocalDate.parse(dateCharSeq));
        tempTrans.setEstadoTransaccion(estadoTransaccion);
        return tempTrans;
    }
    public enum ESTADO_TRANSACCION {
        COMPRA("COM"),
        VENTA("VEN");
        public String value;

        private ESTADO_TRANSACCION(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        public boolean isInEstadoTrans(String value){
            return Arrays.asList(ESTADO_TRANSACCION.values()).stream().map(a -> a.getValue()).anyMatch(a-> a.equals(value));
        }
        public ESTADO_TRANSACCION getEstadoTrans(String estado){
            return Arrays.asList(ESTADO_TRANSACCION.values()).stream().filter(e-> e.getValue().equals(estado)).collect(Collectors.toList()).get(0);
        }
    }
}
