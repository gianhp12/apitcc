package iogianhenrique.repository;


import iogianhenrique.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Funcionarios extends JpaRepository<Funcionario,Integer> {
}
