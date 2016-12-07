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
public class RepeatElementException extends Exception {

    /**
     * Creates a new instance of <code>RepeatElementException</code> without
     * detail message.
     */
    public RepeatElementException() {
        super();
    }

    /**
     * Constructs an instance of <code>RepeatElementException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RepeatElementException(String msg) {
        super(msg);
    }
}
