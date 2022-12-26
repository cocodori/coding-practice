package org.example.domain;

public class RouterId {
    private final String id;

    public RouterId(String id) {
        this.id = id;
    }

    public static RouterId of(String id) {
        return new RouterId(id);
    }
}
