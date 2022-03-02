/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a bicycle.
 *
 * @author Ciprian Constantinescu
 */
public class Bicycle extends Vehicle {

    /**
     * Creates a bicycle with the proper characteristics.
     */
    public Bicycle() {
        super(1, 1, "Moped");
    }

    /**
     * Gets the bicycle's symbol.
     *
     * @return A char representing the symbol of the bicycle.
     */
    @Override
    public char getSymbol() {
        return 'b';
    }

}
