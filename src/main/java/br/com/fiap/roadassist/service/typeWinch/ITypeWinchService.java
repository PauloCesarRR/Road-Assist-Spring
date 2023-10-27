package br.com.fiap.roadassist.service.typeWinch;


import java.util.List;

import br.com.fiap.roadassist.model.TypeWinchModel;

public interface ITypeWinchService {
    public TypeWinchModel create(TypeWinchModel typeWinchModel) throws Exception;
    public TypeWinchModel update(TypeWinchModel typeWinchModel, Integer id) throws Exception;
    public List<TypeWinchModel> getAll() throws Exception;
    public TypeWinchModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
