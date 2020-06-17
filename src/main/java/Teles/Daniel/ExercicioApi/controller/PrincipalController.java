package Teles.Daniel.ExercicioApi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ since 16/06/2020 - 18:58
 */

@RestController
@CrossOrigin (origins = "*" , allowedHeaders = "*")

public class PrincipalController {

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Bem vindo!", new HttpHeaders(), HttpStatus.OK);
    }
}
