/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

import java.io.*;
import java.util.Scanner;

/**
 * This class represents a map.
 *
 * @author Ciprian Constantinescu
 */
public class Map {

    private Street[] streets;
    private int numberOfStreets;
    private int numberOfNodes;

    /**
     * Creates a new map.
     */
    public Map() {
    }

    /**
     * Gets the map's number of nodes.
     *
     * @return An int representing the map's number of nodes.
     */
    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Gets the map's number of streets.
     *
     * @return An int representing the map's number of streets.
     */
    public int getNumberOfStreets() {
        return numberOfStreets;
    }

    /**
     * Reads the map information using the specified Scanner and builds the
     * proper map.
     *
     * @param reader The Scanner used to read the map information.
     */
    public void readMap(Scanner reader) {
        numberOfStreets = reader.nextInt();
        streets = new Street[numberOfStreets];
        numberOfNodes = reader.nextInt();
        String aux;
        for (int i = 0; i < numberOfStreets; i++) {
            aux = reader.next();
            int nodStart = Integer.parseInt(aux.substring(1));
            aux = reader.next();
            int nodEnd = Integer.parseInt(aux.substring(1));
            int cost = reader.nextInt();
            int gabarit = reader.nextInt();
            addStreet(nodStart, nodEnd, cost, gabarit);
        }
    }

    /**
     * Runs the commands read using the specified Scanner and writes the output
     * of those commands using the specified BufferedWriter.
     *
     * @param reader A Scanner used to read the commands.
     * @param writer A BufferedWriter used to write the output of the given
     * commands.
     * @throws IOException if the output could not be written using the
     * specified BufferedWriter.
     */
    public void runCommands(Scanner reader, BufferedWriter writer) throws IOException {
        String aux;
        while (reader.hasNext()) {
            aux = reader.next();
            if (aux.equals("blocaj") || aux.equals("accident") || aux.equals("trafic")) {
                String type = aux;
                aux = reader.next();
                int start = Integer.parseInt(aux.substring(1));
                aux = reader.next();
                int end = Integer.parseInt(aux.substring(1));
                int cost = reader.nextInt();
                addRestriction(type, start, end, cost);
            } else {
                aux = reader.next();
                char symbol = aux.charAt(0);
                Vehicle v = createVehicle(symbol);
                aux = reader.next();
                int start = Integer.parseInt(aux.substring(1));
                aux = reader.next();
                int end = Integer.parseInt(aux.substring(1));
                Node n = drive(v, start, end);
                if (n == null) {
                    writer.write("P" + start + " P" + end + " null\n");
                } else {
                    writer.write(n.getPath() + " " + n.getValue() + "\n");
                }
            }
        }
    }

    /**
     * Applies the Dijkstra algorithm to the map, considering the specified
     * vehicle, starting from the specified start index and looking for the
     * specified end index.
     *
     * @param v A Vehicle used for the implementation of the Dijkstra algorithm.
     * @param start An int representing the starting index.
     * @param end An int representing the ending index.
     * @return A Node representing the destination node, or null, if the
     * destination node could not be reached.
     */
    public Node drive(Vehicle v, int start, int end) {
        DijkstraPriorityQ dpq = new DijkstraPriorityQ(this, v);
        return dpq.dijkstra(start, end);
    }

    /**
     * Creates a vehicle depending on the specified symbol.
     *
     * @param symbol A char representing the symbol of the vehicle.
     * @return A vehicle representing the created vehicle, or null, if the
     * symbol is wrong.
     */
    private Vehicle createVehicle(char symbol) {
        if (symbol == 'b') {
            return new Bicycle();
        }
        if (symbol == 'a') {
            return new Car();
        }
        if (symbol == 'm') {
            return new Motorcycle();
        }
        if (symbol == 'c') {
            return new Truck();
        }
        return null;
    }

    /**
     * Adds a new Street with the specified start index, end index, cost and
     * size limit.
     *
     * @param start An int representing the street's start index.
     * @param end An int representing the street's end index.
     * @param cost An int representing the street's cost.
     * @param size An int representing the street's size limit.
     */
    public void addStreet(int start, int end, int cost, int size) {
        for (int i = 0; i < numberOfStreets; i++) {
            if (streets[i] == null) {
                streets[i] = new Street(start, end, cost, size);
                break;
            }
        }
    }

    /**
     * Adds a new Restriction with the specified type and cost to the street
     * which has the specified start index and end index.
     *
     * @param type A String representing the restriction's type.
     * @param start An int representing the street's start index where the
     * restriction will be added.
     * @param end An int representing the street's end index where the
     * restriction will be added.
     * @param cost An int representing the restriction's cost.
     */
    public void addRestriction(String type, int start, int end, int cost) {
        Street s = findStreet(start, end);
        s.newRestriction(type, cost);
    }

    /**
     * Searches for the street which has the specified start index and the
     * specified end index.
     *
     * @param start An int representing the starting node index.
     * @param end An int representing the destination node index.
     * @return The Street with the specified start index and end index, or null,
     * if that street could not be found.
     */
    public Street findStreet(int start, int end) {
        for (Street s : streets) {
            if (s.getNode_start() == start && s.getNode_end() == end) {
                return s;
            }
        }
        return null;
    }

}
