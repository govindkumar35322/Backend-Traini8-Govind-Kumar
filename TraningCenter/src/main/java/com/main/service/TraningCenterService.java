package com.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entity.TraningCenter;
import com.main.repository.TrainingCenterRepository;
@Service
public class TraningCenterService {
	@Autowired
    private TrainingCenterRepository trainingCenterRepository;
    
    public TraningCenter createTrainingCenter(TraningCenter trainingCenter) {
        return trainingCenterRepository.save(trainingCenter);
    }
    
    public List<TraningCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
    
    public List<TraningCenter> filterTrainingCenters(String city, String state, String centerName) {
        List<TraningCenter> centers = trainingCenterRepository.findAll();
        
        // Apply filters in memory (could be optimized with custom repository methods)
        return centers.stream()
                .filter(center -> 
                        (city == null || center.getAddress().getCity().equalsIgnoreCase(city)) &&
                        (state == null || center.getAddress().getState().equalsIgnoreCase(state)) &&
                        (centerName == null || center.getCenterName().toLowerCase().contains(centerName.toLowerCase()))
                )
                .collect(Collectors.toList());
    }
 
}
