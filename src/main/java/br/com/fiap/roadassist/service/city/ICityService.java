package br.com.fiap.roadassist.service.city;


import java.util.List;

import br.com.fiap.roadassist.model.CityModel;

public interface ICityService {
    public CityModel create(CityModel cityModel) throws Exception;
    public CityModel update(CityModel cityModel, Integer id) throws Exception;
    public List<CityModel> getAll() throws Exception;
    public CityModel getById(Integer id) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
