import java.util.*;
/**
 * Proveedor concreto de Códigos de Falla para vehículos del año 2016. ESTO ES LO MISMO SOLO VARIA EL AÑO AL QUE SE APLICA
 * Implementa la lógica para cargar el catálogo de fallas específico de este año.
 * @author Cortes Miranda Rodrigo Antonio
 * @since 23-11-25
 * @version 1.0
 */
public class CDF16 extends ProveedorCDF {
/**
     * Implementación del método abstracto para crear y devolver la lista de
     * códigos de falla específicos del año 2016.
     * @return La lista de códigos de falla (List<CodigoFalla>) del año 2016.
     */
    @Override
    public List<CodigoFalla> obtenerCodigos() {
        List<CodigoFalla> codigos = new ArrayList<>();

        codigos.add(new CodigoFalla("P0300", "Fallo de encendido múltiple", "Revisar bujías y bobinas"));
        codigos.add(new CodigoFalla("P0420", "Eficiencia baja del catalizador (Banco 1)", "Verificar sensores de oxígeno y catalizador"));
        codigos.add(new CodigoFalla("C0200", "Sensor de velocidad de rueda (ABS)", "Revisar sensor, cableado y anillo dentado"));

        return codigos;
    }
}

