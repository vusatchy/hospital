package com.hospital.storage.endpoint;

import com.hospital.storage.dao.implamantanion.MedicineDaoImplementation;

import model.GetMedicineRequest;
import model.GetMedicineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class MedicineEndpoint {

    public static final String NAMESPACE_URI = "http://model";

    @Autowired
    private MedicineDaoImplementation medicineDaoImplementationl;

    @PayloadRoot( localPart = "getMedicineRequest" , namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetMedicineResponse getMedicineRequest(@RequestPayload GetMedicineRequest request) {
        GetMedicineResponse response = new GetMedicineResponse();
        response.getMedicines().addAll((medicineDaoImplementationl.getMedicineByUsage(request.getName())));
        return response;
    }
}
