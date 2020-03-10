package br.com.rd.ecom.user;

import br.com.rd.ecom.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String Name);
    List<User> findByCpf(String cpf);
    List<User> findByEmail(String email);
    List<User> findByPhoneNumber(Integer phoneNumber);
}
