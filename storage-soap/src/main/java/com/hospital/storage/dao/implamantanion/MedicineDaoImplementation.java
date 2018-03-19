package com.hospital.storage.dao.implamantanion;

import com.hospital.storage.dao.MedicineDao;
import com.hospital.storage.dao.utils.MapperUtil;
import com.hospital.storage.models.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class MedicineDaoImplementation implements MedicineDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Medicine> getMedicineByUsage(String usage) {
        return jdbcTemplate.query(
                "select * from medicines where usage = ?", MapperUtil::medicineMapRow, usage);
    }
}
