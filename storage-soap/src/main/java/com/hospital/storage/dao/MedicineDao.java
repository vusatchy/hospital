package com.hospital.storage.dao;



import com.hospital.storage.model.Medicine;
import java.util.List;



public interface MedicineDao {

    /**
     * This method is used for getting list of medicines by usage
     *
     * @param usage - usage of your medicine.
     *              f.e. Fever,Tired and so on
     * @return List<Medicine> - returns list of models that represent
     * rows at DB as objects
     * @author Yura Vusach
     */
    List<Medicine> getMedicineByUsage(String usage);
}
