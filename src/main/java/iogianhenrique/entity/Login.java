package iogianhenrique.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name="email")
    String email;

    @Column(name="senha")
    String senha;
}
