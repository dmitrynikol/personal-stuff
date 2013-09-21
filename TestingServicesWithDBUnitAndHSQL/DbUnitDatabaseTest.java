import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example database test with DBUnit and HSQLDB.
 * 
 * @author Dmitry Nikolaenko
 *
 */
public class DbUnitDatabaseTest {

    private Connection jdbcConnection;
    private IDatabaseConnection dbConnection;
    private IDataSet dataSet;
    
    @Before
    public void setUp() throws Exception {
        Thread.sleep(1000L);
        Class.forName("org.hsqldb.jdbcDriver");
        jdbcConnection = DriverManager.getConnection("jdbc:hsqldb:mem:hsql://localhost/test;user=sa");
        dbConnection = new DatabaseConnection(jdbcConnection, "create_database.sql");
        dbConnection.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
    }

    @After
    public void tearDown() throws Exception {
        dbConnection.close();
        jdbcConnection.close();
    }
    
    private IDataSet getDataSet() throws Exception {
    	if (dataSet == null) {
    		dataSet = new XmlDataSet(getClass().getResourceAsStream("hsqldb_users.dbunit.xml"));
    	}
        return dataSet;
	}

    @Test
    public void testFindUserByid() throws Exception {
        final ITable users = getDataSet().getTable("users");
        
        String firstName = users.getValue(0, "first_name").toString(); // Tom
        String lastName = users.getValue(0, "last_name").toString(); // Jenkins
        String email = users.getValue(0, "email").toString(); // tom.jenkins@gmail.com
        
        User user = userService.findUserByid("123");
        
        Assert.assertEquals(firstName, user.getFirstName());
        Assert.assertEquals(lastName, user.getLastName());
        Assert.assertEquals(email, user.getEmail());
    }
    
    @Test
    public void testFindUserByEmail() throws Exception {
    	 final ITable users = getDataSet().getTable("users");
    	 
    	 String id = users.getValue(0, "id").toString(); // 123
    	 String firstName = users.getValue(0, "first_name").toString(); // Tom
         String lastName = users.getValue(0, "last_name").toString(); // Jenkins
         
         User user = userService.findUserByEmail("tom.jenkins@gmail.com");
         
         Assert.assertEquals(id, user.getId());
         Assert.assertEquals(firstName, user.getFirstName());
         Assert.assertEquals(lastName, user.getLastName());
    }
}