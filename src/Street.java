/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a street.
 *
 * @author Ciprian Constantinescu
 */
public class Street {

    private int cost;
    private int sizeLimit;
    private Restriction[] restrictions;
    private int node_start;
    private int node_end;
    private int numberOfRestrictions;

    /**
     * Creates a new street.
     */
    public Street() {
    }

    /**
     * Creates a street with the specified starting node index, ending node
     * index, cost and size limit.
     *
     * @param node_start An int representing the street's index of the starting
     * node.
     * @param node_end An int representing the street's index of the ending
     * node.
     * @param cost An int representing the street's cost.
     * @param sizeLimit An int representing the street's size limit.
     */
    public Street(int node_start, int node_end, int cost, int sizeLimit) {
        this.node_end = node_end;
        this.node_start = node_start;
        this.cost = cost;
        this.sizeLimit = sizeLimit;
        this.restrictions = new Restriction[100];
        this.numberOfRestrictions = 0;
    }

    /**
     * Gets the street's cost.
     *
     * @return An int representing the street's cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the street's size limit.
     *
     * @return An int representing the street's size limit.
     */
    public int getSizeLimit() {
        return sizeLimit;
    }

    /**
     * Gets the street's index of the ending node.
     *
     * @return An int representing the street's index of the ending node.
     */
    public int getNode_end() {
        return node_end;
    }

    /**
     * Gets the street's index of the starting node.
     *
     * @return An int representing the street's index of the starting node.
     */
    public int getNode_start() {
        return node_start;
    }

    /**
     * Adds a new restriction to the street.
     *
     * @param restrictionType A String representing the type of the restriction.
     * @param restrictionCost An int representing the cost of the restriction.
     */
    public void newRestriction(String restrictionType, int restrictionCost) {
        restrictions[numberOfRestrictions] = new Restriction(restrictionType, restrictionCost);
        numberOfRestrictions++;
    }

    /**
     * Calculates the street's total traffic cost, depending on the specified
     * vehicle cost.
     *
     * @param vehicle_cost An int representing the cost of the vehicle.
     * @return An int representing the total traffic cost of the street.
     */
    public int trafficCost(int vehicle_cost) {
        int total = this.cost * vehicle_cost;
        for (int i = 0; i < numberOfRestrictions; i++) {
            total += restrictions[i].getRestrictionCost();
        }
        return total;
    }

}
