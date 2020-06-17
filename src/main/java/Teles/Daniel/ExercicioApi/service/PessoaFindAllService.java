package Teles.Daniel.ExercicioApi.service;

import Teles.Daniel.ExercicioApi.model.PessoaEntity;
import Teles.Daniel.ExercicioApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFindAllService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaEntity> findAll() {
        return (List<PessoaEntity>) this.pessoaRepository.findAll();
    }
}
