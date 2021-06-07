package gr.qnr.EmployeeInfo.controllers;

import gr.qnr.EmployeeInfo.mappers.EmployeeToEmployeeXmlModelMapper;
import gr.qnr.EmployeeInfo.models.Employee;
import gr.qnr.EmployeeInfo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@RestController
public class EmployeeController {

    private EmployeeToEmployeeXmlModelMapper mapper;
    private EmployeeService service;

    public EmployeeController(EmployeeService service , EmployeeToEmployeeXmlModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(path = "api/employees",produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getAllEmployees(){
        List<Employee> employees = service.getAllEmployees();
        if(employees.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapEmployeeList(employees), null, HttpStatus.OK);
    }

    @GetMapping(path = "api/employees/department/{id}",produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getEmployeesByDepartmentId(@PathVariable int id){
        List<Employee> employees = service.getEmployeesByDepartmentId(id);
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapEmployeeList(employees), null, HttpStatus.OK);
    }

    @GetMapping(path = "api/employees/name/{lastname}/{firstname}",produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getEmployeeByName(@PathVariable String lastname,@PathVariable String firstname){
        if (service.getEmployeesByFullName(lastname,firstname).isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapEmployeeList(service.getEmployeesByFullName(lastname,firstname)), null, HttpStatus.OK);
    }

    @GetMapping(path = "api/employees/name/{lastname}",produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getEmployeeByName(@PathVariable @Valid String lastname){
        List<Employee> employees =  service.getEmployeesByLastName(lastname);
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapEmployeeList(employees), null, HttpStatus.OK);
    }

    @GetMapping(path = "api/employees/id/{id}",produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getEmployeeById(@PathVariable @Valid int id){
        List<Employee> employees = service.getEmployeesByDepartmentId(id);
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(mapper.mapEmployeeList(employees), null, HttpStatus.OK);
    }

    //Returns view of employees by department
    @GetMapping(path = "/department/{id}")
    public ModelAndView viewEmployeesByDepartmentId(@PathVariable int id){
        List<Employee> employees = service.getEmployeesByDepartmentId(id);
        if (employees.isEmpty()){return new ModelAndView("404");}
        ModelAndView modelAndView = new ModelAndView("view-employee-by-department");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("department",employees.get(0).getDepartment().getName());
        return modelAndView;
    }

    @GetMapping(path = "/employee/{id}")
    public ModelAndView viewEmployeeInfo(@PathVariable int id){
        Optional<Employee> employeeOptional = service.getEmployeeById(id);
        if(employeeOptional.isEmpty()){return new ModelAndView("404");}
        ModelAndView modelAndView = new ModelAndView("view-employee-info");
        modelAndView.addObject("employee", employeeOptional.get());
        return modelAndView;
    }
    @GetMapping(path = "/employees")
    public ModelAndView viewEmployees(){
        List<Employee> employees = service.getAllEmployees();
        if(employees.isEmpty()){return new ModelAndView("404");}
        ModelAndView modelAndView = new ModelAndView("view-employees");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("title", "Employees");
        return modelAndView;
    }

}
