package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {
    public List<ItemType> findByOrderByItemTypeIdAsc();
}
