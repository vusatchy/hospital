package com.hospital.storage.model;

import com.hospital.storage.endpoint.MedicineEndpoint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
    name = "getMedicineRequest",
    namespace = MedicineEndpoint.NAMESPACE_URI
)
public class GetMedicineRequest {
    @XmlElement(
        required = true
    )
    private String name;

    public GetMedicineRequest() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
