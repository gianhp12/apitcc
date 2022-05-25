package iogianhenrique.controller;

import iogianhenrique.entity.Livro;
import iogianhenrique.repository.Livros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    private Livros livros;

    public LivroController(Livros livros) {
        this.livros = livros;
    }

    @GetMapping("{codigo}")
    public Livro getLivroById(@PathVariable Integer codigo){
        return livros
                .findById(codigo)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro save(@RequestBody Livro livro){
        return livros.save(livro);
    }


    @DeleteMapping("{codigo}")
    public void delete(@PathVariable Integer codigo){
        livros.findById(codigo)
                .map(livro -> {
                    livros.delete(livro);
                    return livro;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Livro não encontrado"));
    }
}