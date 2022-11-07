package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    List<Owner> findByOrderByOwnerIdAsc();
}
