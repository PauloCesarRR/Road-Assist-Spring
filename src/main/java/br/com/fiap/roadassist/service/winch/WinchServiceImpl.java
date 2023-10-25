package br.com.fiap.roadassist.service.winch;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.roadassist.model.WinchModel;
import br.com.fiap.roadassist.repo.IWinchRepo;
import br.com.fiap.roadassist.utils.Utils;

@Component
public class WinchServiceImpl implements IWinchService {

    @Autowired
    private IWinchRepo repo;

    @Override
    public WinchModel create(WinchModel winchModel) throws Exception {
        WinchModel winch = repo.findByLicensePlateContaining(winchModel.getLicensePlate());

        if(winch != null){
            return null;
        }

        return repo.save(winchModel);
    }


    @Override
    public WinchModel update(WinchModel winchModel, UUID id) throws Exception {
        WinchModel winch = repo.findById(id).orElse(null);
        if(winch == null) {
            return null;
        }

        Utils.copyNonNullProperties(winchModel, winch);
        return repo.save(winch);
    }


    @Override
    public List<WinchModel> getAll() throws Exception {
        return repo.findAll();
    }


    @Override
    public WinchModel getById(UUID id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public boolean delete(UUID id) throws Exception {
        WinchModel winch = repo.findById(id).orElse(null);
        if(winch == null){
            return false;
        } else {
            repo.deleteById(id);
            return true;
        } 
    }    
}
