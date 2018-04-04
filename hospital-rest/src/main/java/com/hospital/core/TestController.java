package com.hospital.core;

import com.hospital.core.client.MedicineClient;
import com.hospital.storage.model.Medicine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MedicineClient medicineClient;

    @RequestMapping("/med")
    public List<Medicine> greeting(@RequestParam(value="name", defaultValue="Tired") String name) {
        return medicineClient.getMedicines(name);

    }
}