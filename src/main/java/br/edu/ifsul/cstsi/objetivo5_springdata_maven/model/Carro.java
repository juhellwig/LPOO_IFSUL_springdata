package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @OneToMany
    List<Aluguel> alugueis = new ArrayList<>();
    @ManyToOne
    private ModeloCarro modeloCarro;
    @ManyToMany
    List<Acessorio> acessorios = new ArrayList<>();
}
