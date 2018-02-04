/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.enums;

/**
 *
 * @author joel
 */
public enum ActividadEnum {
    
    REA("REALIZADO"),
    NRE("NO REALIZADO");
    
    private String texto;

    private ActividadEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
