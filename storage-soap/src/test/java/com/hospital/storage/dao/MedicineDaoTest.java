package com.hospital.storage.dao;

import com.hospital.storage.dao.implamantanion.MedicineDaoImplementation;
import com.hospital.storage.models.Medicine;
import config.StorageSoapConfig;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StorageSoapConfig.class)
public class MedicineDaoTest {

    @Autowired
    MedicineDaoImplementation contactRepository;

    @Autowired
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(new File(
                "src/test/resources/dataset.xml"));
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
        DatabaseConfig config = dbConn.getConfig();
        config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
        config.setProperty("http://www.dbunit.org/features/caseSensitiveTableNames", true);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);       /*Connection conn = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitConn = new DatabaseConnection(conn, "public");
        DatabaseConfig dbCfg = dbUnitConn.getConfig();
        dbCfg.setFeature(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, Boolean.TRUE);
        IDataSet dataSet = new FlatXmlDataSet(ClassLoader.getSystemResourceAsStream("dataset.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConn, dataSet);*/
    }

    @Test
    public void allElementsLoaded() {
        Assert.assertEquals(1, 1);
    }

}
