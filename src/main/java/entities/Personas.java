package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Diego Alejandro Rubiano
 */
@Entity(name = "PERSONAS")
@Table(name = "PERSONAS")
public class Personas {
    @Id
    @Column(name = "ID_PERSONA", nullable = false)
    private Long idPersona;

    @Column(name = "NOMBRE_PERSONA", nullable = false, length = 100)
    private String nombrePersona;

    @Column(name = "NUM_TELEFONO_PERSONA", nullable = false, length = 20)
    private String numTelefonoPersona;

    @Column(name = "TIPO_PERSONA", nullable = false, length = 2)
    private String tipoPersona;

    @ManyToOne
    @JoinColumn(name = "ID_ORIGENPROD_LUGAR", referencedColumnName = "ID_LUGAR", nullable = false)
    private Lugar lugar;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNumTelefonoPersona() {
        return numTelefonoPersona;
    }

    public void setNumTelefonoPersona(String numTelefonoPersona) {
        this.numTelefonoPersona = numTelefonoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Personas{" + "idPersona=" + idPersona + ", nombrePersona=" + nombrePersona + ", numTelefonoPersona=" + numTelefonoPersona + ", tipoPersona=" + tipoPersona + ", lugar=" + lugar + '}';
    }
    
    
    
}
