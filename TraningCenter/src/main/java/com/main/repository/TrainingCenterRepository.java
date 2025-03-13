package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.Entity.TraningCenter;
@Repository
public interface TrainingCenterRepository extends JpaRepository<TraningCenter, Long> {
	 boolean existsByCenterCode(String centerCode);
}
