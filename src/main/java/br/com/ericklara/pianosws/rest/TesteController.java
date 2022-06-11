package br.com.ericklara.pianosws.rest;

import br.com.ericklara.pianosws.domain.Users;
import br.com.ericklara.pianosws.infra.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class TesteController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public String helloWorld(){
        return "Hello Docker :D";
    }

    @PostMapping("/{nome}/{cpf}")
    public String saveUser(
            @PathVariable String nome,
            @PathVariable String cpf
    ){
        usersRepository.save(new Users(nome, cpf));
        return "Usuário criado :D";
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

}
