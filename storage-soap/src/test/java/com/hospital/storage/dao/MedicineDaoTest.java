package com.hospital.storage.dao;

import com.hospital.storage.models.Medicine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineDaoTest {

	@Autowired
	private MedicineDao medicineDao;

	@Test
	public void allElementsLoaded() {
		List<Medicine> medicines = medicineDao.getMedicineByUsage("Tired");
		Set<Integer> realIds = new HashSet<>(Arrays.asList(1,9,11,16,18,23,25,27,33,42,46,49));
		Assert.assertEquals(realIds,medicines.stream().map(Medicine::getId).collect(Collectors.toSet()));
	}

	@Test
	public void correctModelMapped(){
		List<Medicine> medicines = medicineDao.getMedicineByUsage("Flu");
		Medicine medicine = new Medicine(15,"Neutrogena Day Activating","Flu");
		Medicine medicineFound = medicines.stream().filter(x->x.getId() == 15).findFirst().orElse(null);
		Assert.assertEquals(medicine,medicineFound);
	}

	@Test
	public void reallyHasOnlyNecessaryUsages(){
		boolean allMatch = medicineDao.getMedicineByUsage("Fever")
				.stream().allMatch(medicine -> "Fever".equals(medicine.getUsage()));
		Assert.assertTrue(allMatch);
	}
}
