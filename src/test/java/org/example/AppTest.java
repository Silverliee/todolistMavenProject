package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.Entity.Todolist;
import org.example.Entity.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createUserTest()
    {
        User myTestUser = new User("John","Doe", LocalDate.of(1998,9,9),"testmail@testmailbox.fr","mytestpassword",new Todolist());
        assertEquals("John", myTestUser.getFirstname());
        assertEquals("Doe", myTestUser.getLastname());
        assertEquals(LocalDate.of(1998,9,9), myTestUser.getBirthday());
        assertEquals("testmail@testmailbox.fr", myTestUser.getMailAddress());
        assertEquals("mytestpassword", myTestUser.getPassword());
        assertEquals(0, myTestUser.getTodolist().getItems().size());
    }
}
