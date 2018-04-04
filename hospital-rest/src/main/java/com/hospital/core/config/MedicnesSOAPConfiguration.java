package com.hospital.core.config;

import com.hospital.core.client.MedicineClient;
import com.hospital.storage.model.GetMedicineRequest;
import com.hospital.storage.model.GetMedicineResponse;
import com.hospital.storage.model.Medicine;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MedicnesSOAPConfiguration {

	@Bean
        public Jaxb2Marshaller marshaller() throws JAXBException {
		JAXBContext.newInstance(Medicine.class, GetMedicineRequest.class, GetMedicineResponse.class);
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("medicines.wsdl");
		return marshaller;
	}

	@Bean
	public MedicineClient medicineClient(Jaxb2Marshaller marshaller) {
		MedicineClient client = new MedicineClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}