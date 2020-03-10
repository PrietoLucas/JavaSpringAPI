package br.com.rd.ecom.user;

import br.com.rd.ecom.user.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-user")
    public Clients save (@RequestBody Clients clients) {
        return userRepository.save(clients);
    }

    @GetMapping("/find-user/list")
    public List<Clients> find() {return userRepository.findAll(); }

}