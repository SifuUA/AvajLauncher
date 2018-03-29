package com.okres.avajLauncher;

import java.util.List;

public class Tower {
    private List <Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {

    }

    protected void conditionsChanged() {

    }

}
