package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.StateModel;

public interface IStateRepo extends CrudRepository<StateModel, Integer>{
    StateModel findByName(String name);
}
