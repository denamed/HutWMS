package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Location;
import com.denamed.TestWMS.repositories.AreaRepository;
import com.denamed.TestWMS.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final AreaRepository areaRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository,
                           AreaRepository areaRepository)
    {
        this.locationRepository = locationRepository;
        this.areaRepository = areaRepository;
    }

    public List<Location> findAll() {return locationRepository.findAll();}

    public Location findSingleLocation(int areaId,
                                                     short locatRow,
                                                     short locatPlace,
                                                     short locatLevel)
    {
        return locationRepository.findByAreaIdAndLocatRowAndLocatPlaceAndLocatLevel(areaId,
                locatRow,
                locatPlace,
                locatLevel);
    }

    public void create(Location location) throws Exception {
        if (locationRepository.existsByAreaIdAndLocatRowAndLocatPlaceAndLocatLevel(
                                                                                    location.getAreaId(),
                                                                                    location.getLocatRow(),
                                                                                    location.getLocatPlace(),
                                                                                    location.getLocatLevel())) {
            throw new Exception("Location with entered coordinates is already exist.");
        }else {
            locationRepository.save(location);}
    }


}
