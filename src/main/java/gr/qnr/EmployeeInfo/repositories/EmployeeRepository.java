package gr.qnr.EmployeeInfo.repositories;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import gr.qnr.EmployeeInfo.models.Department;
import gr.qnr.EmployeeInfo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByLastNameAndFirstName(String firstName,String lastName);
    List<Employee> findByLastName(String name);
    List<Employee> findByDepartment(Department department);
}
