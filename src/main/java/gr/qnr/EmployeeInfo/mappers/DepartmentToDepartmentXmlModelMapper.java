package gr.qnr.EmployeeInfo.mappers;

import gr.qnr.EmployeeInfo.models.Department;
import gr.qnr.EmployeeInfo.xmlmodels.DepartmentXmlModel;
import gr.qnr.EmployeeInfo.xmlmodels.Departments;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentToDepartmentXmlModelMapper {

    public DepartmentXmlModel mapDepartmentToDepartmentXmlModel(Department department){
        return new DepartmentXmlModel(
                department.getId(),
                department.getName(),
                department.getLocation().getName()
        );
    }

    public Departments mapDepartmentList(List<Department> departments){
        return new Departments(
                departments.stream().map(d -> mapDepartmentToDepartmentXmlModel(d)).collect(Collectors.toCollection(ArrayList::new)
                ));
    }

}
