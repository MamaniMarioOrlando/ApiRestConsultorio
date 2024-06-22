package med.voll.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DireccionDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DireccionEntity {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public DireccionEntity(DireccionDto direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }
}
