package com.okres.avajLauncher.Aircrafts;

import com.okres.avajLauncher.Exception.MyException;
import com.okres.avajLauncher.Logging.Logger;

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
        if (args.length == 0)
            throw new MyException("Error, cant find file in arguments");
        try {
            weatherTower = new WeatherTower();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int countSimulation = 0;
            if (line != null && !line.equals("")) {
                try {
                    countSimulation = parseInt(line);
                } catch (NumberFormatException e) {
                    System.err.println("First line must be a number - count of "
                            + "simulation");
                    System.exit(0);
                }
                while ((line = reader.readLine()) != null && !line.equals("")) {
                    int height = Integer.parseInt(line.split(" ")[4]);
                    if (height > 100 || height < 0)
                        throw new MyException("The height must be in the range 0 - 100");
                    Flyable flyable = AircraftFactory.
                            newAircraft(line.split(" ")[0],
                                    line.split(" ")[1],
                                    Integer.parseInt(line.split(" ")[2]),
                                    Integer.parseInt(line.split(" ")[3]),
                                    height);
                    flyables.add(flyable);
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 0; i < countSimulation; i++) {
                    weatherTower.changeWeather();
                }
                if (args.length == 2 && args[1].equals("-p"))
                    Logger.getLogger().loggerShowLog();
                Logger.getLogger().writeInFile();
            } else
                throw new MyException("Cant find in first line count of simulations");
        } catch (FileNotFoundException e) {
            System.err.println("Cant find file " + args[0]);
        } catch (IOException e) {
            System.err.println("Cant find in first line count of simulations");
        } catch (MyException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Coordinates must be positive integer number");
        }
    }
}
