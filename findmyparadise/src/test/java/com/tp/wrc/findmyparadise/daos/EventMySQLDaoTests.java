package com.tp.wrc.findmyparadise.daos;


import com.tp.wrc.findmyparadise.persistence.EventMySQLDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("daoTesting")
class EventMySQLDaoTests {

    @Autowired
    EventMySQLDao toTest;

    @Autowired
    JdbcTemplate template;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {

        //Clearing all rows from the Employee, PositionDay, Day, and Day tables and restarting the
        //id sequence to begin at 1.
        template.update("TRUNCATE \"Event\" RESTART IDENTITY;");
        //Inserting values into the test database for testing purposes.
        template.update("INSERT INTO \"Event\" (\"title\", \"summary\", \"category\", \"cost\", \"latitude\", \"longitude\") " +
                "VALUES ('Event Title', 'Event Summary', 'Event Category', 9.99, 0, 0)");

    }

    @Test //Testing method to add a new Event to the database. Golden path.
    public void newEventGoldenPath() {


    }

}
