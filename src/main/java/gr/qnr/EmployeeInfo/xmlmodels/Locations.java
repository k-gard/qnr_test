package gr.qnr.EmployeeInfo.xmlmodels;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Locations {
    @JacksonXmlProperty(localName = "location")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<LocationXmlModel> locations;

    public Locations(List<LocationXmlModel> locations) {
        this.locations = locations;
    }

    public List<LocationXmlModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationXmlModel> locations) {
        this.locations = locations;
    }
}
