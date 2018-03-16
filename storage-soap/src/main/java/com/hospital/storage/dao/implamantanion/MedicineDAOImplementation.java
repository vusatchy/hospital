package com.hospital.storage.dao.implamantanion;

import com.hospital.storage.dao.MedicineDAO;
import com.hospital.storage.models.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class MedicineDAOImplementation implements MedicineDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Medicine> getMedicineByUsage(String usage) {
        return jdbcTemplate.query(
                "select * from medicines where usage = ?", new Object[]{usage},
                (rs, rowNum) -> {
                    Medicine medicine = new Medicine();
                    medicine.setId(rs.getInt("id"));
                    medicine.setName(rs.getString("name"));
                    medicine.setUsage(rs.getString("usage"));
                    return medicine;
                });
    }
}
