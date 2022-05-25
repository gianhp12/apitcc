package iogianhenrique.repository;

import iogianhenrique.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface Alunos extends JpaRepository<Aluno, BigInteger> {
}
