package gr.qnr.EmployeeInfo.services;

import gr.qnr.EmployeeInfo.mappers.LocationToLocationXmlModelMapper;
import gr.qnr.EmployeeInfo.models.Location;
import gr.qnr.EmployeeInfo.models.Error;
import gr.qnr.EmployeeInfo.models.GenericResponse;
import gr.qnr.EmployeeInfo.repositories.LocationRepository;
import gr.qnr.EmployeeInfo.xmlmodels.LocationXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Locations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {
    private LocationRepository repository;
    public LocationToLocationXmlModelMapper mapper;

    public LocationsService(LocationRepository repository, LocationToLocationXmlModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Location> getAllLocations(){
        return repository.findAll();
    }
}
