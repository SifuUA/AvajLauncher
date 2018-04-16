package com.okres.avajLauncher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws MyException {
        try {
            weatherTower = new WeatherTower();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null && !line.equals("")) {
                int countSimulation = parseInt(line);
                System.out.println(countSimulation);
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 0; i < countSimulation; i++) {
                    weatherTower.changeWeather();
                }
                Logger.getLogger().loggerShowLog();
                Logger.getLogger().writeInFile();
            }
            else throw new MyException("Cant find in first line count of simulations");
        } catch (FileNotFoundException e) {
            System.err.println("Cant find file " + args[0]);
        } catch (IOException e) {
            System.err.println("Cant find in first line count of simulations");
        } catch (MyException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("First line must be a number - count of simulation");
        }

    }
}
