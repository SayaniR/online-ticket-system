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
import ots.test.beans.CSR;

/**
 *
 * @author prasun
 */
public class CsrDaoTest {
    
    public CsrDaoTest() {
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
     * Test of csrLoginValidation method, of class CsrDao.
     */
//    @Test
//    public void testCsrLoginValidation() {
//        System.out.println("csrLoginValidation");
//        CSR csr = null;
//        CSR expResult = null;
//        CSR result = CsrDao.csrLoginValidation(csr);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addCsr method, of class CsrDao.
     */
    @Test
    public void testAddCsr() throws Exception {
        System.out.println("addCsr");
        int csrId = 1;
        String csrPassword = "1234";
        String csrName = "prasun";
        String csrEmail = "prasun@123";
        CsrDao instance = new CsrDao();
        int expResult = 1;
        int result = instance.addCsr(csrId, csrPassword, csrName, csrEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
