package gr.qnr.EmployeeInfo.xmlmodels;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;

@JacksonXmlRootElement(localName = "employee")
public class EmployeeXmlModel {

    @JacksonXmlProperty(isAttribute = true)
    private int Id;
    @JacksonXmlProperty
    private String lastName;
    @JacksonXmlProperty
    private String firstName;
    @JacksonXmlProperty
    private String job;
    @JacksonXmlProperty
    private int managerId;
    @JacksonXmlProperty
    private LocalDate hireDate;
    @JacksonXmlProperty
    private double salary;
    @JacksonXmlProperty
    private double commission;
    @JacksonXmlProperty
    private int departmentId;


    public EmployeeXmlModel() {
    }

    public EmployeeXmlModel(int id, String lastName, String firstName, String job, int managerId,
                            LocalDate hireDate, double salary, double commission, int departmentId) {
        Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.job = job;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentId = departmentId;
    }


}

