package med.voll.api.repository;

import med.voll.api.Entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
