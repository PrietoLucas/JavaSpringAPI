package br.com.rd.ecom.repository;

import br.com.rd.ecom.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findByName(String name);
    List<Clients> findByCpf(String cpf);
    List<Clients> findByEmail(String email);
    List<Clients> findByContact(Integer contact);
}