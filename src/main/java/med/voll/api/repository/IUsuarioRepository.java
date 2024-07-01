package med.voll.api.repository;

import med.voll.api.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UserDetails findByLogin(String username);
}
