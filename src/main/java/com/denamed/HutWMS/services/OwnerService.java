package com.denamed.HutWMS.services;

import com.denamed.HutWMS.entities.Owner;
import com.denamed.HutWMS.repositories.OwnerRepository;
import com.denamed.HutWMS.repositories.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final CatalogueRepository catalogueRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository
            , CatalogueRepository catalogueRepository
            )
    {
        this.ownerRepository = ownerRepository;
        this.catalogueRepository = catalogueRepository;
    }

    public List<Owner> findAll(){ return ownerRepository.findByOrderByOwnerIdAsc(); }

    public Optional<Owner> findById(int ownerId) throws Exception
    {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        if(owner.isEmpty()) {
            throw new Exception("<div class=\"alert\">Required owner not exists!</div>");
        } else {
            return owner;
        }
    }

    public void create(Owner owner) throws Exception
    {
        if (ownerRepository.existsById(owner.getOwnerId())) {
            throw new Exception("<div class=\"alert\">Owner " + owner.getOwnerId() + " is already exist!</div>");
        } else {
            ownerRepository.save(owner);
        }
    }

    public void edit(Owner owner) { ownerRepository.save(owner); }

    public void delete(int ownerId) throws Exception
    {
        if (catalogueRepository.existsByOwnerId(ownerId)) {
            throw new Exception("<div class=\"alert\">Owner " + ownerId + " have the articles!</div>");
        } else {
            ownerRepository.deleteById(ownerId);
        }
    }
}