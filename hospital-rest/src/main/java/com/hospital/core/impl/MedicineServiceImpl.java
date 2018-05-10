package com.hospital.core.impl;

import com.hospital.core.service.MedicineService;
import com.hospital.soap.client.GetMedicineRequest;
import com.hospital.soap.client.Medicine;
import com.hospital.soap.client.Medicines;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private Medicines medicinesRepository;

    @Override
    public List<Medicine> getMedicinesByUsage(String usage) {
	GetMedicineRequest getMedicineRequest = new GetMedicineRequest();
	getMedicineRequest.setName(usage);
	return medicinesRepository.getMedicine(getMedicineRequest).getMedicines();
    }
}
