package br.com.rd.ecom.repository;

import br.com.rd.ecom.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    public List<Products> findByDescProduto(String descProduto);
    public List<Products> findByCodProdutoAndDescProduto(Long codProduto, String descProduto);
}
