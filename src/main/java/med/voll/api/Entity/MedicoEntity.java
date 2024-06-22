package med.voll.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DireccionDto;
import med.voll.api.dto.Especialidad;
import med.voll.api.dto.MedicoDto;

@Entity(name= "Medico")
@Table(name= "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private DireccionEntity direccion;

    public MedicoEntity(MedicoDto medicoDto) {
        this.nombre = medicoDto.nombre();
        this.email = medicoDto.email();
        this.telefono = medicoDto.telefono();
        this.documento = medicoDto.documento();
        this.especialidad = medicoDto.especialidad();
        this.direccion = new DireccionEntity(medicoDto.direccion());
    }
}
