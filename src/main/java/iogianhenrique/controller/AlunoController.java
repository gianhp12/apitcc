package iogianhenrique.controller;

import iogianhenrique.entity.Aluno;
import iogianhenrique.repository.Alunos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigInteger;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private Alunos alunos;

    public AlunoController(Alunos alunos) {
        this.alunos = alunos;
    }


    @GetMapping("{cpf}")
    public Aluno getAlunoById(@PathVariable BigInteger cpf) {
        return alunos
                .findById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno save(@RequestBody Aluno aluno){
        return alunos.save(aluno);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable BigInteger cpf){
        alunos.findById(cpf)
                .map(aluno -> {
                    alunos.delete(aluno);
                    return aluno;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));

    }

}



