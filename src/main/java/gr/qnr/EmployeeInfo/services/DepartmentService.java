package gr.qnr.EmployeeInfo.services;

import gr.qnr.EmployeeInfo.mappers.DepartmentToDepartmentXmlModelMapper;
import gr.qnr.EmployeeInfo.models.*;
import gr.qnr.EmployeeInfo.models.Error;
import gr.qnr.EmployeeInfo.repositories.LocationRepository;
import gr.qnr.EmployeeInfo.repositories.DepartmentRepository;
import gr.qnr.EmployeeInfo.xmlmodels.DepartmentXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Departments;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentToDepartmentXmlModelMapper mapper;
    private LocationRepository locationRepository;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentToDepartmentXmlModelMapper mapper,
                             LocationRepository locationRepository ) {
        this.departmentRepository = departmentRepository;
        this.mapper= mapper;
        this.locationRepository= locationRepository;
    }

    public List<Department> getAllDepartments() {
        return  departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
         return departmentRepository.findById(id);
    }


    public List<Department> getDepartmentByLocationId(int id) {
        Location dl = new Location();
        dl.setId(id);
        return  departmentRepository.findByLocation(dl);

    }

    public List<Department> getDepartmentByLocationName(String name) {
        Optional<Location> dl = locationRepository.findByName(name);
        if(dl.isEmpty()){return Collections.emptyList(); }
        return  departmentRepository.findByLocation(dl.get());
    }

    public List<Department> getDepartmentsByLocationId(int id) {
        Location dl = new Location();
        dl.setId(id);
        return departmentRepository.findByLocation(dl);
    }


}
