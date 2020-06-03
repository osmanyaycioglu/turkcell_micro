package com.training.turkcell;


public class MyException extends Exception {

    private final String msg;

    public MyException(final String msgParam) {
        super();
        this.msg = msgParam;
    }


}
