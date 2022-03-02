/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a truck.
 *
 * @author Ciprian Constantinescu
 */
public class Truck extends Vehicle {

    /**
     * Creates a truck with the proper characteristics.
     */
    public Truck() {
        super(3, 6, "Autoutilitar");
    }

    /**
     * Gets the truck's symbol.
     *
     * @return A char representing the symbol of the truck.
     */
    @Override
    public char getSymbol() {
        return 'c';
    }

}
