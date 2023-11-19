package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Aluguel {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    @ManyToOne
    private Carro carro;
    @ManyToOne
    private Motorista motorista;
    @OneToOne
    private ApoliceSeguro apoliceSeguro;
}
