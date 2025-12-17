
package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @GetMapping("/location")
    public String getLocation() {
        return "Location works";
    }
}
