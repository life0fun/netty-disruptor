package com.logicmonitor.research.logserver.inputs;

public class MisfireException extends Exception {

    public MisfireException(String msg) {
        super(msg);
    }

    public MisfireException(Throwable e) {
        super(e);
    }

    public MisfireException(String msg, Throwable e) {
        super(msg, e);
    }

}