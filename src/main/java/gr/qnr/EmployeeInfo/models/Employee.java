package gr.qnr.EmployeeInfo.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @Column(name = "EMPID")

    private int Id;
    @Column(name = "LASTNAME")
    @Length(min = 4, max = 20)

    private String lastName;
    @Length(min = 4, max = 15)
    @Column(name = "FIRSTNAME")

    private String firstName;
    @Length(min = 4, max = 9)
    @Column(name = "JOB")

    private String job;
    @ManyToOne
    @JoinColumn(name = "MNGID",referencedColumnName = "EMPID")
    private Employee Manager;
    @Column(name = "HIREDATE")

    private LocalDate hireDate;
    @Column(name = "SALARY")

    private double salary;
    @Column(name = "COMM")

    private double commission;
    @ManyToOne
    @JoinColumn(name = "DEPTID" ,referencedColumnName = "DEPTID")
    private Department department;


    public Employee() {
    }

    public Employee(int id, String lastName, String firstName, String job, Employee manager,
                    LocalDate hireDate, double salary, double commission, Department department) {
        Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.job = job;
        Manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.department = department;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Employee getManager() {
        return Manager;
    }

    public void setManager(Employee manager) {
        Manager = manager;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
