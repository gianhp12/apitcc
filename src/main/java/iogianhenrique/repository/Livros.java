package iogianhenrique.repository;

import iogianhenrique.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Livros extends JpaRepository<Livro,Integer> {
}
