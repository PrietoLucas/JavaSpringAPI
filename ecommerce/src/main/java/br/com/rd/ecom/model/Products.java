package br.com.rd.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;

    @Column(name = "ds_produto",nullable = false)
    private String descProduto;

    @ManyToOne
    @JoinColumn(name = "cd_categoria")
    private Categoria codCategoria;

    @Column(name = "vl_produto")
    private BigDecimal vlProduto;

}
