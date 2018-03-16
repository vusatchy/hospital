package com.hospital.storage.dao;

import com.hospital.storage.models.Medicine;

import java.util.List;

public interface MedicineDAO {

    List<Medicine> getMedicineByUsage(String usage);
}
