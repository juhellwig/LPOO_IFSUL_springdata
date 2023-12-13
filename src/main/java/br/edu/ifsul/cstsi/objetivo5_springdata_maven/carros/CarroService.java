package br.edu.ifsul.cstsi.objetivo5_springdata_maven.carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository rep;
    public List<Carro> getCarros() {
        return rep.findAll();
    }

    public Carro getCarroById(Long id) {
        Optional<Carro> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Carro getCarroByIdSituacaoTrue(Long id){
        Optional<Carro> optional = rep.finByIdSituacaoTrue(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Carro> getCarroByPlaca(String placa) {
        return new ArrayList<>(rep.findByPlaca(placa + "%"));
    }

    public List<Carro> getCarroBySituacao(Boolean situacao){
        return new ArrayList<>(rep.findBySituacao(situacao));
    }

    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Nao foi possivel inserir o registro");
        return rep.save(carro);
    }
    public Carro atualizar(Carro carro) {
        Assert.notNull(carro.getId(),"Não foi possível atualizar o registro");

        Optional<Carro> optional = rep.findById(carro.getId());
        if(optional.isPresent()) {
            Carro db = optional.get();
            db.setPlaca(carro.getPlaca());
            db.setChassi(carro.getChassi());
            db.setCor(carro.getCor());
            db.setValorDiaria(carro.getValorDiaria());
            rep.save(db);

            return db;
        } else {
            return null;
        }
    }
    public void excluir(Long id) {
        rep.deleteById(id);
    }
}
