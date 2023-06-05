package entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Diego Alejandro Rubiano
 */
@Entity(name = "TRANSACCIONES")
@Table(name = "TRANSACCIONES")
public class Transacciones implements Serializable {

    public Transacciones() {
    }

    @Id
    @Column(name = "ID_TRANSACCION")
    private int id;

    @Column(name = "FECHA_TRANSACCION_DATE")
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;

    @Column(name = "TOTAL_TRANSACCION")
    private float totalTransaccion;

    @Column(name = "ESTADO_TRANSACCION")
    private String estadoTransaccion;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA_VENDE", referencedColumnName = "ID_PERSONA", nullable = true)
    private Personas personaVende;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA_ADQUIERE", referencedColumnName = "ID_PERSONA", nullable = true)
    private Personas personaCompra;

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

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public float getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(float totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }

    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(String estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public Personas getPersonaVende() {
        return personaVende;
    }

    public void setPersonaVende(Personas personaVende) {
        this.personaVende = personaVende;
    }

    public Personas getPersonaCompra() {
        return personaCompra;
    }

    public void setPersonaCompra(Personas personaCompra) {
        this.personaCompra = personaCompra;
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
    public Date dateConvert(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(LocalDate.parse(date, formatter).atStartOfDay(defaultZoneId).toInstant());
    }

    @Override
    public String toString() {
        return "Transacciones{" + "id=" + id + ", fechaTransaccion=" + fechaTransaccion + ", totalTransaccion=" + totalTransaccion + ", estadoTransaccion=" + estadoTransaccion + ", personaVende=" + personaVende + ", personaCompra=" + personaCompra + ", costoTranspor=" + costoTranspor + ", cantidadUnidProd=" + cantidadUnidProd + '}';
    }
    
    public Transacciones createTransaccion(int idIn, String dateCharSeq, float totalTransIn, String estado, Personas personaCompraIN, Personas personaVendeIN, float costoTransportIn, float cantidad_unid_prod) {
        Transacciones tempTrans = new Transacciones();
        tempTrans.setId(idIn);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        tempTrans.setFechaTransaccion(Date.from(LocalDate.parse(dateCharSeq, formatter).atStartOfDay(defaultZoneId).toInstant()));
        tempTrans.setEstadoTransaccion(estado);
        if (personaCompraIN != null) {
            tempTrans.setPersonaCompra(personaCompraIN);
        }
        if (personaVendeIN != null) {
            tempTrans.setPersonaVende(personaVendeIN);
        }
        if (costoTransportIn != 0) {
            tempTrans.setCostoTranspor(costoTransportIn);
        }
        if (cantidad_unid_prod != 0) {
            tempTrans.setCantidadUnidProd(cantidad_unid_prod);
        }
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

        public boolean isInEstadoTrans(String value) {
            return Arrays.asList(ESTADO_TRANSACCION.values()).stream().map(a -> a.getValue()).anyMatch(a -> a.equals(value));
        }

        public ESTADO_TRANSACCION getEstadoTransWithString(String estado) {
            return Arrays.asList(ESTADO_TRANSACCION.values()).stream().filter(e -> e.getValue().equals(estado)).collect(Collectors.toList()).get(0);
        }
    }
}
