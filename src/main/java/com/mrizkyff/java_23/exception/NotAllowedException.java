/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrizkyff.java_23.exception;

/**
 *
 * @author yudi
 */
public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String exception) {
        super(exception);
    }
}
