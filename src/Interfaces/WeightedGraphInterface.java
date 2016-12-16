//----------------------------------------------------------------------------
// WeightedGraphInterface.java       by Dale/Joyce/Weems             Chapter 9
//
// Interface for a class that implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------
package Interfaces;

/**
 *
 * @author atifm
 * @param <E>
 */
public interface WeightedGraphInterface<E> {

    /**
     *
     * @return
     */
    boolean isEmpty();
    // Returns true if this graph is empty; otherwise, returns false.

    /**
     *
     * @return
     */
    boolean isFull();
    // Returns true if this graph is full; otherwise, returns false.

    /**
     *
     * @param vertex
     */
    void addVertex(E vertex);
    // Preconditions:   This graph is not full.
    //                  Vertex is not already in this graph.
    //                  Vertex is not null.
    //
    // Adds vertex to this graph.

    /**
     *
     * @param vertex
     * @return
     */
    boolean hasVertex(E vertex);
    // Returns true if this graph contains vertex; otherwise, returns false.

    /**
     *
     * @param fromVertex
     * @param toVertex
     * @param weight
     */
    void addEdge(E fromVertex, E toVertex, int weight);
    // Adds an edge with the specified weight from fromVertex to toVertex.

    /**
     *
     * @param fromVertex
     * @param toVertex
     * @return
     */
    int weightIs(E fromVertex, E toVertex);
    // If edge from fromVertex to toVertex exists, returns the weight of edge;
    // otherwise, returns a special �null-edge� value.

    /**
     *
     * @param vertex
     * @return
     */
    QueueUnboundedInterface<E> getToVertices(E vertex);
    // Returns a queue of the vertices that are adjacent from vertex.

    /**
     *
     */
    void clearMarks();
    // Sets marks for all vertices to false.

    /**
     *
     * @param vertex
     */
    void markVertex(E vertex);
    // Sets mark for vertex to true.

    /**
     *
     * @param vertex
     * @return
     */
    boolean isMarked(E vertex);
    // Returns true if vertex is marked; otherwise, returns false.

    /**
     *
     * @return
     */
    E getUnmarked();
    // Returns an unmarked vertex if any exist; otherwise, returns null.

}
