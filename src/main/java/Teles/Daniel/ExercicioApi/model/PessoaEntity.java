package Teles.Daniel.ExercicioApi.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ since 16/06/2020 - 19:15
 */

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor

@Component

@Entity
@Table(name = "pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private long id;

    @Column(name = "nome")
    @NotBlank(message = "Nome inválido")
    private String nome;

    @Column(name = "renda")
    @NotNull(message = "Renda inválida")
    private double renda;
}
