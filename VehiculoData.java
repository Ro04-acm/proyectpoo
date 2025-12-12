import java.util.*;
/**
 * Clase de utilidad estática encargada de proveer la lista inicial de todos los vehículos
 * disponibles en el sistema de diagnóstico. Simula una base de datos o un servicio de datos.
 * @author Cortes Miranda Rodrigo Antoio
 * @since 23-11-25
 * @version 1.0
 */
public class VehiculoData {
//es muy cansado escribir uno por uno pero no supe otra forma de automatizarlo :(
/**
     * Crea y devuelve una lista predefinida de objetos Vehiculo con sus características.
     * @return Una lista (List<Vehiculo>) que contiene todos los vehículos disponibles.
     */
    public static List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();

        // --- CHEVROLET 2025 --- 
        lista.add(new Vehiculo(
            "CHEVROLET", "AVEO", 2025,
            "Sedan", "1.5L de 4 cilindros", "Manual de 6 velocidades o Automática de Velocidad Continua (CVT)"
        ));

        // --- CADILLAC 2020 ---
        lista.add(new Vehiculo(
            "CADILLAC", "CT5", 2020,
            "Sedan", "2.0L I4 Turbo o 3.0L V6 Twin Turbo", "Automática de 10 velocidades"
        ));
       
        // --- JEEP 2020 ---
        lista.add(new Vehiculo(
            "JEEP", "GLADIATOR (JT)", 2020,
            "Pickup", "3.6L Pentastar V6 (Gasolina) o 3.0L EcoDiesel V6 (Diésel)", "Manual de 6 velocidades o Automática de 8 velocidades"
        ));
       

        // --- TOYOTA 2016 ---
        lista.add(new Vehiculo(
            "TOYOTA", "Corolla", 2016,
            "Sedan", "1.8L L4", "Automática CVT"
        ));
        lista.add(new Vehiculo(
            "TOYOTA", "Hilux", 2016,
            "Pickup", "2.8L Diesel", "Manual 6 velocidades"
        ));

        // --- HONDA 2016 ---
        lista.add(new Vehiculo(
            "HONDA", "CR-V", 2016,
            "SUV", "2.4L L4", "Automática CVT"
        ));

        // --- BMW 2016 ---
        lista.add(new Vehiculo(
            "BMW", "X5 xDrive40e", 2016,
            "SUV", "2.0L L4 Turbo Híbrido", "Automática 8 velocidades"
        ));
        lista.add(new Vehiculo(
            "BMW", "Serie 3 320i", 2016,
            "Sedan", "2.0L Turbo", "Manual 6 velocidades"
        ));

        // --- TOYOTA 2016 ---
        lista.add(new Vehiculo(
            "TOYOTA", "Corolla", 2016,
            "Sedan", "1.8L L4", "Automática CVT"
        ));
        lista.add(new Vehiculo(
            "TOYOTA", "Hilux", 2016,
            "Pickup", "2.8L Diesel", "Manual 6 velocidades"
        ));

        // --- HONDA 2016 ---
        lista.add(new Vehiculo(
            "HONDA", "CR-V", 2016,
            "SUV", "2.4L L4", "Automática CVT"
        ));

        return lista;
    }
}
