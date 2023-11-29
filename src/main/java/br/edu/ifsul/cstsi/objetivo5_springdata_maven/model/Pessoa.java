package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    @Id
    private String cpf;
    @Enumerated
    private Sexo sexo;
}
