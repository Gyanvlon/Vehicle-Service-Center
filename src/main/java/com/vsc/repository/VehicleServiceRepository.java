package com.vsc.repository;

import com.vsc.model.VService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceRepository extends JpaRepository<VService,Long> {
}
