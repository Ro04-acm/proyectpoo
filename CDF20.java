import java.util.*;

public class CDF20 extends ProveedorCDF {
    @Override
    public List<CodigoFalla> obtenerCodigos() {
        List<CodigoFalla> codigos = new ArrayList<>();

        codigos.add(new CodigoFalla("1002", "Fuel Pump Driver Control Module System Voltage Performance", "Diagnosticar el circuito de suministro de voltaje al módulo de control de la bomba de combustible. Reparar cableado, fusibles o reemplazar el módulo si es necesario."));
        codigos.add(new CodigoFalla("DTC C10C3", "Driveline Mount Actuator 1 Control (Engine Mechanical - 2.0L)", "Inspeccionar el soporte de motor/transmisión activo y su conector. Verificar el circuito de control del actuador y reemplazar el actuador o el soporte completo si está defectuoso."));
        codigos.add(new CodigoFalla("B0001", "Steering Wheel Module Stage 1 High Control (Supplemental Restraints)", "Diagnosticar el circuito del detonador de la bolsa de aire (Squib) del conductor en la Etapa 1. Medir resistencia, verificar cortocircuitos a voltaje y reemplazar el módulo de bolsa de aire del volante si las pruebas del circuito son normales."));
        codigos.add(new CodigoFalla("P0441", "Evaporative Emission Control System Incorrect Purge Flow", "Reemplazar la válvula de purga (Canister Purge Solenoid). Inspeccionar todas las mangueras del sistema EVAP en busca de fugas u obstrucciones."));
        codigos.add(new CodigoFalla("P0300", "Random/Multiple Cylinder Misfire Detected", "Reemplazar las bujías y las bobinas de encendido si son las originales o están desgastadas. Verificar la presión de combustible, inyectores y compresión del motor."));
        codigos.add(new CodigoFalla("B0001-12", "DRIVER FRONTAL SQUIB 1 CONTROL-CIRCUIT SHORT TO BATTERY", "Desconectar la batería. Revisar el arnés de cableado y los conectores del módulo de la bolsa de aire del conductor en busca de un cortocircuito al voltaje (cable pelado tocando positivo). Reparar el cableado o reemplazar la bolsa de aire."));

        return codigos;
    }
}
