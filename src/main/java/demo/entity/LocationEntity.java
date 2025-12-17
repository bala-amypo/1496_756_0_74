
Conversation opened. 1 unread message.

Skip to content
Using Sri Krishna College of Technology Mail with screen readers

1 of 2,600
Fwd:
Inbox

727824TUCS021 ANGEL P
2:05 PM (0 minutes ago)
to me, 727824tucs012, 727824tucs027



---------- Forwarded message ---------
From: 727824TUCS028 ARULSELVAM K <727824tucs028@skct.edu.in>
Date: Wed, Dec 17, 2025 at 2:03 PM
Subject:
To: <727824tucs021@skct.edu.in>




LocationController.java

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LocationEntity;
import com.example.demo.service.LocationService;

@RestController
public class LocationController{
    @Autowired
    LocationService locationservice;
    @PostMapping("/addstudent")
    public LocationEntity add(@RequestBody LocationEntity le){
        return locationservice.createlocation(le);
    }
    @GetMapping ("/showlocation")
    public List<LocationEntity> show(){
        return locationservice.getalllocation();
    }
}

.............................................


LocationEntity.java



package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public LocationEntity() {
    }

    public LocationEntity(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

.......................................



LocationRepository.java



package com.example.demo.repository;
import com.example.demo.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    
}

...............................................



LocationService.java



package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LocationEntity;

public interface LocationService {

    LocationEntity createlocation(LocationEntity le);

    List<LocationEntity> getalllocation();
}

.................................................



LocationServiceImpl.java



package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationEntity createlocation(LocationEntity le) {
        return locationRepository.save(le);
    }

    @Override
    public List<LocationEntity> getalllocation() {
        return locationRepository.findAll();
    }
}

............................................



SwaggerConfig.java



package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9228.408procr.amypo.ai/")
                ));
        }
}











