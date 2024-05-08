package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer integer;

    @Column(length = 60)
    private String titulo;


    @Column(length = 120)
    private Double total;

    @Column(length = 20)
    private String observacoes;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItensVenda> listaItens;

}
