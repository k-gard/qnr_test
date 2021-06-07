package gr.qnr.EmployeeInfo.services;

import gr.qnr.EmployeeInfo.mappers.EmployeeToEmployeeXmlModelMapper;
import gr.qnr.EmployeeInfo.models.*;
import gr.qnr.EmployeeInfo.models.Error;
import gr.qnr.EmployeeInfo.repositories.EmployeeRepository;
import gr.qnr.EmployeeInfo.xmlmodels.EmployeeXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Employees;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;



    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByFullName(String lastname, String firstname) {

        return employeeRepository.findByLastNameAndFirstName(lastname, firstname);
    }

    public List<Employee> getEmployeesByLastName(String lastname) {

        return employeeRepository.findByLastName(lastname);
    }



    public List<Employee> getEmployeesByDepartmentId(int id) {
        Department d = new Department();
        d.setId(id);
        return employeeRepository.findByDepartment(d);
    }


    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepository.findById(id);
    }



}
