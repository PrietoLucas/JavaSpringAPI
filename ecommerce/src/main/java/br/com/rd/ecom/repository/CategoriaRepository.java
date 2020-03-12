package br.com.rd.ecom.repository;

import br.com.rd.ecom.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByCodCategoria(String ds_categoria);
}
