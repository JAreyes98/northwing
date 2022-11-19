package com.jdreyes.northwindjsf.service;

import com.jdreyes.northwindjsf.model.entity.Region;
import com.jdreyes.northwindjsf.repo.RegionCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionCRUD crud;

    @Autowired
    public RegionService(RegionCRUD regionDAO) {
        this.crud = regionDAO;
    }

    public List<Region> obtenerRegiones() {
        return (List<Region>) crud.findAll();
    }


    public Region nuevaRegion(Region r) {
        return crud.save(r);
    }
}
