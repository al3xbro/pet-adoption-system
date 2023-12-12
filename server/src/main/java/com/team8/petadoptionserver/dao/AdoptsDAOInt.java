package com.team8.petadoptionserver.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Log;

@Repository
public interface AdoptsDAOInt {

    List<Log> findAll();

    public int addAdoption(Log log);

}
