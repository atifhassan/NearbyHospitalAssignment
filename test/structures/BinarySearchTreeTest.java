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
public class BinarySearchTreeTest {

    /**
     * Test of Add method, of class BinarySearchTree.
     */
    @Test
    public void testAdd() {
        System.out.println("Add");
        Object element = null;
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        instance.Add("A");
        System.out.println(instance);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Remove method, of class BinarySearchTree.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("Remove");
        Object element = null;
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        instance.Add("A");
        Object expResult = "A";
        Object result = instance.Remove("A");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Contains method, of class BinarySearchTree.
     */
    @Test
    public void testContains() {
        System.out.println("Contains");
        Object element = null;
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        boolean expResult = false;
        boolean result = instance.Contains("A");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Size method, of class BinarySearchTree.
     */
    @Test
    public void testSize() {
        System.out.println("Size");
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        int expResult = 0;
        int result = instance.Size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Get method, of class BinarySearchTree.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("Get");
        Object element = null;
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        instance.Add("A");
        Object expResult = "A";
        Object result = instance.Get("A");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Reset method, of class BinarySearchTree.
     */
    @Test
    public void testReset() {
        System.out.println("Reset");
        BinarySearchTree instance = new BinarySearchTree();
        instance.Reset();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNext method, of class BinarySearchTree.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetNext() throws Exception {
        System.out.println("getNext");
        BinarySearchTree<String> instance = new BinarySearchTree<>();
        instance.Add("C");
        instance.Add("O");
        instance.Add("M");
        instance.Add("P");
        instance.Add("A");
        instance.Add("B");
        Object expResult = "P";
        instance.Reset();
        Object result = null;
        try {
            while(!instance.isEmpty()){
             result = instance.getNext();
             System.out.println(result);
            }
        } catch (EmptyException ex) {

        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BinarySearchTree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BinarySearchTree instance = new BinarySearchTree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
