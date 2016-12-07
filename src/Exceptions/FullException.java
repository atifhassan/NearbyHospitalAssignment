/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Atif Hassan
 */
public class FullException extends Exception {

    /**
     * Creates a new instance of <code>FullException</code> without detail
     * message.
     */
    public FullException() {
        super();
    }

    /**
     * Constructs an instance of <code>FullException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FullException(String msg) {
        super(msg);
    }
}
