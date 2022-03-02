/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

import java.io.*;
import java.util.Scanner;

/**
 * This class represents the Main class of the project.
 *
 * @author Ciprian Constantinescu
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map m = new Map();
        File map = new File("map.in");
        Scanner reader = new Scanner(map);
        m.readMap(reader);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("map.out"));
            m.runCommands(reader, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Exception: IOException");
        }
    }
}
