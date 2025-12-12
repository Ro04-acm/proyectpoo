import java.util.*;
/**
 * Representa un vehículo en el sistema de diagnóstico, almacenando sus características
 * y la lista de códigos de falla específicos que le han sido asignados.
 * @author Cortes Miranda Rodrigo Antonio
 * @since 23-11-25
 * @version 1.0
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private String tipo;
    private String motor;
    private String transmision;
    private List<CodigoFalla> codigos;

/**
     * Constructor para crear una instancia de Vehiculo.
     * @param marca La marca del vehículo.
     * @param modelo El modelo específico del vehículo.
     * @param anio El año de fabricación del vehículo.
     * @param tipo El tipo de carrocería (Sedan, SUV, Pickup, etc.).
     * @param motor La especificación del motor (cilindrada, tipo de combustible).
     * @param transmision La especificación de la transmisión (Manual, Automática).
     */

    public Vehiculo(String marca, String modelo, int anio, String tipo, String motor, String transmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.motor = motor;
        this.transmision = transmision;
        this.codigos = new ArrayList<>();
    }

/**
     * Obtiene la marca del vehículo.
     * @return La marca del vehículo como String.
     */
    public String getMarca() { return marca; }
    
    /**
     * Obtiene el año de fabricación del vehículo.
     * @return El año del vehículo como entero.
     */
    public int getAnio() { return anio; }
    
    /**
     * Obtiene el modelo específico del vehículo.
     * @return El modelo del vehículo como String.
     */
    public String getModelo() { return modelo; }

    /**
     * Asigna la lista de códigos de falla cargados para este vehículo.
     * @param codigos La lista de objetos CodigoFalla.
     */
    public void setCodigos(List<CodigoFalla> codigos) {
        this.codigos = codigos;
    }

    /**
     * Obtiene la lista de códigos de falla asignados a este vehículo.
     * @return La lista de objetos CodigoFalla.
     */
    public List<CodigoFalla> getCodigos() {
        return codigos;
    }

    /**
     * Imprime en consola un resumen de los datos del vehículo (Modelo, Tipo, Motor, Transmisión).
     */
    public void mostrarDatos() {
        System.out.println(modelo + " | " + tipo + " | " + motor + " | " + transmision);
    }
}
