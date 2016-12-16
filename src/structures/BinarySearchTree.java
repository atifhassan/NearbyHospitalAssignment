/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import Exceptions.NullElementException;
import Interfaces.BSTInterface;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> implements BSTInterface<E> {

    private BSTNode<E> root;//parent node
    private E found = null;   // used by remove
    private int size = 0;
    private QueueLinkedList<E> order;

    /**
     *
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     *
     * @param element
     */
    @Override
    public void Add(E element) {
        root = recAdd(element, root);
        size++;
    }

    /**
     * Adds element to tree using recursion
     *
     * @param element
     * @param tree
     * @return
     */
    private BSTNode<E> recAdd(E element, BSTNode<E> tree) {
        if (tree == null) { //empty tree or branch
            tree = new BSTNode<>(element);
        } else if (element.compareTo(tree.getData()) <= 0) { // Add in left subtree
            tree.setLeft(recAdd(element, tree.getLeft()));
        } else { // Add in right subtrees
            tree.setRight(recAdd(element, tree.getRight()));
        }
        return tree;
    }

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    @Override
    public E Remove(E element) throws EmptyException, NullElementException {
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            root = recRemove(element, root);
            size--;
            return found;
        }
    }

    private BSTNode<E> recRemove(E element, BSTNode<E> tree) throws EmptyException // Removes an element e from tree such that e.compareTo(element) == 0
    // and returns true; if no such element exists, returns false. 
    {
        if (tree == null) {
            throw new EmptyException();
        } else if (element.compareTo(tree.getData()) < 0) {
            tree.setLeft(recRemove(element, tree.getLeft()));
        } else if (element.compareTo(tree.getData()) > 0) {
            tree.setRight(recRemove(element, tree.getRight()));
        } else {
            tree = removeNode(tree);
        }
        return tree;
    }

    private BSTNode<E> removeNode(BSTNode<E> tree) throws EmptyException // Removes the information at the node referenced by tree.
    // The user's data in the node referenced by tree is no
    // longer in the tree.  If tree is a leaf node or has only
    // a non-null child pointer, the node pointed to by tree is
    // removed; otherwise, the user's data is replaced by its
    // logical predecessor and the predecessor's node is removed.
    {
        E data;
        found = tree.getData();
        if (tree.getLeft() == null) {
            return tree.getRight();
        } else if (tree.getRight() == null) {
            return tree.getLeft();
        } else {
            data = getPredecessor(tree.getLeft());
            tree.setData(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
            return tree;
        }
    }

    private E getPredecessor(BSTNode<E> tree) // Returns the information held in the rightmost node in tree
    {
        while (tree.getRight() != null) {
            tree = tree.getRight();
        }
        return tree.getData();
    }

    /**
     *
     * @param element
     * @return
     */
    @Override
    public boolean Contains(E element) {

        if (isEmpty()) {
            return false;
        } else {
            BSTNode<E> tree = root;
            while (tree != null) {
                if (tree.getData().compareTo(element) == 0) {
                    return true;
                } else if (element.compareTo(tree.getData()) < 0) {
                    //search left branch
                    tree = tree.getLeft();
                } else {
                    //search right branch
                    tree = tree.getRight();
                }
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     *
     * @return
     */
    @Override
    public int Size() {
        return size;
    }

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    @Override
    public E Get(E element) throws EmptyException, NullElementException {
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            BSTNode<E> tree = root;
            while (tree != null) {
                if (tree.getData().compareTo(element) == 0) {
                    return tree.getData();
                } else if (element.compareTo(tree.getData()) < 0) {
                    //search left branch
                    tree = tree.getLeft();
                } else {
                    //search right branch
                    tree = tree.getRight();
                }
            }
        }
        throw new NullElementException();
    }

    /**
     *
     */
    @Override
    public void Reset() {
        order = new QueueLinkedList<>();
        Order(root);
    }

    private void Order(BSTNode<E> tree) {
        if (tree != null){
            Order(tree.getLeft());
            order.Enqueue(tree.getData());
            Order(tree.getRight());
        }
    }
    /**
     *
     * @return
     * @throws Exceptions.EmptyException
     */
    @Override
    public E getNext() throws EmptyException {
        if (isEmpty()) {
            return null;
        } else {
           return order.Dequeue();
        }
    }

    @Override
    public String toString() {
        String list = "";
        if (!isEmpty()) {
            list += root.toString();
        }
        return list;
    }
}
