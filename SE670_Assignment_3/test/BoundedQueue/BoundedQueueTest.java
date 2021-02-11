/*
 * This JUnit test set was modified by Paul Court for SE 670 and Dr. Omar
 * Al-Azzam.  It hopes to satisfy the requirements for Assignment 3 problem
 * number 3.
 */
package BoundedQueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul Court
 */
public class BoundedQueueTest {
 
    BoundedQueue myTestQueue;  //public variables to assist in tests.
    int myTestQueueSize = 3;  //initalizes the size of the testQueue to 3.
    Object myTestObject = null;

    public BoundedQueueTest() {
          
    }
            
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() { 
        
    myTestQueue = new BoundedQueue(myTestQueueSize);  //Establishes initial conditions.
    }
    
    @After
    public void tearDown() {
        myTestQueue = null;  //Returns state to null.
        myTestQueueSize = 0;
    }

    /**
     * Test proper working enQueue method, of class BoundedQueue.
     */
    @Test
    public void testEnQueue() {
        
        System.out.println("Test of enQueue method.");
        myTestObject = "o1";
        myTestQueue.enQueue(myTestObject);  //Add an object to the bounded queue.
        
       assertEquals("[o1]", myTestQueue.toString());
    }
    
    /**
     * Test null entry to enQueue method, of class BoundedQueue.
     */       
   @Test (expected = NullPointerException.class)
    public void testNullEntry() {
        
        System.out.println("Test of NullPointerException for enQueue method.");
        myTestObject = null;
        myTestQueue.enQueue(myTestObject);  //Add a null object to the bounded queue.
    }

    /**
     * Test of adding to a full queue for enQueue method, of class BoundedQueue.
     */       
   @Test (expected = IllegalStateException.class)
    public void testQueueFull() {
        
        System.out.println("Test of IllegalStateException for enQueue method.");
        myTestQueue.enQueue("o1");
        myTestQueue.enQueue("o2");
        myTestQueue.enQueue("o3");
        
        //Since myTestQueueSize = 3, this added item should cause IllegalStateException.
        myTestQueue.enQueue("o4"); 
    }
    
    /**
     * Test of proper working deQueue method, of class BoundedQueue.
     */
    @Test
    public void testDeQueue() {
        
        System.out.println("Test of deQueue method.");
        //myTestObject = "o1";      
        this.myTestObject = "o1";
        
        myTestQueue.enQueue(myTestObject); //Add an object to the bounded queue. 
        myTestQueue.enQueue("o2");  //Add another object to the bounded queue.
        
        //Writes the deQueued value to thisTestResult.
        Object thisTestResult = myTestQueue.deQueue(); 
        
        //Since FIFO, the object "o1" should be the result.        
        assertEquals("o1", thisTestResult); 
    }

    /**
     * Test of IllegalStateException for deQueue method, of class BoundedQueue.
     */
    @Test (expected = IllegalStateException.class)
    public void testEmptyDeQueue() {
        
        System.out.println("Test of IllegalStateException for deQueue method.");
        
        //Since myTestQueue is assigned to be null, this should cause IllegalStateException.
        myTestQueue.deQueue();
    }
    
    /**
     * Test of isEmpty method, of class BoundedQueue.
     */
    @Test
    public void testIsEmpty() {
        
        System.out.println("Test of isEmpty method.");

        assertTrue(myTestQueue.isEmpty());  
        //The queue was initialized as empty..should be True.
    }

    /**
     * Test of isEmpty method, of class BoundedQueue.
     */
    @Test
    public void testIsNotEmpty() {
        
        System.out.println("Test of isEmpty method.  NOT empty");
        myTestQueue.enQueue("o1");
        
        assertTrue(!myTestQueue.isEmpty());  
        //The queue was initialized as empty then an item was added.
        //This should NOT be true.
    }

    /**
     * Test of isFull method, of class BoundedQueue.
     */
    @Test
    public void testIsFull() {
        
        System.out.println("Test of isFull method.");
        myTestQueue.enQueue("o1");
        myTestQueue.enQueue("o2");
        myTestQueue.enQueue("o3");
        
        assertTrue(myTestQueue.isFull());
       //myQueueSize is initialized as 3.  This should be true.
    }

    /**
     * Test of isFull method for the case of NOT full, of class BoundedQueue.
     */
    @Test
    public void testIsNotFull() {
        
        System.out.println("Test of isFull method.  Not full!");
        myTestQueue.enQueue("o1");
        myTestQueue.enQueue("o2");
        
        assertTrue(!myTestQueue.isFull());
       //myQueueSize is initialized as 3.  This should NOT be true.
    }

    /**
     * Test of toString method, of class BoundedQueue.
     */
    @Test
    public void testToString() {
        
        System.out.println("Test of toString method.");
        myTestQueue.enQueue("o1");
        myTestQueue.enQueue("o2");
        myTestQueue.enQueue("o3");
        
        assertEquals("[o1, o2, o3]", myTestQueue.toString());
        //toString adds "[" and "]" at the beginning and end.  This should
        //be true.
        
    }
    
    /**
     * Test of toString method, of class BoundedQueue.
     */
    @Test
    public void testToStringNull() {
        
        System.out.println("Test of toString method with null entry.");
        
        assertEquals("[]", myTestQueue.toString());
        //toString adds "[" and "]" at the beginning and end.  This should
        //be true.
        
    }
}
