package iogianhenrique.controller;

import iogianhenrique.entity.Login;
import iogianhenrique.repository.Logins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private Logins logins;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }


    @PostMapping("/logar")
    public String logar(Model model, Login email, Login senha){
        Login acess = this.logins.acesso(email.getEmail(),senha.getSenha());
        if(acess != null ){
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }
}

