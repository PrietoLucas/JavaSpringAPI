package br.com.rd.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer codPedido;

    @Column(name = "dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @ManyToOne
    @JoinColumn(name = "id_clients")
    private Clients clients;

    @Column(name = "vl_pedido")
    private BigDecimal vlPedido;

    @Column(name = "vl_frete")
    private BigDecimal vlFrete;

    @Column(name = "ds_forma_pagamento")
    private String dsFormaPagto;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;
}
