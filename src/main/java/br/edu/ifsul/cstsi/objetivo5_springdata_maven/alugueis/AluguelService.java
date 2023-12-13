package br.edu.ifsul.cstsi.objetivo5_springdata_maven.alugueis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AluguelService {
    @Autowired //equivale a dar new (= new AluguelRepository();)
    private AluguelRepository rep;

    public Aluguel insert(Aluguel aluguel) {
        Assert.isNull(aluguel.getId(), "Nao foi possivel inserir o registro");
        return rep.save(aluguel);
    }
}
