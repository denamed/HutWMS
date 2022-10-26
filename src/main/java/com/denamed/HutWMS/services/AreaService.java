package com.denamed.HutWMS.services;

import com.denamed.HutWMS.entities.Area;
import com.denamed.HutWMS.repositories.AreaRepository;
import com.denamed.HutWMS.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private final AreaRepository areaRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository,
                       LocationRepository locationRepository)
    {
        this.areaRepository = areaRepository;
        this.locationRepository = locationRepository;
    }

    public List<Area> findAll() { return areaRepository.findAll(); }

    public Optional<Area> findById(int areaId) throws Exception
    {
        Optional<Area> area = areaRepository.findById(areaId);
        if(area.isEmpty()){
            throw new Exception("<div class=\"alert\">Specified area does not exist!</div>");
        } else {
            return area;
        }
    }

    public Area create(Area area) throws Exception
    {
        if (areaRepository.existsById(area.getAreaId())) {
            throw new Exception("<div class=\"alert\">Area " + area.getAreaId() + " already exists!</div>");
        } else {
            return areaRepository.save(area);
        }
    }

    public void edit(Area area) { areaRepository.save(area); }

    public void delete(int areaId) throws Exception
    {
        if (locationRepository.existsByAreaId(areaId)) {
            throw new Exception("<div class=\"alert\">Area " + areaId + " have the locations!</div>");
        } else {
            areaRepository.deleteById(areaId);
        }
    }
}