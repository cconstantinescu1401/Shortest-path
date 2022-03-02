/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a motorcycle.
 *
 * @author Ciprian Constantinescu
 */
public class Motorcycle extends Vehicle {

    /**
     * Creates a motorcycle with the proper characteristics.
     */
    public Motorcycle() {
        super(1, 2, "Moped");
    }

    /**
     * Gets the motorcycle's symbol.
     *
     * @return A char representing the symbol of the motorcycle.
     */
    @Override
    public char getSymbol() {
        return 'm';
    }

}
