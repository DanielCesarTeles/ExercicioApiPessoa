package Teles.Daniel.ExercicioApi.controller;

import Teles.Daniel.ExercicioApi.model.PessoaEntity;
import Teles.Daniel.ExercicioApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ since 16/06/2020 - 19:15
 */

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PessoaEntity>> findAll() {
        return new ResponseEntity<List<PessoaEntity>>( (List<PessoaEntity> )this.pessoaRepository.findAll(),
                                                      new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<PessoaEntity> findById(@PathVariable("id") long id) {
        if(this.pessoaRepository.existsById(id)){
            return new ResponseEntity<PessoaEntity>( this.pessoaRepository.findById(id).get()
                                                    , new HttpHeaders() , HttpStatus.OK);
        }
            return new ResponseEntity<PessoaEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> save(@Valid  @RequestBody PessoaEntity pessoaEntity) {
        return new ResponseEntity<PessoaEntity>(this.pessoaRepository.save(pessoaEntity),
                                                       new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping (path = "{id}")
    public ResponseEntity<PessoaEntity> update(@PathVariable("id") long id ,
                                               @Valid @RequestBody PessoaEntity pessoaEntity) throws Exception {
        if(id == 0 || !this.pessoaRepository.existsById(id)) {
            throw new Exception("Código inválido");
        }
        return new ResponseEntity<PessoaEntity>(this.pessoaRepository.save(pessoaEntity),
                new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping (path = "{id}")
    public ResponseEntity<PessoaEntity> delete (@PathVariable("id") long id) {
        this.pessoaRepository.deleteById(id);
        return new ResponseEntity<PessoaEntity>  (new HttpHeaders() , HttpStatus.OK);
    }
}
