package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItensVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private Double valorUnitario;

    @Column(length = 20)
    private Double valorTotal;

    @Column(length = 20)
    private Double quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;
}
