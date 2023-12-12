package com.team8.petadoptionserver.dao;

import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Log;

import java.util.List;
import java.util.Map;

@Repository
public interface AdoptsDAOInt {

    List<Map<String, Object>> findAll();

    public int addAdoption(Log log);

    List<Map<String, Object>> getAvailablePets();
    

}
