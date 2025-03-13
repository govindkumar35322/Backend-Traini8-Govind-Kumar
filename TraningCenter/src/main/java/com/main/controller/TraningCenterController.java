package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entity.TraningCenter;
import com.main.service.TraningCenterService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/traning_centers")
@RequiredArgsConstructor
public class TraningCenterController {
	 @Autowired
	    private TraningCenterService trainingCenterService;
	    
	    @PostMapping
	    public ResponseEntity<TraningCenter> createTrainingCenter(@Valid @RequestBody TraningCenter trainingCenter) {
	        // Set the current time in epoch milliseconds
	        trainingCenter.setCreatedOn(System.currentTimeMillis());
	        TraningCenter savedCenter = trainingCenterService.createTrainingCenter(trainingCenter);
	        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<TraningCenter>> getAllTrainingCenters(
	            @RequestParam(required = false) String city,
	            @RequestParam(required = false) String state,
	            @RequestParam(required = false) String centerName) {
	        List<TraningCenter> centers;
	        
	        // Filter functionality as a bonus
	        if (city != null || state != null || centerName != null) {
	            centers = trainingCenterService.filterTrainingCenters(city, state, centerName);
	        } else {
	            centers = trainingCenterService.getAllTrainingCenters();
	        }
	        
	        return new ResponseEntity<>(centers, HttpStatus.OK);
	    }
	}
	 
	 
	

