package gr.qnr.EmployeeInfo.mappers;

import gr.qnr.EmployeeInfo.models.Employee;
import gr.qnr.EmployeeInfo.models.Location;
import gr.qnr.EmployeeInfo.xmlmodels.EmployeeXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Employees;
import gr.qnr.EmployeeInfo.xmlmodels.LocationXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Locations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationToLocationXmlModelMapper {

    public LocationXmlModel mapLocationToLocationXmlModel(Location location){

        return new LocationXmlModel(
                location.getId(),
                location.getName()
        );
    }

    public Locations mapLocationsList(List<Location> locations){
        return new Locations(
                locations.stream().map(l -> mapLocationToLocationXmlModel(l))
                        .collect(Collectors.toCollection(ArrayList::new)
                ));
    }

}
