### Testing services with DBUnit and HyperSQL

Let’s assume that you have a tests that use database and you want to set up the database to be sure about the state before each test run. Otherwise we will get a headaches to maintain a lot of test manually(different configuration and database contents), because we want that out test always run successful. We need a testing tool that provides easy way to initialise database and create/restore consistent state for our test. DBUnit will help us with that. It’s a great integration tool that can export and import your database data to and from XML datasets.
     
This post shows how easily can be used DBUnit and HSQL to write database tests and testing your persistence layer services. So, getting started. Suppose that we have a service UserService that returns User objects from the database. And we want to test services method to make sure that everything is working properly.
     
Well, the plan is to initialize the database before execute test, execute the database schema and read the DBUnit xml file. And then build the IDataSet that represents a collections of tables.

* Here is the link to the [create_database.sql schema](https://github.com/dmitrynikol/personal-stuff/blob/master/TestingServicesWithDBUnitAndHSQL/resources/create_database.sql)
* And here is a simple [dataset xml](https://github.com/dmitrynikol/personal-stuff/blob/master/TestingServicesWithDBUnitAndHSQL/resources/hsqldb_users.dbunit.xml) file. 

Now, we are ready to test our service methods. We can get the necessary data table as an ITable object from IDataSet. 
Finally, the complete [DbUnitDatabaseTest](https://github.com/dmitrynikol/personal-stuff/blob/master/TestingServicesWithDBUnitAndHSQL/DbUnitDatabaseTest.java) file with @Before and @After methods which will be called before and after test accordingly and other important pieces of code. 
 
