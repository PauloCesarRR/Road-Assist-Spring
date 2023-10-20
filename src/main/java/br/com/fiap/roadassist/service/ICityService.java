package br.com.fiap.roadassist.service;

import java.util.UUID;
import java.util.List;

import br.com.fiap.roadassist.model.CityModel;

public interface ICityService {
    public CityModel create(CityModel cityModel) throws Exception;
    public CityModel update(CityModel cityModel, UUID id) throws Exception;
    public List<CityModel> getAll() throws Exception;
    public CityModel getById(UUID id) throws Exception;
    public boolean delete(UUID id) throws Exception;
}
