package com.myspring.lmm.mileage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MileageService {
//	 public List listMileages() throws DataAccessException;

    public List useMileages(String cusId) throws DataAccessException;
    public List stackMileages(String cusId) throws DataAccessException;


}
