package com.okres.avajLauncher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null && !line.equals("")) {
                int countSimulation = parseInt(line);
                System.out.println(countSimulation);
                while ((line = reader.readLine()) != null) {
                    System.out.println(line.split(" ", 2));
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cant find file " + args[0]);
        } catch (IOException e) {
            System.out.println("First line must be number - count of simulation");
        }

    }
}