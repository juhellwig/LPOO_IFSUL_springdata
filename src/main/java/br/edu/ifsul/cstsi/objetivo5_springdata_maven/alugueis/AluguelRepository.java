package br.edu.ifsul.cstsi.objetivo5_springdata_maven.alugueis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> { //classedeModelo, tipo do identificador
}
