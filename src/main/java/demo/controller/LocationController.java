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