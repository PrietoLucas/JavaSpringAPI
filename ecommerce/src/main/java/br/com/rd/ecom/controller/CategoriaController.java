package br.com.rd.ecom.controller;

import br.com.rd.ecom.model.Categoria;
import br.com.rd.ecom.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/categoria")
    public Categoria findCategoriaById(@PathParam("id") Long id){
        return categoriaRepository.findById(id).get();
    }

    @GetMapping("/categoria/{idCategoria}")
    public Categoria findById(@PathVariable("idCategoria") Long idCategoria){
        return categoriaRepository.findById(idCategoria).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id){
        categoriaRepository.deleteById(id);
    }

    @PutMapping("/categoria")
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria){
        Categoria categoriaEntity = categoriaRepository.getOne(categoria.getCodCategoria());
        categoriaEntity.setDescricao(categoria.getDescricao());
        Categoria categoriaAtualiza = categoriaRepository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaAtualiza);
    }

}
