package br.edu.ifsul.cstsi.objetivo5_springdata_maven.carros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query(value = "SELECT c FROM Carro c where c.placa like ?1")
    List<Carro> findByPlaca(String placa);

    List<Carro> findBySituacao(Boolean situacao);

    @Query(value = "SELECT c FROM Carro c where c.id = ?1 and c.situacao=true")
    Optional<Carro> finByIdSituacaoTrue(Long id);
}
