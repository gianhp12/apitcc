package iogianhenrique.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @CPF
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
