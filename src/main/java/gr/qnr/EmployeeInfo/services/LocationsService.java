package gr.qnr.EmployeeInfo.services;

import gr.qnr.EmployeeInfo.mappers.LocationToLocationXmlModelMapper;
import gr.qnr.EmployeeInfo.models.Location;
import gr.qnr.EmployeeInfo.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
