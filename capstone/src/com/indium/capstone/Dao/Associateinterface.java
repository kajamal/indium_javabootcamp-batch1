package com.indium.capstone.Dao;

import com.indium.capstone.Model.Associate;

import java.util.List;

public interface Associateinterface {

    public Boolean create(Associate associate);
    public Boolean update(Associate associate);
    public boolean delete(int id);
    public List<Associate> getall();
}
