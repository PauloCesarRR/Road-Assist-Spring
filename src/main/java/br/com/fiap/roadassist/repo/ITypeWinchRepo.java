package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ITypeWinchRepo extends CrudRepository<TypeWinchModel, Integer>{
    TypeWinchModel findByName(String name);
}
