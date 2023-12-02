package com.team8.petadoptionserver.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdoptsDAOInt {

    List<Map<String, Object>> findAll();

}
