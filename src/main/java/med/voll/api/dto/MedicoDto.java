package med.voll.api.dto;

public record MedicoDto(
        String nombre,
        String email,
        String documento,
        Especialidad especialidades,
        DireccionDto direccion
) {
}
