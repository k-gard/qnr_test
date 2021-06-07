package gr.qnr.EmployeeInfo.xmlmodels;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JacksonXmlRootElement
public class Departments
{
    @JacksonXmlProperty(localName = "department")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<DepartmentXmlModel> departments;

    public Departments(List<DepartmentXmlModel> departments) {
        this.departments = departments;
    }

    public List<DepartmentXmlModel> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentXmlModel> departmentRespons) {
        this.departments = departmentRespons;
    }

}
