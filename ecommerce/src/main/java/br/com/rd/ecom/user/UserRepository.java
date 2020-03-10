package br.com.rd.ecom.user;

import br.com.rd.ecom.user.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Clients, Long> {

    List<Clients> findByName(String name);
    List<Clients> findByCpf(String cpf);
    List<Clients> findByEmail(String email);
    List<Clients> findByContact(Integer contact);
}