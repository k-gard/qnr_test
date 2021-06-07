package gr.qnr.EmployeeInfo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//LOCID  NUMERIC(2),
//LOCNAME  Varchar(50)
@Entity
public class Location {
    @Id
    @Column(name = "LOCID")
    private int Id;
    @Column(name = "LOCNAME")
    @Length(min = 3 ,max= 50)
    private String name;

    public Location() {
    }

    public Location(int id, String name) {
        Id = id;
        this.name = name;
    }
    public Location(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
