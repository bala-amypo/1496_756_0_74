package com.example.demo.service;
import com.example.demo.entity.LocationEntity;
import java.util.List;
public interface LocationService{
    LocationEntity createlocation(LocationEntity location);
    List<LocationEntity> getalllocation();
}