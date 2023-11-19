package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
    private Sexo sexo;
}
