package Teles.Daniel.ExercicioApi.controller;

import Teles.Daniel.ExercicioApi.model.PessoaEntity;
import Teles.Daniel.ExercicioApi.service.*;
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
    public PessoaFindAllService pessoaFindAllService;

    @Autowired
    public PessoaFindByIdService pessoaFindByIdService;

    @Autowired
    public PessoaSaveService pessoaSaveService;

    @Autowired
    public PessoaUpdtadeService pessoaUpdtadeService;

    @Autowired
    public PessoaDeleteService pessoaDeleteService;


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PessoaEntity>> findAll() {
        return new ResponseEntity<List<PessoaEntity>>( (List<PessoaEntity> )this.pessoaFindAllService.findAll(),
                                                      new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<PessoaEntity> findById(@PathVariable("id") long id) {
        PessoaEntity pessoaEntity = this.pessoaFindByIdService.findById(id);
        if(pessoaEntity != null ){
            return new ResponseEntity<PessoaEntity>( pessoaEntity, new HttpHeaders(), HttpStatus.OK);
        }
            return new ResponseEntity<PessoaEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> save(@Valid  @RequestBody PessoaEntity pessoaEntity) {
        return new ResponseEntity<PessoaEntity>(this.pessoaSaveService.save(pessoaEntity),
                                                       new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaEntity> update(@RequestBody PessoaEntity pessoaEntity) {
        return new ResponseEntity<PessoaEntity>(this.pessoaUpdtadeService.update(pessoaEntity),
                new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping (path = "{id}")
    public ResponseEntity<PessoaEntity> delete (@PathVariable("id") long id) {
        this.pessoaDeleteService.delete(id);
        return new ResponseEntity<PessoaEntity>  (new HttpHeaders() , HttpStatus.OK);
    }
}
