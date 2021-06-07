package gr.qnr.EmployeeInfo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @Column(name = "DEPTID")
    private int id;
    @Column(name = "DNAME")
    @Length(min = 2 , max = 14)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCID", referencedColumnName = "LOCID")
    private Location location;

    public Department(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setDepartmentLocation(Location location) {
        this.location = location;
    }
}
