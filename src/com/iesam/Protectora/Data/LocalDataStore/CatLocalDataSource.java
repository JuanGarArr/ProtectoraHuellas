package com.iesam.Protectora.Data.LocalDataStore;

import com.iesam.Protectora.Domain.Models.Cat;

import java.util.List;
public interface CatLocalDataSource {
    public void save(Cat cat);
    public Cat findById(Integer idCat);
    public List<Cat> findAll();

    public void delete(Integer idCat);
}
