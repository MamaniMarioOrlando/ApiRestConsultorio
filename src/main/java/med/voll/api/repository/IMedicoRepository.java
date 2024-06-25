package med.voll.api.repository;

import med.voll.api.Entity.MedicoEntity;
import med.voll.api.dto.MedicoListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<MedicoEntity, Long> {

    Page<MedicoEntity> findAllByEstadoTrue(Pageable paginacion);
}
