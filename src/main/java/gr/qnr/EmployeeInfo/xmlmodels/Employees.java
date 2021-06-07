package gr.qnr.EmployeeInfo.xmlmodels;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;


@JacksonXmlRootElement
public class Employees {

    @JacksonXmlProperty(localName = "employee")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<EmployeeXmlModel> employees;

    public Employees(List<EmployeeXmlModel> employeeList) {
        this.employees = employeeList;
    }

    public List<EmployeeXmlModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeXmlModel> employees) {
        this.employees = employees;
    }
}
