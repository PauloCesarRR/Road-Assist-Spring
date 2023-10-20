package br.com.fiap.roadassist.service.typeWinch;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ITypeWinchService {
    public TypeWinchModel create(TypeWinchModel typeWinchModel) throws Exception;
    public TypeWinchModel update(TypeWinchModel typeWinchModel, UUID id) throws Exception;
    public List<TypeWinchModel> getAll() throws Exception;
    public TypeWinchModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
