package br.edu.ifsul.cstsi.objetivo5_springdata_maven.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ModeloCarro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    @OneToMany
    List<Carro> carros = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="modelocarro_fabricante", referencedColumnName = "id")
    private Fabricante fabricante;
    @Enumerated
    private Categoria categoria;

}
