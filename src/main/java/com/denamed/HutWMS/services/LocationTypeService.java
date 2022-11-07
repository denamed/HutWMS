package com.denamed.HutWMS.services;

import com.denamed.HutWMS.entities.LocationType;
import com.denamed.HutWMS.repositories.LocationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationTypeService {
    private final LocationTypeRepository locationTypeRepository;

    @Autowired
    public LocationTypeService(LocationTypeRepository locationTypeRepository) {
        this.locationTypeRepository = locationTypeRepository;
    }

    public List<LocationType> findAll(){ return locationTypeRepository.findAll();}

    public Optional<LocationType> findById(short locatTypeId) throws Exception
    {
        Optional<LocationType> locationType = locationTypeRepository.findById((int) locatTypeId);
        if(locationType.isEmpty()){
            throw new Exception("<div class=\"alert\">Required location type not exists!</div>");
        } else {
            return locationType;
        }
    }

    public void create(LocationType locationType) throws Exception
    {
        if(locationTypeRepository.existsById(locationType.getLocatTypeId())){
            throw new Exception("<div class=\"alert\">Location type " + locationType.getLocatTypeId() +" is already exist!</div>");
        }
        else{
            locationTypeRepository.save(locationType);
        }
    }

    public void edit(LocationType locationType) { locationTypeRepository.save(locationType); }

    public void delete(short locationTypeId){ locationTypeRepository.deleteById((int) locationTypeId); }

}
