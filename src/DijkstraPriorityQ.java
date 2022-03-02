/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 * This class is used to apply the Dijkstra algorithm, using a priority queue.
 *
 * @author Ciprian Constantinescu
 */
public class DijkstraPriorityQ {

    private int[] costs;
    private boolean[] settled;
    private PriorityQueue pq;
    private Map m;
    private Vehicle v;

    /**
     * Creates a Dijkstra priority queue with the specified Map and Vehicle
     *
     * @param m The map used for the Dijkstra algorithm.
     * @param v The vehicle used for the Dijkstra algorithm.
     */
    public DijkstraPriorityQ(Map m, Vehicle v) {
        this.m = m;
        costs = new int[m.getNumberOfNodes()];
        settled = new boolean[m.getNumberOfNodes()];
        pq = new PriorityQueue();
        this.v = v;
    }

    /**
     * Implements the Dijkstra algorithm, starting from the specified source
     * index and looking for the specified destination index.
     *
     *
     * @param src The source index.
     * @param dest The destination index.
     * @return A Node representing the destination node, or null, if the
     * destination node could not be reached.
     */
    public Node dijkstra(int src, int dest) {

        for (int i = 0; i < m.getNumberOfNodes(); i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        pq.add(src, 0, "P" + src);
        costs[src] = 0;
        while (settled[dest] != true && !pq.isEmpty()) {
            Node n = pq.remove();
            settled[n.getIndex()] = true;
            if (n.getIndex() == dest) {
                return n;
            }
            processStreets(n);
        }
        return null;

    }

    /**
     * Processes the streets related to the specified node, checking all the
     * conditions.
     *
     * @param src A Node representing the starting point of the streets to be
     * processed.
     */
    private void processStreets(Node src) {
        for (int i = 0; i < m.getNumberOfNodes(); i++) {
            if (settled[i] == false && m.findStreet(src.getIndex(), i) != null) {
                Street s = m.findStreet(src.getIndex(), i);
                int newDist = costs[src.getIndex()] + s.trafficCost(v.getCost());
                if (newDist < costs[i] && s.getSizeLimit() >= v.getSize()) {
                    costs[i] = newDist;
                    pq.add(i, costs[i], src.getPath() + " P" + i);
                }
            }
        }
    }

}
