package Teles.Daniel.ExercicioApi.service;

import Teles.Daniel.ExercicioApi.model.PessoaEntity;
import Teles.Daniel.ExercicioApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaUpdtadeService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity update(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }
}
