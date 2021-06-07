package gr.qnr.EmployeeInfo.controllers;

import gr.qnr.EmployeeInfo.mappers.LocationToLocationXmlModelMapper;
import gr.qnr.EmployeeInfo.models.GenericResponse;
import gr.qnr.EmployeeInfo.models.Location;
import gr.qnr.EmployeeInfo.services.LocationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LocationsController {

    private LocationsService locationsService;
    private LocationToLocationXmlModelMapper mapper;

    public LocationsController(LocationsService locationsService,LocationToLocationXmlModelMapper mapper) {
        this.locationsService = locationsService;
        this.mapper = mapper;
    }

    @GetMapping(path = "api/locations",produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getAllDepartmentLocations(){
        List<Location> locations = locationsService.getAllLocations();
        if(locations.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapLocationsList(locations), null, HttpStatus.OK);
    }

    @GetMapping(path = "/locations")
    public ModelAndView viewLocations(){
        List<Location> locations = locationsService.getAllLocations();
        if (locations.isEmpty()){return new ModelAndView("404");}
        ModelAndView modelAndView = new ModelAndView("view-locations");
        modelAndView.addObject("locations", locations);
        modelAndView.addObject("title", "Locations");
        return modelAndView;
    }

}
