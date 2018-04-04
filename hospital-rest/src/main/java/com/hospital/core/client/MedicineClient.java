package com.hospital.core.client;

import com.hospital.storage.model.GetMedicineRequest;
import com.hospital.storage.model.GetMedicineResponse;
import com.hospital.storage.model.Medicine;
import java.util.List;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MedicineClient extends WebServiceGatewaySupport {

    public List<Medicine> getMedicines(String usage) {
        GetMedicineRequest request = new GetMedicineRequest();
        request.setName(usage);

        GetMedicineResponse response = (GetMedicineResponse) getWebServiceTemplate()
            .marshalSendAndReceive(
                request,
                new SoapActionCallback(
                    "http://localhost:8082/ws"));

        return response.getMedicines();
    }
}