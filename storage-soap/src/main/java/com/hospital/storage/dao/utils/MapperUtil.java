package com.hospital.storage.dao.utils;
import com.hospital.storage.models.Medicine;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {

    public static Medicine medicineMapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String usage = rs.getString("usage");
        return new Medicine(id, name, usage);
    }
}
