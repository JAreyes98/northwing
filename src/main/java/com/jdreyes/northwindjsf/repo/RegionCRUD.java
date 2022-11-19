package com.jdreyes.northwindjsf.repo;

import com.jdreyes.northwindjsf.model.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionCRUD extends CrudRepository<Region, Integer> {
}
