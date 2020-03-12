package br.com.rd.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido_item")
public class ItemPedido {

    @Id
    @Column(name = "cd_pedido_item")
    private Integer codPed;

    @Column(name = "vl_produto")
    private BigDecimal vlProduto;

    @Column(name = "vl_frete")
    private  BigDecimal vlFrete;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "cd_produto")
    private Integer codProduto;

    @ManyToOne
    @JoinColumn(name = "cod_pedido")
    private Pedido pedido;
}
