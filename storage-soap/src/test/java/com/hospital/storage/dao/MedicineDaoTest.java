package com.hospital.storage.dao;

import static config.StorageSoapConfig.*;
import static org.h2.engine.Constants.UTF8;

import com.hospital.storage.model.Medicine;
import config.StorageSoapConfig;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StorageSoapConfig.class)
public class MedicineDaoTest {

    @Autowired
    private MedicineDao medicineRepository;

    @Autowired
    private DataSource dataSource;

    private static final String SCHEMA_FILE = "src/test/resources/schema.sql";
    private static final String DATA_SET = "src/test/resources/dataset.xml";

    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, SCHEMA_FILE, UTF8, false);
    }

    @Before
    public void loadTestData() throws Exception {
        IDataSet ids = new FlatXmlDataSetBuilder().build(new File(
            DATA_SET));
        IDatabaseTester databaseTester =
            new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(ids);
        databaseTester.onSetup();
    }

    @Test
    public void testMedicineDao() {
        List<Medicine> medicines = medicineRepository.getMedicineByUsage("Tired");
        Set<Integer> ids = new HashSet<>(Arrays.asList(1, 3));
        Assert.assertEquals(ids, medicines.stream().map(Medicine::getId).collect(Collectors.toSet()));
    }
}
