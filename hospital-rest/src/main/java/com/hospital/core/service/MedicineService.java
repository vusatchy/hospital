package com.hospital.core.service;

import com.hospital.soap.client.Medicine;
import java.util.List;


public interface MedicineService {

     List<Medicine> getMedicinesByUsage(String usage);

}
