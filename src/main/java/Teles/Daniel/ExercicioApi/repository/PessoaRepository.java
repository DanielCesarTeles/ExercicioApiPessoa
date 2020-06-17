package Teles.Daniel.ExercicioApi.repository;

import Teles.Daniel.ExercicioApi.model.PessoaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @ since 16/06/2020 - 19:15
 */
@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {
}
