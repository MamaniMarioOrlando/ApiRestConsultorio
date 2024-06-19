package med.voll.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
