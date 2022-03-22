/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.exception;

/**
 *
 * @author Thato Keith Kujwane
 */
public class UnknownObjectException extends Exception {

    /**
     * Creates a new instance of <code>UnknownObjectException</code> without detail message.
     */
    public UnknownObjectException() {
    }

    /**
     * Constructs an instance of <code>UnknownObjectException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UnknownObjectException(String msg) {
        super(msg);
    }
}
