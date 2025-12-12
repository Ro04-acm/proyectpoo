import java.util.List;
/**
 * Clase abstracta que define el contrato (interfaz) para cualquier proveedor de Códigos de Falla (CDF).
 * Implementa el patrón Factory Method, obligando a las clases hijas a definir
 * cómo obtener sus propios códigos específicos de un año o modelo.
 * @author Cortes Miranda Rodrigo Antonio
 * @since 23-11-25
 * @version 1.0
 */
public abstract class ProveedorCDF {
/**
     * Método abstracto que debe ser implementado por las clases concretas (por año)
     * para cargar su catálogo específico de códigos de falla.
     * @return Una lista (List<CodigoFalla>) de códigos de falla específicos del proveedor.
     */
    public abstract List<CodigoFalla> obtenerCodigos();
}