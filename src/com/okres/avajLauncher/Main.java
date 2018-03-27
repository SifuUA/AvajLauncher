package com.okres.avajLauncher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null && !line.equals(""))
            {
                int countSimulation = parseInt(line);
                System.out.println(countSimulation);
                System.out.println("First line mu");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cant find file " + args[0]);
        } catch (IOException e) {
            System.out.println("First line must be number - count of simulation");
        }

    }
}
