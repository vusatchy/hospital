package com.hospital.storage.dao;

import static config.StorageSoapConfig.*;
import static org.h2.engine.Constants.UTF8;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.hospital.storage.model.Medicine;
import config.StorageSoapConfig;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StorageSoapConfig.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class MedicineDaoTest {

    @Autowired
    private MedicineDao medicineRepository;

    private static final ClassLoader classLoader = MedicineDaoTest.class.getClassLoader();
    private static final String SCHEMA_FILE = new File(classLoader.getResource("schema.sql").getFile()).getPath();

    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, SCHEMA_FILE, UTF8, false);
    }

    @Test
    @DatabaseSetup("/dataset.xml")
    public void testMedicineDao() {
        List<Medicine> medicines = medicineRepository.getMedicineByUsage("Tired");
        Set<String> ids = new HashSet<>(Arrays.asList("Somethingprohen", "Antibiotik"));
        Assert.assertEquals(ids, medicines.stream().map(Medicine::getName).collect(Collectors.toSet()));
    }
}
