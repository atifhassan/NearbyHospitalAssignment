/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Atif Hassan
 */
public class HeapTest {
    

    /**
     * Test of isEmpty method, of class Heap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Heap<String> instance = new Heap();
        instance.enqueue("A");
        instance.enqueue("D");
        instance.enqueue("Q");
        instance.enqueue("Z");
        instance.enqueue("B");
        instance.enqueue("M");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        System.out.println(instance.toString());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of enqueue method, of class Heap.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object element = null;
        Heap<String> instance = new Heap();
        instance.enqueue("A");
        instance.enqueue("D");
        instance.enqueue("Q");
        instance.enqueue("Z");
        instance.enqueue("B");
        instance.enqueue("M");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        System.out.println(instance.toString());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Heap.
     * @throws Exceptions.EmptyException
     */
    @Test
    public void testSize() throws EmptyException {
        System.out.println("size");
        Heap<String> instance = new Heap();
        instance.enqueue("A");
        instance.enqueue("D");
        instance.enqueue("Q");
        instance.enqueue("Z");
        instance.enqueue("B");
        instance.enqueue("M");
        instance.dequeue();
        int expResult = 5;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class Heap.
     * @throws java.lang.Exception
     */
    @Test
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        Heap<String> instance = new Heap();
        instance.enqueue("A");
        instance.enqueue("D");
        instance.enqueue("Q");
        instance.enqueue("Z");
        instance.enqueue("B");
        instance.enqueue("M");
        Object expResult = "A";
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Heap.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Heap instance = new Heap();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
