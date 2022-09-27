package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Area;
import com.denamed.TestWMS.repositories.AreaRepository;
import com.denamed.TestWMS.repositories.LocationRepository;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private final AreaRepository areaRepository;
    private final ModuleRepository moduleRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository, ModuleRepository moduleRepository, LocationRepository locationRepository) {
        this.areaRepository = areaRepository;
        this.moduleRepository = moduleRepository;
        this.locationRepository = locationRepository;
    }

    public List<Area> findAll() {
        return areaRepository.findByOrderByAreaIdAsc();
    }

    public Optional<Area> findById(int areaId) throws Exception{
        Optional<Area> area = areaRepository.findById(areaId);
        if(area.isEmpty()){
            throw new Exception("<div class=\"alert\">Required area not exists!</div>");
        } else {
            return area;
        }
    }

    public Area createArea(Area area) throws Exception {
        if (areaRepository.existsById(area.getAreaId())) {
            throw new Exception("<div class=\"alert\">Area " + area.getAreaId() + " already exists!</div>");
        } else {
            return areaRepository.save(area);
        }
    }

    public void editArea(Area area) {
        areaRepository.save(area);
    }

    public void deleteArea(int areaId) throws Exception{
        if (locationRepository.existsByAreaId(areaId)) {
            throw new Exception("<div class=\"alert\">Area " + areaId + " have the locations!</div>");
        } else {
            areaRepository.deleteById(areaId);
        }
    }


}
