package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Pessoa{
    private String matricula;
}
