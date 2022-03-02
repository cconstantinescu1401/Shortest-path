/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a vehicle.
 *
 * @author Ciprian Constantinescu
 */
public abstract class Vehicle {

    private int size;
    private int cost;
    private String type;

    /**
     * Creates a vehicle with the specified size, cost and type.
     *
     * @param size An int representing the vehicle's size.
     * @param cost An int representing the vehicle's cost.
     * @param type A String representing the vehicle's type.
     */
    public Vehicle(int size, int cost, String type) {
        this.size = size;
        this.cost = cost;
        this.type = type;
    }

    /**
     * Gets the vehicle's cost.
     *
     * @return An int representing the cost of the vehicle.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the vehicle's size.
     *
     * @return An int representing the size of the vehicle.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the vehicle's type.
     *
     * @return A String representing the type of the vehicle.
     */
    public String getType() {
        return type;
    }

    /**
     * Abstract method which should return the symbol of the vehicle.
     *
     * @return A char representing the symbol of the vehicle.
     */
    public abstract char getSymbol();

}
