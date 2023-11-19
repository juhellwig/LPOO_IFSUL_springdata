package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Fabricante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany
    List<ModeloCarro> modelosCarros = new ArrayList<>();
}
