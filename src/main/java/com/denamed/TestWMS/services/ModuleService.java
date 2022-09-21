package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.repositories.BuildingRepository;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository, BuildingRepository buildingRepository) {
        this.moduleRepository = moduleRepository;
        this.buildingRepository = buildingRepository;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Module saveModule(Module module){
        if(buildingRepository.existsById(module.getBuildId())) {
            return moduleRepository.save(module);
        } else {
            /* add message */
            return module;
        }
    }

    public void deleteModule(int modulId) {
        moduleRepository.deleteById(modulId);
    }
}
