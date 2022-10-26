package com.denamed.HutWMS.services;

import com.denamed.HutWMS.entities.LocationStatus;
import com.denamed.HutWMS.repositories.LocationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationStatusService {
    private final LocationStatusRepository locationStatusRepository;

    @Autowired
    public LocationStatusService(LocationStatusRepository locationStatusRepository) {
        this.locationStatusRepository = locationStatusRepository;
    }

    public List<LocationStatus> findAll(){ return locationStatusRepository.findAll();}

    public Optional<LocationStatus> findById(short locatStatusId) throws Exception
    {
        Optional<LocationStatus> locationStatus = locationStatusRepository.findById(locatStatusId);
        if(locationStatus.isEmpty()){
            throw new Exception("<div class=\"alert\">Required location status not exists!</div>");
        } else {
            return locationStatus;
        }
    }

    public void create(LocationStatus locationStatus) throws Exception
    {
        if(locationStatusRepository.existsById(locationStatus.getLocatStatusId())){
            throw new Exception("<div class=\"alert\">Location status " + locationStatus.getLocatStatusId() +" is already exist!</div>");
        }
        else{
            locationStatusRepository.save(locationStatus);
        }
    }

    public void edit(LocationStatus locationStatus) { locationStatusRepository.save(locationStatus); }

    public void delete(short locationStatusId){ locationStatusRepository.deleteById(locationStatusId); }

}
