package com.okres.avajLauncher;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private static List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> copy = new ArrayList<>(observers);
        for (Flyable flyable : copy) {
            flyable.updateConditions();
        }
    }
}

