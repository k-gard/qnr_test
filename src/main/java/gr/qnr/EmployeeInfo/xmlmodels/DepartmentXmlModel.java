package gr.qnr.EmployeeInfo.xmlmodels;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "department")
public class DepartmentXmlModel {

        @JacksonXmlProperty
        private int departmentId;
        @JacksonXmlProperty
        private String name;
        @JacksonXmlProperty
        private String location;

        public DepartmentXmlModel(int departmentId, String name, String departmentLocation) {
            this.departmentId = departmentId;
            this.name = name;
            this.location = departmentLocation;
        }


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


