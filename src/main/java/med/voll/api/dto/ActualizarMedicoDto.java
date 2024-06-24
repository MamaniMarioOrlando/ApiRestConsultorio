package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record ActualizarMedicoDto(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DireccionDto direccionDto
) {
}
