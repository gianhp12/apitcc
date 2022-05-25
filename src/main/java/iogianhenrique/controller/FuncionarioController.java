package iogianhenrique.controller;

import iogianhenrique.entity.Funcionario;
import iogianhenrique.repository.Funcionarios;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    private Funcionarios funcionarios;

    public FuncionarioController(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    @GetMapping("{cpf}")
    public Funcionario getFuncionarioById(@PathVariable Integer cpf ){
        return funcionarios
                .findById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Funcionario não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody @Valid Funcionario funcionario){
        return funcionarios.save(funcionario);
    }
}