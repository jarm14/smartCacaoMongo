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
 * @author TMET
 */
public enum TipoUsuarioEnum {
    
    ADM("ADMINISTRADOR"),
    OPE("OPERACIONAL");
    
    private String texto;

    private TipoUsuarioEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
