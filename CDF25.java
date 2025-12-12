import java.util.*;

public class CDF25 extends ProveedorCDF {
    @Override
    public List<CodigoFalla> obtenerCodigos() {
        List<CodigoFalla> codigos = new ArrayList<>();

        codigos.add(new CodigoFalla("2000 87", "Ignition key position message $1F1 from BCM lost", "Inspeccionar el bus de comunicación (CAN/LIN) y los conectores entre el módulo de la carrocería (BCM) y el módulo de control del motor (ECM) o el interruptor de encendido. Reprogramar o reemplazar el BCM si el cableado es correcto."));
        codigos.add(new CodigoFalla("P0171", "System Too Lean (Bank 1)", "Revisar si hay fugas de vacío en el motor. Inspeccionar o reemplazar el sensor MAF/MAP y el sensor de oxígeno. Verificar la presión de combustible y los inyectores."));
        codigos.add(new CodigoFalla("B0001 11", "AB1FD Squib Driver Frontal Stage 1 Short to Ground (Supplemental Restraints)", "Desconectar la batería y esperar el tiempo de descarga. Inspeccionar el cableado del detonador de la bolsa de aire del conductor en busca de cortocircuito a tierra y reparar/reemplazar el arnés o la bolsa de aire."));

        return codigos;
    }
}
