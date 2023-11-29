package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import ch.qos.logback.core.util.Loader;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Aluguel {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name="carro_id", referencedColumnName = "id")
    private Carro carro;
    @ManyToOne
    @JoinColumn(name="aluguel_id", referencedColumnName = "cpf")
    private Motorista motorista;
    @OneToOne
    private ApoliceSeguro apoliceSeguro;
}
