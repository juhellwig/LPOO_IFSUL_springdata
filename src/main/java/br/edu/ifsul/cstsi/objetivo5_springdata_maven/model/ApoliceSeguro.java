package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ApoliceSeguro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;
}
