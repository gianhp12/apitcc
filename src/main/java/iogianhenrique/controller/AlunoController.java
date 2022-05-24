package iogianhenrique.controller;

import iogianhenrique.entity.Aluno;
import iogianhenrique.repository.Alunos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private Alunos alunos;

    public AlunoController(Alunos alunos) {
        this.alunos = alunos;
    }

    @GetMapping("{cpf}")
    public Aluno getAlunoById(@PathVariable Integer cpf) {
        return alunos
                .findById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno save(@RequestBody @Valid Aluno aluno){
        return alunos.save(aluno);
    }
}



