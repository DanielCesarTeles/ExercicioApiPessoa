package Teles.Daniel.ExercicioApi.service;

import Teles.Daniel.ExercicioApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaDeleteService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void delete(long id) {
        pessoaRepository.deleteById(id);
    }
}
