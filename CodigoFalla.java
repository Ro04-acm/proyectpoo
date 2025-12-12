/**
 * Clase de entidad que representa un Código de Falla de diagnóstico (DTC - Diagnostic Trouble Code).
 * Contiene el código en sí, una descripción y la solución o pasos de diagnóstico recomendados.
 * @author Cortes Miranda Rodrigo Antonio
 * @since 22-11-25
 * @version 1.0
 */
public class CodigoFalla {
    private String codigo;
    private String descripcion;
    private String solucion;

    public CodigoFalla(String codigo, String descripcion, String solucion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.solucion = solucion;
    }
/**
     * Obtiene el código de falla.
     * @return El código alfanumérico como String.
     */
    public String getCodigo() { return codigo; }
    
    /**
     * Obtiene la descripción del código de falla.
     * @return La descripción del problema como String.
     */
    public String getDescripcion() { return descripcion; }
    
    /**
     * Obtiene la solución o pasos de diagnóstico del código de falla.
     * @return La solución o reparación recomendada como String.
     */
    public String getSolucion() { return solucion; }
}