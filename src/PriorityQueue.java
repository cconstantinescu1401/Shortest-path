/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class represents a priority queue implemented with a list.
 *
 * @author Ciprian Constantinescu
 */
public class PriorityQueue {

    private Node nodes;

    /**
     * Creates a new priority queue.
     */
    public PriorityQueue() {
    }

    /**
     * Adds a new element with the specified index, value and path to the
     * priority queue.
     *
     * @param index An int representing the index of the node.
     * @param value An int representing the value of the node.
     * @param path A String representing the path to the node.
     */
    public void add(int index, int value, String path) {
        if (this.nodes == null) {
            nodes = new Node(index, value);
            nodes.setPath(path);
        } else {
            if (this.nodes.getValue() > value) {
                Node aux = new Node(index, value);
                aux.next = this.nodes;
                this.nodes = aux;
                this.nodes.setPath(path);
                return;
            }
            Node aux = this.nodes;
            while (aux.next != null) {
                if (aux.next.getValue() > value) {
                    Node aux2 = new Node(index, value);
                    aux2.next = aux.next;
                    aux2.setPath(path);
                    aux.next = aux2;
                    return;
                }
                aux = aux.next;
            }
            aux.next = new Node(index, value);
            aux.next.setPath(path);

        }
    }

    /**
     * Extracts the first element of the priority queue and removes it from the
     * priority queue.
     *
     * @return A Node representing the first element of the priority queue.
     */
    public Node remove() {
        Node aux = nodes;
        nodes = nodes.next;
        aux.next = null;
        return aux;
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return True, if the priority queue is empty, or false, if the priority
     * queue has at least one element.
     */
    public boolean isEmpty() {
        return nodes == null;
    }

}
