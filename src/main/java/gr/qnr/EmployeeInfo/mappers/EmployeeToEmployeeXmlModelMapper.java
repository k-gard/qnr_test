package gr.qnr.EmployeeInfo.mappers;

import gr.qnr.EmployeeInfo.models.Employee;
import gr.qnr.EmployeeInfo.xmlmodels.EmployeeXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Employees;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeToEmployeeXmlModelMapper {
    public EmployeeXmlModel mapEmployeeToEmployeeXmlModel(Employee employee){

        return new EmployeeXmlModel(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getJob(),
                (employee.getManager() == null)? 0 :employee.getManager().getId(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getCommission(),
                employee.getDepartment().getId()
        );
    }

    public Employees mapEmployeeList(List<Employee> employees){
        return new Employees(
                employees.stream().map(e -> mapEmployeeToEmployeeXmlModel(e)).collect(Collectors.toCollection(ArrayList::new)
        ));
    }
}
