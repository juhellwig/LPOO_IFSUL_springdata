package br.edu.ifsul.cstsi.objetivo5_springdata_maven.alugueis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Aluguel")
@Table(name = "alugueis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;
    private BigDecimal valorTotal;


}
