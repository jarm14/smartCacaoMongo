/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import ec.edu.espe.distribuidas.smartCacao.mongo.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author TMET
 */
@Entity(noClassnameStored = true, value = "cosecha")
public class Cosecha extends BaseEntity {

    private Date fechaPlantacion;
    @Reference
    private Terreno terreno;
    @Reference
    private TipoTerreno tipoTerreno;

    public Cosecha() {
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public TipoTerreno getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerreno tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    @Override
    public String toString() {
        return "Cosecha{" + "fechaPlantacion=" + fechaPlantacion + ", terreno=" + terreno + ", tipoTerreno=" + tipoTerreno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id != null ? super.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cosecha)) {
            return false;
        }
        Cosecha other = (Cosecha) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
}
