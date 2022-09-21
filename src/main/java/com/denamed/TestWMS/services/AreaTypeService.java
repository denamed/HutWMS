package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.AreaType;
import com.denamed.TestWMS.repositories.AreaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaTypeService {
    private final AreaTypeRepository areaTypeRepository;

    @Autowired
    public AreaTypeService(AreaTypeRepository areaTypeRepository) {this.areaTypeRepository = areaTypeRepository;
    }

    public List<AreaType> findAll(){ return areaTypeRepository.findAll();}
    


    public AreaType saveAreaType(AreaType areaType) {

        return areaTypeRepository.save(areaType);
    }

    public void deleteAreaType (int areaTypeId){ areaTypeRepository.deleteById(areaTypeId);}
}
