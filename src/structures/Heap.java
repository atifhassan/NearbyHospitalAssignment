/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import Interfaces.PriorityQueueInterface;
import java.util.ArrayList;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public class Heap<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private ArrayList<E> elements;  // priority queue elements
    private int lastIndex;          // index of last element in priority queue
    private int size;           // index of last position in ArrayList

    /**
     *
     */
    public Heap() {
        elements = new ArrayList<>();
        lastIndex = -1;
        size = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() // Returns true if this priority queue is empty; otherwise, returns false.
    {
        return (lastIndex == -1);
    }

    /**
     *
     * @param element
     */
    @Override
    public void enqueue(E element) // Throws PriQOverflowException if this priority queue is full;
    // otherwise, adds element to this priority queue.
    {
        lastIndex++;
        size++;
        elements.add(lastIndex, element);
        reheapUp(element);
    }

    /**
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     *
     * @param element
     */
    private void reheapUp(E element) // Current lastIndex position is empty.
    // Inserts element into the tree and ensures shape and order properties.
    {
        int hole = lastIndex;
        while ((hole > 0) // hole is not root and element < hole's parent
                && (element.compareTo(elements.get((hole - 1) / 2)) < 0)) {
            // move hole's parent down and then move hole up
            elements.set(hole, elements.get((hole - 1) / 2));
            hole = (hole - 1) / 2;
        }
        elements.set(hole, element);  // place element into final hole
    }
    
    /**
     *
     * @return @throws EmptyException
     */
    @Override
    public E dequeue() throws EmptyException // Throws PriQUnderflowException if this priority queue is empty;
    // otherwise, removes element with highest priority from this priority queue and returns it.
    {
        if (isEmpty()) {
            throw new EmptyException("Priority queue is empty");
        } else {
            size--;
            E hold;      // element to be dequeued and returned
            E toMove;    // element to move down heap
            hold = elements.get(0);              // remember element to be returned
            toMove = elements.remove(lastIndex); // element to reheap down
            lastIndex--;                         // decrease priority queue size
            if (lastIndex != -1) {
                reheapDown(toMove);               // restore heap properties
            }
            return hold;                         // return largest element
        }
    }
    
    /**
     *
     * @param element
     */
    private void reheapDown(E element) // Current root position is "empty";
    // Inserts element into the tree and ensures shape and order properties.
    {
        int hole = 0;      // current index of hole
        int newhole;       // index where hole should move to

        newhole = newHole(hole, element);   // find next hole
        while (newhole != hole) {
            elements.set(hole, elements.get(newhole));  // move element up
            hole = newhole;                            // move hole down
            newhole = newHole(hole, element);          // find next hole
        }
        elements.set(hole, element);           // fill in the final hole
    }
    
    /**
     *
     * @param hole
     * @param element
     * @return
     */
    private int newHole(int hole, E element) // If either child of hole is larger than element, return the index
    // of the larger child; otherwise, return the index of hole.
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if (left > lastIndex) // hole has no children
        {
            return hole;
        } else if (left == lastIndex) // hole has left child only
        {
            if (element.compareTo(elements.get(left)) < 0) // element < left child
            {
                return left;
            } else // element >= left child
            {
                return hole;
            }
        } else // hole has two children 
        {
            if (elements.get(left).compareTo(elements.get(right)) < 0) // left child < right child
            {
                if (elements.get(right).compareTo(element) <= 0) // right child <= element
                {
                    return hole;
                } else // element < right child
                {
                    return right;
                }
            } else // left child >= right child
            {
                if (elements.get(left).compareTo(element) <= 0) // left child <= element
                {
                    return hole;
                } else // element < left child
                {
                    return left;
                }
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() // Returns a string of all the heap elements.
    {
        if(isEmpty()){
            return "";
        }
        String list = "the heap is:\n";
        for (int index = 0; index <= lastIndex; index++) {
            list+= index + ". " + elements.get(index) + "\n";
        }
        return list;
    }

}
