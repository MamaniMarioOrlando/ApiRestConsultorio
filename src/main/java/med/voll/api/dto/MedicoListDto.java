package med.voll.api.dto;

import med.voll.api.Entity.MedicoEntity;

public record MedicoListDto(
        Integer id,
        String nombre,
        Especialidad especialidad,
        String documento,
        String email
) {
    public MedicoListDto(MedicoEntity entityMedico){
        this(entityMedico.getId(),entityMedico.getNombre(),entityMedico.getEspecialidad(), entityMedico.getDocumento(), entityMedico.getEmail());
    }
}
