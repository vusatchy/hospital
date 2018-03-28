package com.hospital.storage.dao.utils;

import com.hospital.storage.model.Medicine;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MapperUtil {

    public static Medicine medicineMapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String usage = rs.getString("usage");
        Medicine medicine = new Medicine();
        medicine.setId(id);
        medicine.setName(name);
        medicine.setUsage(usage);
        return medicine;
    }
}
