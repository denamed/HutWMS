package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.Location;
import com.denamed.HutWMS.entities.LocationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, LocationId> {
    boolean existsByAreaId(int areaId);
    Location findByAreaIdAndLocatRowAndLocatPlaceAndLocatLevel(int areaId,
                                                               short locatRow,
                                                               short locatPlace,
                                                               short locatLevel);
    boolean existsByAreaIdAndLocatRowAndLocatPlaceAndLocatLevel(int areaId,
                                                short locatRow,
                                                short locatPlace,
                                                short locatLevel);


}
