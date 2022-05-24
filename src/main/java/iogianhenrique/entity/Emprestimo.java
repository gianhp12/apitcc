package iogianhenrique.entity;


import iogianhenrique.enums.StatusEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_cpf")
    private Aluno aluno;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Enumerated
    @Column(name = "status")
    private StatusEmprestimo status;

}
