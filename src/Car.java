/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a car.
 *
 * @author Ciprian Constantinescu
 */
public class Car extends Vehicle {

    /**
     * Creates a car with the proper characteristics.
     */
    public Car() {
        super(2, 4, "Autovehicul");
    }

    /**
     * Gets the car's symbol.
     *
     * @return A char representing the symbol of the car.
     */
    @Override
    public char getSymbol() {
        return 'a';
    }

}
