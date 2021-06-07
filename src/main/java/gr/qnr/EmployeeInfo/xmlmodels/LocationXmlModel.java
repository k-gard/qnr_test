package gr.qnr.EmployeeInfo.xmlmodels;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

@JacksonXmlRootElement(localName = "location")
public class LocationXmlModel {
    @JacksonXmlProperty
    private int id;
    @JacksonXmlProperty
    private String name;

    public LocationXmlModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
