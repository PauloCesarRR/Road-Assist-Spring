package br.com.fiap.roadassist.service.typeWinch;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.TypeWinchModel;
import br.com.fiap.roadassist.repo.ITypeWinchRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class TypeWinchServiceImpl implements ITypeWinchService {

    @Autowired
    private ITypeWinchRepo repo;

    @Override
    public TypeWinchModel create(TypeWinchModel typeWinchModel) throws Exception {
        TypeWinchModel typeWinch = repo.findByName(typeWinchModel.getName());

        if(typeWinch != null){
            return null;
        }

        return repo.save(typeWinchModel);
    }


    @Override
    public TypeWinchModel update(TypeWinchModel typeWinchModel, Integer id) throws Exception {
        TypeWinchModel typeWinch = repo.findById(id).orElse(null);
        if(typeWinch == null) {
            return null;
        }

        Utils.copyNonNullProperties(typeWinchModel, typeWinch);
        return repo.save(typeWinch);
    }


    @Override
    public List<TypeWinchModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public TypeWinchModel getById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(Integer id) throws Exception {
        TypeWinchModel typeWinch = repo.findById(id).orElse(null);
        if(typeWinch == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
