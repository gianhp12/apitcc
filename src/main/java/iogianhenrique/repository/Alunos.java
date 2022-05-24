package iogianhenrique.repository;

import iogianhenrique.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Alunos extends JpaRepository<Aluno,Integer> {
}
