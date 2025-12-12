import java.util.*;
/**
 * Clase principal que contiene el punto de entrada (main) del Sistema de Diagnóstico Automotriz.
 * Esta clase gestiona el flujo de interacción con el usuario, la selección de vehículos
 * y la carga polimórfica de los códigos de falla.
 * Incluye un bucle principal de reinicio y validación robusta de entrada (try-catch).
 * @author Cortes Miranda Rodrigo Antonio
 * @since 23-11-2025
 * @version 1.0
 */
public class App {
    private static Scanner sc = new Scanner(System.in);
/**
     * Método principal que inicializa y ejecuta el ciclo del Sistema de Diagnóstico Automotriz.
     * Implementa la lógica de selección de Marca, Año y Modelo, la carga de códigos
     * basada en el año, y el menú de reinicio/salida.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Inicialización de datos
        List<Vehiculo> vehiculos = VehiculoData.obtenerVehiculos();
        System.out.println("--- Sistema de Diagnóstico Automotriz ---");

        boolean continuarDiagnostico = true;

        // -------------------------------------------------------------------
        // INICIO DEL BUCLE PRINCIPAL (DO-WHILE) - Controla la repetición de todo el diagnóstico.
        // -------------------------------------------------------------------
        do {
            // Marca
            Set<String> marcas = new TreeSet<>(); // implementa la interfaz Set y almacena elementos únicos en un orden natura lo busque y use de google :)
            
            // iteramos para obtener todas las marcas disponibles
            for (Vehiculo v : vehiculos) marcas.add(v.getMarca());
            
            // Convertimos el Set a una List para poder acceder por índice
            List<String> listaMarcas = new ArrayList<>(marcas);

            String marcaSeleccionada = null;
            int opcMarca = -1;

            // Bucle para selección de Marca con validación
            do {
                try {
                    System.out.println("\n--- Seleccionar Marca ---");
                    // Iteramos la lista de marcas para mostrarlas al usuario con un número de opción (i + 1) pq sino sale 0 y no se ve bien :)
                    for (int i = 0; i < listaMarcas.size(); i++)
                        System.out.printf("%d) %s%n", (i + 1), listaMarcas.get(i));
                    System.out.print("Selecciona una marca: ");

                    opcMarca = sc.nextInt(); //se guuarda
                    
                    // Verificamos 
                    if (opcMarca < 1 || opcMarca > listaMarcas.size()) {
                        // Si está fuera de rango
                        throw new IndexOutOfBoundsException("Opción fuera de rango.");
                    }
                    
                    //si esta bn
                    marcaSeleccionada = listaMarcas.get(opcMarca - 1);
                    
                } catch (InputMismatchException e) {
                    //por si ingresan texto
                    System.out.println("ERROR: Ingresa un número válido para la opción.");
                    sc.next(); // si no limpiaba el buffer se hacia un bucle
                    opcMarca = -1; // Forzar la repetición del bucle 
                } catch (IndexOutOfBoundsException e) {
                    // si no esta disponible el numero como decimales
                    System.out.println("ERROR: La opción seleccionada no existe en el menú.");
                    opcMarca = -1; // se fuerza a repetir 
                }
            } while (opcMarca < 1 || opcMarca > listaMarcas.size());

            // 2. Seleccionar Año
            Set<Integer> anios = new TreeSet<>();
            // Filtramos y agregamos solo los años que corresponden a la marca seleccionada
            for (Vehiculo v : vehiculos)
                if (v.getMarca().equalsIgnoreCase(marcaSeleccionada))
                    anios.add(v.getAnio());
                    
            List<Integer> listaAnios = new ArrayList<>(anios); //integer vuelve el primitivo int en objeto

            int anioSeleccionado = -1;
            int opcAnio = -1;

            // lo mismo q con marca
            do {
                try {
                    System.out.println("\n--- Seleccionar Año para " + marcaSeleccionada + " ---");
                    // Iteramos la lista de años para mostrarlos
                    for (int i = 0; i < listaAnios.size(); i++)
                        System.out.printf("%d) %d%n", (i + 1), listaAnios.get(i));
                    System.out.print("Selecciona el año: ");

                    opcAnio = sc.nextInt();
                    if (opcAnio < 1 || opcAnio > listaAnios.size()) {
                        throw new IndexOutOfBoundsException("Opción fuera de rango.");
                    }
                    anioSeleccionado = listaAnios.get(opcAnio - 1);
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Ingresa un número válido para la opción.");
                    sc.next();
                    opcAnio = -1;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR: La opción seleccionada no existe en el menú.");
                    opcAnio = -1;
                }
            } while (opcAnio < 1 || opcAnio > listaAnios.size());

            // 3. Seleccionar Modelo
            List<Vehiculo> modelosDisponibles = new ArrayList<>();
            // Filtramos los vehículos que coincidan con la Marca y el Año seleccionados
            for (Vehiculo v : vehiculos)
                if (v.getMarca().equalsIgnoreCase(marcaSeleccionada) && v.getAnio() == anioSeleccionado)
                    modelosDisponibles.add(v);

            Vehiculo vehiculoSeleccionado = null;
            int opcModelo = -1;

            // Bucle para selección de Modelo con validación (Misma lógica)
            do {
                try {
                    System.out.println("\n--- Seleccionar Modelo ---");
                    // Iteramos los modelos disponibles y usamos el método 'mostrarDatos()'
                    for (int i = 0; i < modelosDisponibles.size(); i++) {
                        System.out.print((i + 1) + ") ");
                        modelosDisponibles.get(i).mostrarDatos();
                    }
                    System.out.print("Selecciona el modelo: ");

                    opcModelo = sc.nextInt();
                    if (opcModelo < 1 || opcModelo > modelosDisponibles.size()) {
                        throw new IndexOutOfBoundsException("Opción fuera de rango.");
                    }
                    vehiculoSeleccionado = modelosDisponibles.get(opcModelo - 1);
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Ingresa un número válido para la opción.");
                    sc.next();
                    opcModelo = -1;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR: La opción seleccionada no existe en el menú.");
                    opcModelo = -1;
                }
            } while (opcModelo < 1 || opcModelo > modelosDisponibles.size());


            // 4. Cargar Códigos de Falla por año
            List<CodigoFalla> codigos = new ArrayList<>(); // Lista donde se almacenarán los códigos.
            ProveedorCDF proveedor = null; // Variable 

            //codigo por año
            if (anioSeleccionado == 2016) {
                proveedor = new CDF16(); 
            } else if (anioSeleccionado == 2020) {
                proveedor = new CDF20();
            } else if (anioSeleccionado == 2025) {
                proveedor = new CDF25();
            } 
            
            // Ejecutamos el Polimorfismo
            if (proveedor != null) {
                codigos = proveedor.obtenerCodigos();
            } else {
                System.out.println("\nADVERTENCIA: No se encontraron códigos de falla disponibles para el año " + anioSeleccionado + ".");
            }

            vehiculoSeleccionado.setCodigos(codigos);

            
            System.out.println("\n--- Códigos de Falla para " + vehiculoSeleccionado.getModelo() + " (Año " + vehiculoSeleccionado.getAnio() + ") ---");
            
            // Verificamos si la lista de códigos está vacía antes de intentar imprimirla
            if (codigos.isEmpty()) {
                System.out.println("No hay códigos de falla cargados para este vehículo/año.");
            } else {
                // Iteramos sobre la lista de códigos de falla y mostramos los detalles
                for (CodigoFalla c : codigos) {
                    System.out.println(c.getCodigo() + " - " + c.getDescripcion() + " - " + c.getSolucion());
                }
            }

            int opcSalida = -1;

            do {
                try {
                    System.out.println("\n----------------------------------------------------");
                    System.out.println("1) Volver a la selección de marca");
                    System.out.println("2) Salir del programa");
                    System.out.print("Selecciona una opción: ");
                    
                    opcSalida = sc.nextInt();
                    
                    if (opcSalida < 1 || opcSalida > 2) {
                        throw new IndexOutOfBoundsException("Opción fuera de rango.");
                    }
                    
                    if (opcSalida == 2) {
                        continuarDiagnostico = false; // Detiene el bucle principal
                    } 
                    // Si opcSalida es 1, continuarDiagnostico se mantiene true (reinicia el diagnóstico)

                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Ingresa un número válido para la opción.");
                    sc.next(); // Limpiar el buffer
                    opcSalida = -1;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR: La opción seleccionada no existe en el menú.");
                    opcSalida = -1;
                }
            } while (opcSalida < 1 || opcSalida > 2);
            // FIN DEL MENÚ DE SALIDA
            
        } while (continuarDiagnostico); // FIN DEL BUCLE PRINCIPAL
        sc.close();
        System.out.println("\n--- Fin del programa ---");
    }
}