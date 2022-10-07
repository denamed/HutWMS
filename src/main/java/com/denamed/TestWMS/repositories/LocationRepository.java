package com.denamed.TestWMS.repositories;

import com.denamed.TestWMS.entities.Location;
import com.denamed.TestWMS.entities.LocationId;
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
