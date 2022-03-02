/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a node from a list.
 *
 * @author Ciprian Constantinescu
 */
public class Node {

    private int index;
    private int value;
    private String path;
    Node next;

    /**
     * Creates a new Node.
     */
    public Node() {
    }

    /**
     * Creates a node with the specified index and value
     *
     * @param index An int representing the node's index.
     * @param value An int representing the node's value.
     */
    public Node(int index, int value) {
        this.index = index;
        this.value = value;
        next = null;
    }

    /**
     * Gets the path to the node.
     *
     * @return A String representing the path to the node.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path to the node.
     *
     * @param path A String representing the path to the node.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the node's index.
     *
     * @return An int representing the node's index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the node's value.
     *
     * @return An int representing the node's value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the node's value.
     *
     * @param value An int representing the node's value.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Sets the node's index.
     *
     * @param index An int representing the node's index.
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
