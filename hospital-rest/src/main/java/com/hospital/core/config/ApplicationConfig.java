package com.hospital.core.config;


import com.hospital.soap.client.Medicines;
import com.hospital.soap.client.Medicines_Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Medicines medicinesService() {
        return new Medicines_Service().getMedicines();
    }

}
