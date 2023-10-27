package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.StateModel;

public interface IStateRepo extends JpaRepository<StateModel, Integer>{
    StateModel findByName(String name);
}
