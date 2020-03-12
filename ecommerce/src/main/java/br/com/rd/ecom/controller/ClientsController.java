package br.com.rd.ecom.controller;

import br.com.rd.ecom.model.Clients;

import br.com.rd.ecom.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientsController {

    @Autowired
    private ClientsRepository clientsRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-user")
    public Clients save (@RequestBody Clients clients) {
        return clientsRepository.save(clients);
    }

    @GetMapping("/find-user/list")
    public List<Clients> find() {return clientsRepository.findAll(); }

}