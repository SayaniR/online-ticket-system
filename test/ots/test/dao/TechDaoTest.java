/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ots.test.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ots.test.beans.Tech;

/**
 *
 * @author prasun
 */
public class TechDaoTest {
    
    public TechDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateLoginCredentials method, of class TechDao.
     */
    @Test
    public void testValidateLoginCredentials() {
        System.out.println("validateLoginCredentials");
        Tech tech = new Tech();
        Tech expResult = tech;
        Tech result = TechDao.validateLoginCredentials(tech);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addTech method, of class TechDao.
     */
    @Test
    public void testAddTech() throws Exception {
        System.out.println("addTech");
        int techId = 1;
        String techPassword = "1234";
        String techName = "prasuntest";
        String techEmail = "test@email";
        String ticketLevel = "l1";
        TechDao instance = new TechDao();
        int expResult = 1;
        int result = instance.addTech(techId, techPassword, techName, techEmail, ticketLevel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
