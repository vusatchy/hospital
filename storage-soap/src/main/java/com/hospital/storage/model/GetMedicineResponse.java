package com.hospital.storage.model;

import com.hospital.storage.endpoint.MedicineEndpoint;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
    name = "getMedicineResponse",
    namespace = MedicineEndpoint.NAMESPACE_URI
)
public class GetMedicineResponse {
    private List<Medicine> medicines;

    public GetMedicineResponse() {
    }

    public List<Medicine> getMedicines() {
        if (this.medicines == null) {
            this.medicines = new ArrayList();
        }

        return this.medicines;
    }
    public void setMedicines(List<Medicine> medicines){
        this.medicines = medicines;
    }
}
