package com.hospital.storage.dao.implamantanion;

import com.hospital.storage.dao.MedicineDao;
import com.hospital.storage.model.Medicine;
import com.hospital.storage.utils.MapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MedicineDaoImplementation implements MedicineDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Medicine> getMedicineByUsage(String usage) {
        return jdbcTemplate.query(
                "select * from medicines where usage = ?", MapperUtil::medicineMapRow, usage);
    }
}
