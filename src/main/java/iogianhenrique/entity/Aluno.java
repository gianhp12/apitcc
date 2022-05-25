package iogianhenrique.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "cpf")
    BigInteger cpf;

    @Column(name = "nome")
    String nome;

    @Column(name = "email")
    @Email
    String email;

    @Column(name = "telefone")
    String telefone;

}
