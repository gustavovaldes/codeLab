package com.guga.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guga
 * <p>
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class P41_RouteBetweenNodes {

    private DirectedGraph G = null;

    //TODO add unit
    //TODO generic?
    //TODO look for standard solution
    public static void main(String[] args) {

        P41_RouteBetweenNodes t = new P41_RouteBetweenNodes();
        t.G = new DirectedGraph(6);

        t.G.addEdge(0, 1);
        t.G.addEdge(0, 2);
        t.G.addEdge(0, 3);
        t.G.addEdge(3, 4);
        t.G.addEdge(4, 5);


        //true
        System.out.println(t.areConnected(t.G, 0, 1));
        System.out.println(t.areConnected(t.G, 4, 4));
        System.out.println(t.areConnected(t.G, 0, 5));
        System.out.println(t.areConnected(t.G, 3, 5));
        System.out.println(t.areConnected(t.G, 5, 0));

        //falset.G,
        System.out.println(t.areConnected(t.G, 1, 4));
        System.out.println(t.areConnected(t.G, 2, 4));
        System.out.println(t.areConnected(t.G, 2, 5));


    }

    private boolean areConnected(DirectedGraph g, int a, int b) {
        return g.isConnected(a, b) || g.isConnected(b, a);
    }
}


class DirectedGraph {
    int V;
    int E;
    List<Integer>[] vertices;

    public DirectedGraph(int N) {
        this.V = N;
        this.E = 0;
        vertices = new ArrayList[N];
        for (int i = 0; i < this.V; i++) {
            vertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        vertices[v].add(w);
    }

    public boolean isConnected(int v, int w) {
        if (v == w) return true;
        for (Integer x : vertices[v]) {
            if (isConnected(x, w)) return true;
        }
        return false;
    }
}

