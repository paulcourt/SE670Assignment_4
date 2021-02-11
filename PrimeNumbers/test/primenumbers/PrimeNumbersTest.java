/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author court
 */
public class PrimeNumbersTest {
    
    public PrimeNumbersTest() {
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
     * Test of computePrimes method, of class PrimeNumbers.
     */
    @Test
    public void testComputePrimes() {
        System.out.println("A test of computePrimes method.");
        int n = 5;
        PrimeNumbers instance = new PrimeNumbers();
        instance.computePrimes(n);
        String result = instance.toString();
        
        System.out.println(result);
        assertEquals("[2, 3, 5, 7, 11]", result);
        
    }

     /**
     * Test of that infects, but still outputs the correct answer.
     */
    @Test
    public void testInfectNoReveal() {
        System.out.println("A test of infectNoReveal.");
        int n = 5;
        PrimeNumbers instance = new PrimeNumbers();
        instance.computePrimes(n);
        String result = instance.toString();
        
        System.out.println(result);
        assertEquals("[2, 3, 5, 7, 11]", result);
        
    }
    
    /**
     * Test of that infects, and reveals an unexpected result.
     */
    @Test
    public void testInfectReveal() {
        System.out.println("A test of infectReveal.");
        int n = 8;
        PrimeNumbers instance = new PrimeNumbers();
        instance.computePrimes(n);
        String result = instance.toString();
        
        System.out.println(result);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", result);
        
    }    
}
