/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a restriction.
 *
 * @author Ciprian Constantinescu
 */
public class Restriction {

    private String restrictionType;
    private int restrictionCost;

    /**
     * Creates a restriction with the specified type and cost.
     *
     * @param type A string representing the type of the restriction.
     * @param cost An int representing the cost of the restriction.
     */
    public Restriction(String type, int cost) {
        this.restrictionType = type;
        this.restrictionCost = cost;
    }

    /**
     * Gets the Restriction's cost.
     *
     * @return An int representing the restriction's cost.
     */
    public int getRestrictionCost() {
        return restrictionCost;
    }

    /**
     * Gets the Restriction's type.
     *
     * @return A String representing the restriction's type.
     */
    public String getRestrictionType() {
        return restrictionType;
    }

}
