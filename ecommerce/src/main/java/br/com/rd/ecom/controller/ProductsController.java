package br.com.rd.ecom.controller;

import br.com.rd.ecom.model.Products;
import br.com.rd.ecom.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @PostMapping("/product")
    public Products save (@RequestBody Products products){return productsRepository.save(products);}
    @PutMapping("/product")
    public Products alterar(@RequestBody Products products){
        Products productsEntity = productsRepository.getOne(products.getCodProduto());
        productsEntity.setDescProduto(products.getDescProduto());
        productsEntity.setCodCategoria(products.getCodCategoria());
        productsEntity.setVlProduto(products.getVlProduto());

        return productsRepository.save(productsEntity);
    }
    @GetMapping("/product/idSearch/{id}")
    public Products findProductById(@PathVariable("id") Long id){
        return productsRepository.findById(id).get();
    }
    @GetMapping("/product/descSearch/{descricao}")
    public List<Products> SearchProducDesc(@PathVariable("descricao") String descricao){
        return productsRepository.findByDescProduto(descricao);
    }

    @GetMapping("/product/list")
    public List<Products> find() {
        return productsRepository.findAll();
    }

    @GetMapping("/product")
    public ResponseEntity<List<Products>> findById(@PathParam("id") Long id,
                                                                   @PathParam("descricao")String descricao){
        List<Products> products = new ArrayList<>();

        if (id != null && descricao != null)
            products = productsRepository.findByCodProdutoAndDescProduto(id, descricao);
        else if(id !=null)
            products.add(productsRepository.findById(id).get());
        else if(descricao != null)
            products = productsRepository.findByDescProduto(descricao);

        if(products != null && products.size()>0)
            return ResponseEntity.ok().body(products);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable("id")Long id) {
        productsRepository.deleteById(id);
    }
}
