package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Module saveModule(Module module){
        /* add validation if module already exist */
        return moduleRepository.save(module);
    }

    public void deleteModule(int modulId) {
        moduleRepository.deleteById(modulId);
    }
}
