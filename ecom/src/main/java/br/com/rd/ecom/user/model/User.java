package br.com.rd.ecom.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "ds_name")
    private String Name;

    @Column(nullable = false, name = "num_cpf")
    private String cpf;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "phoneNumber")
    private Integer phoneNumber;

    @Column(nullable = false, name = "password")
    private  String password;
}
