package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Diego Alejandro Rubiano
 */
@Entity(name = "LUGAR")
@Table(name = "LUGAR")
public class Lugar {

    @Id
    @Column(name = "ID_LUGAR", nullable = false)
    private Long idLugar;

    @Column(name = "TIPO_LUGAR", nullable = false, length = 2)
    private String tipoLugar;

    @Column(name = "NOMBRE_LUGAR", nullable = false, length = 50)
    private String nombreLugar;

    @Column(name = "ID_OTRO_LUGAR")
    private Long idOtroLugar;

    public Lugar() {
    }

    public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public Long getIdOtroLugar() {
        return idOtroLugar;
    }

    public void setIdOtroLugar(Long idOtroLugar) {
        this.idOtroLugar = idOtroLugar;
    }

}
