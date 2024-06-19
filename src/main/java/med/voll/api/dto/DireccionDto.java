package med.voll.api.dto;

public record DireccionDto(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
) {
}
