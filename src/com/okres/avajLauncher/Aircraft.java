package com.okres.avajLauncher;

public class Aircraft {
    protected static long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id++;
    }

    private long nextId() {
        return idCounter + 1;
    }
}
