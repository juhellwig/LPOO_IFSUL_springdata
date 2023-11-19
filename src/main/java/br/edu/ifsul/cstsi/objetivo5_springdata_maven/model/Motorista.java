package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

@Entity
public class Motorista extends Pessoa {
    private String numeroCNH;
}
