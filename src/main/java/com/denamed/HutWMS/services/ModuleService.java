package com.denamed.HutWMS.services;

import com.denamed.HutWMS.entities.Module;
import com.denamed.HutWMS.repositories.AreaRepository;
import com.denamed.HutWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final AreaRepository areaRepository;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository,
                         AreaRepository areaRepository)
    {
        this.moduleRepository = moduleRepository;
        this.areaRepository = areaRepository;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Optional<Module> findById(int modulId) { return moduleRepository.findById(modulId); }

    //create
    public void create(Module module) throws Exception
    {
        if (moduleRepository.existsById(module.getModulId())){
            throw new Exception("<div class=\"alert\">Module " + module.getModulId() + " is already exist!</div>");
        } else {
            moduleRepository.save(module);
        }
    }

    //edit
    public void edit(Module module){ moduleRepository.save(module); }

    public void delete(int modulId) throws Exception
    {
        if (areaRepository.existsByModulId(modulId)){
           throw new Exception("<div class=\"alert\">Module " + modulId + " have the areas!</div>");
        } else {
            moduleRepository.deleteById(modulId);
        }
    }
}
