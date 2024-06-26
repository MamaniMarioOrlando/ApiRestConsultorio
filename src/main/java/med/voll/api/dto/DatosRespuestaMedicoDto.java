package med.voll.api.dto;

import med.voll.api.Entity.DireccionEntity;
import med.voll.api.Entity.MedicoEntity;

public record DatosRespuestaMedicoDto(
        Integer id,
        String nombre,
        String email,
        String documento,
        String telefono,
        Boolean estado,
        DireccionEntity direccionEntity
) {
}
