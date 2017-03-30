package com.logicmonitor.research.logserver.inputs;

public abstract class AbstractDescriptor {
    private final String name;
    private final boolean exclusive;
    private final String linkToDocs;

    // required for guice, but isn't called.
    protected AbstractDescriptor() {
        throw new IllegalStateException("This class " + this.getClass().getCanonicalName() + " should not be instantiated directly, this is a bug.");
    }

    protected AbstractDescriptor(String name, boolean exclusive, String linkToDocs) {
        this.name = name;
        this.exclusive = exclusive;
        this.linkToDocs = linkToDocs;
    }

    public String getName() {
        return name;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public String getLinkToDocs() {
        return linkToDocs;
    }
}

