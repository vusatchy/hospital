package com.hospital.core.config;

import com.hospital.soap.client.Medicines_0020Port;
import com.hospital.soap.client.Medicines_0020PortService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Medicines_0020Port medicines_0020PortService() {
        return new Medicines_0020PortService().getMedicines_0020PortSoap11();
    }

}
