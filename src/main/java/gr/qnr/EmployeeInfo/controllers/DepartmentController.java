package gr.qnr.EmployeeInfo.controllers;

import gr.qnr.EmployeeInfo.mappers.DepartmentToDepartmentXmlModelMapper;
import gr.qnr.EmployeeInfo.models.Department;
import gr.qnr.EmployeeInfo.services.DepartmentService;
import gr.qnr.EmployeeInfo.xmlmodels.Departments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private DepartmentService service;
    private DepartmentToDepartmentXmlModelMapper mapper;

    public DepartmentController(DepartmentService service,DepartmentToDepartmentXmlModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(path = "/api/departments", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getAllDepartments(){
        List<Department> departments = service.getAllDepartments();
        if(departments.isEmpty()){
            return new ResponseEntity(new Departments(Collections.emptyList()),null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapDepartmentList(departments), null, HttpStatus.OK);
    }

    @GetMapping(path = "/api/departments/{id}", produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getDepartmentById(@PathVariable @Valid int id){
        Optional<Department> departmentOptional = service.getDepartmentById(id);
        if(departmentOptional.isEmpty()){
            return new ResponseEntity(new Departments(Collections.emptyList()),null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapDepartmentToDepartmentXmlModel(departmentOptional.get()), null, HttpStatus.OK);
    }

    @GetMapping(path = "/api/departments/findByLocation/{name}" ,produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getDepartmentByLocationName(@PathVariable @Valid String name){
        List<Department> departments = service.getDepartmentByLocationName(name);
        if(departments.isEmpty()){
            return new ResponseEntity(new Departments(Collections.emptyList()),null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapDepartmentList(departments), null, HttpStatus.OK);
    }

   
    @GetMapping(path = "/location/{id}")
    public ModelAndView viewDepartmentsByLocationId(@PathVariable @Valid int id){
        List<Department> departments = service.getDepartmentsByLocationId(id);
        if (departments.isEmpty()){
            ModelAndView error = new ModelAndView("404");
            error.addObject("item","Department");
            return error;
        }
        ModelAndView modelAndView = new ModelAndView("view-department-by-location");
        modelAndView.addObject("departments", service.getDepartmentsByLocationId(id));
        modelAndView.addObject("title", "View Departments");
        modelAndView.addObject("location", service.getDepartmentsByLocationId(id).get(0).getLocation().getName());
        return modelAndView;
    }

    @GetMapping(path = "/departments")
    public ModelAndView viewDepartments(){
        List<Department> departments = service.getAllDepartments();
        if (departments.isEmpty()){
            ModelAndView error = new ModelAndView("404");
            error.addObject("item","Department");
            return error;

        }
        ModelAndView modelAndView = new ModelAndView("view-departments");
        modelAndView.addObject("departments", service.getAllDepartments());
        modelAndView.addObject("title", "Departments");
        return modelAndView;
    }
}
