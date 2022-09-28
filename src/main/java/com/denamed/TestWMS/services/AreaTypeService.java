package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.AreaType;
import com.denamed.TestWMS.repositories.AreaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AreaTypeService {
    private final AreaTypeRepository areaTypeRepository;

    @Autowired
    public AreaTypeService(AreaTypeRepository areaTypeRepository) { this.areaTypeRepository = areaTypeRepository; }

    public List<AreaType> findAll(){ return areaTypeRepository.findAll(); }

    public Optional<AreaType> findById(int areaTypeID) throws Exception
    {
        Optional<AreaType> areaType = areaTypeRepository.findById(areaTypeID);
        if(areaType.isEmpty()){
            throw new Exception("<div class=\"alert\">Required area type not exists!</div>");
        }
        else{
            return areaType;
        }
    }

    public void create(AreaType areaType) throws Exception
    {
        if(areaTypeRepository.existsById(areaType.getAreaTypeId())){
            throw new Exception("<div class=\"alert\">Required area type not exists!</div>");
        }
        else{
            areaTypeRepository.save(areaType);
        }
    }

    public void edit(AreaType areaType) { areaTypeRepository.save(areaType); }

    public void delete(int areaTypeId){ areaTypeRepository.deleteById(areaTypeId); }
}