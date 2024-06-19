package med.voll.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DireccionDto;
import med.voll.api.dto.Especialidad;

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
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidades;
    @Embedded
    private DireccionDto direccion;
}
